package al19136.process;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Process {
	protected ArrayList<ProcessData> psList = new ArrayList<>();
	protected ArrayList<ProcessData> readyList = new ArrayList<>();
	public ArrayList<ProcessData> timeTable = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	public void setpsList(ArrayList<ProcessData> psList) {
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
			psdata.setPid(ProcessData.DO_NOTHING);
			timeTable.add(psdata);
		}else {
			readyList.get(0).execute(quantum);
			timeTable.add(new ProcessData(readyList.get(0)));
			if(readyList.get(0).getTime()==ProcessData.FINISHED) {
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
			if(timeTable.get(time).getPid()!=ProcessData.DO_NOTHING) {
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
	public abstract void calc();
}
