public class CompOR extends Component {

	public CompOR(String name) {
		super(name);
	}

	public boolean getOut() {
		return (this.getInA() | this.getInB());
	}

}
