package org.myhometask1;

import java.util.Iterator;

public class CustomIterator<E> implements Iterator {
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
    public Object next() {
        return values[index++];
    }
}
