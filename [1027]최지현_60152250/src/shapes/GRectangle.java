package shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import constants.GConstants.EDrawingType;

public class GRectangle extends GShape {
	private Rectangle rectangle;
	public GRectangle() {
		super(EDrawingType.TP);
		rectangle = new Rectangle();
		this.shape = this.rectangle;
		this.rectangle.setLocation(0, 0);
		this.rectangle.setSize(0, 0);
	}
	public Rectangle getShape(){	return rectangle;	}
	@Override
	public void initDrawing(int x, int y, Graphics2D g2D) {
		this.rectangle.setBounds(x, y, 0, 0);
	}
	@Override
	public void keepDrawing(int x, int y, Graphics2D g2D) {
		this.draw(g2D);
		this.rectangle.setSize(x - this.rectangle.x, y - this.rectangle.y);
		this.draw(g2D);
	}
	public void continueDrawing(int x, int y, Graphics2D g2D) {
	}
	@Override
	public void finishDrawing(int x, int y, Graphics2D g2D) {
		this.compareSize(g2D);
	}
	@Override
	public void draw(Graphics2D g2D) {
		if( this.rectangle.width < 0 && this.rectangle.height < 0){
			g2D.drawRect(this.rectangle.width+this.rectangle.x, this.rectangle.y
					+this.rectangle.height, -this.rectangle.width, -this.rectangle.height);
		}else if(this.rectangle.width < 0){
			g2D.drawRect(this.rectangle.width+this.rectangle.x, this.rectangle.y,
					-this.rectangle.width, this.rectangle.height);			
		}else if(this.rectangle.height < 0){		
			g2D.drawRect(this.rectangle.x, this.rectangle.y+this.rectangle.height, 
					this.rectangle.width, -this.rectangle.height);
		}
		g2D.draw(rectangle);
	}
	public void compareSize(Graphics2D g2D){
		if( this.rectangle.width < 0 && this.rectangle.height < 0){
			this.rectangle.setBounds(rectangle.width+rectangle.x, rectangle.y
					+rectangle.height, -rectangle.width, -rectangle.height);
		}else if(this.rectangle.width < 0){
			this.rectangle.setBounds(rectangle.width+rectangle.x, rectangle.y,
					-rectangle.width, rectangle.height);			
		}else if(this.rectangle.height < 0){		
			this.rectangle.setBounds(rectangle.x, rectangle.y+rectangle.height, 
					rectangle.width, -rectangle.height);
		}
	}
	public void AnchorDraw(Graphics2D g2D, Rectangle rectangle){
		Anchors anchors = new Anchors();
		if(rectangle.equals(null)){
			System.out.println("ww");
		}
		anchors.draw(g2D, rectangle);
	}
}