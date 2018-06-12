package graph;

public class Edge {

	private int source;
	private int target;
	private Integer cost;

	public Edge(int source, int target, Integer cost) {
		super();
		this.setSource(source);
		this.setTarget(target);
		this.cost = cost;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

}
