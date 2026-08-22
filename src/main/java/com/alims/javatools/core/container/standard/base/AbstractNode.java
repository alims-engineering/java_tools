package com.alims.javatools.core.container.standard.base;

import java.util.Objects;
import com.alims.javatools.core.container.standard.interfaces.Node;

public abstract class AbstractNode<V>
        implements Node<V> {

    private V value;

    // ====================================
    //  Constructor
    // ====================================
    protected AbstractNode(V value) {
        this.value = Objects.requireNonNull(value, "value must not be null");
    }

    // ====================================
    //  Method - Override
    // ====================================
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        Objects.requireNonNull(value, "value must not be null");

        V oldValue = this.value;
        this.value = value;

        return oldValue;
    }
}
