package models.trees;

import models.strategies.Strategy;

/**
 * Created by Florian on 06/02/2018.
 */
public class Tree {

    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

}
