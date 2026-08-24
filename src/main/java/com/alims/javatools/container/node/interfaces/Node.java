package com.alims.javatools.container.node.interfaces;

import com.alims.javatools.container.interfaces.SelfCreatable;

public interface Node<
        V,
        SELF extends Node<V, SELF>
        > extends SelfCreatable<V, SELF> 
{

    V getValue();

    V setValue(V value);

}
