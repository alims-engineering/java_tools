package com.alims.javatools.container.list.model;

import com.alims.javatools.container.list.base.AbstractTimeAnnotatedList;
import com.alims.javatools.time.model.TimeInfo;

import java.util.ArrayList;

/**
 * A time-annotated list backed by an {@link ArrayList}.
 *
 * @param <E> element type
 */
public class ArrayTimeAnnotatedList<E>
        extends AbstractTimeAnnotatedList<
                E, TimeInfo, ArrayList<AnnotatedEntry<E, TimeInfo>> //
        > {

    // ====================================
    // Constructor
    // ====================================
    public ArrayTimeAnnotatedList() {
        super(new ArrayList<>());
    }

    public ArrayTimeAnnotatedList(
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
    protected TimeInfo createAnnotation(
            E element
    ) {
        return new TimeInfo();
    }

    @Override
    protected ArrayList<AnnotatedEntry<E, TimeInfo>>
            createAnnotatedEntries() {

        return new ArrayList<>();
    }
}
