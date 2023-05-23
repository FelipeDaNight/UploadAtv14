public class Atividade5 {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Atividade5() {
        head = new Node(-1); 
        head.next = head; 
        size = 0;
    }

    
    public int contarElementos() {
        return size;
    }

    
    public void inserirEsquerda(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    
    public void concatenar(Atividade5 lista) {
        Node tail1 = head;
        while (tail1.next != head) {
            tail1 = tail1.next;
        }
        Node tail2 = lista.head.next;
        tail1.next = tail2;
        while (tail2.next != lista.head) {
            tail2 = tail2.next;
        }
        tail2.next = head;
        size += lista.size;
    }

    
    public static Atividade5 intercalarListasOrdenadas(
        Atividade5 lista1, Atividade5 lista2) {
            Atividade5 result = new Atividade5();
        Node current1 = lista1.head.next;
        Node current2 = lista2.head.next;

        while (current1 != lista1.head && current2 != lista2.head) {
            if (current1.data <= current2.data) {
                result.inserirEsquerda(current1.data);
                current1 = current1.next;
            } else {
                result.inserirEsquerda(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != lista1.head) {
            result.inserirEsquerda(current1.data);
            current1 = current1.next;
        }

        while (current2 != lista2.head) {
            result.inserirEsquerda(current2.data);
            current2 = current2.next;
        }

        return result;
    }

    
    public Atividade5 copiarLista() {
        Atividade5 copy = new Atividade5();
        Node current = head.next;
        while (current != head) {
            copy.inserirEsquerda(current.data);
            current = current.next;
        }
        return copy;
    }

    
    public void exibirLista() {
        if (head.next == head) {
            System.out.println("A lista está vazia.");
            return;
        }

        Node current = head.next;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
