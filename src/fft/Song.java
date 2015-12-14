package fft;

import java.util.Arrays;
import java.util.Deque;

public enum Song {
	SINGLE_LADIES, ITS_NOT_UNUSUAL, GANGNAM_STYLE, NONE;
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
		System.out.println("yStats: middle:" + yStats[0] + ", amp: " + yStats[1] + ", pd: " + yStats[2]);
		double middleY = yStats[0];
		double ampY = yStats[1];
		double pdY = yStats[2];
		
		if (((3.5 > middleZ) && (3.22 < middleZ)) && ((2.6 > ampZ) && (2.0 < ampZ)) && ((15 < pdZ) && (19 > pdZ))
			&& ((0.3 > middleX) && (0 < middleX)) && ((0.6 > ampX) && (0.3 < ampX)) && ((11 < pdX) && (14 > pdX))
			&& ((1.8 > middleY) && (1.2 < middleY)) && ((0.9 > ampY) && (0.5 < ampY)) && ((15 < pdY) && (19 > pdY)))
		{
			return Song.SINGLE_LADIES;
		}	
		// TODO: modify these
//		else if (((3.5 > middleZ) && (3.22 < middleZ)) && ((2.6 > ampZ) && (2.0 < ampZ)) && ((16 < freqZ) && (20 > freqZ))
//				&& ((0.3 > middleX) && (0 < middleX)) && ((0.6 > ampX) && (0.3 < ampX)) && ((16 < freqX) && (20 > freqX))
//				&& ((1.8 > middleY) && (1.2 < middleY)) && ((0.9 > ampY) && (0.5 < ampY)) && ((16 < freqY) && (20 > freqY)))
//		{
//			return Song.ITS_NOT_UNUSUAL;
//		}
//		else if (((3.5 > middleZ) && (3.22 < middleZ)) && ((2.6 > ampZ) && (2.0 < ampZ)) && ((16 < freqZ) && (20 > freqZ))
//				&& ((0.3 > middleX) && (0 < middleX)) && ((0.6 > ampX) && (0.3 < ampX)) && ((16 < freqX) && (20 > freqX))
//				&& ((1.8 > middleY) && (1.2 < middleY)) && ((0.9 > ampY) && (0.5 < ampY)) && ((16 < freqY) && (20 > freqY)))
//		{
//			return Song.GANGNAM_STYLE;
//		} 
		else {
			return Song.NONE;
		}


	}
}
