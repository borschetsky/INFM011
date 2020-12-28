package com.company;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    Object[] array;
    int lastElement = -1;

    public  Stack () {
        array = new Object[4];
    }

    public void push(T element) {
        int currentPosition = lastElement + 1;

        if(currentPosition > array.length - 1){
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[currentPosition] = element;
        lastElement = currentPosition;
    }

    public  int testsize () {
        return  array.length;
    }
    public T pop () throws EmptyStackException {
        if(!isEmpty()){
            Object elementToReturn = array[lastElement];
            lastElement--;
            return  (T)elementToReturn;
        }
        throw  new EmptyStackException();
    }

    public T peek () throws  EmptyStackException {
        if(!isEmpty()){
            return  (T)array[lastElement];
        }
        throw  new EmptyStackException();
    }

    public  boolean isEmpty() {
        return !(lastElement > -1);
    }

    public int size () {
        return  lastElement + 1;
    }

    public void clear () {
        if(!isEmpty()){
            lastElement = -1;
        }
    }
}
