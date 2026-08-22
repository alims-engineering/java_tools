package com.alims.javatools.core.container.standard.model;

import com.alims.javatools.core.container.standard.interfaces.Node;
import com.alims.javatools.core.container.standard.base.AbstractSingleConnectionNode;

public class SingleConnectionNode<V>
        extends AbstractSingleConnectionNode<V> {

    // ====================================
    //  Constructor
    // ====================================
    public SingleConnectionNode(V value) {
        super(value);
    }

    public SingleConnectionNode(V value, Node<V> connection) {
        super(value, connection);
    }

    @Override
    public Node<V> createSelf(V value) {
        return new SingleConnectionNode<>(value);
    }
}
