class Circular {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    
    public int contarElementos() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    
    public void inserirEsquerda(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        }
    }

    
    public void concatenar(Circular lista) {
        if (head == null) {
            head = lista.head;
        } else if (lista.head != null) {
            Node last1 = head;
            while (last1.next != head) {
                last1 = last1.next;
            }
            Node last2 = lista.head;
            while (last2.next != lista.head) {
                last2 = last2.next;
            }
            last1.next = lista.head;
            last2.next = head;
        }
    }

    
    public static Circular intercalarListasOrdenadas(Circular lista1, Circular lista2) {
        Circular result = new Circular();
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

    
    public Circular copiarLista() {
        Circular copy = new Circular();
        if (head == null) {
            return copy;
        }

        Node current = head;
        do {
            copy.inserirEsquerda(current.data);
            current = current.next;
        } while (current != head);

        return copy;
    }


    public void exibirLista() {
    }
}

class Atividade3 {
    public static void main(String[] args) {
        Circular lista1 = new Circular();
        lista1.inserirEsquerda(3);
        lista1.inserirEsquerda(2);
        lista1.inserirEsquerda(1);

        Circular lista2 = new Circular();
        lista2.inserirEsquerda(6);
        lista2.inserirEsquerda(5);
        lista2.inserirEsquerda(4);

        System.out.println("Número de elementos na lista1: " + lista1.contarElementos());
        System.out.println("Número de elementos na lista2: " + lista2.contarElementos());

        lista1.concatenar(lista2);
        System.out.println("Número de elementos após a concatenação: " + lista1.contarElementos());

        System.out.println("Lista intercalada ordenada:");
        Circular listaIntercalada = Circular.intercalarListasOrdenadas(lista1, lista2);
        listaIntercalada.exibirLista();

        Circular listaCopia = lista1.copiarLista();
        System.out.println("Número de elementos na lista copiada: " + listaCopia.contarElementos());
    }
}
