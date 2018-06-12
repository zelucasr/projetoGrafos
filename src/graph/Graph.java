package graph;
import java.util.ArrayList;

public class Graph {

	private ArrayList<Edge> edges;
	private ArrayList<Node> nodes;
	private int numNodes;
	
	public Graph(int numNodes){
		this.edges = new ArrayList<Edge>();
		this.nodes = new ArrayList<Node>();
		this.numNodes = numNodes;
		for(int i = 0; i < numNodes; i++){ //Cria nós vazios
			this.nodes.add(new Node(i));
		}
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void addEdge(int source, int target, int capacity, int edgeCost) {
		Edge edge = new Edge(source, target, capacity, edgeCost);
		this.edges.add(edge);
		this.nodes.get(source).getEdgesAdjacent().add(edge);
	}
	
	public Edge getEdge(int source, int target){
		for(Edge e: edges){
			if(source == e.getSource() && target == e.getTarget()){
				return e;
			}
		}
		return null; //implementar
	}

	public int getNumNodes() {
		return numNodes;
	}

	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}

}
