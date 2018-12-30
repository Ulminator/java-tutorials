# Concurrency and Multi Threading

#### What is a Thread?

- A thread is defined at the OS level.
- A thread is a set of instructions.
- An application can be composed of several threads.
- Different threads can be executed "at the same time"
- JVM works with several threads (GC, JIT, ...)

#### Who is responsible for the CPU sharing?

- A special element called a `scheduler`.
- There are three reasons for the scheduler to pause a thread:
    - The CPU should be shared equally among threads.
    - The thread is waiting for some more data. (I/O operations)
    - The thread is waiting for another thread to do something. (release a resource)

#### Race Conditions

- Accessing data concurrently may lead to issues.
    - 2 different threads are trying to read and write the same variable at the same time.
    - This is a race condition.
    - "same time" does not mean the same thing on a single core and on a multi core CPU.

## Singleton Pattern

- Synchronization
    - How to handle Singleton with multithreading?
    - Prevents a block of code to be executed by more than one thread at the same time.
    
    - For Synchronization to work, we need a special, technical object that will hold the key.
    - This key is defined internally in the Object class, making it accessible for every class.
    - This key is also called a monitor.

    - Synchronized on a static method - The key is held by the class object.
    - Synchronized on a non static method - The key is held by an instance of the class.
    
## Reentrant Locks and Deadlocks

- Locks are reentrant
    - If a synchronized method in one instance of an object calls a synchronized method in another instance of that object,
     then it will still work since the thread making that call already has the key. 
    - When a thread holds a lock, it can enter a block synchronized on the lock it is holding.

- Deadlocks
    - A situation where a thread T1 holds a key needed by a thread T2, and T2 holds the key needed by T1.
 
    - The JVM is able to detect deadlock situations and can log information to help debug the application.
    - There is not much we can do if a deadlock occurs besides rebooting the JVM.
    
## Runnable Pattern

- Most basic way to create threads in Java.
- First create an instance of Runnable
- Then pass it to the constructor of the Thread class.
- Then call start() method of this thread object.

- The first pattern to launch threads in Java.
- Introduced in Java 1.0

## Producer Consumer Pattern

- A producer produces values in a buffer.
- A consumer consumes the values from this buffer.
- Be careful: the buffer can be empty or full
- Producers and consumers run in their own threads

#### Wait/Notify

- wait() and notify() are two methods from the Object class
- They are invoked on a given object.
- The thread executing the invocation should hold the key of that object.
- Cannot be invoked outside of a synchronized block.

- Calling wait() releases the key held by this thread.
- Puts the current thread in a WAIT state.
- The only way to release a thread from a WAIT state is by calling notify().
- This puts it in a RUNNABLE state.

## States of Threads

- A thread can be running or not
- If it is not running, can the thread scheduler give it a hand?
    - If the thread is in the WAIT list, the answer is no.
    
- Initially in NEW state
- Thread.start() puts it in the RUNNABLE state.
    - The thread scheduler is free to give a time slice of the CPU to this thread so it can execute its tasks.
- Once task is completed, the thread enters the TERMINATED state.

- However, threads in the RUNNABLE state can go into other states before being TERMINATED.
- BLOCKED - Waiting at the entrance of a synchronized block.
- WAITING - Parked when using a wait() call.
- TIME_WAITING - Parked using a sleep(timeout) or a wait(timeout) call.