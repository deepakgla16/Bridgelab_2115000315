import java.util.Scanner;

class Process {
    int processID;
    int burstTime;
    int priority;
    Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;

    // Add process at the end
    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;  // Circular connection
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove process by ID
    public void removeProcess(int processID) {
        if (head == null) {
            return;
        }

        Process current = head, prev = null;
        do {
            if (current.processID == processID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Process " + processID + " completed and removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Simulate Round Robin execution
    public void executeProcesses(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        int totalProcesses = 0;
        int totalWaitingTime = 0, totalTurnaroundTime = 0;

        Process current = head;
        do {
            totalProcesses++;
            current = current.next;
        } while (current != head);

        int[] waitingTime = new int[totalProcesses];
        int[] turnaroundTime = new int[totalProcesses];
        int[] remainingBurstTime = new int[totalProcesses];
        int[] processIDs = new int[totalProcesses];

        current = head;
        for (int i = 0; i < totalProcesses; i++) {
            processIDs[i] = current.processID;
            remainingBurstTime[i] = current.burstTime;
            current = current.next;
        }

        int time = 0, completed = 0;
        while (completed < totalProcesses) {
            for (int i = 0; i < totalProcesses; i++) {
                if (remainingBurstTime[i] > 0) {
                    if (remainingBurstTime[i] > timeQuantum) {
                        time += timeQuantum;
                        remainingBurstTime[i] -= timeQuantum;
                    } else {
                        time += remainingBurstTime[i];
                        turnaroundTime[i] = time;
                        waitingTime[i] = turnaroundTime[i] - current.burstTime;
                        remainingBurstTime[i] = 0;
                        completed++;
                        removeProcess(processIDs[i]);
                    }
                }
            }
        }

        for (int i = 0; i < totalProcesses; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / totalProcesses);
    }

    // Display process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        System.out.println("Processes in Queue:");
        Process current = head;
        do {
            System.out.println("Process ID: " + current.processID + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}

// Driver Code
public class RoundRobinSchedulerSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nRound Robin Scheduler:");
            System.out.println("1. Add Process");
            System.out.println("2. Display Process Queue");
            System.out.println("3. Execute Processes");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    scheduler.addProcess(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.executeProcesses(scanner.nextInt());
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
