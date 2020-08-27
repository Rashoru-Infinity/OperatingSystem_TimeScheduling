package al19136.process;

import java.util.Comparator;

public class TimeComparator implements Comparator<ProcessData> {
	@Override
	public int compare(ProcessData p1,ProcessData p2) {
		return p1.getTime()<p2.getTime() ? -1 : 1;
	}
}
