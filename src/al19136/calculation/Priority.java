package al19136.calculation;

import java.util.ArrayList;
import java.util.Collections;

import al19136.process.PriorityComparator;
import al19136.process.Process;
import al19136.process.ProcessData;

public class Priority extends Process {
	@Override
	public void calc() {
		sortArrival();
		for(int i=0;psList.size()>0||readyList.size()>0;i++) {
			addReadyList(i);
			if(readyList.size()>0) {
				if(!readyList.get(0).isExecuting()) {
					sortPriority(readyList);
				}
				execute(readyList.get(0).getTime());
			}else {
				execute(ProcessData.DO_NOTHING);
			}
		}
	}
	
	private void sortPriority(ArrayList<ProcessData> processList) {
		Collections.sort(processList,new PriorityComparator());
	}
}
