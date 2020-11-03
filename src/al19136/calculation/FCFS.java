package al19136.calculation;

public class FCFS extends Process {
	@Override
	public void calc() {
		sortArrival();
		for(int i=0;psList.size()>0||readyList.size()>0;i++) {
			addReadyList(i);
			if(readyList.size()>0) {
				execute(readyList.get(0).getRemaining());
			}else {
				execute(DO_NOTHING);
			}
		}
	}
}
