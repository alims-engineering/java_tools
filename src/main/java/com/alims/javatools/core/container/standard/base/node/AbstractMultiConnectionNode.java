package com.alims.javatools.core.container.standard.base.node;

import com.alims.javatools.core.container.standard.interfaces.node.MultiConnectableNode;
import com.alims.javatools.core.container.standard.interfaces.node.Node;

import java.util.Collection;
import java.util.Objects;

public abstract class AbstractMultiConnectionNode<
        V, C extends Collection<Node<V>>> extends AbstractNode<V>
        implements MultiConnectableNode<V, C> {

    private final C connections;

    // ====================================
    // Constructor
    // ====================================
    protected AbstractMultiConnectionNode(
            V value,
            C connections
    ) {
        super(value);

        this.connections = Objects.requireNonNull(
                connections,
                "connections must not be null"
        );
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public C getConnections() {
        return connections;
    }

    @Override
    public boolean connect(Node<V> other) {
        if (other == null || connections.contains(other)) {
            return false;
        }

        return connections.add(other);
    }

    @Override
    public Node<V> append(V element) {
        Node<V> node = createSelf(element);

        if (!connect(node)) {
            return null;
        }

        return node;
    }

    @Override
    public Node<V> disconnect(Node<V> other) {
        if (other == null || !connections.remove(other)) {
            return null;
        }

        return other;
    }

    @Override
    public boolean isConnectionEmpty() {
        return connections.isEmpty();
    }

    @Override
    public boolean containConnection(Node<V> other) {
        return connections.contains(other);
    }

    @Override
    public int connectionCount() {
        return connections.size();
    }
}
