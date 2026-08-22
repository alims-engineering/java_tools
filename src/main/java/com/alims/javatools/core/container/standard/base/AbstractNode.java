import java.util.Objects;
import com.alims.javatools.core.container.standard.interfaces.Node;

public abstract class AbstractNode<V> implements Node<V> {

    private final V value;

    protected AbstractNode(V value) {
        this.value = Objects.requireNonNull(value, "value must not be null");
    }

    @Override
    public V getValue() {
        return value;
    }
}