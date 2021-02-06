#### Multithreading

#### 1. Process vs threads
1. Threads can share memory but processes don't. Process consists of multiple threads
2. Thread is smalled unit of execution in process


##### 2. Problems
1. Hard to find bugs
2. Higher cost of maintenance
3. Increased utilisation of system resources: Waste of time in context switches
4. Program may experience slowdown.

##### 3. Concurrency vs Parallelism

##### Concurrency

a ----> b -----> c ----> d    [one coffee machine]

e ----> f -----> g ----> h

##### Parallelism

a ----> b -----> c ----> d    [one coffee machine]

e ----> f -----> g ----> h    [one coffee machine]

##### 4. Preemptive vs Cooperative multitasking

###### Preemptive multitasking
* THE CPU juggles b/w different programs to allow others to run on CPU.

###### Cooperative multitasking
* Involves well-behaved programs to give up control back to scheduler.
* A malicious program can bring the entire state to halt by not giving the control

##### 5. Sync vs async
###### Sync: 
Serial Execution
###### Async: 
1. Asynchronous programming is a means of parallel programming in which a unit of work runs separately from the main application thread and notifies the calling thread of its completion, failure or progress
2. Asynchronous programming is an excellent choice for applications that do extensive network or disk I/O and spend most of their time waiting

##### 5. CPU Bound vs IO bound

CPU Bound: Compute intensive
Theoretically, the multithreaded program should finish in half the time that it takes for the single-threaded program. However, there will be a slight overhead of creating the two threads and merging the results from the two threads.

IO Bound:Io intensive. Waits i/p and o/p to complete while CPU sits idle

If a program is CPU bound we can increase the number of processors and structure our program to spawn multiple threads that individually run on a dedicated or shared CPU.
For I/O bound programs, it makes sense to have a thread give up CPU control if it is waiting for an I/O operation to complete so that another thread can get scheduled on the CPU and utilize CPU cycles

##### 6. Throughput vs latency
Throughput is defined as the rate of doing work
Latency is defined as the time required to complete a task or produce a result.

##### 7. Critical sections and race condition
Critical section: Piece of code to be executed concurrently by more than one thread and exposed shared data.
Race condition: When thread runs without sync causing application to be inconsistent.

##### 8. Deadlocks, Liveliness and reentrant locks
###### Deadlock
2 or more threads are not able to make any progress
A -> B and B -> A
###### Liveliness
Ability of program to execute in a timely manner.

###### Live Lock
A live-lock occurs when two threads continuously react in response to the actions by the other thread without making any real progress

Person X and Person Y wants to cross 
Person X moves right and person Y moves left and both again in deadlock
###### Starvation