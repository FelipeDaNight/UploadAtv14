class Node {
    int data;
    Node prev;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    public void append(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void display() {
        Node current = head;
        
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public void concatenate(DoublyLinkedList list2) {
        if (head == null) {
            head = list2.head;
            tail = list2.tail;
        } else {
            tail.next = list2.head;
            
            if (list2.head != null) {
                list2.head.prev = tail;
            }
            
            tail = list2.tail;
        }
    }
    
    public void split() {
        if (head == null || head.next == null) {
            return;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node secondHead = slow.next;
        slow.next = null;
        secondHead.prev = null;
        
        DoublyLinkedList secondList = new DoublyLinkedList();
        secondList.head = secondHead;
        secondList.tail = tail;
        tail = slow;
        
        System.out.print("Primeira Lista: ");
        display();
        System.out.print("Segunda Lista: ");
        secondList.display();
    }
    
    public void merge(DoublyLinkedList list2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        
        Node current1 = head;
        Node current2 = list2.head;
        
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.append(current1.data);
                current1 = current1.next;
            } else {
                mergedList.append(current2.data);
                current2 = current2.next;
            }
        }
        
        while (current1 != null) {
            mergedList.append(current1.data);
            current1 = current1.next;
        }
        
        while (current2 != null) {
            mergedList.append(current2.data);
            current2 = current2.next;
        }
        
        System.out.print("Lista intercalada: ");
        mergedList.display();
    }
}

public class Atividade1 {
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);
        
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);
        
        
        list1.concatenate(list2);
        System.out.print("Listas Concatenadas: ");
        list1.display();
        
        
        list1.split();
        
        
        DoublyLinkedList list3 = new DoublyLinkedList();
        list3.append(2);
        list3.append(4);
        list3.append(6);
        
        DoublyLinkedList list4 = new DoublyLinkedList();
        list4.append(1);
        list4.append(3);
        list4.append(5);
        
        list3.merge(list4);
    }
}
