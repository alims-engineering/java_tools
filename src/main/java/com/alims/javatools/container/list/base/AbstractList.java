package com.alims.javatools.container.list.base;

public abstract class AbstractList<E>
        extends java.util.AbstractList<E> {

    private int size;

    // ====================================
    //  Constructor
    // ====================================
    protected AbstractList() {
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public int size() {
        return size;
    }

    // ====================================
    // Method - Protected - Index
    // ====================================
    protected final void increaseSize() {
        size++;
    }

    protected final void decreaseSize() {
        size--;
    }

    // ====================================
    // Method - Protected - Index
    // ====================================
    protected final boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    protected final boolean isPositionIndex(int index) {
        return index >= 0 && index <= size();
    }

    protected final void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size()
            );
        }
    }

    protected final void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size()
            );
        }
    }
}
