package com.alims.javatools.core.container.standard.base.node;

import com.alims.javatools.core.container.standard.interfaces.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractNodeTest {

    static class TestNode<V> extends AbstractNode<V> {

        protected TestNode(V value) {
            super(value);
        }

        @Override
        public Node<V> createSelf(V value) {
            return new TestNode<>(value);
        }
    }

    @Test
    void shouldReturnInitialValue() {
        Node<String> node = new TestNode<>("Hello");

        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldReturnOldValueAndUpdateValueWhenSetValue() {
        Node<String> node = new TestNode<>("Hello");

        String oldValue = node.setValue("World");

        assertEquals("Hello", oldValue);
        assertEquals("World", node.getValue());
    }

    @Test
    void shouldCreateNewNodeWithSpecifiedValue() {
        Node<String> node = new TestNode<>("Hello");

        Node<String> newNode = node.createSelf("World");

        assertNotNull(newNode);
        assertEquals("World", newNode.getValue());

        // createSelf 应该创建新对象，而不是返回自己
        assertNotSame(node, newNode);

        // 原节点不应该被修改
        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldSupportMultipleValueUpdates() {
        Node<Integer> node = new TestNode<>(1);

        assertEquals(1, node.setValue(2));
        assertEquals(2, node.getValue());

        assertEquals(2, node.setValue(3));
        assertEquals(3, node.getValue());
    }

    @Test
    void shouldThrowExceptionWhenInitialValueIsNull() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new TestNode<String>(null)
        );

        assertEquals("value must not be null", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSettingValueToNull() {
        Node<String> node = new TestNode<>("Hello");

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> node.setValue(null)
        );

        assertEquals("value must not be null", exception.getMessage());

        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldSupportDifferentGenericTypes() {
        Node<Integer> integerNode = new TestNode<>(123);
        Node<String> stringNode = new TestNode<>("Hello");

        assertEquals(123, integerNode.getValue());
        assertEquals("Hello", stringNode.getValue());
    }
}