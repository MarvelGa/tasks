package com.myhometask1;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.CustomArray;

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
    void shouldGetElementByIndex() {
        String expected = "Cat1";
        String actual = customArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnSize() {
        int expected = 3;
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
        int expected = 2;
        customArray.delete(0);
        int actual = customArray.size();
        assertEquals(customArray.get(0), "Cat2");
        assertEquals(customArray.get(1), "Cat3");
    }

    @Test
    void shouldDeleteMiddleElement() {
        int expected = 2;
        customArray.delete(1);
        int actual = customArray.size();
        assertEquals(customArray.get(0), "Cat1");
        assertEquals(customArray.get(1), "Cat3");
    }

    @Test
    void shouldDeleteLastElement() {
        int expected = 2;
        customArray.delete(2);
        int actual = customArray.size();
        assertEquals(customArray.get(0), "Cat1");
        assertEquals(customArray.get(1), "Cat2");
    }

    @Test
    void shouldCleanAll() {
        int expected = 0;
        customArray.deleteAll();
        int actual = customArray.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowClassCastExceptionWhenTryAddElementWithIntegerType() {
        Integer type = 1;
        Object obj = type;
        Throwable exception = Assertions.assertThrows(ClassCastException.class, () -> {
            customArray.add((String) obj);
        });
        assertEquals(exception.getClass(), ClassCastException.class);
    }

    @Test
    void shouldThrowClassCastExceptionWhenTryDeleteElementWithIntegerType() {
        String type = "string";
        Object obj = type;
        Throwable exception = Assertions.assertThrows(ClassCastException.class, () -> {
            customArray.delete((Integer) obj);
        });
        assertEquals(exception.getClass(), ClassCastException.class);
    }

    @AfterEach
    void cleanUp() {
        customArray.deleteAll();
    }
}
