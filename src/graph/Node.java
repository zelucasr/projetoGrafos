package graph;
import java.util.ArrayList;

public class Node {

	private int id;
	private String name;
	private ArrayList<Edge> edgesAdjacent;
	
	public Node(int id){
		this.id = id;
		this.edgesAdjacent = new ArrayList<Edge>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Edge> getEdgesAdjacent() {
		return edgesAdjacent;
	}

	public void setEdgesAdjacent(ArrayList<Edge> edgesAdjacent) {
		this.edgesAdjacent = edgesAdjacent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
