package com.hillel.hwYorsh1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArray implements List<MyArray> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<MyArray> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(MyArray myArray) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends MyArray> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends MyArray> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public MyArray get(int index) {
        return null;
    }

    @Override
    public MyArray set(int index, MyArray element) {
        return null;
    }

    @Override
    public void add(int index, MyArray element) {

    }

    @Override
    public MyArray remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<MyArray> listIterator() {
        return null;
    }

    @Override
    public ListIterator<MyArray> listIterator(int index) {
        return null;
    }

    @Override
    public List<MyArray> subList(int fromIndex, int toIndex) {
        return null;
    }
}
