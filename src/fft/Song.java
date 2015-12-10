package fft;

public class Song {
	double bpm;
	double beatsPerMove;
	
	public Song(int bPerMin, int beatsPerMove) {
		this.bpm = bPerMin;
		this.beatsPerMove = beatsPerMove;
	}
	// an estimate of the "ideal" frequency of the song. number of samples we expect to see per period (one dance move)
	public double getSamplesPerMove(double samplingFreq) {
		System.out.println("bpm: " + bpm + ", samplingFreq: " + samplingFreq + ", beatsPerMove: " + beatsPerMove);
		return 1/(bpm/60/1000*samplingFreq/beatsPerMove);
	}
}
