package com.alims.javatools.container.node.base;

import com.alims.javatools.container.node.interfaces.Node;
import java.io.Serializable;

public abstract class AbstractNode<
        V, Self extends Node<V, Self>>
        implements Node<V, Self>, Serializable {

    private static final long serialVersionUID = 1L;
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
