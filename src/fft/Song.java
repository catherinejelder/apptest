package fft;

import java.util.Arrays;
import java.util.Deque;

public enum Song {
	SINGLE_LADIES, ITS_NOT_UNUSUAL, GANGNAM_STYLE, NONE;
	static double threshold = 0.1; // values must be within 10% of the canonical value
	static double[] single_ladies_stats = {3.363, 2.379, 16.0, 0.1735, 0.4425, 12.0, 1.568, 0.7284, 16.0};

//	double bpm;
//	double beatsPerMove;
//	Title title;
	
//	private Song(Title t) {
//		this.title = t;
//	}
//	public enum Title {
//		SINGLE_LADIES, ITS_NOT_UNUSUAL, GANGNAM_STYLE, NONE
//	}

//	public Song(int bPerMin, int beatsPerMove) {
//		this.bpm = bPerMin;
//		this.beatsPerMove = beatsPerMove;
//	}
	// an estimate of the "ideal" period of the song. number of samples we expect to see per dance move
	public double getPeriod(double samplingFreq, double bpm, double beatsPerMove) {
		System.out.println("bpm: " + bpm + ", samplingFreq: " + samplingFreq + ", beatsPerMove: " + beatsPerMove);
		return 1/(bpm/60/1000*samplingFreq/beatsPerMove);
	}
	
//	public Song isSong(double amp, double avg, double pd) {
	public static Song isSong(SimpleDanceRecord record) {
		double[] zStats = record.getStats(0);
		System.out.println("zStats: middle:" + zStats[0] + ", amp: " + zStats[1] + ", pd: " + zStats[2]);
		double middleZ = zStats[0];
		double ampZ = zStats[1];
		double pdZ = zStats[2];
		double[] xStats = record.getStats(1);	
		System.out.println("xStats: middle:" + xStats[0] + ", amp: " + xStats[1] + ", pd: " + xStats[2]);
		double middleX = xStats[0];
		double ampX = xStats[1];
		double pdX = xStats[2];
		double[] yStats = record.getStats(2);	
		System.out.println("yStats: middle:" + yStats[0] + ", amp: " + yStats[1] + ", pd: " + yStats[2] + "\n");
		double middleY = yStats[0];
		double ampY = yStats[1];
		double pdY = yStats[2];
		
		double[] song_stats = {middleZ, ampZ, pdZ, middleX, ampX, pdX, middleY, ampY, pdY};
		
		for(int i=0; i<single_ladies_stats.length; i++) {
			if (Math.abs(single_ladies_stats[i] - song_stats[i]) > threshold) {
				break;
			}
			if (i == (single_ladies_stats.length - 1)) {
				return Song.SINGLE_LADIES;
			}
		}
		return Song.NONE;
		// TODO: add more songs
	}
}
