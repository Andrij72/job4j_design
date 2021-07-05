package tree.algoritm;

import org.slf4j.Logger;

import java.util.*;

public class Tree<T> {
    private static Logger logger;
    private T value;
    private List<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
    }

    private T getValue() {
        return value;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public static <T> Tree<T> of(T value) {
        return new Tree<T>(value);
    }

    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    public static <T> Optional<Tree<T>> search(T value, Tree<T> start) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
            logger.info("Visited node with value: {}", Optional.of(currentNode.getValue()));
            if (!Objects.equals(currentNode.getValue(), value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

}
