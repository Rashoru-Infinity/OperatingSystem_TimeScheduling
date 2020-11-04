package al19136.processors;

import al19136.process.ProcessData;
import al19136.process.ProcessStatus;

public class Processors implements ProcessStatus {
	protected ProcessData[] processors;
	protected static final int NOT_FOUND = -1;
	public Processors (int processors, Processors prevContexts) {
		this.processors = new ProcessData[processors];
		for (int i = 0;i < processors;i++) {
			if (prevContexts == null) {
				this.processors[i] = new ProcessData();
				this.processors[i].setPid(DO_NOTHING);
			}else {
				if (!prevContexts.getContext(i).isChangeable()) {
					this.processors[i] = new ProcessData(prevContexts.getContext(i));
				}else {
					this.processors[i] = new ProcessData();
					this.processors[i].setPid(DO_NOTHING);
				}
			}
		}
	}
	public boolean allocateProcess(ProcessData waitingProcess) {
		boolean foundEmpty = false;
		int emptyIndex = NOT_FOUND;
		for (int i = 0;i < processors.length;i++) {
			if (processors[i].getPid() == waitingProcess.getPid()) {
				processors[i].execute(processors[i].getQuantum());
				return true;
			}
			if (processors[i].getPid() == DO_NOTHING && !foundEmpty) {
				foundEmpty = true;
				emptyIndex = i;
			}
		}
		if (foundEmpty) {
			processors[emptyIndex] = new ProcessData(waitingProcess);
			processors[emptyIndex].execute(processors[emptyIndex].getQuantum());
		}
		return foundEmpty;
	}
	public ProcessData getContext(int index) {
		return processors[index];
	}
	public void fillDoNothing() {
		for (int i = 0;i < processors.length;i++) {
			processors[i] = new ProcessData();
			processors[i].setPid(DO_NOTHING);
		}
	}
}
