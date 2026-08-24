package com.alims.javatools.container.node.interfaces;

public interface ConnectableNode<
        V, SELF extends ConnectableNode<V, SELF>> extends Node<V, SELF> {

    boolean connect(SELF other);

    SELF append(V value);

    SELF disconnect(SELF other);

    boolean isConnectionEmpty();

    boolean containConnection(SELF node);

    int connectionCount();

}
