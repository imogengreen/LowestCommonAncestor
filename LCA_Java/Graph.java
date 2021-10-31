import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Graph {
    int V; //number of vertices in the graph
    List<Integer> adjacencyList[]; //maintain adjacency lists to represent the graph

    @SuppressWarnings("unchecked")
    /**
     * Building our graph.
     * @param V: this is the number of vertices in the graph
     */
	public Graph(int V) {
        this.V = V;        
		List<Integer> adjacencyList[] = new LinkedList[V]; //singly linked list of adjacent vertices
        this.adjacencyList = adjacencyList;

        for (int i=0; i<V; i++) {
        	adjacencyList[i] = new LinkedList<>(); //create a new linked list for each vertex in the graph
        }
    }
    /**
     * Here we want to add an edge between vertices v and u to the representation of the graph
     * @param v: this is the "source" vertex
     * @param u: this is the "destination" vertex
     */
    public void addEdge(int v, int u) {
        this.adjacencyList[v].add(u);
    }
    
    /**
     * Finding the depth at which our desired vertex is located.
     * @param v: the vertex we want to arrive at
     * @param parentVertices: the ancestors of the vertex we want to arrive at
     * @return: an integer array containing the depths of the vertices in the graph
     */
    private int[] findDepths (int v, List<Integer> parentVertices[]) {
        int[] allDepths = new int[V];
        for (int i=0; i<V; i++) {
            if ( i == v ) {
                allDepths[i] = -1;
            } else {
                allDepths[i] = 0;
            }
        }
        allDepths = findDepthsRecursive(v,allDepths,parentVertices,1);
        return allDepths;
    }
    
    /**
     * We keep calling this recursive function and looping through the parentVertices List, incrementing depth
     * 		by 1 each time until we reach the end of the list. When finished, we return an integer array containing all
     * 		the depths.
     * @param v: the vertex we want to arrive at
     * @param allDepths: array initialised to 0 and -1 and passed to the recursive call
     * @param parentVertices: the ancestors of the vertex that we want to arrive at
     * @param depth: the depth or "number of steps" it takes to arrive at the vertex
     * @return: an integer array containing the depths of the vertices in the graph
     */
    private int[] findDepthsRecursive(int v, int[] allDepths, List<Integer> parentVertices[], int depth) {
        Iterator<Integer> list = parentVertices[v].listIterator();
        while (list.hasNext())
        {
            int n = list.next();
            if (allDepths[n]>depth || allDepths[n]==0) {
                allDepths[n] = depth;
            }
            if (!parentVertices[n].isEmpty()) {
                allDepths = findDepthsRecursive(n,allDepths,parentVertices,depth+1);
            }
        }
        return allDepths;
    }
    
    /**
     * We use the depths of v and u in calculating the Lowest Common Ancestor
     * @param vDepth: "steps" to arrive at vertex v
     * @param uDepth: "steps" to arrive at vertex u
     * @return: integer array containing the LCAs of v and u
     */
     int[] calculateLCAs (int[] vDepth, int[] uDepth) {
     	int[] LCAs = null;
     	int[] totalDepth = new int[V];
         int depthOfLCA = V+1;
         for (int i=0; i<V; i++) {
             if (vDepth[i] == 0 || uDepth[i] == 0) {
                 totalDepth[i] = -1;
             } else if (vDepth[i] == -1) {
                 totalDepth[i] = uDepth[i];
             } else if (uDepth[i] == -1) {
                 totalDepth[i] = vDepth[i];
             } else {
                 totalDepth[i] = vDepth[i] + uDepth[i];
             }
             if (totalDepth[i] < depthOfLCA && totalDepth[i] != -1) {
                 LCAs = new int[1];
                 LCAs[0] = i;
                 depthOfLCA = totalDepth[i];
             } else if (totalDepth[i] == depthOfLCA) {
                 LCAs = Arrays.copyOf(LCAs, LCAs.length + 1);
                 LCAs[LCAs.length - 1] = i;
             }
         }
         return LCAs;
     }
     
    /**
     * This function finds the Lowest Common Ancestor between two vertices (or nodes).
     * An important feature here is that we take the adjacency list and reverse it, making it the parent list.
     * This gives us a list where the first element is closest to the vertex we are interested in, and moves further out
     * the further through the list we go.
     * @param v: the first vertex we are interested in.
     * @param u: the second vertex we are interested in.
     * @return: integer array to find the LCA between the two vertices
     */
	@SuppressWarnings("unchecked")
	public int[] findLowestCA(int v, int u) {
        if (v<V && u<V) {	//must meet this condition to be contained in the graph
            List<Integer> parentVertices[] = new LinkedList[V];
            for (int i=0; i<V; i++) {
                parentVertices[i] = new LinkedList<>();
            }
            for (int j=0; j<V; j++) {
                Iterator<Integer> tmpList = adjacencyList[j].listIterator();
                while (tmpList.hasNext())
                {
                    int k = tmpList.next();
                    parentVertices[k].add(j);
                }
            }
            int[] vDepth = findDepths(v, parentVertices);
            int[] uDepth = findDepths(u, parentVertices);
            int LowestCAs[] = calculateLCAs(vDepth,uDepth);
            return LowestCAs;
        }
        return null;
    }
} 