package shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import constants.GConstants.EDrawingType;

abstract public class GShape {
	protected Shape shape;
	private EDrawingType eDrawingType;
	public EDrawingType geteDrawingType() {	return eDrawingType;}
	public GShape(EDrawingType eDrawingType){
		this.eDrawingType = eDrawingType;
	}
	protected Anchors anchors;	
	public Anchors getAnchors() {return anchors;}
	public void setAnchors(Anchors anchors) {this.anchors = anchors;}
	public Shape getShape(){	return this.shape;	}
	abstract public void draw(Graphics2D g2D);
	abstract public void initDrawing(int x, int y, Graphics2D g2D);
	abstract public void keepDrawing(int x, int y, Graphics2D g2D);
	abstract public void continueDrawing(int x, int y, Graphics2D g2D);
	abstract public void finishDrawing(int x, int y, Graphics2D g2D);
	
	public GShape clone() {
		try {
			return this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean on(int x, int y) {
		return shape.contains(x, y);
	}
	public void AnchorDraw(Graphics2D g2D, Rectangle rectangle){
		Anchors anchors = new Anchors();if(rectangle.equals(null)){
			System.out.println("ww");
		}
		anchors.draw(g2D, rectangle);
	}
}
