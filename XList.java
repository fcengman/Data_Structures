
/**
 * title: XList.java
 * description: An interface with list methods. 
 * date: February 23, 2021
 * @author Freya Engman
 * @version 1.0
 * @copyright 2001-2020 Freya Engman
 */
public interface XList<T> {
    
    /** Add an element to the end of a list. */
    public void append(T item);
    /** Add an element to the list at a given position. */
    public void add(int index, T item);
    /** Remove the last item in the list. */
    public T removeLast();
    /** Remove an item from the list. */
    public T remove(T item);
    /** Replace an item in the list at a given position. */
    public void replace(int index, T item);
    /** Get an item from a given position. */
    public T get(int index);
    /** Finds an item in the array. */
    public int find(T item);
    /** Gets the number of elements stored in the array. */
    public int size();
    /** Gets a string of the elements storedi in the array. */
    public String toString();

}
