package com.alims.javatools.container.list.base;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

public abstract class AbstractAnchoredLinkedList<
        E, ////
        Node extends ConnectableNode<E, Node>  ////
        >   //
        extends AbstractList<E> {

    // ====================================
    // Constructor
    // ====================================
    protected AbstractAnchoredLinkedList() {
    }

    // ====================================
    // Method - Abstract
    // ====================================
    /**
     * Creates a node containing the given element.
     */
    protected abstract Node createNode(E element);
}
