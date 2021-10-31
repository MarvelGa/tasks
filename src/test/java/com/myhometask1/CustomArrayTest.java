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
        assertEquals("Cat2", customArray.get(0));
        assertEquals("Cat3", customArray.get(1));
    }

//    @Test
//    void shouldDeleteMiddleElement() {
//        int expected = 2;
//        customArray.delete(1);
//        int actual = customArray.size();
//        assertEquals("Cat1", customArray.get(0));
//        assertEquals("Cat3", customArray.get(1));
//    }
//
//    @Test
//    void shouldDeleteLastElement() {
//        int expected = 2;
//        customArray.delete(2);
//        int actual = customArray.size();
//        assertEquals("Cat1", customArray.get(0));
//        assertEquals("Cat2", customArray.get(1));
//    }

    @Test
    void shouldCleanAll() {
        int expected = 0;
        customArray.deleteAll();
        int actual = customArray.size();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenTryDeleteElementWithNotExistedIndex() {
        int notExistIndex = 4;
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

    @AfterEach
    void cleanUp() {
        customArray.deleteAll();
    }
}
