package com.alims.javatools.container.list.model;

import com.alims.javatools.container.list.base.AbstractDualAnchoredSinglyLinkedList;
import com.alims.javatools.container.node.model.SingleConnectionNode;

/*
 * DualAnchoredSinglyLinkedList<E>
 *          |
 *          v
 * AbstractDualAnchoredSinglyLinkedList<
 *     E,
 *     SingleConnectionNode<E>
 * >
 */
public class DualAnchoredSinglyLinkedList<E>
        extends AbstractDualAnchoredSinglyLinkedList<
                E,
                SingleConnectionNode<E>
        > {

    // ====================================
    // Constructor
    // ====================================

    public DualAnchoredSinglyLinkedList() {
        super();
    }

    // ====================================
    // Method - Override
    // ====================================

    @Override
    public SingleConnectionNode<E> createNode(
            E element
    ) {
        return new SingleConnectionNode<>(element);
    }
}