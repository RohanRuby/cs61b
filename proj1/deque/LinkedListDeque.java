package deque;

public class LinkedListDeque<T> {
    private int size;
    private Node front;
    private Node back;

    private class Node{
        T data;
        Node prev;
        Node next;
        Node(T d){
            data = d;
        }
    }

    public LinkedListDeque(){
        size = 0;
        Node node = new Node(null);
        front = null;
        back = null;
    }

    public int size(){
        return size;
    }
    public void addFirst(T val){

        // If empty, initialize
        if(this.isEmpty()){
            Node n = new Node(val);
            front = n;
            back = n;
            size++;
            return;
        }
        // Make the first node
        Node firstNode = new Node(val);
        firstNode.next = front;
        front.prev = firstNode;
        front = firstNode;
        size++;
    }

    public T removeFirst(){
        // If empty, return null
        if(this.isEmpty()){
            return null;
        }
        T val = front.data;

        // ReMake the first node
        if(front.next != null){
            Node secNode = front.next;
            secNode.prev = null;
            front = front.next;
        }else{
            front = null;
            back = null;
        }
        size--;
        return val;
    }

    public void addLast(T val){

        // If empty, initialize
        if(isEmpty()){
            Node n = new Node(val);
            front = n;
            back = n;
            size++;
            return;
        }

        // Add last node to the list
        Node lastNode = new Node(val);
        back.next = lastNode;
        lastNode.prev = back;
        back = lastNode;
        size++;
    }

    public T removeLast(){
        // If empty, return null
        if(this.isEmpty()){
            return null;
        }
        T val = back.data;


        //ReMake the last node
        if(back.prev != null){
            Node secNode = back.prev;
            secNode.next = null;
            back = back.prev;
        } else{
            back = null;
            front = null;
        }
        size--;
        return val;
    }
    public void printDeque(){
        Node n = front;
        while(n != null){
            if(n.data != null) System.out.println(n.data);
            n = n.next;
        }
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }
    public T get(int index){
        if(index < size){
            Node node = front;
            for(int i = 0; i<index; i++){
                node = node.next;
            }
            return node.data;
        }else{
            return null;
        }

    }

    public T getRecursive(int index){
        return getRecursiveHelper(front, index);
    }

    public T getRecursiveHelper(Node n, int index){
        if(n == null) return null;
        if(index == 0)
            return n.data;
        else
            return getRecursiveHelper(n.next, index-1);
    }
}
