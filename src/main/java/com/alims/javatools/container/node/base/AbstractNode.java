package com.alims.javatools.container.node.base;

import java.util.Objects;

import com.alims.javatools.container.node.interfaces.Node;

public abstract class AbstractNode<
        V, Self extends Node<V, Self>>
        implements Node<V, Self> {

    private V value = null;

    // ====================================
    // Constructor
    // ====================================
    protected AbstractNode() {
    }

    protected AbstractNode(V value) {
        this.value = value;
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public V getValue() {
        return value;
    }

@Override
public V setValue(V value) {
    V oldValue = this.value;
    this.value = value;

    return oldValue;
}
}
