package al19136.process;

import java.util.Comparator;

public class PriorityComparator implements Comparator<ProcessData> {
	@Override
	public int compare(ProcessData p1,ProcessData p2) {
		return p1.getPriority()>p2.getPriority() ? -1 : 1;
	}
}
