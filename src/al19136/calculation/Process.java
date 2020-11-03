package al19136.calculation;

import java.util.ArrayList;
import java.util.Collections;

import al19136.calculation.comparator.ArrivalTimeComparator;
import al19136.process.ProcessData;
import al19136.process.ProcessStatus;

public abstract class Process implements ProcessStatus {
	protected ArrayList<ProcessData> psList = new ArrayList<>();
	protected ArrayList<ProcessData> readyList = new ArrayList<>();
	public ArrayList<ProcessData> timeTable = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public void setPSList(ArrayList<ProcessData> psList) {
		this.psList = (ArrayList<ProcessData>)psList.clone();
	}
	protected void addReadyList(int time) {
		if(psList.size()>0) {
			for(int i=0;psList.get(i).isArrived(time)&&i<psList.size();i++) {
				readyList.add(new ProcessData(psList.get(i)));
				psList.remove(i--);
				if(psList.size()==0) {
					break;
				}
			}
		}
	}
	protected void execute(int quantum) {
		if(readyList.size()==0) {
			ProcessData psdata = new ProcessData();
			psdata.setPid(DO_NOTHING);
			timeTable.add(psdata);
		}else {
			readyList.get(0).execute(quantum);
			timeTable.add(new ProcessData(readyList.get(0)));
			if(readyList.get(0).getRemaining() == FINISHED) {
				readyList.remove(0);
			}
		}
	}
	protected void sortArrival() {
		Collections.sort(psList,new ArrivalTimeComparator());
	}
	public String getTimeTable(int time) {
		StringBuilder sb = new StringBuilder();
		if(time<timeTable.size()) {
			if(timeTable.get(time).getPid() != DO_NOTHING) {
				sb.append("Process");
				sb.append(timeTable.get(time).getPid());
			}else {
				sb.append("DO_NOTHING");
			}
		}else {
			sb.append("DO_NOTHING");
		}
		return sb.toString();
	}
	public Object getTurnAroundTime(int pid) {
		for (int time = 0;time < timeTable.size();time++) {
			if (timeTable.get(time).getPid() == pid && timeTable.get(time).getRemaining() == 0) {
				return time - timeTable.get(time).getArrivalTime() + 1;
			}
		}
		return null;
	}
	public abstract void calc();
}
