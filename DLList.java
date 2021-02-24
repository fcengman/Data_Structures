
/**
 * title: DLList.java
 * description: This class implements a doubly linked list, implementing the list interface.  
 * date: February 23, 2021
 * @author Freya Engman
 * @version 1.0
 * @copyright 2001-2020 Freya Engman
 */

public class DLList<T> implements List<T> {
    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.value = item;
        }

        /** Gets the values stored in the node. */
        public String toString() {
            return value.toString();
        }
    }

    Node<T> head;
    Node<T> tail;
    int size;

    /** Adds an element to the end of the list. */
    public void append(T item) {
        if (item == null)
            return;
        Node<T> element = new Node<T>(item);
        size++;
        if (isEmpty()) {
            head = tail = element;
        }
        tail.next = element;
        element.prev = tail;
        tail = element;

    }

    /** Adds an element to the list at a given position. */
    public void add(int index, T item) {
        if (index > size - 1 || size < 0)
            throw new IndexOutOfBoundsException();
        if (item == null)
            return;
        size++;
        Node<T> element = new Node<T>(item);
        /* Position is the head of the list. */
        if (index == 0) {
            element.next = head;
            head.prev = element;
            head = element;
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = element;
        element.prev = current.prev;
        current.prev = element;
        element.next = current;

    }

    /** Removes the last element in the list. */
    public T removeLast() {
        if (isEmpty())
            return null;
        size--;
        T output = tail.value;
        tail = tail.prev;
        tail.next = null;
        return output;
    }

    /** Removes an element from the list at a given position. */
    public T remove(T item) {
        if (item == null)
            return null;
        T output = null;
        Node<T> current = head.next;
        /* When the item is the head of the list. */
        if (head.value == item) {
            output = head.value;
            head = head.next;
            head.prev = null;
            /* when the item is the tail of the list. */
        } else if (tail.value == item) {
            output = tail.value;
            tail = tail.prev;
            tail.next = null;
            /* Find the item in the list. */
        } else {
            for (int i = 1; i < size; i++) {
                if (current.value == item) {
                    output = current.value;
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                current = current.next;
            }
        }
        if (output != null)
            size--;
        return output;
    }

    /** Replace an element at a given position. */
    public void set(int index, T item) {
        if (index > size - 1 || size < 0)
            throw new IndexOutOfBoundsException();
        if (item == null)
            return;
        Node<T> element = new Node<T>(item);
        if (index == 0) {
            element.next = head.next;
            head.next.prev = element;
            head = element;
        } else if (index == size - 1) {
            tail.prev.next = element;
            element.prev = tail.prev;
            tail = element;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = element;
            current.next.prev = element;
            element.next = current.next;
            element.prev = current.prev;
        }

    }

    /* Gets an element in the list at a given position. */
    public T get(int index) {
        if (index > size - 1 || size < 0)
            throw new IndexOutOfBoundsException();
        T output = null;
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        output = current.value;
        return output;
    }

    /** Gets the index of an element in the list. */
    public int find(T item) {
        if (item == null)
            return -1;
        ;
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.value == item)
                return i;
            current = current.next;
        }
        return -1;
    }

    /** Gets the number of elements in a list. */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /** Gets all items stored in the list. */
    public String toString() {
        ArrayList<T> output = new ArrayList<T>();
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            output.append(temp.value);
            temp = temp.next;
        }
        return output.toString();
    }

    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();
        list.append(1);
        list.append(3);
        list.append(5);
        list.append(7);
        list.append(9);
        list.append(11);
        list.append(13);
        System.out.println(list);
        list.add(3, 6);
        list.add(0, 0);
        list.add(8, 12);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(12);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.set(2, 4);
        System.out.println(list);
        list.set(0, 2);
        list.set(5, 10);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.find(2));
        System.out.println(list.find(10));

    }

}
