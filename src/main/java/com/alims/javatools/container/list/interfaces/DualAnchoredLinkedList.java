package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

public interface DualAnchoredLinkedList<
        V, ////
        Node extends ConnectableNode<V, Node> //
        > extends MultiAnchoredLinkedList<V, Node> {

    Node getFirstAnchor();

    Node getSecondAnchor();
}
