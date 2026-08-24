package com.alims.javatools.container.list.interfaces;

public interface List<E>
        extends java.util.List<E> {

    // ====================================
    // Method - First Operation
    // ====================================
    E setFirst(E element);

    // ====================================
    // Method - Last Operation
    // ====================================
    E setLast(E element);
}
