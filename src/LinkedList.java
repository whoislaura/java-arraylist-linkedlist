public class LinkedList<T> implements IList<T>{

    private Node<T> head, tail;
    private int size;

    public LinkedList (){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public void add(T o) {
        Node<T> value = new Node<>(o);

        if(isEmpty()) head = tail = value;

        //para evitar que add() sea O(n), ademas de head agregue tail(ultimo elemento de la lista) y asi seria O(1)
        else{
            tail.setNext(value);
            tail = value;
        }
        size++;
    }

    @Override
    public void add(T o, int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                head = new Node<T>(o, head);
                if (isEmpty()) tail=head;
            }
            else if (index == size()) {
                add(o);
                return;
            }
            else {
                Node<T> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                Node<T> node = new Node<>(o);
                node.setNext(cursor.getNext());
                cursor.setNext(node);
            }
            size++;
        }
        else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    @Override
    public T remove(int index) {
        if(index >= 0 && index < size) {
            Node<T> aux;
            if(index == 0) {
                aux = head;
                head = head.getNext();

                if(head == null) tail = null;
            }
            else{
                Node<T> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                aux = cursor.getNext();
                cursor.setNext(aux.getNext());
                if (aux == tail) {
                    tail = cursor;
                }
            }
            size--;
            return aux.getVal();
        } else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size){
            if(index == size-1) return tail.getVal();

            Node<T>cursor = head;
            for(int i=0; i<index; i++){
                cursor = cursor.getNext();
            }
            return cursor.getVal();
        }
        else {
            throw new UnsupportedOperationException("Index out of range");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
