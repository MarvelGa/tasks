package com.myhometask1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.CustomIterator;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomIteratorTest {
    String[] str;
    CustomIterator<String> customIterator;


    @BeforeEach
    void setUp() {
        str = new String[3];
        str[0] = "Dog";
        str[1] = "Cat";
        str[2] = "Hare";
        customIterator = new CustomIterator(str);
    }

    @Test
    void shouldReturnNextElement() {
        var expected = "Dog";
        var actual = customIterator.next();
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnResultOfExistingOfNextElement() {
        boolean expected = true;
        boolean actual = customIterator.hasNext();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNoSuchElementException() {
        Throwable exception = Assertions.assertThrows(NoSuchElementException.class, () -> {
            for (int i = 0; i < 10; i++) {
                customIterator.next();
            }
        });
        assertEquals(exception.getClass(), NoSuchElementException.class);
    }
}
