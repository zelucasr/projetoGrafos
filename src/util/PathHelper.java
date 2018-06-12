package util;

public class PathHelper {

	private int cost;
	private int sourceNode;

	public PathHelper(int cost, int sourceNode) {
		super();
		this.cost = cost;
		this.sourceNode = sourceNode;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSourceNode() {
		return sourceNode;
	}

	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}

}
