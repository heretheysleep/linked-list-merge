import java.util.Scanner;

public class List {
    protected Node head;

    protected class Node {
        protected int data;
        protected Node next;

        public Node() {
            next = null;
        }

        public Node(int data) {
            this.data = data;
            next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public List() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public boolean search(int data) {
        if (isEmpty()) {
            return false;
        }

        return search(data, head);
    }

    private boolean search(int data, Node node) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        return search(data, node.next);
    }

    public boolean remove(int data) {
        Node node;
        Node previous = null;

        for (node = head; (node != null) && (node.data != data); node = node.next) {
            previous = node;
        }

        if (previous == null) {
            return false;
        }

        if (node == head) {
            head = head.next;
        } else {
            previous.next = node.next;
        }

        node = null;

        return true;
    }

    public void print() {
        String output = "[";

        if (isEmpty()) {
            output += "]";
        } else {
            output += print(head);
        }

        System.out.println(output);
    }

    private String print(Node node) {
        String string = "";

        string += node.data;

        if (node.next == null) {
            string += "]";

            return string;
        }

        string += ", ";

        return string + print(node.next);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return size(head);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.next);
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        int number = 0;

        do {
            System.out.println("Insira um n??mero ou F/f para Finalizar listagem:");
            input = scanner.nextLine();

            if (input.toUpperCase().equals("F")) {
                break;
            }

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Entrada inv??lida.");

                continue;
            }

            this.insert(number);
        } while (true);
    }

    public List mergeLists(List firstList, List secondList) {
        List list = new List();

        for (Node node = firstList.head; node != null; node = node.next) {
            list.insert(node.data);
        }

        for (Node node = secondList.head; node != null; node = node.next) {
            list.insert(node.data);
        }

        return list;
    }
}
