import static org.junit.Assert.*;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testFindLowestCA() {
		Graph emptyTestGraph = new Graph(0);
		assertNull("Testing on an empty graph", emptyTestGraph.findLowestCA(2,4));
		
		/*Now, we will build a new graph for testing
		 * 
		 * 			0
		 * 			  \
		 * 				1
		 * 			  /
		 * 		    2
		 * 			  \
		 * 				3		
		 */
		
		Graph myGraph1 = new Graph(4);
		myGraph1.addEdge(0, 1);
		myGraph1.addEdge(1, 2);
		myGraph1.addEdge(2, 3);
		
		assertNull("Testing invalid input for vertex 1", myGraph1.findLowestCA(7, 2));
		assertNull("Testing invalid input for vertex 2", myGraph1.findLowestCA(1, 9));
		assertNull("Testing invalid input for both vertices", myGraph1.findLowestCA(10, 11));
		
		int[] testLCA = new int[1];
		testLCA[0] = 0;
		int[] tmp = null;
		
		tmp = myGraph1.findLowestCA(0, 1);
		assertEquals("1 has one parent", testLCA[0], tmp[0]);
		tmp = myGraph1.findLowestCA(2, 0);
		assertEquals("2 has two parents", testLCA[0], tmp[0]);
		tmp = myGraph1.findLowestCA(3, 0);
		assertEquals("3 has three parents", testLCA[0], tmp[0]);
		
		/*Now we will build and test the graph below
		 * 			
		 * 				0
		 * 			  /	  \
		 * 		     1		2
		 * 		    /
		 *     	   3
		 */
		
		Graph myGraph2 = new Graph(4);
		myGraph2.addEdge(0, 1);
		myGraph2.addEdge(0, 2);
		myGraph2.addEdge(1, 3);
		
		tmp = myGraph2.findLowestCA(3,0);
		assertEquals("Our LCA is 0", testLCA[0], tmp[0]);
		
		tmp = myGraph2.findLowestCA(2, 3);
		assertEquals("Our LCA is 0", testLCA[0], tmp[0]);
		
		tmp = myGraph2.findLowestCA(0,3);
		assertEquals("Our LCA is 0", testLCA[0], tmp[0]);
		
		tmp = myGraph2.findLowestCA(3, 2);
		assertEquals("Our LCA is 0", testLCA[0], tmp[0]);
		
		/*Building a graph that has 2 LCAs
		 * 
		 * 				0
		 * 			  /	  \
		 *           1     2
		 *          /       \
		 *         3		 4
		 * 		   |\ 	   / |
		 *         |  \  /   |
		 *         |  /  \   |
		 *         | /     \ |
		 * 		   6	     5
		 * 					
		 */
		
		testLCA = new int[] {3,4};
		Graph myGraph3 = new Graph(7);
		myGraph3.addEdge(0, 1);
		myGraph3.addEdge(0, 2);
		myGraph3.addEdge(1, 3);
		myGraph3.addEdge(2, 4);
		myGraph3.addEdge(3, 5);
		myGraph3.addEdge(4, 5);
		myGraph3.addEdge(3, 6);
		myGraph3.addEdge(4, 6);
		
		//There will be two LCAs for 5 and 6. They are 3 and 4
		tmp = myGraph3.findLowestCA(5, 6);
		assertEquals("The two LCAs for 5 and 6 are 3 and 4", testLCA[0], tmp[0]);
		assertEquals("The two LCAs for 5 and 6 are 3 and 4", testLCA[1], tmp[1]);
		
		
		/*Building a graph that has more than 2 LCAs
		 * 
		 * 				0
		 * 			  /	  \
		 *           1     2
		 *          /       \
		 *         3----7    4 
		 * 		   |\ 	|  / |
		 *         |  \ |/   |
		 *         |  /  \   |
		 *         | /     \ |
		 * 		   6	     5	
		 * 
		 */
		testLCA = new int[] {3,4,7};
		Graph myGraph4 = new Graph(8);
		myGraph4.addEdge(0, 1);
		myGraph4.addEdge(0, 2);
		myGraph4.addEdge(1, 3);
		myGraph4.addEdge(2, 4);
		myGraph4.addEdge(3, 5);
		myGraph4.addEdge(4, 5);
		myGraph4.addEdge(3, 6);
		myGraph4.addEdge(4, 6);
		myGraph4.addEdge(3, 7);
		myGraph4.addEdge(7, 6);
		myGraph4.addEdge(7, 5);
		//There will be three LCAs for 5 and 6. They are 3, 4 and 7
		tmp = myGraph4.findLowestCA(5, 6);
		assertEquals("The three LCAs for 5 and 6 are 3, 4 and 7", testLCA[0], tmp[0]);
		assertEquals("The three LCAs for 5 and 6 are 3, 4 and 7", testLCA[1], tmp[1]);
		assertEquals("The three LCAs for 5 and 6 are 3, 4 and 7", testLCA[2], tmp[2]);
	}

}
