package com.alims.javatools.container.list.base;

import com.alims.javatools.container.list.model.AnnotatedEntry;
import com.alims.javatools.time.model.TimeInfo;

import java.time.Instant;

/**
 * An abstract implementation of a time-annotated list.
 *
 * Each annotation must extend {@link TimeInfo}. The list automatically
 * maintains the last modified time of an annotation when its associated
 * element is replaced.
 *
 * @param <E> element type
 * @param <A> annotation type
 * @param <L> underlying list type
 */

public abstract class AbstractTimeAnnotatedList<
        E,
        A extends TimeInfo,
        L extends java.util.List<AnnotatedEntry<E, A>>
        >
        extends AbstractAnnotatedList<E, A, L> {

    // ====================================
    // Constructor
    // ====================================

    protected AbstractTimeAnnotatedList(
            L annotatedEntries
    ) {
        super(annotatedEntries);
    }

    protected AbstractTimeAnnotatedList(
            E element
    ) {
        super(element);
    }


    /*
     * ============================================================
     * Annotation Operations
     * ============================================================
     */

    @Override
    protected A updateAnnotation(
            E oldElement,
            E newElement,
            A oldAnnotation
    ) {
        oldAnnotation.setLastModifiedAt(
                Instant.now()
        );

        return oldAnnotation;
    }
}
