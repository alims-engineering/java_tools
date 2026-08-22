package com.alims.javatools.core.container.standard.interfaces;

public interface SingleConnectableNode<V> extends ConnectableNode<V> {

    public abstract Node<V> getConnection();

}
