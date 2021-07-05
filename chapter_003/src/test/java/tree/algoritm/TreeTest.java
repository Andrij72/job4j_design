package tree.algoritm;

import org.junit.Test;

public class TreeTest {

    @Test
    public void search() {

        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);

        Tree.search(4, root);
    }
}