package com.alims.javatools.container.node.base;

import com.alims.javatools.container.node.interfaces.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractNodeTest {

    static class TestNode<V>
            extends AbstractNode<V, TestNode<V>> {

        protected TestNode(V value) {
            super(value);
        }

        @Override
        public TestNode<V> createSelf(V value) {
            return new TestNode<>(value);
        }
    }

    @Test
    void shouldReturnInitialValue() {
        Node<String, TestNode<String>> node =
                new TestNode<>("Hello");

        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldReturnOldValueAndUpdateValueWhenSetValue() {
        Node<String, TestNode<String>> node =
                new TestNode<>("Hello");

        String oldValue = node.setValue("World");

        assertEquals("Hello", oldValue);
        assertEquals("World", node.getValue());
    }

    @Test
    void shouldCreateNewNodeWithSpecifiedValue() {
        TestNode<String> node =
                new TestNode<>("Hello");

        TestNode<String> newNode =
                node.createSelf("World");

        assertNotNull(newNode);
        assertEquals("World", newNode.getValue());

        assertNotSame(node, newNode);

        assertEquals("Hello", node.getValue());
    }

    @Test
    void shouldSupportMultipleValueUpdates() {
        TestNode<Integer> node =
                new TestNode<>(1);

        assertEquals(1, node.setValue(2));
        assertEquals(2, node.getValue());

        assertEquals(2, node.setValue(3));
        assertEquals(3, node.getValue());
    }

    @Test
    void shouldAllowNullAsInitialValue() {
        TestNode<String> node =
                new TestNode<>(null);

        assertNull(node.getValue());
    }

    @Test
    void shouldAllowSettingValueToNull() {
        TestNode<String> node =
                new TestNode<>("Hello");

        String oldValue = node.setValue(null);

        assertEquals("Hello", oldValue);
        assertNull(node.getValue());
    }

    @Test
    void shouldSupportDifferentGenericTypes() {
        TestNode<Integer> integerNode =
                new TestNode<>(123);

        TestNode<String> stringNode =
                new TestNode<>("Hello");

        assertEquals(123, integerNode.getValue());
        assertEquals("Hello", stringNode.getValue());
    }

    @Test
    void shouldReturnConcreteSelfTypeFromCreateSelf() {
        TestNode<String> node =
                new TestNode<>("Hello");

        TestNode<String> newNode =
                node.createSelf("World");

        assertInstanceOf(TestNode.class, newNode);
    }
}