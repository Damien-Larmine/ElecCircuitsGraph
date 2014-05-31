public class CompXOR extends Component {

	public CompXOR(String name) {
		super(name);
	}

	public boolean getOut() {
		if (this.getInA() == this.getInB()) {
			return false;
		} else {
			return true;
		}
	}

}
