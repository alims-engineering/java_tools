package com.alims.javatools.container.list.base;

import com.alims.javatools.container.list.model.AnnotatedEntry;
import com.alims.javatools.container.list.interfaces.AnnotatedList;
import java.util.Objects;

/**
 * An abstract implementation of {@link AnnotatedList}.
 *
 * @param <E> element type
 * @param <A> annotation type
 * @param <L> underlying list type
 */
public abstract class AbstractAnnotatedList<
        E, ////
        A, ////
        L extends java.util.List<AnnotatedEntry<E, A>>                            ////
        >//
        extends java.util.AbstractList<E>
        implements AnnotatedList<E, A, L> {

    protected final L annotatedEntries;

    protected AbstractAnnotatedList(L annotatedEntries) {
        this.annotatedEntries = Objects.requireNonNull(annotatedEntries);
    }

    protected AbstractAnnotatedList(E element) {
        this.annotatedEntries = createAnnotatedEntries();

        add(element);
    }


    /*
     * ============================================================
     * Basic List Operations
     * ============================================================
     */
    @Override
    public final int size() {
        return annotatedEntries.size();
    }

    @Override
    public final boolean isEmpty() {
        return annotatedEntries.isEmpty();
    }

    @Override
    public final void clear() {
        annotatedEntries.clear();
    }


    /*
     * ============================================================
     * Element Operations
     * ============================================================
     */
    @Override
    public void add(int index, E element) {
        annotatedEntries.add(
                index,
                createAnnotationEntry(element)
        );
    }

    @Override
    public E get(int index) {
        return getAnnotationEntry(index)
                .getElement();
    }

    @Override
    public E set(int index, E element) {
        AnnotatedEntry<E, A> oldEntry
                = getAnnotationEntry(index);

        E oldElement
                = oldEntry.getElement();

        A newAnnotation
                = updateAnnotation(
                        oldElement,
                        element,
                        oldEntry.getAnnotation()
                );

        annotatedEntries.set(
                index,
                new AnnotatedEntry<>(
                        element,
                        newAnnotation
                )
        );

        return oldElement;
    }

    @Override
    public E remove(int index) {
        return annotatedEntries
                .remove(index)
                .getElement();
    }


    /*
     * ============================================================
     * First / Last Operations
     * ============================================================
     */
    @Override
    public E removeLast() {
        return annotatedEntries
                .removeLast()
                .getElement();
    }

    @Override
    public E removeFirst() {
        return annotatedEntries
                .removeFirst()
                .getElement();
    }

    @Override
    public E getLast() {
        return annotatedEntries
                .getLast()
                .getElement();
    }

    @Override
    public E getFirst() {
        return annotatedEntries
                .getFirst()
                .getElement();
    }

    @Override
    public void addLast(E element) {
        annotatedEntries.addLast(
                createAnnotationEntry(element)
        );
    }

    @Override
    public void addFirst(E element) {
        annotatedEntries.addFirst(
                createAnnotationEntry(element)
        );
    }

    @Override
    public E setFirst(E element) {
        return set(0, element);
    }

    @Override
    public E setLast(E element) {
        return set(size() - 1, element);
    }

    /*
     * ============================================================
     * Annotation Operations
     * ============================================================
     */
    @Override
    public A getAnnotation(int index) {
        return getAnnotationEntry(index)
                .getAnnotation();
    }


    /*
     * ============================================================
     * Protected Operations
     * ============================================================
     */
    protected AnnotatedEntry<E, A> createAnnotationEntry(
            E element
    ) {
        return new AnnotatedEntry<>(
                element,
                createAnnotation(element)
        );
    }

    protected AnnotatedEntry<E, A> getAnnotationEntry(
            int index
    ) {
        return annotatedEntries.get(index);
    }

    protected abstract A createAnnotation(
            E element
    );

    protected abstract A updateAnnotation(
            E oldElement,
            E newElement,
            A oldAnnotation
    );


    /*
     * ============================================================
     * Underlying List Factory
     * ============================================================
     */
    protected abstract L createAnnotatedEntries();
}
