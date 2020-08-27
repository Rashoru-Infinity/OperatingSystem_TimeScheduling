package al19136.process;

import java.util.Comparator;

public class ArrivalTimeComparator implements Comparator<ProcessData> {
	@Override
	public int compare(ProcessData p1,ProcessData p2) {
		return p1.getArrivalTime()<p2.getArrivalTime() ? -1 : 1;
	}
}
