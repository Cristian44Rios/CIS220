// Cristian Rios
// Chpt5 PA

// Define a Node class to represent each element in the queue
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a Queue class to represent the queue implemented as a linked list 
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }
    
    // Enqueue operation: adds an item to the end of the queue
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (front == null) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }
    
    // Dequeue operation: removes and returns the item from the front of the queue
    public int dequeue() {
        if (front == null) {
            return -1;
        }
        int dequeuedItem = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to peek at the front item without removing it
    public int peek() {
        if (front == null) {
            return 0;
        }
        return front.data;
    }

    // Method to get the length of the queue
    public int getLength() {
        int count = 0;
        Node temp = front;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    // Method to display the queue's values from front to rear
    public void displayQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class to demonstrate the queue operations
public class QueueAsLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        
        // Display the initial queue (should be empty)
        queue.displayQueue();
        
        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        // Peek at the front item
        System.out.println("Front item: " + queue.peek());
        
        // Display queue length
        System.out.println("Queue length: " + queue.getLength());
        
        // Enqueue operations
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("Front item after enqueue: " + queue.peek());
        queue.enqueue(3);
        System.out.println("Queue length after enqueue: " + queue.getLength());
        
        // Dequeue operations
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Front item after dequeue: " + queue.peek());
        queue.enqueue(4);
        queue.displayQueue();
        
        queue.enqueue(5);
        System.out.println("Dequeued item: " + queue.dequeue());
        queue.enqueue(6);
        System.out.println("Queue length after enqueue: " + queue.getLength());
        queue.displayQueue();
        
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Queue length: " + queue.getLength());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}