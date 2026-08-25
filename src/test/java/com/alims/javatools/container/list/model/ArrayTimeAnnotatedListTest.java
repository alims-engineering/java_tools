package com.alims.javatools.container.list.model;

import com.alims.javatools.time.model.TimeInfo;
import java.time.Instant;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTimeAnnotatedListTest {

    // ====================================
    // Constructor
    // ====================================

    @Test
    void shouldCreateEmptyList() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void shouldCreateListWithElement() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>("A");

        assertEquals(1, list.size());
        assertEquals("A", list.get(0));

        assertNotNull(list.getAnnotation(0));
    }


    // ====================================
    // Method - add
    // ====================================

    @Test
    void shouldAddElementWithTimeInfo() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");

        assertEquals(1, list.size());
        assertEquals("A", list.get(0));

        TimeInfo timeInfo =
                list.getAnnotation(0);

        assertNotNull(timeInfo);
        assertNotNull(timeInfo.getCreatedAt());
        assertNotNull(timeInfo.getLastModifiedAt());
    }

    @Test
    void shouldCreateTimeInfoWithSameCreationAndModificationTime() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");

        TimeInfo timeInfo =
                list.getAnnotation(0);

        assertEquals(
                timeInfo.getCreatedAt(),
                timeInfo.getLastModifiedAt()
        );
    }

    @Test
    void shouldAddElementAtMiddle() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("C");

        list.add(1, "B");

        assertEquals(3, list.size());

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));

        assertNotNull(list.getAnnotation(1));
    }


    // ====================================
    // Method - First Operation
    // ====================================

    @Test
    void shouldAddFirstWithTimeInfo() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.addFirst("B");
        list.addFirst("A");

        assertEquals(2, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());

        assertNotNull(list.getAnnotation(0));
        assertNotNull(list.getAnnotation(1));
    }

    @Test
    void shouldGetFirst() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");

        assertEquals("A", list.getFirst());
    }

    @Test
    void shouldSetFirstAndUpdateLastModifiedAt() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");

        TimeInfo timeInfo =
                list.getAnnotation(0);

        Instant createdAt =
                timeInfo.getCreatedAt();

        Instant lastModifiedAt =
                timeInfo.getLastModifiedAt();

        String oldValue =
                list.setFirst("X");

        TimeInfo updatedTimeInfo =
                list.getAnnotation(0);

        assertEquals("A", oldValue);

        assertEquals("X", list.getFirst());
        assertEquals("B", list.getLast());

        assertEquals(
                createdAt,
                updatedTimeInfo.getCreatedAt()
        );

        assertTrue(
                updatedTimeInfo
                        .getLastModifiedAt()
                        .compareTo(lastModifiedAt) >= 0
        );
    }

    @Test
    void shouldRemoveFirst() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed =
                list.removeFirst();

        assertEquals("A", removed);

        assertEquals(2, list.size());

        assertEquals("B", list.getFirst());
        assertEquals("C", list.getLast());
    }


    // ====================================
    // Method - Last Operation
    // ====================================

    @Test
    void shouldAddLastWithTimeInfo() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals(3, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());

        assertNotNull(list.getAnnotation(2));
    }

    @Test
    void shouldGetLast() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("C", list.getLast());
    }

    @Test
    void shouldSetLastAndUpdateLastModifiedAt() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");

        TimeInfo timeInfo =
                list.getAnnotation(1);

        Instant createdAt =
                timeInfo.getCreatedAt();

        Instant lastModifiedAt =
                timeInfo.getLastModifiedAt();

        String oldValue =
                list.setLast("X");

        TimeInfo updatedTimeInfo =
                list.getAnnotation(1);

        assertEquals("B", oldValue);

        assertEquals("A", list.getFirst());
        assertEquals("X", list.getLast());

        assertEquals(
                createdAt,
                updatedTimeInfo.getCreatedAt()
        );

        assertTrue(
                updatedTimeInfo
                        .getLastModifiedAt()
                        .compareTo(lastModifiedAt) >= 0
        );
    }

    @Test
    void shouldRemoveLast() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed =
                list.removeLast();

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
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void shouldSetElementByIndexAndUpdateTimeInfo() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        TimeInfo timeInfo =
                list.getAnnotation(1);

        Instant createdAt =
                timeInfo.getCreatedAt();

        Instant lastModifiedAt =
                timeInfo.getLastModifiedAt();

        String oldValue =
                list.set(1, "X");

        TimeInfo updatedTimeInfo =
                list.getAnnotation(1);

        assertEquals("B", oldValue);

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("C", list.get(2));

        assertEquals(
                createdAt,
                updatedTimeInfo.getCreatedAt()
        );

        assertTrue(
                updatedTimeInfo
                        .getLastModifiedAt()
                        .compareTo(lastModifiedAt) >= 0
        );
    }


    // ====================================
    // Method - remove
    // ====================================

    @Test
    void shouldRemoveElementFromMiddle() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed =
                list.remove(1);

        assertEquals("B", removed);

        assertEquals(2, list.size());

        assertEquals("A", list.getFirst());
        assertEquals("C", list.getLast());
    }


    // ====================================
    // Annotation
    // ====================================

    @Test
    void shouldReturnCorrectAnnotation() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");

        TimeInfo firstAnnotation =
                list.getAnnotation(0);

        TimeInfo secondAnnotation =
                list.getAnnotation(1);

        assertNotNull(firstAnnotation);
        assertNotNull(secondAnnotation);

        assertNotSame(
                firstAnnotation,
                secondAnnotation
        );
    }


    // ====================================
    // Method - clear
    // ====================================

    @Test
    void shouldClearAllElements() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }


    // ====================================
    // Boundary
    // ====================================

    @Test
    void shouldThrowExceptionWhenGettingFirstFromEmptyList() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertThrows(
                NoSuchElementException.class,
                list::getFirst
        );
    }

    @Test
    void shouldThrowExceptionWhenGettingLastFromEmptyList() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertThrows(
                NoSuchElementException.class,
                list::getLast
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingFirstFromEmptyList() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertThrows(
                NoSuchElementException.class,
                list::removeFirst
        );
    }

    @Test
    void shouldThrowExceptionWhenRemovingLastFromEmptyList() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertThrows(
                NoSuchElementException.class,
                list::removeLast
        );
    }

    @Test
    void shouldThrowExceptionWhenIndexIsNegative() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(-1)
        );
    }

    @Test
    void shouldThrowExceptionWhenIndexIsGreaterThanSize() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.add("A");

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(1)
        );
    }

    @Test
    void shouldThrowExceptionWhenAddingOutsideValidPosition() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.add(1, "A")
        );
    }


    // ====================================
    // Complex Scenario
    // ====================================

    @Test
    void shouldMaintainCorrectElementsAndAnnotationsAfterMultipleOperations() {
        ArrayTimeAnnotatedList<String> list =
                new ArrayTimeAnnotatedList<>();

        list.addLast("B");
        list.addFirst("A");
        list.addLast("D");

        list.add(2, "C");

        list.set(1, "X");

        assertEquals(4, list.size());

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));

        for (int i = 0; i < list.size(); i++) {
            assertNotNull(
                    list.getAnnotation(i)
            );
        }

        assertEquals("A", list.removeFirst());
        assertEquals("D", list.removeLast());

        assertEquals(2, list.size());

        assertEquals("X", list.getFirst());
        assertEquals("C", list.getLast());
    }
}

