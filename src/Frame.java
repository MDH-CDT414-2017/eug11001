
//For storing the score of a frame ("a bowling round")
//By: Erik Ullberg (eug11001)

public class Frame {
	//Vars
	private int throw1_I;
	private int throw2_I;

	//Get/Sets
	public int getThrow1() {
		return throw1_I;
	}

	public int getThrow2() {
		return throw2_I;
	}

	//Constructors
	public Frame(int t1, int t2) {
		throw1_I = t1;
		throw2_I = t2;
	}
}
