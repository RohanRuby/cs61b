package deque;


public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;

    private T[] array;

    public ArrayDeque(){
        int defaultLength = 8;
        size = 0;
        array = (T[]) new Object[defaultLength]; // Use object array
        nextFirst = defaultLength/2;
        nextLast = nextFirst + 1;
    }

    private void resize(int capacity){
        T[] newArray = (T[]) new Object[capacity];
        int ptr = getIndexPlus(nextFirst);
        for (int i = 0; i < size; i++) {
            newArray[i] = array[ptr];
            ptr = getIndexPlus(ptr);
        }
        array = newArray;
        nextFirst = array.length - 1;
        nextLast = size;
    }

    public void addFirst(T item){
        if(size == array.length)
            resize(array.length*2);
        array[nextFirst] = item;
        size++;
        nextFirst = getIndexMinus(nextFirst);
    }

    public void addLast(T item){
        if(size == array.length)
            resize(array.length*2);
        array[nextLast] = item;
        size++;
        nextLast = getIndexPlus(nextLast);
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        if (this.size() < array.length/4 && array.length > 16) resize(array.length/4);
        T val = array[getIndexPlus(nextFirst)];
        size--;
        nextFirst = getIndexPlus(nextFirst);
        return val;
    }

    public T removeLast(){
        if(isEmpty()) return null;
        if (this.size() < array.length/4 && array.length > 16) resize(array.length/4);
        T val = array[getIndexMinus(nextLast)];
        size--;
        nextLast = getIndexMinus(nextLast);
        return val;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return this.size() == 0 ;
    }

    public void printDeque(){
        int ptr = getIndexPlus(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(array[ptr] + " ");
            ptr = getIndexPlus(ptr);
        }
    }

    public T get(int index){
        if (index < 0 || index >= size)
            return null;

        int i = (getIndexPlus(nextFirst) + index) % array.length;
        return array[i];
    }

    private int getIndexMinus(int index){
        if(index == 0) return array.length - 1;
        return index - 1;
    }

    private int getIndexPlus(int index){
        if(index == array.length - 1) return 0;
        return index + 1;
    }


}
