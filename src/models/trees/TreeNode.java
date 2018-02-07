package models.trees;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class TreeNode {

    private HashMap<TreeNode, Double> parents, children;
    private Object content;
    private int depth;

    public TreeNode(int depth, double cost, Object content) {
        this.depth = depth;
        this.parents = new HashMap<>();
        this.children = new HashMap<>();
        this.content = content;
    }

    public HashMap<TreeNode, Double> getParents() {
        return parents;
    }

    public void addParent(TreeNode parent, double cost){
        parents.put(parent, cost);
    }

    public void removeParent(TreeNode parent){
        parents.remove(parent);
    }

    public HashMap<TreeNode, Double> getChildren() {
        return children;
    }

    public void removeChild(TreeNode child){
        children.remove(child);
    }

    public void addChild(TreeNode child, double cost){
        children.put(child,cost);
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
