public class CompAND extends Component {

	public CompAND(String name) {
		super(name);
	}

	public boolean getOut() {
		return (this.getInA() & this.getInB());
	}

}
