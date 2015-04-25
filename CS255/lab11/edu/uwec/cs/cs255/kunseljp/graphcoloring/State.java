package edu.uwec.cs.cs255.kunseljp.graphcoloring;

public interface State {
	public boolean hasMoreChildren();
	public State nextChild();
	public boolean isFeasible();
	public boolean isSolved();
	public int getBound();
}
