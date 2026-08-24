package com.alims.javatools.container.node.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMultiConnectionNodeTest {

    static class TestNode<V>
            extends AbstractMultiConnectionNode<
                    V,
                    TestNode<V>,
                    List<TestNode<V>>
                    > {

        protected TestNode(V value) {
            super(value, new ArrayList<>());
        }

        @Override
        public TestNode<V> createSelf(V value) {
            return new TestNode<>(value);
        }
    }

    @Test
    void shouldHaveEmptyConnectionsInitially() {
        TestNode<String> node = new TestNode<>("A");

        assertTrue(node.isConnectionEmpty());
        assertTrue(node.getConnections().isEmpty());
        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldConnectNodeSuccessfully() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        boolean result = node.connect(other);

        assertTrue(result);
        assertTrue(node.getConnections().contains(other));

        assertFalse(node.isConnectionEmpty());
        assertTrue(node.containConnection(other));

        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldConnectMultipleNodesSuccessfully() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> first = new TestNode<>("B");
        TestNode<String> second = new TestNode<>("C");

        assertTrue(node.connect(first));
        assertTrue(node.connect(second));

        assertTrue(node.containConnection(first));
        assertTrue(node.containConnection(second));

        assertEquals(2, node.connectionCount());
        assertFalse(node.isConnectionEmpty());
    }

    @Test
    void shouldNotConnectDuplicateNode() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        assertTrue(node.connect(other));

        boolean result = node.connect(other);

        assertFalse(result);

        assertTrue(node.containConnection(other));
        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldNotConnectNull() {
        TestNode<String> node = new TestNode<>("A");

        boolean result = node.connect(null);

        assertFalse(result);
        assertTrue(node.isConnectionEmpty());

        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldDisconnectConnectedNode() {
        TestNode<String> node = new TestNode<>("A");
        TestNode<String> other = new TestNode<>("B");

        assertTrue(node.connect(other));

        TestNode<String> result = node.disconnect(other);

        assertSame(other, result);

        assertFalse(node.containConnection(other));
        assertTrue(node.isConnectionEmpty());

        assertEquals(0, node.connectionCount());
    }

    @Test
    void shouldDisconnectOnlySpecifiedNode() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> first = new TestNode<>("B");
        TestNode<String> second = new TestNode<>("C");

        assertTrue(node.connect(first));
        assertTrue(node.connect(second));

        TestNode<String> result = node.disconnect(first);

        assertSame(first, result);

        assertFalse(node.containConnection(first));
        assertTrue(node.containConnection(second));

        assertEquals(1, node.connectionCount());
        assertFalse(node.isConnectionEmpty());
    }

    @Test
    void shouldReturnNullWhenDisconnectingNonConnectedNode() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> connected = new TestNode<>("B");
        TestNode<String> other = new TestNode<>("C");

        assertTrue(node.connect(connected));

        TestNode<String> result = node.disconnect(other);

        assertNull(result);

        assertTrue(node.containConnection(connected));
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

        assertTrue(node.containConnection(appendedNode));
        assertTrue(node.getConnections().contains(appendedNode));

        assertFalse(node.isConnectionEmpty());
        assertEquals(1, node.connectionCount());
    }

    @Test
    void shouldAppendMultipleNodesSuccessfully() {
        TestNode<String> node = new TestNode<>("A");

        TestNode<String> first = node.append("B");
        TestNode<String> second = node.append("C");
        TestNode<String> third = node.append("D");

        assertNotNull(first);
        assertNotNull(second);
        assertNotNull(third);

        assertEquals("B", first.getValue());
        assertEquals("C", second.getValue());
        assertEquals("D", third.getValue());

        assertTrue(node.containConnection(first));
        assertTrue(node.containConnection(second));
        assertTrue(node.containConnection(third));

        assertEquals(3, node.connectionCount());
    }
}

