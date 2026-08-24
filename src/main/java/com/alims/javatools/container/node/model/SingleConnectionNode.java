package com.alims.javatools.container.node.model;

import com.alims.javatools.container.node.base.AbstractSingleConnectionNode;

public class SingleConnectionNode<V>
        extends AbstractSingleConnectionNode<
                V,
                SingleConnectionNode<V>
                > {

    public SingleConnectionNode(V value) {
        super(value);
    }

    public SingleConnectionNode(
            V value,
            SingleConnectionNode<V> connection
    ) {
        super(value, connection);
    }

    @Override
    public SingleConnectionNode<V> createSelf(V value) {
        return new SingleConnectionNode<>(value);
    }
}
