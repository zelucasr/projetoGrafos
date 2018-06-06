package graph;
import java.util.ArrayList;

public class Graph {

	private ArrayList<Edge> edges;
	
	public Graph(){
		this.edges = new ArrayList<Edge>();
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

}
