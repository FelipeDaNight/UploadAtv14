public class Atividade4 {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    
    public int contarElementos() {
        return size;
    }

   
    public void inserirEsquerda(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.previous = head;
            head.next = head;
        } else {
            Node tail = head.previous;
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    
    public void concatenar(Atividade4 lista) {
        if (head == null) {
            head = lista.head;
        } else if (lista.head != null) {
            Node tail1 = head.previous;
            Node tail2 = lista.head.previous;
            tail1.next = lista.head;
            lista.head.previous = tail1;
            tail2.next = head;
            head.previous = tail2;
        }
        size += lista.size;
    }

    
    public static Atividade4 intercalarListasOrdenadas(
        Atividade4 lista1, Atividade4 lista2) {
            Atividade4 result = new Atividade4 ();
        Node current1 = lista1.head;
        Node current2 = lista2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                result.inserirEsquerda(current1.data);
                current1 = current1.next;
            } else {
                result.inserirEsquerda(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            result.inserirEsquerda(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            result.inserirEsquerda(current2.data);
            current2 = current2.next;
        }

        return result;
    }

    
    public Atividade4 copiarLista() {
        Atividade4 copy = new Atividade4();
        Node current = head;
        for (int i = 0; i < size; i++) {
            copy.inserirEsquerda(current.data);
            current = current.next;
        }
        return copy;
    }

    
    public void exibirLista() {
        if (head == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        Node current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
