package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import java.lang.*;
import java.util.*;


public class Queue {

    private ImmutableLinkedList queue = new ImmutableLinkedList();


    public Object peek(){

        return this.queue.getFirst();
    }

    public Object dequeue(){

        Object first = queue.getFirst();
        this.queue = this.queue.removeFirst();
        return first;
    }

    public void enqueue(Object e){
        this.queue = this.queue.addLast(e);
    }

    @Override
    public String toString(){
        return this.queue.toString();
    }
}
