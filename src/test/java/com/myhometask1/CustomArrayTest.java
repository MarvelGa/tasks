package com.myhometask1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.customarray.CustomArray;
import org.myhometask1.customarray.CustomIterator;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayTest {
    CustomArray<String> customArray;

    @BeforeEach
    void setUp() {
        customArray = new CustomArray();
        customArray.add("Cat1");
        customArray.add("Cat2");
        customArray.add("Cat3");
    }

    @Test
    void shouldAddElement() {
        String expected = "Cat4";
        customArray.add("Cat4");
        String actual = customArray.get(3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldResizeTheArray() {
        customArray.add("Cat5");
        customArray.add("Cat6");
        customArray.add("Cat7");
        customArray.add("Cat8");
        customArray.add("Cat9");
        customArray.add("Cat10");
        customArray.add("Cat11");
        int expected = 16;
        int actual = customArray.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSetCustomSizeOfTheArray() {
        int size = 20;
        CustomArray<String> customArray = new CustomArray<>(size);
        int actual = customArray.size();
        assertEquals(size, actual);
    }

    @Test
    void shouldGetCurrentIndex() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int expectedLastArrayIndex = 9;
        var method = CustomArray.class.getDeclaredMethod("getLastIndexOfArray");
        method.setAccessible(true);
        var actualLastArrayIndex = method.invoke(new CustomArray<>());
        assertEquals(expectedLastArrayIndex, actualLastArrayIndex);
    }

    @Test
    void shouldGetCurrentIndexWithCustomCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int expectedLastArrayIndex = 0;
        int customCapacity = 0;
        var method = CustomArray.class.getDeclaredMethod("getLastIndexOfArray");
        method.setAccessible(true);
        var actualLastArrayIndex = method.invoke(new CustomArray<>(customCapacity));
        assertEquals(expectedLastArrayIndex, actualLastArrayIndex);
    }

    @Test
    void shouldGetElementByIndex() {
        String expected = "Cat1";
        String actual = customArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSize() {
        int expected = 10;
        int actual = customArray.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdate() {
        String expected = "Murchik";
        customArray.update(2, "Murchik");
        String actual = customArray.get(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteFirstElement() {
        int expected = 9;
        customArray.delete(0);
        int actual = customArray.size();
        assertEquals(actual, expected);
        assertEquals("Cat2", customArray.get(0));
        assertEquals("Cat3", customArray.get(1));
    }

    @Test
    void shouldCleanAll() {
        int expected = 0;
        customArray.deleteAll();
        int actual = customArray.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryDeleteElementWithNotExistedIndex() {
        int notExistIndex = 44;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            customArray.delete(notExistIndex);
        });
        assertEquals(exception.getClass(), IllegalArgumentException.class);
        assertEquals(exception.getMessage(), String.format("The index=%s not exist", notExistIndex));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryDeleteElementInEmptyArray() {
        customArray.deleteAll();
        int notExistIndex = 4;
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            customArray.delete(notExistIndex);
        });
        assertEquals(exception.getClass(), IllegalArgumentException.class);
        assertEquals(exception.getMessage(), String.format("The index=%s not exist. Array is empty!", notExistIndex));
    }

    @Test
    void shouldReturnIterator() {
        var actual = customArray.iterator();
        assertEquals(actual.getClass(), CustomIterator.class);
    }

    @AfterEach
    void cleanUp() {
        customArray.deleteAll();
    }
}
