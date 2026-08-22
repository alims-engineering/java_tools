package com.alims.javatools.core.container.standard.interfaces.node;

import java.util.Collection;

public interface MultiConnectableNode<
        V, 
        C extends Collection<Node<V>>
        >
        extends ConnectableNode<V> 
{
    C getConnections();
}
