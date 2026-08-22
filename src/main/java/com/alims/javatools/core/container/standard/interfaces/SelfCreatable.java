package com.alims.javatools.core.container.standard.interfaces;

public interface SelfCreatable<V, SELF> {

    SELF createSelf(V value);

}