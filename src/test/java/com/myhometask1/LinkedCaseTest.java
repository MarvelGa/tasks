package com.myhometask1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.myhometask1.customlinkedlist.LinkedCase;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedCaseTest {
    LinkedCase<String> str;

    @BeforeEach
    void setUp() {
        str = new LinkedCase();
    }

    @Test
    void shouldAddLastElement() {
        str.addLast("cat");
        assertEquals(str.size(), 1);
        assertEquals(str.getElementByIndex(0), "cat");
    }

    @Test
    void shouldAddFirstElement() {
        str.addFirst("cat");
        assertEquals(str.size(), 1);
        assertEquals(str.getElementByIndex(0), "cat");
    }

    @Test
    void shouldReturnTrue() {
        str.addFirst("cat");
        str.iterator().hasNext();
        assertEquals(str.iterator().hasNext(), true);
    }

    @Test
    void shouldReturnFalse() {
        str.iterator().hasNext();
        assertEquals(str.iterator().hasNext(), false);
    }

    @Test
    void shouldIteratingByDescending() {
        str.addLast("cat");
        str.addLast("dog");
        str.addLast("hare");

        Iterator iterator = str.descendingIterator();
        assertEquals(str.size(), 3);
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), "hare");
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), "dog");
        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), "cat");
        assertEquals(iterator.hasNext(), false);
    }

    @Test
    void shouldIterateElement() {
        str.addFirst("cat");
        str.addFirst("dog");
        str.addFirst("hare");
        Iterator iterator = str.iterator();
        assertEquals(iterator.next(), "hare");
        assertEquals(iterator.next(), "dog");
        assertEquals(iterator.next(), "cat");
    }
}
