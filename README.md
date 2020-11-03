# OperatingSystem_TimeScheduling
This is a simulator for CPU time scheduling.

# Demo
The following is the execution example of the simulator.

```
OperatingSystem_TimeScheduling/src/bin$ java al19136.Main
Input the number of processors.
2
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

FCFS :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        DO_NOTHING
2:      Process0        Process1
3:      Process0        Process1
4:      Process1        Process2
5:      Process1        Process2
SPT :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        DO_NOTHING
2:      Process0        Process1
3:      Process0        Process1
4:      Process1        Process2
5:      Process1        Process2
Deadline :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        DO_NOTHING
2:      Process1        Process0
3:      Process1        Process0
4:      Process1        Process2
5:      Process1        Process2
Priority :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        DO_NOTHING
2:      Process1        Process0
3:      Process1        Process0
4:      Process2        Process1
5:      Process2        Process1
RoundRobin :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        DO_NOTHING
2:      Process0        Process1
3:      Process0        Process1
4:      Process1        Process2
5:      Process1        Process2

FCFS:
        Process0:
                TurnAroundTime : 4.0
        Process1:
                TurnAroundTime : 4.0
        Process2:
                TurnAroundTime : 2.0
        Average : 3.3333333333333335

SPT:
        Process0:
                TurnAroundTime : 4.0
        Process1:
                TurnAroundTime : 4.0
        Process2:
                TurnAroundTime : 2.0
        Average : 3.3333333333333335

Deadline:
        Process0:
                TurnAroundTime : 4.0
        Process1:
                TurnAroundTime : 4.0
        Process2:
                TurnAroundTime : 2.0
        Average : 3.3333333333333335

Priority:
        Process0:
                TurnAroundTime : 4.0
        Process1:
                TurnAroundTime : 4.0
        Process2:
                TurnAroundTime : 2.0
        Average : 3.3333333333333335

RoundRobin:
        Process0:
                TurnAroundTime : 4.0
        Process1:
                TurnAroundTime : 4.0
        Process2:
                TurnAroundTime : 2.0
        Average : 3.3333333333333335

```

First, please input some informations follow the instructions.

After that, simulator simulates CPU time scheduling.

Finally, this program displays the result on the console.

# Process to execute
```
$ git clone https://github.com/Rashoru-Infinity/OperatingSystem_TimeScheduling.git
$ cd OperatingSystem_TimeScheduling
$ sudo apt install ant
$ cd src
$ ant
$ cd bin
$ java al19136.Main
```
