package com.alims.javatools.core.container.standard.interfaces.node;

import com.alims.javatools.core.container.standard.interfaces.SelfCreatable;

public interface Node<V> 
        extends SelfCreatable<V, Node<V>> {

    V getValue();

    V setValue(V value);

}
