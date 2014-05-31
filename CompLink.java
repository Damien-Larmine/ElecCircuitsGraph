public class CompLink extends Component{

  private String comp1;
  private String comp2;
  private int in1;
  private int in2;

  public CompLink(String name,String comp1,int in1,String comp2, int in2) {
	super(name);

	this.comp1 = comp1;
	this.comp2 = comp2;
	this.in1 = in1;
	this.in2 = in2;
  }

  public String getComp1(){
	return this.comp1;
  }

  public String getComp2(){
	return this.comp2;
  }

  public int getIn1(){
	return this.in1;
  }

  public int getIn2(){
	return this.in2;
  }
}




