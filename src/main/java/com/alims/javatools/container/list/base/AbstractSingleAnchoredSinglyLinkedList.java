package com.alims.javatools.container.list.base;

import com.alims.javatools.container.list.interfaces.AnchoredSinglyLinkedList;
import com.alims.javatools.container.list.interfaces.SingleAnchoredLinkedList;
import com.alims.javatools.container.node.interfaces.SingleConnectableNode;

/*
 * AbstractSingleAnchoredSinglyLinkedList<E, Node>
 *          |
 *          +-- implements SingleAnchoredLinkedList<E, Node>
 *          |
 *          +-- implements AnchoredSinglyLinkedList<E, Node>
 *          |
 *          v
 * AbstractAnchoredLinkedList<E, Node>
 *          |
 *          v
 * AbstractList<E>
 *          |
 *          v
 * java.util.AbstractList<E>
 */
public abstract class AbstractSingleAnchoredSinglyLinkedList<
        E,
        Node extends SingleConnectableNode<E, Node>
        >
        extends AbstractAnchoredLinkedList<E, Node>
        implements
                SingleAnchoredLinkedList<E, Node>,
                AnchoredSinglyLinkedList<E, Node> {

    // ====================================
    // Field
    // ====================================

    protected Node anchor;

    // ====================================
    // Constructor
    // ====================================

    protected AbstractSingleAnchoredSinglyLinkedList() {
    }

    // ====================================
    // Method - Override - Normal Operation
    // ====================================

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        /*
         * Insert at first position.
         */
        if (index == 0) {
            addFirst(element);
            return;
        }

        /*
         * Find previous node.
         */
        Node previous = getNode(index - 1);
        Node next = previous.getConnection();

        /*
         * Create new node.
         */
        Node newNode = createNode(element);

        /*
         * Disconnect previous -> next.
         */
        if (next != null) {
            previous.disconnect(next);
        }

        /*
         * Connect newNode -> next.
         */
        if (next != null) {
            newNode.connect(next);
        }

        /*
         * Connect previous -> newNode.
         */
        previous.connect(newNode);

        increaseSize();
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);

        return getNode(index).getValue();
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);

        Node node = getNode(index);

        E oldValue = node.getValue();

        node.setValue(element);

        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);

        /*
         * Remove first node.
         */
        if (index == 0) {
            return removeFirst();
        }

        /*
         * Find previous node.
         */
        Node previous = getNode(index - 1);

        Node removed = previous.getConnection();
        Node next = removed.getConnection();

        /*
         * Disconnect previous -> removed.
         */
        previous.disconnect(removed);

        /*
         * Connect previous -> next.
         */
        if (next != null) {
            previous.connect(next);

            /*
             * Disconnect removed -> next.
             */
            removed.disconnect(next);
        }

        decreaseSize();

        return removed.getValue();
    }

    // ====================================
    // Method - Override - First Operation
    // ====================================

    @Override
    public void addFirst(E element) {
        Node newNode = createNode(element);

        /*
         * Connect newNode -> anchor.
         */
        if (anchor != null) {
            newNode.connect(anchor);
        }

        anchor = newNode;

        increaseSize();
    }

    @Override
    public E getFirst() {
        checkElementIndex(0);

        return anchor.getValue();
    }

    @Override
    public E removeFirst() {
        checkElementIndex(0);

        return removeAnchor();
    }

    // ====================================
    // Method - Override - Anchor
    // ====================================

    @Override
    public Node getAnchor() {
        return anchor;
    }

    // ====================================
    // Method - Protected
    // ====================================

    /**
     * Removes the anchor node and returns its value.
     *
     * The caller must ensure that the list is not empty.
     */
    protected E removeAnchor() {
        Node removed = anchor;
        Node next = removed.getConnection();

        anchor = next;

        /*
         * Disconnect removed -> next.
         */
        if (next != null) {
            removed.disconnect(next);
        }

        decreaseSize();

        return removed.getValue();
    }

    /**
     * Returns the node at the specified index.
     *
     * The caller must ensure that the index is valid.
     */
    protected Node getNode(int index) {
        Node current = anchor;

        for (int i = 0; i < index; i++) {
            current = current.getConnection();
        }

        return current;
    }
}