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
15
Input priority of the process.
10
Input how long does the process take.
9
Process1
Input the arrival time of the process.
1
Input the deadline of the process.
21
Input priority of the process.
4
Input how long does the process take.
9
Process2
Input the arrival time of the process.
5
Input the deadline of the process.
31
Input priority of the process.
12
Input how long does the process take.
8

FCFS :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        Process1
2:      Process0        Process1
3:      Process0        Process1
4:      Process0        Process1
5:      Process0        Process1
6:      Process0        Process1
7:      Process0        Process1
8:      Process0        Process1
9:      Process2        Process1
10:     Process2        DO_NOTHING
11:     Process2        DO_NOTHING
12:     Process2        DO_NOTHING
13:     Process2        DO_NOTHING
14:     Process2        DO_NOTHING
15:     Process2        DO_NOTHING
SPT :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        Process1
2:      Process0        Process1
3:      Process0        Process1
4:      Process0        Process1
5:      Process0        Process1
6:      Process0        Process1
7:      Process0        Process1
8:      Process0        Process1
9:      Process2        Process1
10:     Process2        DO_NOTHING
11:     Process2        DO_NOTHING
12:     Process2        DO_NOTHING
13:     Process2        DO_NOTHING
14:     Process2        DO_NOTHING
15:     Process2        DO_NOTHING
Deadline :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        Process1
2:      Process0        Process1
3:      Process0        Process1
4:      Process0        Process1
5:      Process0        Process1
6:      Process0        Process1
7:      Process0        Process1
8:      Process0        Process1
9:      Process2        Process1
10:     Process2        DO_NOTHING
11:     Process2        DO_NOTHING
12:     Process2        DO_NOTHING
13:     Process2        DO_NOTHING
14:     Process2        DO_NOTHING
15:     Process2        DO_NOTHING
Priority :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        Process1
2:      Process0        Process1
3:      Process0        Process1
4:      Process0        Process1
5:      Process0        Process1
6:      Process0        Process1
7:      Process0        Process1
8:      Process0        Process1
9:      Process2        Process1
10:     Process2        DO_NOTHING
11:     Process2        DO_NOTHING
12:     Process2        DO_NOTHING
13:     Process2        DO_NOTHING
14:     Process2        DO_NOTHING
15:     Process2        DO_NOTHING
RoundRobin :
        Processor0      Processor1
0:      Process0        DO_NOTHING
1:      Process0        Process1
2:      Process0        Process1
3:      Process0        Process1
4:      Process0        Process1
5:      Process0        Process2
6:      Process1        Process2
7:      Process1        Process0
8:      Process2        Process0
9:      Process2        Process1
10:     Process0        Process1
11:     Process2        Process1
12:     Process2        DO_NOTHING
13:     Process2        DO_NOTHING

FCFS:
        Process0:
                TurnAroundTime : 9.0
        Process1:
                TurnAroundTime : 9.0
        Process2:
                TurnAroundTime : 11.0
        Average : 9.666666666666666

SPT:
        Process0:
                TurnAroundTime : 9.0
        Process1:
                TurnAroundTime : 9.0
        Process2:
                TurnAroundTime : 11.0
        Average : 9.666666666666666

Deadline:
        Process0:
                TurnAroundTime : 9.0
        Process1:
                TurnAroundTime : 9.0
        Process2:
                TurnAroundTime : 11.0
        Average : 9.666666666666666

Priority:
        Process0:
                TurnAroundTime : 9.0
        Process1:
                TurnAroundTime : 9.0
        Process2:
                TurnAroundTime : 11.0
        Average : 9.666666666666666

RoundRobin:
        Process0:
                TurnAroundTime : 11.0
        Process1:
                TurnAroundTime : 11.0
        Process2:
                TurnAroundTime : 9.0
        Average : 10.333333333333334

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
