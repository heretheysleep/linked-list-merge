public class SortedList extends List {
    public void insert(int data) {
        Node auxiliary, newNode;
        Node previous = null;

        newNode = new Node(data);

        for (auxiliary = head; (auxiliary != null) && (auxiliary.data < data); auxiliary = auxiliary.next) {
            previous = auxiliary;
        }

        if (previous == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }

        newNode.next = auxiliary;
    }

    public boolean remove(int data) {
        Node node;
        Node previous = null;

        for (node = head; (node != null) && (node.data < data); node = node.next) {
            previous = node;
        }

        if ((node == null) || (node.data != data)) {
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
}
