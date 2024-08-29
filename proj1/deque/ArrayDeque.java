package deque;

public class ArrayDeque<T> {
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
        for(int i = 0; i < size; i++)
            newArray[i] = array[i % capacity];
        nextLast = size;
        nextFirst = capacity - 1;
        array = newArray;
    }
    public void addFirst(T val){
        if(size == array.length)
            resize(array.length*2);
        array[nextFirst] = val;
        size++;
        nextFirst--;
        if(nextFirst == -1) nextFirst = array.length - 1;
    }

    public void addLast(T val){
        if(size == array.length)
            resize(array.length*2);
        //System.out.println("nextlast: " + nextLast + " length: " + array.length);

        array[nextLast] = val;
        size++;
        nextLast++;
        nextLast = nextLast % array.length;
    }

    public T removeFirst(){
        if (this.size() < array.length/4) resize(array.length/4);
        if (this.isEmpty()) return null;
        int index = (nextFirst + 1) % array.length;
        T val = array[index];
        nextFirst++;
        nextFirst = nextFirst % array.length;
        size--;
        return val;
    }

    public T removeLast(){
        if (this.size() < array.length/4) resize( array.length/4);
        if (this.isEmpty()) return null;
        int index = nextLast - 1;
        if(index < 0) index = index + array.length;
        T val = array[index];
        nextLast = index;
        size--;
        return val;

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return this.size() == 0 ;
    }

    public void printDeque(){
        for(int i = nextFirst + 1; i< nextLast; i++){
            System.out.println(array[i]);
        }
    }

    public T get(int i){
        return array[i];
    }
}
