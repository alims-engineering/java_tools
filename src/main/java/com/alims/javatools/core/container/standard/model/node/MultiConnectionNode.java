package com.alims.javatools.core.container.standard.model.node;

import com.alims.javatools.core.container.standard.base.node.AbstractMultiConnectionNode;
import com.alims.javatools.core.container.standard.interfaces.node.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class MultiConnectionNode<V>
        extends AbstractMultiConnectionNode<
                V,
                Collection<Node<V>>
        > {

    // ====================================
    // Constructor
    // ====================================

    public MultiConnectionNode(V value) {
        super(value, new ArrayList<>());
    }

    public MultiConnectionNode(
            V value,
            Collection<Node<V>> connections
    ) {
        super(
                value,
                Objects.requireNonNull(
                        connections,
                        "connections must not be null"
                )
        );
    }

    @Override
    public Node<V> createSelf(V value) {
        return new MultiConnectionNode<>(value);
    }
}