package com.alims.javatools.container.list.model;

public class AnnotatedEntry<E, A> {

    protected E element;

    protected A annotation;

    // ====================================
    // Constructor
    // ====================================
    public AnnotatedEntry() {
    }

    public AnnotatedEntry(E element, A annotation) {
        this.element = element;
        this.annotation = annotation;
    }

    // ====================================
    // Method
    // ====================================
    public E getElement() {
        return element;
    }

    public A getAnnotation() {
        return annotation;
    }
}
