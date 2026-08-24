package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

public interface SingleAnchoredLinkedList<
        V, ////
        Node extends ConnectableNode<V, Node>//
        > extends AnchoredLinkedList<V, Node> {

    Node getAnchor();
}
