import java.awt.Dimension;
import java.util.ArrayList;

abstract class Bird extends Entity {
	protected short flyingTime;
	protected int eggLeft;
	protected ArrayList<Egg> eggs;
	protected boolean isFlying = false;
	private long launchTime;
	protected boolean isMoving;
	private double time;
	private double angle;
	protected Dimension frameSize;
	private double accelX;
	protected int startLocationX;
	protected int startLocationY;
	private double accelY;
	
	public Bird() {
		isMoving = false;
		time = 0.1;
		angle = 45;
		accelX = 0;
		startLocationX = 40;
		startLocationY = 400;
		accelY = 9.81;
	}
	public int getEggLeft() {
		return eggLeft;
	}
	
	public void setEggLeft(int i) {
		this.eggLeft = i;
	}
	
	public abstract void volStationaire();
	
	public boolean isFlying() {
		return isFlying;
	}
	
    public void move() {
    	if(isMoving)
    	{
	    	position.setLocation(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX,0.5*accelY*time*time-Math.sin(angle)*speed*time+startLocationY);
	    	time+=0.1;
	    	if (position.getY() > (int) frameSize.getHeight() || position.getX() > (int) frameSize.getWidth())
				visible = false;
    	}
    	if(isFlying && (System.currentTimeMillis() - launchTime) > 10000) {
    		visible = false;
    	}
    }
    
    public void launch(){
    	isMoving = true;
    	isFlying = true;
    	launchTime = System.currentTimeMillis();
    }
    
	public void moveRight() {
		//position.setLocation(position.getX() + speed, position.getY());
		accelX+=0.1;
    }
    
    public void moveLeft() {
    	//position.setLocation(position.getX() - speed, position.getY());
    	accelX-=0.1;
    }
    
	public abstract void moveUp();
	public abstract void moveDown();
	
	public abstract void reload();
}
