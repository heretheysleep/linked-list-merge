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

    public List mergeLists(List firstList, List secondList) {
        List list = new SortedList();

        for (Node node = firstList.head; node != null; node = node.next) {
            list.insert(node.data);
        }

        for (Node node = secondList.head; node != null; node = node.next) {
            list.insert(node.data);
        }

        return list;
    }
}
