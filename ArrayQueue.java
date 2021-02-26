public class ArrayQueue<T> implements Queue<T> {

    private int head;
    private int tail;
    public ArrayList<T> queue;

    public ArrayQueue() {
        queue = new ArrayList<T>();
    }

    public void insert(T item) {
        if (item == null)
            return;
        if (queue.isEmpty()) {
            queue.append(item);
            head = 0;
        } else {
            if(queue.length() - 1 != tail){
                queue.append(item);
                tail++;
            } else {
                reorder();
                head = 0;
                tail = 0;
            }
            
        }
        if (queue.length() - 1 != tail) {
        tail++;
        } else {
        tail = 0;
        }

    }

    public T poll() {
        if (queue.isEmpty())
            return null;
        T temp = queue.remove(head);
        head = queue.length() - 1 != head ? head++ : 0;
        return temp;
    }

    public T peek() {
        if (queue.isEmpty())
            return null;
        return queue.get(head);
    }

    private void reorder(){
        ArrayList<T> newQueue = new ArrayList<T>();
        for(int i = head; i <= tail; i++){
            newQueue.append(queue.get(i));
        }
        queue = newQueue;
    }

    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.insert(1);
        System.out.println(queue.queue.length());
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        System.out.print(queue);
    }

}
