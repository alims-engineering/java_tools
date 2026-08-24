package com.alims.javatools.container.list.model;

import com.alims.javatools.container.node.model.SingleConnectionNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DualAnchoredSinglyLinkedListTest {

    // ====================================
    // Constructor
    // ====================================

    @Test
    void shouldCreateEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    // ====================================
    // Method - add
    // ====================================

    @Test
    void shouldAddElementToEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add(0, "A");

        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    void shouldAddElementAtMiddle() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("C");

        list.add(1, "B");

        assertEquals(3, list.size());

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    // ====================================
    // Method - First Operation
    // ====================================

    @Test
    void shouldAddFirst() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.addFirst("B");
        list.addFirst("A");

        assertEquals(2, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void shouldGetFirst() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");

        assertEquals("A", list.getFirst());
    }

    @Test
    void shouldSetFirst() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");

        String oldValue = list.setFirst("X");

        assertEquals("A", oldValue);

        assertEquals("X", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void shouldRemoveFirst() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.removeFirst();

        assertEquals("A", removed);

        assertEquals(2, list.size());

        assertEquals("B", list.getFirst());
        assertEquals("C", list.getLast());
    }

    // ====================================
    // Method - Last Operation
    // ====================================

    @Test
    void shouldAddLast() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals(3, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
    }

    @Test
    void shouldGetLast() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.getLast());
    }

    @Test
    void shouldSetLast() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");

        String oldValue = list.setLast("X");

        assertEquals("B", oldValue);

        assertEquals("A", list.getFirst());
        assertEquals("X", list.getLast());
    }

    @Test
    void shouldRemoveLast() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.removeLast();

        assertEquals("C", removed);

        assertEquals(2, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    // ====================================
    // Method - Normal get / set
    // ====================================

    @Test
    void shouldGetElementByIndex() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void shouldSetElementByIndex() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String oldValue = list.set(1, "X");

        assertEquals("B", oldValue);

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("C", list.get(2));
    }

    // ====================================
    // Method - remove
    // ====================================

    @Test
    void shouldRemoveElementFromMiddle() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);

        assertEquals(2, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());

        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void shouldRemoveFirstUsingIndex() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");

        String removed = list.remove(0);

        assertEquals("A", removed);

        assertEquals("B", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void shouldRemoveLastUsingIndex() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");
        list.add("B");

        String removed = list.remove(1);

        assertEquals("B", removed);

        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
    }

    // ====================================
    // Single Node
    // ====================================

    @Test
    void shouldMaintainAnchorsForSingleNode() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.addFirst("A");

        assertEquals(1, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
    }

    @Test
    void shouldBecomeEmptyAfterRemovingOnlyNodeFromFirst() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");

        assertEquals("A", list.removeFirst());

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldBecomeEmptyAfterRemovingOnlyNodeFromLast() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");

        assertEquals("A", list.removeLast());

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    // ====================================
    // Node Creation
    // ====================================

    @Test
    void shouldCreateSingleConnectionNode() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        SingleConnectionNode<String> node =
                list.createNode("Hello");

        assertNotNull(node);

        assertEquals("Hello", node.getValue());
    }

    // ====================================
    // Boundary
    // ====================================

    @Test
    void shouldThrowExceptionWhenGettingFirstFromEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                list::getFirst
        );
    }

    @Test
    void shouldThrowExceptionWhenGettingLastFromEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                list::getLast
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingFirstFromEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                list::removeFirst
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingLastFromEmptyList() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                list::removeLast
        );
    }

    @Test
    void shouldThrowExceptionWhenIndexIsNegative() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(-1)
        );
    }

    @Test
    void shouldThrowExceptionWhenIndexIsGreaterThanSize() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.add("A");

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(1)
        );
    }

    @Test
    void shouldThrowExceptionWhenAddingOutsideValidPosition() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1, "A")
        );
    }

    // ====================================
    // Complex Scenario
    // ====================================

    @Test
    void shouldMaintainCorrectStructureAfterMultipleOperations() {
        DualAnchoredSinglyLinkedList<String> list =
                new DualAnchoredSinglyLinkedList<>();

        list.addLast("B");
        list.addFirst("A");
        list.addLast("D");

        list.add(2, "C");

        assertEquals(4, list.size());

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));

        assertEquals("A", list.getFirst());
        assertEquals("D", list.getLast());

        assertEquals("A", list.removeFirst());
        assertEquals("D", list.removeLast());

        assertEquals(2, list.size());

        assertEquals("B", list.getFirst());
        assertEquals("C", list.getLast());

        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
    }
}