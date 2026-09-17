public class Node<T> {
    //un nodo contiene 2 parametros, valor y un puntero al siguiente elemento
    protected T val;
    protected Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
