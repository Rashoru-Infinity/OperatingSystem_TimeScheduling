# OperatingSystem_TimeScheduling
This is a simulator for CPU time scheduling.

# Demo
The following is the execution example of the simulator.

=================================================================

C:\Users\65536\Documents\src>java al19136.Main

Input the number of processes.

3

Input a quantum.

2

Process0

Input the arrival time of the process.

0

Input the deadline of the process.

10

Input priority of the process.

1

Input how long does the process take.

4

Process1

Input the arrival time of the process.

2

Input the deadline of the process.

6

Input priority of the process.

3

Input how long does the process take.

4

Process2

Input the arrival time of the process.

4

Input the deadline of the process.

9

Input priority of the process.

5

Input how long does the process take.

2

  FCFS       SPT        Deadline   Priority   RoundRobin
  
0:Process0   Process0   Process0   Process0   Process0

1:Process0   Process0   Process0   Process0   Process0

2:Process0   Process0   Process1   Process0   Process1

3:Process0   Process0   Process1   Process0   Process1

4:Process1   Process2   Process1   Process2   Process0

5:Process1   Process2   Process1   Process2   Process0

6:Process1   Process1   Process2   Process1   Process2

7:Process1   Process1   Process2   Process1   Process2

8:Process2   Process1   Process0   Process1   Process1

9:Process2   Process1   Process0   Process1   Process1

10:DO_NOTHING   DO_NOTHING   DO_NOTHING   DO_NOTHING   DO_NOTHING

=================================================================

First, please input some informations follow the instructions.

After that, simulator simulates CPU time scheduling.

Finally, this program displays the result on the console.
