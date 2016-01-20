package fft;

public class Stats {
	SingleAxisStats zStats;
	SingleAxisStats xStats;
	SingleAxisStats yStats;
	
	public Stats(SingleAxisStats zStats, SingleAxisStats xStats, SingleAxisStats yStats) {
		this.zStats = zStats;
		this.xStats = xStats;
		this.yStats = yStats;
	}
	
	public boolean isEquivalentTo(Stats s) {
		if (zStats != null && s.zStats != null) {
			if (!zStats.isEquivalentTo(s.zStats)) {
				return false;
			}
		}
		if (xStats != null && s.xStats != null) {
			if (!xStats.isEquivalentTo(s.xStats)) {
				return false;
			}			
		}
		if (yStats != null && s.yStats != null) {
			if (!yStats.isEquivalentTo(s.yStats)) {
				return false;
			}			
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "zStats: " + zStats + ",\n xStats: " + xStats + ",\n yStats: " + yStats;
	}
}
