class Node {
    public int value;
    public Node next;

    public Node(int value) {
        System.out.println("Criando um novo no com o valor de " + value);
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;
    public LinkedList() {
        head = null;
    }

    public void add(int value) {
        System.out.println("Adicionando um novo no com o valor de " + value);
        Node newNode = new Node(value);
        if (head == null) {
            System.out.println("A head era nula, populando com o valor " + value);
            head = newNode;
        } else {
            Node current = head;
            System.out.println("Comecando a percorrer lista");
            while(current.next != null) {
                current = current.next;
                System.out.println("Novo no encontrado com o valor de " + current.getValue());
            }

            System.out.println("Ultimo no encontrado com o valor de " + current.getValue());
            current.next = newNode;
        }
    }

    public void exists(int value) {
        Node current = head;
        if (current == null) {
            System.out.println("Lista vazia, valor nao encontrado " + value);
        } else {
            if (current.getValue() == value) {
                System.out.println("Lista encontrada na head com o valor de " + value);
            } else {
                current = current.next;
                while(current != null) {
                    if (current.getValue() == value) {
                        System.out.println("Lista encontrada com o valor de " + value);
                        return;
                    }

                    current = current.next;
                }

                if (current == null) {
                    System.out.println("Item nao encontrado com o valor de " + value);
                }
            }
        }
    }

    public void remove(int value) {
        Node current = head;
        if (current == null) {
            System.out.println("Lista vazia, valor nao foi removido " + value);
        } else {
            if (current.getValue() == value) {
                head = current.next;
                current.next = null;
                System.out.println("Lista removida com o valor de " + value);
                System.out.println("HEad com o valor de " + head.getValue());
            } else {
                Node anterior = head;
                current = current.next;
                while(current != null) {
                    if (current.getValue() == value) {
                        anterior.next = current.next;
                        current.next = null;
                        System.out.println("Lista removida com o valor de " + value);
                        return;
                    }

                    anterior = anterior.next;
                    current = current.next;
                }

                if (current == null) {
                    System.out.println("Item nao encontrado com o valor de " + value);
                    System.out.println("Ultimo valor da lista " + anterior.getValue());
                }
            }
        }
    }


    public void printList() {
        System.out.println("PERCORRENDO LISTA");
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println(" null ");
    }

}


public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.printList();

        System.out.println("---------");
        list.exists(80);
        System.out.println("---------");
        list.exists(40);
        System.out.println("---------");
        list.remove(40);
        System.out.println("---------");
        list.exists(40);
        System.out.println("---------");
        list.exists(10);
        System.out.println("---------");
        list.printList();
    }
}