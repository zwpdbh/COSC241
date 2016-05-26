package week12;

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
        if(rootValue == null) {
            return 0;
        }
        int count = 1;
        for(Tree<T> t: children) {
            count += t.size();    
        }

        return count;
    }
    
    public int maxDegree() {
        int max = children.size();
        for(Tree<T> t: children) {
            if(max < t.maxDegree()) {
                max = t.maxDegree();
            }
        }

        return max;
    }
    
    public void add(Tree<T> child) {
        // implement this method
       children.add(child); 
    }

    public Tree<T> find(T value) {
        if(rootValue == null) {
            return null;
        }
        if(rootValue.equals(value)) {
            return this;
        }
        for(Tree<T> t: children) {
            Tree<T> match = t.find(value);
            if(match != null) {
                return match;
            }
        }
        return null;
    }
    
    public List<T> postOrder() {
        ArrayList<T> nodes = new ArrayList<T>();
        for(Tree<T> t: children) {
            nodes.addAll(t.postOrder())
        }
       nodes.add(rootValue);

       return nodes;
    }
    
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }
    
    public String toIndentedString() {
        
        return indentString(1) + "\n";
    }

    public String indentString(int depth) {
        String str = (rootValue == null) ? "" : rootValue.toString();
        for(Tree<T> t: children) {
            str += "\n" + blank(depth) + t.indentString(depth+1);
        }
        return str;
    }

    private String blank(int n) 
    {
        String s = "";
        for(int i=1; i<=n; i++) {
            s+="  ";
        }
        return s;
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
