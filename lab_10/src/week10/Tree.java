/**
 * Created by zw on 5/11/16.
 */
package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 *
 * @author Michael Albert
 * @param <T> The type of values stored in the tree.
 */
public class Tree<T> {

    private T rootValue;
    private List<Tree<T>> children;

    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    public int size() {
        int size = 1;
        if (this.children.size() == 0) {
            return 1;
        } else {
            for (int i=0; i<this.children.size(); i++) {
                size += this.children.get(i).size();
            }
            return size;
        }
    }

    public int maxDegree() {
        // implement this method
        int degree = this.children.size();
        for (int i=0;i<this.children.size();i++) {
            if (this.children.get(i).maxDegree() > degree) {
                degree = this.children.get(i).maxDegree();
            }
        }

        return degree;
    }


    public void add(Tree<T> child) {
        this.children.add(child);
    }

    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    public List<T> postOrder() {
        ArrayList<T> nodes = new ArrayList<>();
        if (this.children.size()==0) {
            nodes.add(this.rootValue);
        } else {
            for (int i=0;i<this.children.size();i++) {
                nodes.addAll(this.children.get(i).postOrder());
            }
            nodes.add(this.rootValue);
        }
        return nodes;
    }


    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

    public String toIndentedString() {
        return "Not implemented yet!";
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
