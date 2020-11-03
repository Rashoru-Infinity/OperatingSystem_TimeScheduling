package al19136.calculation;

import java.util.ArrayList;
import java.util.Collections;

import al19136.calculation.comparator.PriorityComparator;
import al19136.process.ProcessData;

public class Priority extends Process {
	public Priority(int processors) {
		super(processors);
	}

	@Override
	public void calc() {
		sortArrival();
		for(int i = 0;psList.size() > 0 || readyList.size() > 0;i++) {
			addReadyList(i);
			for (int j = 0;j < readyList.size();j++) {
				if (readyList.get(j).isExecuting()) {
					readyList.get(i).setQuantum(readyList.get(i).getRemaining());
				}
			}
			sortPriority(readyList);
			execute();
		}
	}
	
	private void sortPriority(ArrayList<ProcessData> processList) {
		Collections.sort(processList,new PriorityComparator());
	}
}
