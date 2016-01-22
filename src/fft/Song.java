package fft;

public enum Song {
	// z, x, y
	// middle val, amplitude, period
//	GANGNAM_STYLE(new Stats(new SingleAxisStats(3.14, 0.6748, 24.0), new SingleAxisStats(0.8817, 0.5656, 10.0), new SingleAxisStats(-0.3990, 0.5268, 10.0))), 
//	SINGLE_LADIES(new Stats(new SingleAxisStats(3.363, 2.379, 16.0), new SingleAxisStats(0.1735, 0.4425, 12.0), new SingleAxisStats(1.568, 0.7284, 16.0))),
//	GANGNAM_STYLE(new Stats(new SingleAxisStats(3.14, 0.6748, 24.0), new SingleAxisStats(0.8817, 0.5656, 10.0), new SingleAxisStats(-0.3990, 0.5268, 10.0))), 
	GANGNAM_STYLE(new StatRange(new SingleAxisStatRange(-2.50, 2.80, 0.400, 0.770, 8.0, 16.5), new SingleAxisStatRange(0.6, 0.91, 0.42, 0.71, 7, 13), new SingleAxisStatRange(0.62, 0.91, 0.42, 0.71, 7, 11))),
	NONE(null);
	
	StatRange statRange;
	
	private Song(StatRange sRange) {
		this.statRange = sRange;
	}
	
//	static double threshold = 0.1; // values must be within 10% of the canonical value
//	// middle val, amplitude, and period for each axis (z, x, y)
////	static double[] single_ladies_stats = {3.363, 2.379, 16.0, 0.1735, 0.4425, 12.0, 1.568, 0.7284, 16.0};
////	static double[] gangnam_style_stats = {-1.449, 0.6748, 24.0, 0.8817, 0.5656, 10.0, -0.3990, 0.5268, 10.0};
//	Stats stats;
//	
////	double bpm;
////	double beatsPerMove;
////	Title title;
//	
////	public Song(int bPerMin, int beatsPerMove) {
////		this.bpm = bPerMin;
////		this.beatsPerMove = beatsPerMove;
////	}
//	// an estimate of the "ideal" period of the song. number of samples we expect to see per dance move
//	public static double getPeriod(double samplingFreq, double bpm, double beatsPerMove) {
//		System.out.println("bpm: " + bpm + ", samplingFreq: " + samplingFreq + ", beatsPerMove: " + beatsPerMove);
//		return 1/(bpm/60/1000*samplingFreq/beatsPerMove);
//	}
//	
////	public Song isSong(double amp, double avg, double pd) {
//	public static Song isSong(SimpleDanceRecord record) {
//		double[] zStats = record.getStats(0);
//		System.out.println("zStats: middle:" + zStats[0] + ", amp: " + zStats[1] + ", pd: " + zStats[2]);
//		double middleZ = zStats[0];
//		double ampZ = zStats[1];
//		double pdZ = zStats[2];
//		double[] xStats = record.getStats(1);	
//		System.out.println("xStats: middle:" + xStats[0] + ", amp: " + xStats[1] + ", pd: " + xStats[2]);
//		double middleX = xStats[0];
//		double ampX = xStats[1];
//		double pdX = xStats[2];
//		double[] yStats = record.getStats(2);	
//		System.out.println("yStats: middle:" + yStats[0] + ", amp: " + yStats[1] + ", pd: " + yStats[2] + "\n");
//		double middleY = yStats[0];
//		double ampY = yStats[1];
//		double pdY = yStats[2];
//		
//		double[] song_stats = {middleZ, ampZ, pdZ, middleX, ampX, pdX, middleY, ampY, pdY};
//		
//		// TODO: add more songs
//		for(int i=0; i<single_ladies_stats.length; i++) {
//			if (Math.abs(single_ladies_stats[i] - song_stats[i]) > threshold) {
//				break;
//			}
//			if (i == (single_ladies_stats.length - 1)) {
//				return Song.SINGLE_LADIES;
//			}
//		}
//		return Song.NONE;
//	}
}
