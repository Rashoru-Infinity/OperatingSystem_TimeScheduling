package al19136.calculation;

import al19136.process.ProcessData;

public class RoundRobin extends Process {
	private int quantum;
	public RoundRobin(int quantum) {
		this.quantum = quantum;
	}
	@Override
	public void calc() {
		sortArrival();
		for(int i=0;psList.size()>0||readyList.size()>0;i++) {
			addReadyList(i);
			execute(quantum);
		}
	}
	@Override
	protected void addReadyList(int time) {
		if(psList.size()>0) {
			for(int i=0;psList.get(i).isArrived(time)&&i<psList.size();i++) {
				ProcessData arrivedProcess = new ProcessData(psList.get(i));
				arrivedProcess.setQuantum(quantum);
				arrivedProcess.initStatus(arrivedProcess.getQuantum());
				readyList.add(arrivedProcess);
				psList.remove(i--);
				if(psList.size()==0) {
					break;
				}
			}
		}
	}
	@Override
	protected void execute(int quantum) {
		if(readyList.size()>0) {
			if(!readyList.get(0).isExecuting()) {
				readyList.add(new ProcessData(readyList.get(0)));
				readyList.remove(0);
			}
		}
		super.execute(quantum);
	}
}
