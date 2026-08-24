package com.alims.javatools.container.node.model;

import com.alims.javatools.container.node.base.AbstractMultiConnectionNode;

import java.util.ArrayList;

public class ArrayListMultiConnectionNode<V>
        extends AbstractMultiConnectionNode< ////
                V, ////
                ArrayListMultiConnectionNode<V>, ////
                ArrayList<ArrayListMultiConnectionNode<V>>//
        > {

    // ====================================
    // Constructor
    // ====================================
    public ArrayListMultiConnectionNode() {
        super(new ArrayList<>());
    }

    public ArrayListMultiConnectionNode(V value) {
        super(
                value,
                new ArrayList<>()
        );
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public ArrayListMultiConnectionNode<V> createSelf(V value) {
        return new ArrayListMultiConnectionNode<>(value);
    }
}
