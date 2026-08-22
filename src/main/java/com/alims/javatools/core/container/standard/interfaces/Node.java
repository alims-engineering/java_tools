package com.alims.javatools.core.container.standard.interfaces;

public interface Node<V> 
        extends SelfCreatable<V, Node<V>> {

    V getValue();

    V setValue(V value);

}
