package com.alims.javatools.core.container.standard.model.node;

import com.alims.javatools.core.container.standard.interfaces.node.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleConnectionNodeTest {

    @Test
    void shouldCreateNode() {
        SingleConnectionNode<String> node
                = new SingleConnectionNode<>("A");

        assertEquals("A", node.getValue());
    }

    @Test
    void shouldCreateSelf() {
        SingleConnectionNode<String> node
                = new SingleConnectionNode<>("A");

        Node<String> newNode = node.createSelf("B");

        assertNotNull(newNode);
        assertEquals("B", newNode.getValue());
        assertNotSame(node, newNode);
    }

    @Test
    void shouldAppendNode() {
        SingleConnectionNode<String> node
                = new SingleConnectionNode<>("A");

        Node<String> next = node.append("B");

        assertNotNull(next);
        assertEquals("B", next.getValue());
        assertSame(next, node.getConnection());
    }
}
