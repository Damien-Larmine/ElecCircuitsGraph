public class Component {

	private String name;
	private boolean inA;
	private boolean inB;

	public Component(String name) {
		this.name = name;
		
		this.inA = false;
		this.inB = false;
	}

	public String getName() {
		return this.name;
	}

	public boolean getInA() {
		return this.inA;
	}

	public boolean getInB() {
		return this.inB;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInA(boolean a) {
		this.inA = a;
	}

	public void setInB(boolean b) {
		this.inB = b;
	}
}
