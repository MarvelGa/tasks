package org.myhometask1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    public CustomIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
