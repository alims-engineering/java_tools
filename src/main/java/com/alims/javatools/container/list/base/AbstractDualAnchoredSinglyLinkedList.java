package com.alims.javatools.container.list.base;

import com.alims.javatools.container.list.interfaces.AnchoredSinglyLinkedList;
import com.alims.javatools.container.list.interfaces.DualAnchoredLinkedList;
import com.alims.javatools.container.node.interfaces.SingleConnectableNode;

/*
 * AbstractDualAnchoredSinglyLinkedList<E, Node>
 *          |
 *          +-- implements DualAnchoredLinkedList<E, Node>
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
public abstract class AbstractDualAnchoredSinglyLinkedList<
        E,
        Node extends SingleConnectableNode<E, Node>
        >
        extends AbstractAnchoredLinkedList<E, Node>
        implements
                DualAnchoredLinkedList<E, Node>,
                AnchoredSinglyLinkedList<E, Node> {

    // ====================================
    // Field
    // ====================================

    protected Node firstAnchor;

    protected Node secondAnchor;

    // ====================================
    // Constructor
    // ====================================

    protected AbstractDualAnchoredSinglyLinkedList() {
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
         * Insert at last position.
         */
        if (index == size()) {
            addLast(element);
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
        previous.disconnect(next);

        /*
         * Connect previous -> newNode.
         */
        previous.connect(newNode);

        /*
         * Connect newNode -> next.
         */
        newNode.connect(next);

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

        return getNode(index).setValue(element);
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);

        /*
         * Remove first position.
         */
        if (index == 0) {
            return removeFirst();
        }

        /*
         * Remove last position.
         */
        if (index == size() - 1) {
            return removeLast();
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
        previous.connect(next);

        /*
         * Disconnect removed -> next.
         */
        removed.disconnect(next);

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
         * Empty list.
         */
        if (firstAnchor == null) {
            firstAnchor = newNode;
            secondAnchor = newNode;

            increaseSize();
            return;
        }

        /*
         * Connect newNode -> firstAnchor.
         */
        newNode.connect(firstAnchor);

        firstAnchor = newNode;

        increaseSize();
    }

    @Override
    public E getFirst() {
        checkElementIndex(0);

        return firstAnchor.getValue();
    }

    @Override
    public E setFirst(E element) {
        checkElementIndex(0);

        return firstAnchor.setValue(element);
    }

    @Override
    public E removeFirst() {
        checkElementIndex(0);

        Node removed = firstAnchor;

        /*
         * Single-node list.
         */
        if (firstAnchor == secondAnchor) {
            firstAnchor = null;
            secondAnchor = null;

            decreaseSize();

            return removed.getValue();
        }

        Node next = removed.getConnection();

        /*
         * Move first anchor.
         */
        firstAnchor = next;

        /*
         * Disconnect removed -> next.
         */
        removed.disconnect(next);

        decreaseSize();

        return removed.getValue();
    }

    // ====================================
    // Method - Override - Last Operation
    // ====================================

    @Override
    public void addLast(E element) {
        Node newNode = createNode(element);

        /*
         * Empty list.
         */
        if (secondAnchor == null) {
            firstAnchor = newNode;
            secondAnchor = newNode;

            increaseSize();
            return;
        }

        /*
         * Connect secondAnchor -> newNode.
         */
        secondAnchor.connect(newNode);

        secondAnchor = newNode;

        increaseSize();
    }

    @Override
    public E getLast() {
        checkElementIndex(size() - 1);

        return secondAnchor.getValue();
    }

    @Override
    public E setLast(E element) {
        checkElementIndex(size() - 1);

        return secondAnchor.setValue(element);
    }

    @Override
    public E removeLast() {
        checkElementIndex(size() - 1);

        Node removed = secondAnchor;

        /*
         * Single-node list.
         */
        if (firstAnchor == secondAnchor) {
            firstAnchor = null;
            secondAnchor = null;

            decreaseSize();

            return removed.getValue();
        }

        /*
         * Find the node before secondAnchor.
         */
        Node previous = getNode(size() - 2);

        /*
         * Disconnect previous -> removed.
         */
        previous.disconnect(removed);

        /*
         * Move second anchor.
         */
        secondAnchor = previous;

        decreaseSize();

        return removed.getValue();
    }

    // ====================================
    // Method - Protected
    // ====================================

    /**
     * Returns the node at the specified index.
     *
     * The caller must ensure that the index is valid.
     */
    protected Node getNode(int index) {
        Node current = firstAnchor;

        for (int i = 0; i < index; i++) {
            current = current.getConnection();
        }

        return current;
    }
}