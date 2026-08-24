package com.alims.javatools.container.node.base;

import com.alims.javatools.container.node.interfaces.SingleConnectableNode;

public abstract class AbstractSingleConnectionNode<
        V, Self extends SingleConnectableNode<V, Self>>
        extends AbstractNode<V, Self>
        implements SingleConnectableNode<V, Self> {

    protected Self connection;

    // ====================================
    // Constructor
    // ====================================
    protected AbstractSingleConnectionNode() {
    }

    protected AbstractSingleConnectionNode(V value) {
        super(value);
    }

    protected AbstractSingleConnectionNode(
            V value,
            Self connection
    ) {
        super(value);
        this.connection = connection;
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public Self getConnection() {
        return connection;
    }

    @Override
    public boolean connect(Self other) {
        if (other == null || connection != null) {
            return false;
        }

        connection = other;

        return true;
    }

    @Override
    public Self append(V element) {
        Self node = createSelf(element);

        if (!connect(node)) {
            return null;
        }

        return node;
    }

    @Override
    public Self disconnect(Self other) {
        if (connection == other) {
            Self result = connection;

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
    public boolean containConnection(Self other) {
        return connection == other;
    }

    @Override
    public int connectionCount() {
        return connection == null ? 0 : 1;
    }
}
