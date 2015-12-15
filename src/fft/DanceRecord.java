package fft;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;

public class DanceRecord {	
	
	private long window = 5 * 1000; // window of history we're interested in, in ms
	
	private class Point {
		public long timestamp;
		public float[] position;
		Point(long ts, float[] pos) {
			timestamp = ts;
			position = pos;
		}
	}
	
	private Deque<Point> queue = new ArrayDeque<Point>(); // timestamp

	private boolean isExpired(Point p, long ts) {
		if ((ts - p.timestamp) > window) return true;
		else return false;
	}
	
	public void addPoint(long ts, float[] pos) {
		// add point to queue
		queue.add(new Point(ts, pos));
		// trim old points from queue
		while(!queue.isEmpty() && isExpired(queue.getFirst(), ts)) {
			queue.removeFirst();
		}
	}
	/**
	 * 
	 * @param axis 0 for zs, 1 for xs, 2 for ys
	 * @return
	 */
	private double[] getPositions(int axis) {
		Point[] pts = (Point[]) queue.toArray();
//		Object[] zs = Arrays.stream(pts).map(pt -> new Float(pt.position[0]).doubleValue()).toArray();
		List<Double> positions = Arrays.stream(pts).map(pt -> new Float(pt.position[axis]).doubleValue()).collect(Collectors.toList());
//		List<Double> xs = Arrays.stream(pts).map(pt -> new Float(pt.position[1]).doubleValue()).collect(Collectors.toList());
//		List<Double> ys = Arrays.stream(pts).map(pt -> new Float(pt.position[2]).doubleValue()).collect(Collectors.toList());
		double[] positionArray = ArrayUtils.toPrimitive(positions.toArray(new Double[positions.size()]));
//		double[] xsArr = ArrayUtils.toPrimitive(zs.toArray(new Double[xs.size()]));
//		double[] ysArr = ArrayUtils.toPrimitive(zs.toArray(new Double[ys.size()]));

//		double[][] vals = new double[3][queue.size()];
//		vals[0] = zsArr;
//		vals[1] = xsArr;
//		vals[2] = ysArr;
//		return vals;
		return positionArray;
	}
	public void getFreqencies() {
		DoubleFFT_1D fft = new DoubleFFT_1D(queue.size());
		double[] zs = getPositions(0);
		System.out.println("z positions: " + zs);
		fft.realForward(zs);
		System.out.println("z fft vals:" + zs);
		// get period of max frequency found
	}
	
}
