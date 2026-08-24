package com.alims.javatools.container.node.base;

import com.alims.javatools.container.node.interfaces.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSingleConnectionNodeTest {

    static class TestNode<V>
            extends AbstractSingleConnectionNode<V, TestNode<V>> {

        protected TestNode(V value) {
            super(value);
        }

        @Override
        public TestNode<V> createSelf(V value) {
            return new TestNode<>(value);
        }
    }

    @Test
    void shouldHaveEmptyConnectionInitially() {
        TestNode<String> node = new TestNode<>("A");

        assertTrue(node.isConnectionEmpty());
        assertNull(node.getConnection());
        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldConnectNodeSuccessfully() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        boolean result = node.connect(other);

        assertTrue(result);
        assertSame(other, node.getConnection());
        assertFalse(node.isConnectionEmpty());
        assertTrue(node.containConnection(other));
        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldNotConnectWhenAlreadyConnected() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> first = new TestNode<>("B");
        TestNode<String> second = new TestNode<>("C");

        assertTrue(node.connect(first));

        boolean result = node.connect(second);

        assertFalse(result);
        assertSame(first, node.getConnection());
        assertFalse(node.containConnection(second));
        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldNotConnectNull() {
        TestNode<String> node = new TestNode<>("A");

        boolean result = node.connect(null);

        assertFalse(result);
        assertTrue(node.isConnectionEmpty());
        assertNull(node.getConnection());
        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldDisconnectConnectedNode() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        assertTrue(node.connect(other));

        TestNode<String> result = node.disconnect(other);

        assertSame(other, result);
        assertNull(node.getConnection());
        assertTrue(node.isConnectionEmpty());
        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldReturnNullWhenDisconnectingNonConnectedNode() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> connected = new TestNode<>("B");
        TestNode<String> other = new TestNode<>("C");

        assertTrue(node.connect(connected));

        TestNode<String> result = node.disconnect(other);

        assertNull(result);
        assertSame(connected, node.getConnection());
        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldReturnCorrectConnectionState() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        assertFalse(node.containConnection(other));

        assertTrue(node.connect(other));

        assertTrue(node.containConnection(other));
    }

    @Test
    void shouldAppendAndConnectNewNode() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> appendedNode = node.append("B");

        assertNotNull(appendedNode);
        assertEquals("B", appendedNode.getValue());
        assertSame(appendedNode, node.getConnection());

        assertFalse(node.isConnectionEmpty());
        assertTrue(node.containConnection(appendedNode));

        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldReturnNullWhenAppendingToAlreadyConnectedNode() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> first = node.append("B");
        TestNode<String> second = node.append("C");

        assertNotNull(first);
        assertNull(second);

        assertSame(first, node.getConnection());
        assertEquals("B", node.getConnection().getValue());

        assertEquals(1, node.connectionCount());
    }
}
