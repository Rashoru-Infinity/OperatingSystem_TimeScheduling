package al19136;

import java.util.Scanner;
import java.util.ArrayList;

import al19136.calculation.*;
import al19136.process.*;
import al19136.process.Process;

public class Main {
	private static ArrayList<ProcessData> psList = new ArrayList<>();
	private static int quantum;
	public static void main(String[] args) {
		setProcess();
		executeProcess();
	}
	private static void setProcess() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the number of processes.");
		int n = sc.nextInt();
		System.out.println("Input a quantum.");
		quantum = sc.nextInt();
		for(int i=0;i<n;i++) {
			ProcessData ps = new ProcessData();
			System.out.println("Process"+i);
			ps.setPid(i);
			System.out.println("Input the arrival time of the process.");
			ps.setArrivalTime(sc.nextInt());
			System.out.println("Input the deadline of the process.");
			ps.setDeadline(sc.nextInt());
			System.out.println("Input priority of the process.");
			ps.setPriority(sc.nextInt());
			System.out.println("Input how long does the process take.");
			ps.setTime(sc.nextInt());
			psList.add(ps);
		}
		sc.close();
	}
	private static void executeProcess() {
		ArrayList<Process> timeTable = new ArrayList<>();
		timeTable.add(new FCFS());
		timeTable.add(new SPT());
		timeTable.add(new Deadline());
		timeTable.add(new Priority());
		RoundRobin rr = new RoundRobin();
		rr.setQuantum(quantum);
		timeTable.add(rr);
		for(int i=0;i<timeTable.size();i++) {
			timeTable.get(i).setpsList(psList);
			timeTable.get(i).calc();
		}
		printTimeTable(timeTable);
	}
	
	private static void printTimeTable(ArrayList<Process> timeTable) {
		final int space = 11;
		final int packageNameLength = 20;
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for(int i=0;i<timeTable.size();i++) {
			String str = timeTable.get(i).getClass().getName();
			sb.append(str.substring(packageNameLength));
			for(int j=0;j<space-str.substring(packageNameLength).length();j++) {
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());
		sb.delete(0,sb.length());
		for(int i=0;;i++) {
			sb.append(i);
			sb.append(":");
			for(int j=0;j<timeTable.size();j++) {
				sb.append(timeTable.get(j).getTimeTable(i));
				sb.append("   ");
			}
			System.out.println(sb.toString());
			if(timeTable.get(0).timeTable.size()<=i) {
				break;
			}
			sb.delete(0, sb.length());
		}
	}
}
