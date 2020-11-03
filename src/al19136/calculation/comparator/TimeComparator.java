package al19136.calculation.comparator;

import java.util.Comparator;

import al19136.process.ProcessData;

public class TimeComparator implements Comparator<ProcessData> {
	@Override
	public int compare(ProcessData p1,ProcessData p2) {
		if (p1.isExecuting() && !p2.isExecuting()) {
			return -1;
		}else if (!p1.isExecuting() && p2.isExecuting()) {
			return 1;
		}
		return p1.getRemaining()<p2.getRemaining() ? -1 : 1;
	}
}
