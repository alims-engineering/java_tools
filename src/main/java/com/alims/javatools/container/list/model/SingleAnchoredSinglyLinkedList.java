package com.alims.javatools.container.list.model;

import com.alims.javatools.container.list.base.AbstractSingleAnchoredSinglyLinkedList;
import com.alims.javatools.container.node.model.SingleConnectionNode;

public class SingleAnchoredSinglyLinkedList<E>
        extends AbstractSingleAnchoredSinglyLinkedList<
                E,
                SingleConnectionNode<E>
        > {

    // ====================================
    // Constructor
    // ====================================

    public SingleAnchoredSinglyLinkedList() {
    }

    // ====================================
    // Method - Override
    // ====================================

    @Override
    protected SingleConnectionNode<E> createNode(
            E element
    ) {
        return new SingleConnectionNode<>(element);
    }
}
