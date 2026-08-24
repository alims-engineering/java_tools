package com.alims.javatools.container.node.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleConnectionNodeTest {

    @Test
    void shouldCreateNode() {
        SingleConnectionNode<String> node =
                new SingleConnectionNode<>("A");

        assertEquals("A", node.getValue());
    }

    @Test
    void shouldCreateSelf() {
        SingleConnectionNode<String> node =
                new SingleConnectionNode<>("A");

        SingleConnectionNode<String> newNode =
                node.createSelf("B");

        assertNotNull(newNode);
        assertEquals("B", newNode.getValue());
        assertNotSame(node, newNode);
    }

    @Test
    void shouldAppendNode() {
        SingleConnectionNode<String> node =
                new SingleConnectionNode<>("A");

        SingleConnectionNode<String> next =
                node.append("B");

        assertNotNull(next);
        assertEquals("B", next.getValue());
        assertSame(next, node.getConnection());
    }
}
