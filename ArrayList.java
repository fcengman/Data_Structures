
/**
 * title: ArrayList.java
 * description: This class implements a dynamically sized array. 
 * date: February 23, 2021
 * @author Freya Engman
 * @version 1.0
 * @copyright 2001-2020 Freya Engman
 */


import java.util.Arrays;

public class ArrayList<T> implements XList<T> {
    T[] values;
    int size;
    final int DEFAULT_SIZE = 10;

    /** Default constructor for ArrayList */
    public ArrayList() {
        this.size = 0;
        values = newArray(DEFAULT_SIZE);
    }

    /** Helper method to initialize new ArrayList */
    @SafeVarargs
    static <T> T[] newArray(int length, T... array) {
        return Arrays.copyOf(array, length);
    }

    /**
     * Resize the array when the number of items is less than half the length of the
     * array.
     */
    private void resize() {
        T[] newValues = newArray(Math.max(1, size * 2));
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
    }

    /**
     * Adds item to the end of the array.
     * 
     * @param item Element added to the array.
     */
    public void append(T item) {
        if (size + 1 > values.length)
            resize();
        values[size++] = item;
    }

    /**
     * Adds item to position in the array.
     * 
     * @param index Position where element is added.
     * @param item  Element added to the array.
     */
    public void add(int index, T item) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (size + 1 > values.length)
            resize();

        for (int i = size - 1; i >= index; i--) {
            values[i + 1] = values[i];
        }
        values[index] = item;
        size++;
    }

    /**
     * Remove the last item im the array.
     * 
     * @return Element removed from the array.
     */
    public T removeLast() {
        if (isEmpty())
            return null;
        size--;
        T temp = values[size];
        values[size] = null;
        if (size / values.length < .5)
            resize();
        return temp;

    }

    /**
     * Removes a given item from the array.
     * 
     * @param item Element removed from the array.
     * @return Element removed from the array.
     */
    public T remove(T item) {
        if (item == null)
            return null;
        T temp = null;
        int index = 0;
        /* Find item. */
        while (index < size) {
            if (values[index] == item) {
                temp = values[index];
                values[index] = null;
                break;
            }
            index++;
        }
        /* If item is not in the array, return and exit method. */
        if (temp == null)
            return temp;
        size--;
        /* Shift items to fill hole. */
        for (int i = index; i < size; i++) {
            values[i] = values[i + 1];
        }
        values[size] = null;
        if (size / values.length < .5)
            resize();
        return temp;
    }

    /**
     * Stores a new item in a given position.
     * 
     * @param index Position of the item to be replaced.
     * @param item  Element to be added to the array.
     */
    public void replace(int index, T item) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        values[index] = item;
    }

    /**
     * Get an item stored in a particular position.
     * 
     * @param index The position of the given item.
     * @return Item at the given position.
     */
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        return values[index];
    }

    /**
     * Gets an item stored in the array,
     * 
     * @param item Element stored in the array.
     * @return The position of the element.
     * 
     */
    public int find(T item) {
        if (item == null)
            return -1;
        for (int i = 0; i < size; i++) {
            if (values[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /** Gets the number of elements stored in the array, */
    public int size() {
        return size;
    }

    /** Determines if the array is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Generates a string of the elements stored in the array. */
    public String toString() {
        T[] output = newArray(size);
        for (int i = 0; i < size; i++) {
            output[i] = values[i];
        }
        return Arrays.toString(output);
    }

    /** Main method used to execute the program. */
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println(array);
        array.append(1);
        array.append(2);
        array.append(3);
        array.append(4);
        array.append(5);
        array.append(6);
        array.append(7);
        array.append(8);
        array.append(9);
        array.add(1, 10);
        System.out.println(array);
        array.add(3, 11);
        System.out.println(array);
        System.out.println(array.get(4));
        array.replace(4, 12);
        System.out.println(array);
        array.removeLast();
        System.out.println(array);
        array.remove(4);
        System.out.println(array);
        array.remove(6);
        System.out.println(array);
        System.out.println(array.find(3));

    }
}