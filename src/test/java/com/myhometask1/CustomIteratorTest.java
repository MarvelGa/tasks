package com.myhometask1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.customarray.CustomIterator;

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
        assertEquals(customIterator.next(), "Dog");
        assertEquals(customIterator.next(), "Cat");
        assertEquals(customIterator.next(), "Hare");
    }

    @Test
    void shouldReturnFalse() {
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
            while (customIterator.hasNext()) {
                customIterator.next();
            }
            customIterator.next();
        });
        assertEquals(exception.getClass(), NoSuchElementException.class);
    }
}
