// Imogen Green 
// Student number: 17326096
// CSU33012 coursework MT 2021/22
// Test cases for LCABinaryTree
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LCABinaryTreeTest {

  //By testing findLCA for different types of trees, we end up testing all methods in the codebase.
  @Test
  public void findLCATest() {
    // We want to test behaviour on a tree that contains no elements
    LCABinaryTree testBT = new LCABinaryTree();
    testBT.root = null;
    assertEquals(-1, testBT.findLCA(2, 3));

    /*
     * Now, we want to add to the BT to have a tree that looks like this: 
      *      1 
      *    /   \ 
      *   2     3
     */
    testBT.root = new Node(1);
    testBT.root.left = new Node(2);
    testBT.root.right = new Node(3);
    assertEquals(1, testBT.findLCA(2, 3));

    /*
     * Extending our tree and adding more nodes so that it looks like this: 
     *        1 
     *      /   \ 
     *     2     3 
     *    / \   / \ 
     *   4   5 6   7
     * 
     * When searching for the LCA of 3 and 7, we should return 3.
     */
    testBT.root.left.left = new Node(4);
    testBT.root.left.right = new Node(5);
    testBT.root.right.left = new Node(6);
    testBT.root.right.right = new Node(7);
    assertEquals(3, testBT.findLCA(3, 7));
  }
}
