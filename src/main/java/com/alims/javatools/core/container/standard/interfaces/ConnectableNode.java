package com.alims.javatools.core.container.standard.interfaces;

public interface ConnectableNode<V> extends Node<V> {

    boolean connect(Node<V> other);

    Node<V> append(V value);

    Node<V> disconnect(Node<V> other);

    boolean isConnectionEmpty();

    boolean containConnection(Node<V> other);

    int connectionCount();

}
