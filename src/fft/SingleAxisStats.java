package fft;

public class SingleAxisStats {
	// average value
	double middle;
	// max - min
	double amplitude;
	// number of samples in one cycle
	double period;
	
	public SingleAxisStats(double middle, double amplitude, double period) {
		this.middle = middle;
		this.amplitude = amplitude;
		this.period = period;
	}
	
	public boolean isEquivalentTo(SingleAxisStats s) {
		// TODO: put threshold in constants file
		double threshold = 0.1; // values must be within 0.1 of the canonical value
		if (middle != 0 && s.middle != 0) {
			if ((Math.abs(middle - s.middle) > threshold)) {
				return false;
			}
		}
		if (amplitude != 0 && s.amplitude != 0) {
			if ((Math.abs(amplitude - s.amplitude) > threshold)) {
				return false;
			}
		}
		if (period != 0 && s.period != 0) {
			if ((Math.abs(period - s.period) > threshold)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "middle: " + middle + ",\n amplitude: " + amplitude + ",\n period: " + period;

	}
}
