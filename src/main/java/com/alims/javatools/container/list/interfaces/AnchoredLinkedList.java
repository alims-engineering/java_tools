package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

import java.util.List;

public interface AnchoredLinkedList<
        V, ////
        Node extends ConnectableNode<V, Node> //
        > extends List<V> {

}
