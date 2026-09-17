public class ArrayList<T> implements IList<T>{

    private Object[] items;
    private int cap;
    private int size;

    public ArrayList(){
        this.size = 0;  //cantidad de elementos inicialmente 0
        this.cap = 10;  //capacidad inicial de 10 elementos
        this.items = new Object[cap];
    }

    //si la cantidad de elementos supera la capacidad actual
    //se crea un array auxiliar con la capacidad+10 y se copian todos los elementos
    private void expand(){
        Object[] aux = new Object[cap + 10];
        System.arraycopy(items, 0, aux, 0, size);
        cap+=10;
        items = aux;
    }

    private boolean isFull(){
        return size == cap;
    }

    //Implementacion de metodos de IList

    @Override
    public void add(T o) {
        if(isFull()) expand();

        items[size++] = o;
    }

    @Override
    public void add(T o, int index) {
        if(index < size){
            if(isFull()) expand();

            for(int i=size; i>index; i--){
                //desplaza los elementos (despues de index) una posicion
                items[i+1] = items[i];
                items[i] = items[i-1];
            }
            items[index] = o;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if(index < size){
            T aux = (T) items[index];
            for(int i=index; i<size-1; i++){
                //desplaza los elementos (despues de index) una posicion anterior
                items[i] = items[i+1];
            }
            size--;
            return aux;
        }
        return null;
    }

    @Override
    public T get(int index) {
        return (T) items[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    //vacia la lista y la devuelve a capacidad=10
    public void clear() {
        cap = 10;
        items = new Object[cap];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
