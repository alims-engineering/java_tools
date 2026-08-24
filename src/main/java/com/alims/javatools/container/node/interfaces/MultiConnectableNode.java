package com.alims.javatools.container.node.interfaces;

import java.util.Collection;

public interface MultiConnectableNode<
        V, ////
        Self extends MultiConnectableNode<V, Self, C>, ////
        C extends Collection<Self> ////
        > //
        extends ConnectableNode<V, Self> {

    C getConnections();
}