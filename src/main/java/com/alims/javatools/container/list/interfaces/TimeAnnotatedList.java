package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.list.model.AnnotatedEntry;
import com.alims.javatools.time.model.TimeInfo;
import java.time.Instant;

public interface TimeAnnotatedList<
        E, ////
        A extends TimeInfo, ////
        L extends java.util.List<AnnotatedEntry<E, A>>   ////
        > //
        extends AnnotatedList<E, A, L> {

    Instant getCreatedAt(int index);

    Instant getLastModifiedAt(int index);
}
