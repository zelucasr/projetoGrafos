package modelProblem;

public class Airplane {

	private Integer size;
	private String model;

	public Airplane(Integer size, String model) {
		this.size = size;
		this.model = model;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
