package ua.edu.ucu.collections.immutable;
import java.io.*;
import java.lang.*;
import java.util.*;

// У результаті змін, що призводять на модифікації
//(зміну стану) колекції має повртатись нова колекція
public interface ImmutableList {


    ImmutableList add(Object e); //додає елемент у кінець колекції

    ImmutableList add(int index, Object e);
    
    ImmutableList addAll(Object[] c); //додає масив елементів у кінець колекції

    ImmutableList addAll(int index, Object[] c);
    
    Object get(int index);
    
    ImmutableList remove(int index);
    
    ImmutableList set(int index, Object e);
    
    int indexOf(Object e);
    
    int size(); //розмір колекції

    ImmutableList clear(); //очищує вміст колекції

    boolean isEmpty(); //якщо у колеції нема елементів то повертає true

    Object[] toArray(); //перетворює колекцію до масиву обєктів

    @Override
    String toString();
}
