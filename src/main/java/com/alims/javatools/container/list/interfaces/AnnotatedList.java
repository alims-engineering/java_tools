package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.list.model.AnnotatedEntry;

public interface AnnotatedList<
        E, ////
        A, ////
        L extends java.util.List<AnnotatedEntry<E, A>>      ////
        > // 
        extends List<E> {

    A getAnnotation(int index);
}
