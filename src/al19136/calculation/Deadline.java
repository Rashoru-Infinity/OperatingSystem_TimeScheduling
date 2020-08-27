package al19136.calculation;

import java.util.Collections;

import al19136.process.DeadlineComparator;
import al19136.process.Process;
import al19136.process.ProcessData;

public class Deadline extends Process {
	@Override
	public void calc() {
		sortArrival();
		for(int i=0;psList.size()>0||readyList.size()>0;i++) {
			addReadyList(i);
			if(readyList.size()>0) {
				sortDeadline();
				execute(readyList.get(0).getTime());
			}else {
				execute(ProcessData.DO_NOTHING);
			}
		}
	}
	
	private void sortDeadline() {
		Collections.sort(readyList,new DeadlineComparator());
	}
}
