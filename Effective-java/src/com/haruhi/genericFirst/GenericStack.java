package com.haruhi.genericFirst;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Project <h2>Venus</h2>
 * @Package <h3>com.haruhi.genericFirst</h3>
 * @Description <p></p>
 * @Author SuzumiyaHaruhi
 * @Time 2017/12/17 12:24:03
 * @Version v1.0
 */
public class GenericStack<E> implements Iterable<E> {
    private int size = 0;
    final private int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] elements;
    public GenericStack(){
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public GenericStack(int capacity){
        elements = (E[]) new Object[capacity];
    }
    public E push (E e){
        ensureCapacity();
        elements[size++] = e;
        return e;
    }
    private void ensureCapacity(){
        if(elements.length == size){
            E[] temp = (E[]) new Object[size * 2 + 1];
            System.arraycopy(elements, 0, temp, 0, size);
            elements = temp;
        }
    }
    public E pop(){
        if (size == 0) {
            throw new EmptyStackException();
        }
        E e = elements[--size];
        elements[size] = null;
        return e;
    }

    /**
     * @Project <h2>Venus</h2>
     * @Package <h3>com.haruhi.genericFirst.GenericStack</h3>
     * @Description <p>栈 迭代器</p>
     * @Author SuzumiyaHaruhi
     * @Time 2017/12/17 12:24:03
     * @Version v1.0
     */
    private class StackIterator implements Iterator<E>{
        int count = size;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            return elements[--count];
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        int count = 25888;
        while(count-- > 0){
            stack.push(count);
        }
        for(Integer item:stack){
            System.out.println(item);
        }
    }
}
