package fft;

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
//		Float[] z = (Float[]) record.zs.toArray();
//		Float[] x = (Float[]) record.xs.toArray();		
//		Float[] y = (Float[]) record.ys.toArray();
		double[] zStats = record.getStats(0);
		double ampZ = zStats[0];
		double avgZ = zStats[1];
		double pdZ = zStats[2];
		double[] xStats = record.getStats(1);		
		double ampX = xStats[0];
		double avgX = xStats[1];
		double pdX = xStats[2];
		double[] yStats = record.getStats(2);		
		double ampY = yStats[0];
		double avgY = yStats[1];
		double pdY = yStats[2];
		
		if (((2.5 < ampZ) && (ampZ < 4.5)) && ((3 < avgZ) && (avgZ < 4)) && ((16 < pdZ) && (pdZ < 20))
			&& ((ampX < 1)) && ((16 < pdX) && (pdX < 20))
			&& ((ampY < 1)) && ((16 < pdY) && (pdY < 20)))
		{
			return Song.SINGLE_LADIES;
		}	
		// TODO: modify these
		else if (((2.5 < ampZ) && (ampZ < 4.5)) && ((3 < avgZ) && (avgZ < 4)) && ((16 < pdZ) && (pdZ < 20))
				&& ((ampZ < 1)) && ((16 < pdZ) && (pdZ < 20))
				&& ((ampZ < 1)) && ((16 < pdZ) && (pdZ < 20)))
		{
			return Song.ITS_NOT_UNUSUAL;
		}
		else if (((2.5 < ampZ) && (ampZ < 4.5)) && ((3 < avgZ) && (avgZ < 4)) && ((16 < pdZ) && (pdZ < 20))
				&& ((ampZ < 1)) && ((16 < pdZ) && (pdZ < 20))
				&& ((ampZ < 1)) && ((16 < pdZ) && (pdZ < 20)))
		{
			return Song.GANGNAM_STYLE;
		} else {
			return Song.NONE;
		}


	}
}
