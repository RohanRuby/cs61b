package deque;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListDeque<T> implements Deque<T>{
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
    public void addFirst(T item){

        // If empty, initialize
        if(this.isEmpty()){
            Node n = new Node(item);
            front = n;
            back = n;
            size++;
            return;
        }
        // Make the first node
        Node firstNode = new Node(item);
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

    public void addLast(T item){

        // If empty, initialize
        if(isEmpty()){
            Node n = new Node(item);
            front = n;
            back = n;
            size++;
            return;
        }

        // Add last node to the list
        Node lastNode = new Node(item);
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

    private boolean isEmpty(){
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

    private T getRecursiveHelper(Node n, int index){
        if(n == null) return null;
        if(index == 0)
            return n.data;
        else
            return getRecursiveHelper(n.next, index-1);
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator<T>();
    }

    public class LinkedListIterator<T> implements Iterator<T> {
        private Node current = front;
        private Node lastReturned = null;
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            if (!hasNext()) return null;
            lastReturned = current;
            current = current.next;
            return (T) lastReturned.data;
        }

        @Override
        public void remove(){

        }

    }

    public boolean equals(Object o){
        if (o instanceof LinkedListDeque) {
            LinkedListDeque<T> target = (LinkedListDeque<T>) o;
            if(target.front == null && front == null) return true;
            else if (target.front != null && front != null) {
                Node n1 = front;
                Node n2 = target.front;
                while (n1 != null) {
                    if (n2 == null) return false;
                    if (n1.data != null) {
                        if (n2.data == null || n1.data != n2.data) return false;
                    }
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return true;
            }
            return false;
        }
        else return false;
    }
}
