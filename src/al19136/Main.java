package al19136;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import al19136.calculation.*;
import al19136.calculation.Process;
import al19136.process.*;

public class Main implements ProcessStatus {
	private static ArrayList<ProcessData> psList = new ArrayList<>();
	private static int quantum;
	private static ArrayList<Process> timeTable;
	private static int processors;
	public static void main(String[] args) {
		setProcess();
		System.out.println("");
		executeProcess();
		printTimeTable();
		System.out.println("");
		printTurnAroundTime();
	}
	private static void setProcess() {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Input the number of processors.");
		while (true) {
			try {
				processors = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.next();
				continue;
			}
			if (processors > 0) {
				break;
			}else {
				System.out.println("Negative number and zero are invalid");
			}
		}
		while (true) {
			System.out.println("Input the number of processes.");
			try {
				n = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.next();
				continue;
			}
			if (n >= 0) {
				break;
			}else {
				System.out.println("Negative number is invalid.");
			}
		}
		while (true) {
			System.out.println("Input a quantum.");
			try {
				quantum = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.next();
				continue;
			}
			if (quantum > 0) {
				break;
			}else {
				System.out.println("Zero and Negative number are invalid.");
			}
		}
		for(int i=0;i<n;i++) {
			ProcessData ps = new ProcessData();
			StringBuilder sb = new StringBuilder();
			sb.append("Process");
			sb.append(String.valueOf(i));
			System.out.println(sb.toString());
			ps.setPid(i);
			while (true) {
				System.out.println("Input the arrival time of the process.");
				int x;
				try {
					x = sc.nextInt();
				}catch(InputMismatchException e) {
					sc.next();
					continue;
				}
				if (x < 0) {
					System.out.println("Negative number is invalid.");
					sc.next();
					continue;
				}
				ps.setArrivalTime(x);
				break;
			}
			while (true) {
				System.out.println("Input the deadline of the process.");
				int x;
				try {
					x = sc.nextInt();
				}catch(InputMismatchException e) {
					sc.next();
					continue;
				}
				ps.setDeadline(x);
				break;
			}
			while (true) {
				System.out.println("Input priority of the process.");
				int x;
				try {
					x = sc.nextInt();
				}catch(InputMismatchException e) {
					sc.next();
					continue;
				}
				ps.setPriority(x);
				break;
			}
			while (true) {
				System.out.println("Input how long does the process take.");
				int x;
				try {
					x = sc.nextInt();
				}catch(InputMismatchException e) {
					sc.next();
					continue;
				}
				if (x > 0) {
					ps.setTime(x);
					break;
				}else {
					System.out.println("Zero and Negative number are invalid.");
				}
			}
			psList.add(ps);
		}
		sc.close();
	}
	private static void executeProcess() {
		timeTable = new ArrayList<>();
		timeTable.add(new FCFS(processors));
		timeTable.add(new SPT(processors));
		timeTable.add(new Deadline(processors));
		timeTable.add(new Priority(processors));
		timeTable.add(new RoundRobin(processors, quantum));
		for(int i=0;i<timeTable.size();i++) {
			timeTable.get(i).setPSList(psList);
			timeTable.get(i).calc();
		}
	}
	
	private static void printTimeTable() {
		final int packageNameLength = 20;
		StringBuilder sb = new StringBuilder();
		for (Process p : timeTable) {
			sb.delete(0, sb.length());
			String str = p.getClass().getName();
			sb.append(str.substring(packageNameLength));
			sb.append(" : ");
			System.out.println(sb.toString());
			sb.delete(0,  sb.length());
			sb.append("  ");
			for (int i = 0;i < processors;i++) {
				sb.append("\tProcessor");
				sb.append(i);
			}
			System.out.println(sb.toString());
			for (int time = 0;time < p.getTotalTime();time++) {
				sb.delete(0, sb.length());
				int pid;
				sb.append(String.valueOf(time));
				sb.append(":");
				for (int i = 0;i < processors;i++) {
					sb.append("\t");
					pid = p.getTimeTable(time, i);
					switch(pid) {
					case DO_NOTHING:
						sb.append("DO_NOTHING");
						break;
					default:
						sb.append("Process");
						sb.append(String.valueOf(pid));
						break;
					}
				}
				System.out.println(sb.toString());
			}
		}
	}
	private static void printTurnAroundTime() {
		final int packageNameLength = 20;
		for (Process p : timeTable) {
			double total = 0;
			StringBuilder sb = new StringBuilder();
			sb.append(p.getClass().getName().substring(packageNameLength));
			sb.append(":");
			System.out.println(sb.toString());
			for (int pid = 0;pid < psList.size();pid++) {
				Double turnAroundTime = p.getTurnAroundTime(pid);
				if (turnAroundTime == null) {
					continue;
				}
				sb.delete(0, sb.length());
				sb.append("\tProcess");
				sb.append(String.valueOf(pid));
				sb.append(":\n");
				sb.append("\t\tTurnAroundTime : ");
				sb.append(turnAroundTime.toString());
				System.out.println(sb.toString());
				total += turnAroundTime.doubleValue();
			}
			sb.delete(0, sb.length());
			sb.append("\tAverage : ");
			sb.append(String.valueOf(total / psList.size()));
			sb.append("\n");
			System.out.println(sb.toString());
		}
	}
}
