package al19136.calculation;

import al19136.process.ProcessData;

public class RoundRobin extends Process {
	private int quantum;
	public RoundRobin(int processors, int quantum) {
		super(processors);
		this.quantum = quantum;
	}
	@Override
	public void calc() {
		sortArrival();
		for(int i = 0;psList.size() > 0 || readyList.size() > 0;i++) {
			addReadyList(i);
			for (int j = 0;j < readyList.size();j++) {
				if (readyList.get(j).isExecuting()) {
					readyList.get(j).setQuantum(quantum);
				}
			}
			execute();
		}
	}
	@Override
	protected void addReadyList(int time) {
		if(psList.size() > 0) {
			for(int i = 0;psList.get(i).isArrived(time) && i < psList.size();i++) {
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
	protected void execute() {
		for (int i = 0;i < readyList.size();i++) {
			if (!readyList.get(i).isExecuting()) {
				readyList.add(new ProcessData(readyList.get(i)));
				readyList.remove(i--);
			}
		}
		super.execute();
	}
}
