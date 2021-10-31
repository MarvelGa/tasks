package com.myhometask1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.CustomIterator;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomIteratorTest {
    String[] str;
    Integer[] integers;
    CustomIterator<String> customIterator;
    CustomIterator<Integer> customIterator2;


    @BeforeEach
    void setUp() {
        str = new String[3];
        str[0] = "Dog";
        str[1] = "Cat";
        str[2] = "Hare";
        customIterator = new CustomIterator(str);

        integers = new Integer[0];
        customIterator2 = new CustomIterator<>(integers);
    }

    @Test
    void shouldReturnNextElement() {
        var expected = "Dog";
        var actual = customIterator.next();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnNextElement2() {
        var expected = "Hare";
        String actual = null;
        for (int i = 0; i < 3; i++) {
            actual = customIterator.next();
        }
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnResultOfExistingOfNextElement2() {
        boolean actual = customIterator2.hasNext();
        assertEquals(false, actual);
    }

    @Test
    void shouldReturnResultOfExistingOfNextElement() {
        boolean actual = customIterator.hasNext();
        assertEquals(true, actual);
    }


    @Test
    void shouldThrowNoSuchElementException() {
        Throwable exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            for (int i = 0; i < 4; i++) {
                customIterator.next();
            }
        });
        assertEquals(exception.getClass(), NoSuchElementException.class);
    }
}
