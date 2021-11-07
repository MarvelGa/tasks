package org.myhometask1.customarray;

import java.util.Iterator;

public class CustomArray<E> implements Method<E> {
    private E[] values;
    private int pointerOfIndex = 0;

    public CustomArray() {
        values = (E[]) new Object[10];
    }

    public CustomArray(int customCapacity) {
        values = (E[]) new Object[customCapacity];
    }

    @Override
    public boolean add(E e) {
        if (pointerOfIndex == getLastIndexOfArray()) {
            E[] temp = values;
            values = (E[]) new Object[(temp.length * 3 / 2) + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
        values[pointerOfIndex] = e;
        pointerOfIndex++;
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

    private int getLastIndexOfArray() {
        return values.length == 0 ? 0 : values.length - 1;
    }
}
