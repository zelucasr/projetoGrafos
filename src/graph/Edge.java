package graph;

public class Edge {

	private int source;
	private int target;
	private Integer cost;
	private int maxCapacity;
	private int actualCapacity;

	public Edge(int source, int target, Integer maxCapacity, Integer cost) {
		this.setSource(source);
		this.setTarget(target);
		this.cost = cost;
		this.actualCapacity = 0;
		this.maxCapacity = maxCapacity;
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

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getActualCapacity() {
		return actualCapacity;
	}

	public void setActualCapacity(int actualCapacity) {
		this.actualCapacity = actualCapacity;
	}

}
