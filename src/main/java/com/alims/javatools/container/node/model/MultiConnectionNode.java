package com.alims.javatools.container.node.model;

import com.alims.javatools.container.node.base.AbstractMultiConnectionNode;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class MultiConnectionNode<
        V, C extends Collection<MultiConnectionNode<V, C>>>
        extends AbstractMultiConnectionNode<
                V, MultiConnectionNode<V, C>, C> {

    private final Supplier<C> connectionFactory;

    // ====================================
    // Constructor
    // ====================================
    public MultiConnectionNode(
            Supplier<C> connectionFactory
    ) {
        super(createConnections(connectionFactory));

        this.connectionFactory = requireConnectionFactory(
                connectionFactory
        );
    }

    public MultiConnectionNode(
            V value,
            Supplier<C> connectionFactory
    ) {
        super(
                value,
                createConnections(connectionFactory)
        );

        this.connectionFactory = requireConnectionFactory(
                connectionFactory
        );
    }

    // ====================================
    // Method - Override
    // ====================================
    @Override
    public MultiConnectionNode<V, C> createSelf(
            V value
    ) {
        return new MultiConnectionNode<>(
                value,
                connectionFactory
        );
    }

    // ====================================
    // Helper
    // ====================================
    private static <
            V, C extends Collection<MultiConnectionNode<V, C>>>
            C createConnections(
                    Supplier<C> connectionFactory
            ) {

        return Objects.requireNonNull(
                requireConnectionFactory(
                        connectionFactory
                ).get(),
                "connectionFactory must not return null"
        );
    }

    private static <C> Supplier<C> requireConnectionFactory(
            Supplier<C> connectionFactory
    ) {
        return Objects.requireNonNull(
                connectionFactory,
                "connectionFactory must not be null"
        );
    }
}
