package fft;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

//import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;
import edu.emory.mathcs.jtransforms.dct.DoubleDCT_1D;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Mean;

/**
 * assume 40 ms samples
 * @author celder
 *
 */
public class SimpleDanceRecord {	
	
	private int window = 5 * 1000 / 40; // number of recent records we're interested in
	public Deque<float[]> queue = new ArrayDeque<float[]>(); // timestamp
	// TODO: change to 3 queues. or 3d array of queues.
	
	// stats
	private StandardDeviation std = new StandardDeviation(); // or amplitude
	private Mean mean = new Mean();
	
	// for testing
	public void setQueue(float[][] dq) {
		int numCols = dq[0].length;
		for (int i=0; i<numCols; i++) {
			float zs = dq[0][i];
			float xs = dq[1][i];
			float ys = dq[2][i];
			float[] point = new float[]{zs, xs, ys};
			addPoint(point);
		}
	}
	// for testing
	public void addPoint(float[] pos) {
		// add point to queue
		queue.add(pos);
		// trim old points from queue
		if (queue.size() > window) {
			queue.removeFirst();
		}
		// update stats
		// TODO: not just for zs
//		std.increment(pos[0]);
//		mean.increment(pos[0]);
	}
	
	public double getStd() {
		return std.getResult();
	}
//	public double getMean(int axis) {
////		return mean.getResult();
//		
//		for (int i = 0; i < queue[axis].size(); i++) {
//			
//		}
//	}
	
	/**
	 * 
	 * @param axis 0 for zs, 1 for xs, 2 for ys
	 * @return
	 */
	public double[] getPositions(int axis) {
//		float[][] pts = (float[][]) queue.toArray();
//		List<Double> positions = Arrays.stream(pts).map(pt -> new Float(pt[axis]).doubleValue()).collect(Collectors.toList());
//		double[] positionArray = ArrayUtils.toPrimitive(positions.toArray(new Double[positions.size()]));
//		return positionArray;
		Deque<float[]> localQueue = new ArrayDeque<float[]>(queue);
		int size = localQueue.size();
		double[] vals = new double[size];
//		System.out.println("vals has size: " + vals.length);
		for(int i=0; i<size; i++) {
			vals[i] = new Float(localQueue.getFirst()[axis]).doubleValue();
//			System.out.println("vals[" + i + "]: " + vals[i]);
			localQueue.removeFirst();
		}
		return vals;
	}
	
	public double[] getFreqencies(int axis) {
//		DoubleFFT_1D fft = new DoubleFFT_1D(queue.size());
		DoubleDCT_1D dct = new DoubleDCT_1D(queue.size());
		System.out.println("dct:" + dct);
		double[] vals = getPositions(axis);
//		fft.realForward(vals);
		dct.forward(vals, true);
//		System.out.println("fft vals:" + vals);
		// get period of max frequency found
		return vals;
	}
	
}
