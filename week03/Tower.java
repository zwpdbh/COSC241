package week03;

/**
 *  A recursive representation of a tower of blocks.
 *
 * @author Michael Albert
 */
public class Tower{

    /** The top block. */
    private char top;
    
    /** The rest of the tower. */
    private Tower rest;

    /**
     * Creates a new empty Tower.
     */
    public Tower() {
        this.top = ' ';
        this.rest = null;
    }
    
    /**
     *  External classes can only create empty towers and manipulate
     *  them using public methods, because this constructor is
     *  private.
     * @param top the top block in this tower
     * @param rest the rest of the tower
     */
    private Tower(char top, Tower rest) {
        this.top = top;
        this.rest = rest;
    }

    /**
     *  Returns true if this tower is empty, otherwise false.  Empty
     *  towers are represented with the top block being a space
     *  character.
     * @return whether the tower is empty or not.
     */
    public boolean isEmpty() {

        return top == ' ';
    }
        
    /**
     *  Creates a new tower by adding the given block to the top of
     *  this tower.
     * @param block a block to add to the top of this tower.
     * @return a new tower created by adding a block to the top of
     * this tower.
     */
    public Tower add(char block) {
        return new Tower(block, this);
    }
    
    /**public method to return the height of tower.
     * @param 
     * @return int , represent the height of the tower
     */
    public int height() {
        // int sum = 0;
        // Tower currentNode = this;
        // while (currentNode.rest != null) {
        //     sum++;
        //     currentNode = currentNode.rest;
        // }
        
        // return sum;
        if (this.isEmpty()) {
        	return 0;
        } else {
        	return 1 + this.rest.height();
        }
    }
    
    /**Public method, count the number of specific blocks in the tower.
     * @param c , the char represent the block. 
     * @return int , represent the number of specific blocks in the tower
     */
    public int count(char c) {
        // int sum = 0;
        // Tower currentNode = this;
        // while (currentNode.rest != null) {
        //     if (currentNode.top == c) {
        //         sum ++;
        //     }
        //     currentNode = currentNode.rest;
        // }
        // return sum;
        if (this.isEmpty()) {
        	return 0;
        } else if (this.rest!=null && this.top==c) {
        	return 1+this.rest.count(c);
        } else {
        	return 0 + this.rest.count(c);
        }
    }
    /**My self added method for debug.
     * @return a string to represent the tower.
     * */
    public String toString() {
        String str = "";
        Tower currentNode = this;
        while (currentNode.rest != null) {
            str += currentNode.top;
            currentNode = currentNode.rest;
        }
        
        return str;
    }
    
    /**Method to take the some nodes, and get rid of the rest.
     *@param k , the number of nodes want to take.
     *keep the first to k th Node, get rid of the rest.
     */
    public void take(int k) {
        int i = 1;
        Tower currentNode = this;
        while (i <= k && currentNode.rest != null) {
            currentNode = currentNode.rest;
            i++;
        }
        currentNode.rest = null;
    }

    /** removes the top k blocks.
     * @param k remove(int k)that removes the top k blocks
     */
    public void remove(int k) {
        int i = 1;
        Tower currentNode = this;
        while (i <= k && currentNode.rest != null) {
            currentNode = currentNode.rest;
            i++;
        }

        this.top = currentNode.top;
        this.rest = currentNode.rest;
    }

    /**
     * set the tower using string.
     * @param towerString , my setter method to set the block of tower using a
     * string
     * */
    public void setTower(String towerString) {
        Tower newTower = new Tower();
        for (int i = towerString.length()-1; i>=0; i--) {
            newTower = newTower.add(towerString.charAt(i));
        }

        this.top = newTower.top;
        this.rest = newTower.rest ;
    }
}
