// Cristian Rios
// Chpt4 PA

// Define a Node class to represent each element in the list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a List class to represent the singly linked list
class List {
    Node head;
    Node tail;

    public List() {
        head = null;
        tail = null;
    }

    public void listAppend(int item) {
        Node newNode = new Node(item);
        listAppendNode(newNode);
    }

    private void listAppendNode(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void listPrepend(int item) {
        Node newNode = new Node(item);
        listPrependNode(newNode);
    }

    private void listPrependNode(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean listInsertAfter(int currentItem, int newItem) {
        Node currentNode = listSearch(currentItem);
        if (currentNode != null) {
            Node newNode = new Node(newItem);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            if (currentNode == tail) {
                tail = newNode;
            }
            return true;
        }
        return false;
    }

    public Node listSearch(int key) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == key) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public void listRemoveNodeAfter(Node curNode) {
        if (curNode == null) {
            if (head != null) {
                head = head.next;
                if (head == null) {
                    tail = null;
                }
            }
        } else if (curNode.next != null) {
            curNode.next = curNode.next.next;
            if (curNode.next == null) {
                tail = curNode;
            }
        }
    }

    public int sumDataValues() {
        int sum = 0;
        Node curNode = head;
        while (curNode != null) {
            sum += curNode.data;
            curNode = curNode.next;
        }
        return sum;
    }

    public void listTraverse() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " -> ");
            curNode = curNode.next;
        }
        System.out.println("NULL");
    }

    public void listInsertionSortSinglyLinked() {
        if (head == null || head.next == null) {
            return;
        }
        Node sorted = null;
        Node curNode = head;
        while (curNode != null) {
            Node next = curNode.next;
            if (sorted == null || curNode.data <= sorted.data) {
                curNode.next = sorted;
                sorted = curNode;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data < curNode.data) {
                    temp = temp.next;
                }
                curNode.next = temp.next;
                temp.next = curNode;
            }
            curNode = next;
        }
        head = sorted;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        List myList = new List();

        // Display initial empty list
        System.out.println("List:");
        myList.listTraverse();

        // Sum of empty list
        System.out.println("The sum of the list's data values is: " + myList.sumDataValues());

        // Append and prepend nodes
        myList.listPrepend(30);
        myList.listInsertAfter(30, 40);
        myList.listInsertAfter(40, 70);
        myList.listAppend(10);
        myList.listInsertAfter(10, 60);
        myList.listAppend(20);
        myList.listAppend(50);
        myList.listInsertAfter(10, 60);
        myList.listInsertAfter(40, 70);

        // Display list after insertions
        System.out.println("List:");
        myList.listTraverse();

        // Remove head and a node after 70
        myList.listRemoveNodeAfter(null);
        Node node70 = myList.listSearch(70);
        if (node70 != null) myList.listRemoveNodeAfter(node70);

        // Display list after deletions
        System.out.println("List:");
        myList.listTraverse();

        // Search for specific values
        System.out.println(myList.listSearch(50) != null ? "Node 50 was found." : "Node 50 was not found.");
        System.out.println(myList.listSearch(15) != null ? "Node 15 was found." : "Node 15 was not found.");

        // Sort and display sorted list
        myList.listInsertionSortSinglyLinked();
        System.out.println("Sorted list:");
        myList.listTraverse();

        // Display sum of sorted list
        System.out.println("The sum of the list's data values is: " + myList.sumDataValues());
    }
}