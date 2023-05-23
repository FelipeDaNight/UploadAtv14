
public class Atividade2 {
    private Node head;
    private Node tail;

    public Atividade2() {
        head = new Node(-1); 
        tail = new Node(-1); 

        head.next = tail;
        tail.prev = head;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public boolean search(int data) {
        Node current = head.next;
        while (current != tail) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void delete(int data) {
        Node current = head.next;
        while (current != tail) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head.next;
        while (current != tail) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Atividade2 list = new Atividade2();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.display(); 

        System.out.println("Procura 3: " + list.search(3));
        System.out.println("Procura 6: " + list.search(6)); 

        list.delete(3);
        list.display();
    }
}