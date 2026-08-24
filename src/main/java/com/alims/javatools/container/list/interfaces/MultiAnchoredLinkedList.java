package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

import java.util.Collection;

public interface MultiAnchoredLinkedList<
        V, ////
        Node extends ConnectableNode<V, Node>//
        > extends AnchoredLinkedList<V, Node> {

}
