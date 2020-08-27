package al19136.process;

import java.util.Comparator;

public class DeadlineComparator implements Comparator<ProcessData> {
	@Override
	public int compare(ProcessData p1,ProcessData p2) {
		return p1.getDeadline()<p2.getDeadline() ? -1 : 1;
	}
}
