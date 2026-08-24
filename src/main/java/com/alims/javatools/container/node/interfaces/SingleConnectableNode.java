package com.alims.javatools.container.node.interfaces;

public interface SingleConnectableNode<
        V,
        SELF extends SingleConnectableNode<V, SELF>
        > extends ConnectableNode<V, SELF> {

    SELF getConnection();

}