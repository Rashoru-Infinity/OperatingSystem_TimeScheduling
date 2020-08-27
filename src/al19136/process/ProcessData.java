package al19136.process;

public class ProcessData {
	private int time;
	private int priority;
	private int pid;
	private int arrivalTime;
	private int deadline;
	private boolean executing = false;
	private int quantum;
	private boolean changeable = false;
	public static final int FINISHED = 0;
	public static final int DO_NOTHING = -1;
	
	public ProcessData(ProcessData psdata) {
		time = psdata.getTime();
		priority = psdata.getPriority();
		pid = psdata.getPid();
		arrivalTime = psdata.getArrivalTime();
		deadline = psdata.getDeadline();
		executing = psdata.isExecuting();
		quantum = psdata.getQuantum();
		changeable = psdata.isChangeable();
	}
	public ProcessData() {
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public void initStatus(int quantum) {
		start(quantum);
	}
	private void start(int quantum) {
		executing = true;
		changeable = false;
		setQuantum(quantum);
	}
	private void stop() {
		if(changeable) {
			executing = false;
		}
	}
	public int getTime() {
		return time;
	}
	public int getPriority() {
		return priority;
	}
	public int getPid() {
		return pid;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getDeadline() {
		return deadline;
	}
	public boolean isArrived(int time) {
		if(arrivalTime<=time) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isExecuting() {
		return executing;
	}
	public void execute(int quantum) {
		if(!isExecuting()) {
			start(quantum);
		}
		time--;
		this.quantum--;
		if(isChangeable()) {
			stop();
		}
	}
	private boolean isChangeable() {
		if(quantum<=ProcessData.FINISHED) {
			changeable = true;
		}else {
			changeable = false;
		}
		return changeable;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	public int getQuantum() {
		return quantum;
	}
}
