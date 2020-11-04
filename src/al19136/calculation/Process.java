package al19136.calculation;

import java.util.ArrayList;
import java.util.Collections;

import al19136.calculation.comparator.ArrivalTimeComparator;
import al19136.process.ProcessData;
import al19136.process.ProcessStatus;
import al19136.processors.Processors;

public abstract class Process implements ProcessStatus {
	protected ArrayList<ProcessData> psList = new ArrayList<>();
	protected ArrayList<ProcessData> readyList = new ArrayList<>();
	protected ArrayList<Processors> processorsStatus = new ArrayList<>();
	protected int processors;
	
	public Process(int processors) {
		this.processors = processors;
	}
	
	@SuppressWarnings("unchecked")
	public void setPSList(ArrayList<ProcessData> psList) {
		this.psList = (ArrayList<ProcessData>)psList.clone();
	}
	protected void addReadyList(int time) {
		if(psList.size() > 0) {
			for(int i = 0;psList.get(i).isArrived(time) && i < psList.size();i++) {
				readyList.add(new ProcessData(psList.get(i)));
				psList.remove(i--);
				if(psList.size() == 0) {
					break;
				}
			}
		}
	}
	protected void execute() {
		Processors currentStatus;
		if(readyList.size() == 0) {
			currentStatus = new Processors(processors, null);
			currentStatus.fillDoNothing();
		}else {
			if (processorsStatus.size() != 0) {
				currentStatus = new Processors(processors, processorsStatus.get(processorsStatus.size() - 1));
			}else {
				currentStatus = new Processors(processors, null);
			}
			for (int i = 0;i < readyList.size() && i < processors;i++) {
				currentStatus.allocateProcess(readyList.get(i));
				readyList.get(i).execute(readyList.get(i).getQuantum());
				if (readyList.get(i).getRemaining() == FINISHED) {
					readyList.remove(i--);
				}
			}
		}
		processorsStatus.add(currentStatus);
	}
	protected void sortArrival() {
		Collections.sort(psList,new ArrivalTimeComparator());
	}
	public int getTimeTable(int time, int processorID) {
		return processorsStatus.get(time).getContext(processorID).getPid();
	}
	public Double getTurnAroundTime(int pid) {
		for (int time = 0;time < processorsStatus.size();time++) {
			for (int p = 0;p < processors;p++) {
				if (processorsStatus.get(time).getContext(p).getPid() == pid && processorsStatus.get(time).getContext(p).getRemaining() == 0) {
					return new Double(time - processorsStatus.get(time).getContext(p).getArrivalTime() + 1);
				}
			}
		}
		return null;
	}
	public int getTotalTime() {
		return processorsStatus.size();
	}
	public abstract void calc();
}
