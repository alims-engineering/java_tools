package com.alims.javatools.core.container.standard.base;

import com.alims.javatools.core.container.standard.interfaces.Node;
import com.alims.javatools.core.container.standard.interfaces.SingleConnectableNode;

public abstract class AbstractSingleConnectionNode<V>
        extends AbstractNode<V>
        implements SingleConnectableNode<V> {

    protected Node<V> connection;

    // ====================================
    //  Constructor
    // ====================================

    protected AbstractSingleConnectionNode(V value) {
        super(value);
    }

    protected AbstractSingleConnectionNode(V value, Node<V> connection) {
        super(value);
        this.connection = connection;
    }

    // ====================================
    //  Method - Override
    // ====================================

    @Override
    public Node<V> getConnection() {
        return connection;
    }

    @Override
    public boolean connect(Node<V> other) {
        if (other == null || connection != null) {
            return false;
        }

        connection = other;
        return true;
    }

    @Override
    public Node<V> append(V element) {
        Node<V> node = createSelf(element);

        if (!connect(node)) {
            return null;
        }

        return node;
    }

    @Override
    public Node<V> disconnect(Node<V> other) {
        if (connection == other) {
            Node<V> result = connection;
            connection = null;
            return result;
        }

        return null;
    }

    @Override
    public boolean isConnectionEmpty() {
        return connection == null;
    }

    @Override
    public boolean containConnection(Node<V> other) {
        return connection == other;
    }

    @Override
    public int connectionCount() {
        return connection == null ? 0 : 1;
    }
}