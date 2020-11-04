package al19136.calculation;

import java.util.Collections;

import al19136.calculation.comparator.DeadlineComparator;

public class Deadline extends Process {
	
	public Deadline(int processors) {
		super(processors);
	}

	@Override
	public void calc() {
		sortArrival();
		for(int i = 0;psList.size() > 0 || readyList.size() > 0;i++) {
			addReadyList(i);
			for (int j = 0;j < readyList.size();j++) {
				if (!readyList.get(j).isExecuting()) {
					readyList.get(j).setQuantum(readyList.get(j).getRemaining());
				}
			}
			sortDeadline();
			execute();
		}
	}
	
	private void sortDeadline() {
		Collections.sort(readyList,new DeadlineComparator());
	}
}
