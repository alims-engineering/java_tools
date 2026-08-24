package com.alims.javatools.container.node.base;

import com.alims.javatools.container.node.interfaces.MultiConnectableNode;

import java.util.Collection;
import java.util.Objects;

public abstract class AbstractMultiConnectionNode<
        V, // Value
        Self extends MultiConnectableNode<V, Self, C>, // This Class it Self
        C extends Collection<Self>            ////
        > 
        extends AbstractNode<V, Self>
        implements MultiConnectableNode<V, Self, C> {

    private final C connections;

    // ====================================
    // Constructor
    // ====================================
    protected AbstractMultiConnectionNode(C connections) {
        super();

        this.connections = Objects.requireNonNull(
                connections,
                "connections must not be null"
        );
    }

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
    public boolean connect(Self other) {
        if (other == null || connections.contains(other)) {
            return false;
        }

        return connections.add(other);
    }

    @Override
    public Self append(V value) {
        Self node = createSelf(value);

        if (!connect(node)) {
            return null;
        }

        return node;
    }

    @Override
    public Self disconnect(Self other) {
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
    public boolean containConnection(Self other) {
        return connections.contains(other);
    }

    @Override
    public int connectionCount() {
        return connections.size();
    }
}
