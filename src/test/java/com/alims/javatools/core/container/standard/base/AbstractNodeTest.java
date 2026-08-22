package com.alims.javatools.core.container.standard.base;

import com.alims.javatools.core.container.standard.interfaces.Node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractNodeTest {

    static class TestNode<V> extends AbstractNode<V> {

        protected TestNode(V value) {
            super(value);
        }
    }

    @Test
    void shouldReturnCorrectValue() {
        Node<String> node = new TestNode<>("Hello");

        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new TestNode<String>(null)
        );

        assertEquals("value must not be null", exception.getMessage());
    }

    @Test
    void shouldSupportDifferentGenericTypes() {
        Node<Integer> node = new TestNode<>(123);

        assertEquals(123, node.getValue());
    }
}
