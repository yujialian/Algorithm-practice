## CPU scheduling I
	Decide which process to execute and when.
	
## What is CPU burst?
	  CPU burst is when the process is being executed in the CPU(A period of uninterrupted CPU activity. I/O burst is when the CPU is waiting for I/O for further execution. After I/O burst, the process goes to ready queue for the next CPU burst.
	Process execution begin with a CPU burst, followed by a I/O burst.
	
### CPU-I/O Burst Cycle
	Process execution consists of a cycle of CPU execution and I/O wait.
	
### Process state: new, ready, running, waiting, terminated.

### CPU Scheduler
	Select from among the processes in memory that are ready to execute, and allocates the CPU to one of them.
	
### CPU scheduling decisions may take place when a process:
	1. A new process arrives
	2. Terminates
	3. Switches from running to waiting state
	4. Switches from running to ready state
	5. Switches from waiting to ready 
	
### Terminates, switches from running to waiting state is non preemptive(不可中断）/cooperative(合作）
	Once a process gets the CPU, keeps it until termination/switching to waiting state/release of the CPU 
	
### All other scheduling is preemptive（可中断）

## Dispatcher
	Dispatcher module gives control of the CPU to the process selected by the short-term scheduler;
	– switching context
	– switching to user mode
	– jumping to the proper location in the user program to restart that program 
	Dispatch latency – time it takes for the dispatcher to stop one process and start another running
	
### Optimization Criteria
	• Maximize CPU utilization
	• Maximize throughput
	• Minimize turn around time
	• Minimize waiting time
	• Minimize response time
	
# First-Come, First-Served (FCFS) Scheduling

	# processes are assigned the CPU in the order they request it
	# when the running process blocks, the first “Ready” is run next
	# when a process gets “Ready”, it is put at the end of the queue
	
### Waiting time – total amount of time a process has been waiting in the ready queue 

### Response time – amount of time it takes from when a request was submitted until the first response is produced, not output (for time-sharing environment) 

### Turn around time – amount of time passed to finish execution of a particular process 

### PROS:
	• It is a fair algorithm
		– schedule in the order that they arrive 
### CONS:
	• Average response time can be lousy
		– small requests wait behind big ones (convoy effect)
	• May lead to poor utilization of other resources
	 – FCFS may result in poor overlap of CPU and I/O activity
		• E.g., a CPU-intensive job prevents an I/O-intensive job from doing a small bit of 			computation, thus preventing it from going back and keeping the I/O subsystem busy


# Shortest-Job-First (SJF) Scheduling

### Associate with each process the length of its next CPU burst. Use these lengths to schedule the process with the shortest time 

### Two schemes:
	– non preemptive – once CPU given to the process it cannot be preempted until completes its CPU burst
	– preemptive – if a new process arrives with CPU burst length less than remaining time of current executing process, preempt. -->This scheme is know as the Shortest-Remaining-Time-First 
	- SJF is optimal – gives minimum average waiting time for a given set of processes
	
### PROS:
	• Provably(证明地) optimal with respect to average waiting time
	– prevents convoy(护送) effect (long delay of short jobs) 
	
### CONS:
	• Can cause starvation of long jobs
	• Requires advanced knowledge of CPU burst times
	– this can be very hard to predict accurately
	
# Non-Preemptive SJF
	non preemptive, assumes the run times are known in advance
	among several equally important “Ready” jobs (or CPU bursts), the scheduler picks the one that will finish the earliest
	
### Preemptive SJF (SRT)
	preemptive version of SJF, also assumes known run time choose the process whose remaining run time is shortest allows new short jobs to get good service
	
# Priority Scheduling
	• A priority number (integer) is associated with each process
	• The CPU is allocated to the process with the highest priority (smallest integer ≡ highest priority) [Preemptive, non preemptive].
	• SJF is a priority scheduling where priority is the predicted next CPU burst time
	
	Problem ≡ Starvation – low priority processes may never execute
	Solution ≡ Aging – as time progresses increase the priority of the process
	
### PROS:
	• Guarantees early completion of high priority jobs 
### CONS:
	• Can cause starvation of low priority jobs
	• How to decide/assign priority numbers?
	
# Round Robin scheduling
	Each process gets a small unit of CPU time (time quantum(定量)), usually 10-100 milliseconds. After this time has elapsed, the process is preempted and added to the end of the ready queue. 

	If there are n processes in the ready queue and the time quantum is q, then each process gets 1/n of the CPU time in chunks of at most q time units at once. No process waits more than (n-1)q time units. 
	
	Performance
      – q large ⇒ FIFO
      – q small ⇒ q must be large with respect to context switch, otherwise overhead is too high
	
	preemptive FCFS, based on a timeout interval, the quantum q.
	the running process is interrupted by the clock and put last in a FIFO “Ready” queue; then, the first “Ready” process is run instead
	
### PROS: 
	Great for timesharing
	no starvation
	Does not require prior knowledge of CPU burst times
	Generally reduces average response time 
### CONS:
	• What if all jobs are almost time same length?
	– Increases the turn around time
	• How to set the “best” time quantum?
	– if small, then context switch often, incurring high overhead
	– if large, then response time degrades

# Context switch
	In computing, a context switch is the process of storing the state of a process or of a thread, so that it can be restored and execution resumed from the same point later. This allows multiple processes to share a single CPU, and is an essential feature of a multitasking operating system.

# a crucial parameter is the quantum q (generally ~10–100ms) 
	q should be big compared to context switch latency (~10µs)
	q should be less than the longest CPU bursts, otherwise RR degenerates(退化) to FCFS
	
	
# Multilevel Feedback Queue scheduling
	• A process can move between the various queues; aging can be implemented this way 
	
## Multilevel-feedback-queue scheduler defined by the following parameters: 
	– number of queues
	– scheduling algorithms for each queue
	– method used to determine which queue a process will enter when that process needs service
	– method used to determine when to upgrade a process
	– method used to determine when to degrade a process
	
	
# BSD Priority Scheduling

### BSD scheduler has 64 priorities and thus 64 ready queues, numbered 0 (PRI_MIN) through 63 (PRI_MAX). 

### Lower numbers correspond to lower priorities in 4.4BSD, so that priority 0 is the lowest priority and priority 63 is the highest.

### Only threads with the highest run, if more than one, round robin.

### It gives a thread that has received CPU time recently lower priority for being reassigned the CPU the next time the scheduler runs.



# Lecture 8 Process Synchronization - I

### Concurrent access to shared data may result in data inconsistency 

### Maintaining data consistency requires mechanisms to ensure the orderly execution of cooperating processes 

## Race condition: 
	The situation where several processes access and manipulate shared data concurrently. The final value of the shared data depends upon which process finishes last. 
### To prevent race conditions:
	concurrent processes must be synchronized(同步的).
	Ensure that only one process at a time is manipulating the variable counter.

## Significant race conditions in I/O & variable sharing
### in this case, replacing the global variables with local variables did not solve the problem

##Two race conditions here: 
	one race condition in the shared variables and the order of value assignment 
	another race condition in the shared output stream: which thread is going to write to output first (this race persisted even after making the variables local to each thread)
 
## Critical section/region: " The “indivisible” execution blocks are critical regions 
	segment of code in which the process may be changing shared data (eg. common variables) 
	No two processes should be executing in their critical sections at the same time --> prevents race conditions
	Critical section problem: design a protocol that the processes use to cooperate
	
### a critical region is a section of code that should be executed by only one process or thread at a time
### although it is not necessarily the same region of memory or section of program in both processes

# Solution

## Requirements:

	Mutual Exclusion - If process Pi is executing in its critical section, then no other processes can be executing in their critical sections
	
	Progress - If no process is executing in its critical section and there exist some processes that wish to enter their critical section, then the selection of the processes that will enter the critical section next cannot be postponed indefinitely
	
	Bounded Waiting - A bound(limit) must exist on the number of times that other processes are allowed to enter their critical sections after a process has made a request to enter its critical section and before that request is granted.
	! Assume that each process executes at a nonzero speed 
	! No assumption concerning relative speed of the N processes
	
## Solution:
### Mutual Exclusion
	critical regions can be protected from concurrent access by padding them with entrance and exit gates (we’ll see how later): a thread must try to check in, then it must check out
### Desired effect: mutual exclusion from the critical region

# Implementation 1 — disabling hardware interrupts 
	No guarantees that the user process is going to ever exit the critical region.
	The CPU can not interleave other task.
	Critical region becomes one physically indivisible block, not logically.
	Not working in multi-processors
	
# Implementation 2 — simple lock variable:A enter CR, set lock to one, prevqent B from entering, reset to 0 when A exit.
	 1.the “lock” is a shared variable
	 2. entering the critical region means testing and then setting the lock 
	 3. exiting means resetting the lock
	 
	 X1: Can not prevent from A and B trying to set lock at the same time. a race condition
	 x2: The problem comes from the small gap between testing that the lock is off and setting the lock 
	 X3: it may happen that the other thread gets scheduled exactly in between these two actions (falls in the gap) so they both find the lock off and then they both set it and enter
	 
# Implementation 3 — “indivisible” lock variable 

	the indivisibility of the “test-lock-and-set-lock” operation can be implemented with the hardware instruction TSL
	 
# Implementation 4 — no-TSL toggle for two threads
	thread B exits CR and switches the lock back to 0 to allow A to enter next 
	
# Implementation 5 — Peterson’s no-TSL, no-alternation

	
	 

	
	
	
