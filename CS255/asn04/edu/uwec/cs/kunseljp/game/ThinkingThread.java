package edu.uwec.cs.kunseljp.game;

public class ThinkingThread implements Runnable {
	
	GamePlayer gp = null;
	
	public ThinkingThread(GamePlayer GP){
		this.gp = GP;
	}
	
	public void run(){
		MiniMax m = new MiniMax(this.gp.maxlevel);
		gp.computerDone(m.generateNextMove(gp.BP.board));
	}
}
