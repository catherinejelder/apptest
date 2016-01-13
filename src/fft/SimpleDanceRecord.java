package fft;

import java.util.ArrayDeque;
import java.util.Deque;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * assume 40 ms samples
 * @author celder
 *
 */
public class SimpleDanceRecord {	
	
	private int window = 3 * 1000 / 40; // number of recent records we're interested in
	
	public Deque<Float> zs = new ArrayDeque<Float>();
	public Deque<Float> xs = new ArrayDeque<Float>();
	public Deque<Float> ys = new ArrayDeque<Float>();

	// for testing
	public void setQueue(float[] z, float[] x, float[] y) {
		for (int i=0; i<z.length; i++) {
			zs.add(z[i]);
			xs.add(x[i]);
			ys.add(y[i]);
		}
	}
	
	// for testing
	public void addPoint(float[] pos) {
		// add point to queue
		zs.add(pos[0]);
		xs.add(pos[1]);
		ys.add(pos[2]);
		// trim old points from queue
		trimQueueIfNeeded(zs);
		trimQueueIfNeeded(xs);
		trimQueueIfNeeded(ys);
	}
	public void trimQueueIfNeeded(Deque<Float> q) {
		if (q.size() > window) q.removeFirst();
	}
	
//	public Stats {
//		private middle;
//		private amp;
//		private freq;
//		public Stats(double mid, double am, double fr) {
//			middle = mid;
//			amp = am;
//			freq = fr;
//		}
//	}
	public double[] getStats(int axis) {
		DescriptiveStatistics stats = new DescriptiveStatistics();
		Deque<Float> targetArr;
		if (axis == 0){
			targetArr = zs;
		} else if (axis == 1) {
			targetArr = xs;
		} else {
			targetArr = ys;
		}
		for (int i=0; i<targetArr.size(); i++) {
			stats.addValue((new Float((float) targetArr.toArray()[i])).doubleValue());
		}
		double[] statsArr = new double[3];
		double amp = stats.getMax() - stats.getMin();
//		System.out.println("stats: max:" + stats.getMax() + ", min: " + stats.getMin());
		double middle = stats.getMin() + (amp / 2);
//		double freq = getTopFrequency(axis); // TODO: use fourier transform
		double pd = 2 * (targetArr.size() / getNumMiddleCrossings(targetArr, middle));
		
		statsArr[0] = middle;
		statsArr[1] = amp;
		statsArr[2] = pd;
//		Stats stats = new Stats(middle, amp, freq);
		return statsArr;
	}

	private int getNumMiddleCrossings(Deque<Float> queue, double middle) {
		Object[] arr = queue.toArray();
		int numCrossings = 0;
		for (int i=0; i<arr.length-1; i++) {
			if (Math.signum((float)arr[i] - middle) != Math.signum((float)arr[i+1] - middle)) {
				numCrossings++;
			}
		}
		return numCrossings;
	}
//	/**
//	 * 
//	 * @param axis 0 for zs, 1 for xs, 2 for ys
//	 * @return
//	 */
//	public double[] getDataForAxis(int axis) {
//		Deque<Float> chosenDeque = new ArrayDeque<Float>(zs.size()); // assume zs, xs, ys all same size
//		if (axis == 0) {
//			chosenDeque.addAll(zs);
//		} else if (axis == 1) {
//			chosenDeque.addAll(xs);
//		} else {
//			chosenDeque.addAll(ys);
//		}
//		int size = chosenDeque.size();
//		double[] vals = new double[size];
//		for(int i=0; i<size; i++) {
//			vals[i] = new Float(chosenDeque.getFirst()).doubleValue();
//			chosenDeque.removeFirst();
//		}
//		return vals;
//	}
//	
//	public double getTopFrequency(int axis) {
//		DoubleDCT_1D dct = new DoubleDCT_1D(zs.size()); // assume zs, xs, ys all same size
//		double[] dataArr = null;
//		dataArr = getDataForAxis(axis);
//		dct.forward(dataArr, false);
//		// get period of max frequency found
//		return dataArr[0];
//	}
	
}
