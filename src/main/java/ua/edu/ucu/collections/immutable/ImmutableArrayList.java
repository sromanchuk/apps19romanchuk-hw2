package ua.edu.ucu.collections.immutable;

import java.io.*;
import java.lang.*;
import java.util.*;

public class ImmutableArrayList implements ImmutableList {

    private Object[] array;
    private int length;

    public ImmutableArrayList(){
        this.length = 0;
        this.array = new Object[this.length];

    }

    public ImmutableArrayList(Object[] array){
        this.length = array.length;
        this.array = Arrays.copyOf(array, this.length);

    }


    public ImmutableArrayList add(Object e){

        Object[] array = Arrays.copyOf(this.array, this.length+1);

        array[this.length] = e;
        ImmutableArrayList newList = new ImmutableArrayList(array);
        return newList;

    } //додає елемент у кінець колекції

    public ImmutableArrayList add(int index, Object e){
        if (index > this.length){
            throw new IndexOutOfBoundsException("Unable to add element: index is out of bounds!");
        }

        Object[] array = Arrays.copyOf(this.array, this.length+1);
        for (int i = this.length; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = e;
        ImmutableArrayList newList = new ImmutableArrayList(array);
        return newList;
    } //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції


    public ImmutableArrayList addAll(Object[] c){ //додає масив елементів у кінець колекції

        Object[] array = Arrays.copyOf(this.array, this.length+c.length);

        for (int i = 0; i < c.length; i++){
            array[this.length + i] = c[i];
        }
        ImmutableArrayList newList = new ImmutableArrayList(array);
        return newList;
    }

    public ImmutableArrayList addAll(int index, Object[] c){

        if (index > this.length){
            throw new IndexOutOfBoundsException("Unable to add element: index is out of bounds!");
        }

        Object[] array = Arrays.copyOf(this.array, this.length+c.length);

        for (int i = this.length - 1; i > index - 1; i--){
            array[i + c.length] = array[i];
        }
        for (int i = 0; i < c.length; i++){
            array[index + i] = c[i];
        }
        ImmutableArrayList newList = new ImmutableArrayList(array);
        return newList;

    } // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції



    public Object get(int index){
        if (index >= this.length){
            throw new IndexOutOfBoundsException("Unable to add element: index is out of bounds!");
        }
        return this.array[index];
    } //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableArrayList remove(int index){
        if (index >= this.length){
            throw new IndexOutOfBoundsException("Unable to add element: index is out of bounds!");
        }
        Object[] array = Arrays.copyOf(this.array, this.length);
        for (int i = index; i < this.length - 1; i++)
        {
            array[i] = array[i+1];
        }
        Object[] arrayRm = Arrays.copyOf(this.array, this.length - 1);
        ImmutableArrayList newList = new ImmutableArrayList(arrayRm);
        return newList;

    } //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableArrayList set(int index, Object e){
        if (index >= this.length){
            throw new IndexOutOfBoundsException("Unable to add element: index is out of bounds!");
        }
        Object[] array = Arrays.copyOf(this.array, this.length);
        array[index] = e;
        ImmutableArrayList newList = new ImmutableArrayList(array);
        return newList;
    } //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public int indexOf(Object e){
        for (int i = 0; i < this.length; i++){
            if (this.array[i] == e){
                return i;
            }
        }
        return -1;
    } //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)

    public int size(){
        return this.length;
    } //розмір колекції

    public ImmutableArrayList clear(){
        ImmutableArrayList newList = new ImmutableArrayList();
        return newList;
    } //очищує вміст колекції

    public boolean isEmpty(){
        return (this.length == 0);
    } //якщо у колеції нема елементів то повертає true

    public Object[] toArray(){
        Object[] array = new Object[this.length];
        for (int i = 0; i < array.length; i++){
            array[i] = this.array[i];
        }
        return array;
    } //перетворює колекцію до масиву обєктів

    @Override
    public String toString(){
        String out = "[";
        for (int i = 0; i < this.length; i++){
            out += this.array[i] + "";
            if (i < this.length - 1){
                out += ", ";
            }

        }
        return out+"]";
    } //повертає рядок, де через кому відображаютсься елементи колекції
}
