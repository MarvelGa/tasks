package org.myhometask1;

import java.util.Iterator;

public class CustomArray<E> implements Method<E> {
    private E[] values;

    public CustomArray() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            int numberToDeletingElement = index;
            System.arraycopy(temp, 0, values, 0, numberToDeletingElement);
            int numberAfterDeletingElement = temp.length - numberToDeletingElement - 1;
            System.arraycopy(temp, index + 1, values, index, numberAfterDeletingElement);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(String.format("The index=%s not exist", index));
        } catch (NegativeArraySizeException ex) {
            throw new IllegalArgumentException(String.format("The index=%s not exist. Array is empty!", index));
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public void deleteAll() {
        values = (E[]) new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<>(values);
    }
}
