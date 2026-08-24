package com.alims.javatools.container.interfaces;

public interface SelfCreatable<V, SELF> {

    SELF createSelf(V value);

}