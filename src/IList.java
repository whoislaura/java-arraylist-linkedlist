public interface IList<T> {

    //Metodos esenciales de una lista generica

    void add(T e);

    void add(T e, int index);

    T remove(int index);

    T get(int index);

    int size();

    void clear();

    boolean isEmpty();
}
