package com.alims.javatools.container.list.interfaces;

import com.alims.javatools.container.node.interfaces.ConnectableNode;

public interface AnchoredLinkedList<
        V, ////
        Node extends ConnectableNode<V, Node> //
        > extends List<V> {

}
