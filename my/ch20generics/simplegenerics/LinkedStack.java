package my.ch20generics.simplegenerics;

// 链式泛型栈
public class LinkedStack<T> {
    // 私有静态成员类
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() { item = null; next = null; }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return next == null;
        }
    }
    // 结束哨兵 十分巧妙
    private Node<T> top = new Node<>();
    // 简洁版的 push()
    public void push(T item) {
        top = new Node<>(item, top);
    }
    // null 作为结束的标志(哨兵)
    public T pop() {
        T result = top.item;
        if (!top.end()) 
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        for (String s : "1 2 3 4".split(" "))
            ls.push(s);
        String s;
        while ((s = ls.pop()) != null)
            System.out.println(s);
    }
}
