public interface XList<T> {
    
    public void append(T item);
    public void add(int index, T item);
    public T removeLast();
    public T remove(T item);
    public void replace(int index, T item);
    public T get(int index);
    public int find(T item);
    public int size();
    public String toString();

}
