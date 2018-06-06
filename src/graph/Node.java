package graph;
import java.util.ArrayList;

public class Node {

	private String name;
	private ArrayList<Node> adjacent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Node> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(ArrayList<Node> adjacent) {
		this.adjacent = adjacent;
	}

}
