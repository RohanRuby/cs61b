package deque;

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;

    private T[] array;

    public ArrayDeque(){
        size = 0;
        array = (T[]) new Object[8]; // Use object array
        nextFirst = 4;
        nextLast = 5;
    }
    private void resize(int dir, int capacity){
        T[] newArray = (T[]) new Object[capacity];
        // resize the left
        if(dir == 1){
            for(int i = nextFirst + 1; i < nextLast; i++)
                newArray[i + capacity - array.length - nextFirst - 1] = array[i];
            //int oldFirst = nextFirst;
            //int oldNext = nextLast;
            nextLast = capacity + nextLast - array.length - nextFirst - 1;
            nextFirst = capacity - array.length - 1;
            array = newArray;
        }
        //resize the right
        if(dir == -1){
            for(int i = nextFirst + 1; i < nextLast; i++)
                newArray[i] = array[i];
            array = newArray;
            //nextFirst = size - 1;
        }
        // smaller
        if(dir == 0){
            for(int i = nextFirst + 1; i < nextLast; i++)
                newArray[(capacity - this.size)/2 + i - nextFirst - 1] = array[i];
            int oldNextFirst = nextFirst;
            nextFirst = (capacity - this.size)/2 - 1;
            nextLast = (capacity - this.size)/2 + nextLast - oldNextFirst - 1;
            array = newArray;
        }
    }
    public void addFirst(T val){
        if(nextFirst == -1)
            resize(1, array.length*2);
        array[nextFirst] = val;
        size++;
        nextFirst--;
    }

    public void addLast(T val){
        if(nextLast == array.length)
            resize(-1, array.length*2);
        //System.out.println("nextlast: " + nextLast + " length: " + array.length);
        array[nextLast] = val;
        size++;
        nextLast++;
    }

    public T removeFirst(){
        if(this.size() < array.length/4) resize(0, array.length/4);
        if (this.isEmpty()) return null;
        T val = array[nextFirst + 1];
        nextFirst++;
        size--;
        return val;
    }

    public T removeLast(){
        if(this.size() < array.length/4) resize(0, array.length/4);
        if (this.isEmpty()) return null;
        T val = array[nextLast - 1];
        nextLast--;
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
