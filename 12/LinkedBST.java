package week12;

import java.util.Scanner;

import static week12.LinkedBST.Direction.*;

/**
 *  A binary tree implementation using links. We assume that the tree
 *  is not to store 'null' elements. In particular if the root node
 *  *is* null then the tree is empty. This can only occur if a tree
 *  is initially constructed with no arguments, or if we remove the
 *  only element from a tree.
 *
 *  @author Michael Albert, Iain Hewson
 */
public class LinkedBST<T extends Comparable<T>> {

    /** The element held at the root of this tree. */
    private T root;

    /** The left subtree of this tree. */
    private LinkedBST<T> left;

    /** The right subtree of this tree. */
    private LinkedBST<T> right;

    /**
     *  Creates a BST with the given value.
     *
     * @param value to store at the root of this LinkedBST.
     */
    public LinkedBST(T value) {
        root = value;
        left = null;
        right = null;
    }
   
    /** 
     *  Creates a new empty BST.
     */
    public LinkedBST() {
        this(null);
    }

    /**
     *  Adds an element to this BST if it isn't already there.
     *
     * @param element an element to be added.
     */
    public void add(T element) {
        if(root == null) {
            root = element;
            return;
        }
        if(root.compareTo(element)==0) {
            return;
        } else if (root.compareTo(element)>0) {
            if(left == null) {
                left = new LinkedBST<T>(element);
            } else {
                left.add(element);
            }
        } else {
            if(right == null) {
                right = new LinkedBST<T>(element);
            } else {
                right.add(element);
            }
        }
    }

    /**
     *  Returns the height of this tree.
     *
     * @return the height of this tree.
     */
   
    // New method
    public int height() {
         if(root==null) {
            return 0;
         }

         int leftD = (left == null) ? 0 : left.height() + 1;
         int rightD = (right == null) ? 0 : right.height() + 1;

         if(leftD > rightD) {
            return leftD;
         } else {
            return rightD;
         }
    }

    // Old method
    // public int height() {
         
    //       return (level()-1<0) ? 0 : level()-1;
    // }

    // private int level() {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftH = (left == null) ? 0 : left.level();
    //     int rightH = (right == null) ? 0 : right.level();
        
    //     if(leftH > rightH) {
    //         return leftH + 1;
    //     } else {
    //         return rightH + 1;
    //     }

    // }

  

    /**
     *  Searches for the given target within this tree.
     *
     * @param target 
     * @return true if target is found, otherwise false.
     */
    public boolean search(T target) {
        if(root == null) {
            return false;
        }
        if(root.compareTo(target) == 0) {
            return true;
        } else {
            boolean leftS = (left == null) ? false : left.search(target);
            if(leftS) {
                return true;
            } else {
                return (right == null) ? false : right.search(target);
            }
        }
    }
   
    /**
     *  Returns the size of this BST.
     *
     * @return the size of this BST.
     */
    public int size() {
        if(root == null) {
            return 0;
        }    

        int leftN = (left == null) ? 0 : left.size();
        int rightN = (right == null) ? 0 : right.size();


        return 1 + leftN + rightN;
       
    }

    /**
     *  Returns how many elements are greater than or equal to the
     *  parameter <code>low</code>.
     *
     * @param low the lower bound to use when counting elements.
     * @return how many elements are greater than or equal to the
     *         parameter <code>low</code>.
     */
    public int sizeAbove(T low) {
        if(root == null) {
            return 0;
        }   
        if(root.compareTo(low)<0) {
            return (right == null) ? 0 : right.sizeAbove(low);
        } else {
            int leftN = (left == null) ? 0 : left.sizeAbove(low);
            int rightN = (right == null) ? 0 : right.size();
            return 1 + leftN + rightN;
        }
    }

    /**
     *  Returns how many elements are less than the parameter
     *  <code>high</code>.
     *
     * @param high the element to compare when counting elements.
     * @return how many elements are less than the parameter
     *         <code>high</code>.
     */
    public int sizeBelow(T high) {
        if(root == null) {
            return 0;
        }

        if(root.compareTo(high) >= 0) {
            return (left == null) ? 0 : left.sizeBelow(high);
        } else {
            int rightN = (right == null) ? 0 : right.sizeBelow(high);
            int leftN = (left == null) ? 0 : left.size();
            return 1 + rightN + leftN;
        }
    }

    
    /**
     *  Returns how many elements are greater than or equal to the
     *  parameter <code>low</code> and less than the parameter
     *  <code>high</code>.
     *
     * @param low the lower bound to use when counting elements.
     * @param high the upper bound to use when counting elements.
     * @return how many elements are between low (inclusive) and
     *         high (exclusive).
     */
    public int sizeBetween(T low, T high) {
        return sizeBelow(high) + sizeAbove(low) - size();    
    }

    /**
     *  Removes the given element from this tree if it is present.
     *
     * @param element the element to remove.
     */
    public void remove(T element) {
        // implement this method from the lectures if you
        // want to do the extension exercises
    }

    /** The direction used when creating a representation of this tree. */
    enum Direction {LEFT, RIGHT, NO};
    
    /**
     *  Recursively generates a representation of this tree.
     *
     * @param curr the current line being generated.
     * @param dir the direction of the last link followed.
     * @param result the representation generated so far.
     * @return a representation of this tree.
     */
    public StringBuilder str(String curr, Direction dir, StringBuilder result) {
        if(right != null) {
            right.str(curr + (dir == LEFT ? "│  " : "   "), RIGHT, result);
        }
        if (root != null) {
            result.append(curr + (dir == RIGHT ? "┌─ " :
                                  dir == LEFT ? "└─ " : "  ") + root + "\n");
        }
        if(left != null) {
            left.str(curr +  (dir == RIGHT ? "│  " : "   "), LEFT, result);
        }
        return result;
    }

    @Override
    public String toString() {
        return str("", NO, new StringBuilder()).toString();
    }

    /**
     *  Entry point of program (used for testing).
     *  Valid commands are:
     *  <pre>
     *  a (add) item(s)             - calls add with each item
     *  f (find) item               - calls search with item
     *  p (print)                   - calls toString
     *  h (height)                  - calls height
     *  s (size)                    - calls size
     *  sa (sizeabove) low          - calls sizeAbove(low)
     *  sb (sizebelow) high         - calls sizeBelow(high)
     *  si (sizeinbetween) low high - calls sizeBetween(low,high)
     *  </pre>
     *  Return values of methods are printed to stdout.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        LinkedBST<String> tree = new LinkedBST<>();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            if (line.hasNext()) {
                String command = line.next();
                switch (command) {
                    case "a": case "add":
                        while (line.hasNext()) {
                            tree.add(line.next());
                        }
                        break;
                    case "f": case "find":
                        if (line.hasNext()) {
                            System.out.println(tree.search(line.next()));
                        }
                        break;
                    case "p": case "print":
                        System.out.print(tree);
                        break;
                    case "h": case "height":
                        System.out.println(tree.height());
                        break;
                    case "s": case "size":
                        System.out.println(tree.size());
                        break;
                    case "sa": case "sizeabove":
                        if (line.hasNext()) {
                            String low = line.next();
                            System.out.println(tree.sizeAbove(low));
                        }
                        break;
                    case "sb": case "sizebelow":
                        if (line.hasNext()) {
                            System.out.println(tree.sizeBelow(line.next()));
                        }
                        break;
                    case "si": case "sizeinbetween":
                        if (line.hasNext()) {
                            String low = line.next();
                            if (line.hasNext()) {
                                System.out.println(tree.sizeBetween
                                                   (low, line.next()));
                            }
                        }
                        break;
                    default:
                        System.err.println("Unknown command: " + command);
                }
            }
        }
    }

}
