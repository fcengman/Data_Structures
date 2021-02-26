
/**
 * title: SLList.java description: This class uses a singly linked list to
 * implement the list interface. date: February 23, 2021
 * 
 * @author Freya Engman
 * @version 1.0
 * @copyright 2001-2020 Freya Engman
 */
public class SLList<T> implements List<T> {
    private class Node<T> {
        T value;
        Node<T> next;

        /** Default constructor for Node. */
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

    /** Add an element to the end of the list. */
    public void append(T item) {
        Node<T> element = new Node<T>(item);
        if (item == null)
            return;
        size++;
        if (isEmpty()) {
            head = tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }

    /** Add an element to the list at a given position. */
    public void add(int index, T item) {
        if (index > size - 1 || size < 0)
            throw new IndexOutOfBoundsException();
        if (item == null)
            return;
        size++;
        Node<T> element = new Node<T>(item);
        Node<T> temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        element.next = temp.next;
        temp.next = element;
    }

    /** Remove the last element from the list. */
    public T removeLast() {
        size--;
        T output = tail.value;
        Node<T> temp = head;
        for (int i = 1; i < size; i++) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        return output;
    }

    /** Remove a given element from the list. */
    public T removeElement(T item) {
        if (item == null)
            return null;

        T output;
        Node<T> prev = head;
        Node<T> current = head.next;
        /* When the item is the head of the list. */
        if (head.value == item) {
            output = head.value;
            head = head.next;
            size--;
            return output;
        }
        /* Find item in list. */
        for (int i = 1; i < size; i++) {
            if (current.value == item) {
                /* When the item is the tail of the list. */
                if (i == size) {
                    tail = prev;
                }
                output = current.value;
                prev.next = current.next;
                size--;
                return output;
            }
            current = current.next;
            prev = prev.next;
        }
        return null; // Item is not in the list.
    }

    public T remove(int index) {
        if (index > size || size < 0)
            throw new IndexOutOfBoundsException();
        if (isEmpty())
            return null;
        if (index == 0) {
            head = head.next;
        }
        Node<T> current = head.next;
        Node<T> prev = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        T temp = current.value;
        if (index == size - 1) {
            prev.next = null;
            tail = prev;
        } else {
            prev.next = current.next;
            current.next = null;
        }
        size--;
        return temp;

    }

    /** Replaces an element at a given position. */
    public void set(int index, T item) {
        if (index > size || size < 0)
            throw new IndexOutOfBoundsException();
        if (item == null)
            return;
        Node<T> element = new Node<T>(item);
        Node<T> current = head;
        /* When the position is the head. */
        if (index == 0) {
            head = element;
            element.next = current;
            return;
        }
        Node<T> prev = head;
        current = current.next;
        /* Iterate to given position. */
        for (int i = 2; i <= index; i++) {
            current = current.next;
            prev = prev.next;
        }
        /* When the position is the tail. */
        if (index == size - 1) {
            tail = element;
        } else {
            element.next = current.next;
        }
        prev.next = element;

    }

    /* Gets the element stored in a given position. */
    public T get(int index) {
        if (index > size - 1 || size < 0)
            throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    /** Gets the index of a given element. */
    public int find(T item) {
        if (item == null)
            return -1;
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.value == item) {
                return i;
            }
        }
        return -1;
    }

    /** Gets the number of elements stored in the list. */
    public int size() {
        return size;
    }

    /** Determines whether the list is empty. */
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

    /** Main method used to execute the program. */
    public static void main(String[] args) {
        SLList<Integer> list = new SLList<>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        System.out.println(list + " Size: " + list.size());
        list.add(3, 7);
        System.out.println(list + " Size: " + list.size());
        list.removeLast();
        System.out.println(list + " Size: " + list.size());
        list.removeElement(1);
        System.out.println(list + " Size: " + list.size());
        list.removeElement(5);
        System.out.println(list + " Size: " + list.size());
        System.out.println(list.removeElement(10));
        list.set(2, 6);
        System.out.println(list + " Size: " + list.size());
        list.set(0, 1);
        System.out.println(list + " Size: " + list.size());
        list.set(3, 8);
        System.out.println(list + " Size: " + list.size());
        System.out.println("At index 1 is: " + list.get(1));
        System.out.println("1's index is: " + list.find(1));

    }

}
