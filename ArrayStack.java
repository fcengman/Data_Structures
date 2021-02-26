public class ArrayStack<T> implements Stack<T> {

    int top;
    ArrayList<T> stack;

    public ArrayStack() {
        stack = new ArrayList<T>();
        top = -1;

    }

    public void push(T item) {
        top++;
        stack.append(item);

    }

    public T peek() {
        return stack.get(top);
    }

    public T pop() {
        T temp = stack.get(top);
        stack.removeLast();
        top--;
        return temp;
    }

    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

}
