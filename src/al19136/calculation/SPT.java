package al19136.calculation;

import java.util.Collections;

import al19136.calculation.comparator.TimeComparator;

public class SPT extends Process {
	public SPT(int processors) {
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
			sortRemaining();
			execute();
		}
	}
	
	private void sortRemaining() {
		Collections.sort(readyList,new TimeComparator());
	}
}
