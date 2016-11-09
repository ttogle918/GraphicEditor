package shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import constants.GConstants.EDrawingType;

public class GEllipse extends GShape {
	private Ellipse2D ellipse;
	public GEllipse() {
		super(EDrawingType.TP);
		ellipse = new Ellipse2D.Double();
		this.shape = this.ellipse;
		this.ellipse.setFrame(0	, 0, 0, 0);
	}
	public Ellipse2D getShape(){	return ellipse;	}
	@Override
	public void initDrawing(int x, int y, Graphics2D g2D) {
		this.ellipse.setFrame(x, y, 0, 0);
	}
	@Override
	public void keepDrawing(int x, int y, Graphics2D g2D) {
		this.draw(g2D);
		this.ellipse.setFrame(ellipse.getX(), ellipse.getY(), x-ellipse.getX(), y-ellipse.getY());
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
		if( this.ellipse.getWidth() < 0 && this.ellipse.getHeight() < 0){
			g2D.drawOval((int)(ellipse.getWidth()+ellipse.getX()), (int)(this.ellipse.getY()
					+this.ellipse.getHeight()), -(int)this.ellipse.getWidth(), -(int)this.ellipse.getHeight());
		}else if(this.ellipse.getWidth() < 0){
			g2D.drawOval((int)(this.ellipse.getX()+this.ellipse.getWidth()), (int)this.ellipse.getY(),
					-(int)this.ellipse.getWidth(), (int)this.ellipse.getHeight());
		}else if(this.ellipse.getHeight() < 0){		
			g2D.drawOval((int)(this.ellipse.getX()), (int)(this.ellipse.getY()+this.ellipse.getHeight()),
					(int)this.ellipse.getWidth(), -(int)this.ellipse.getHeight());
		}
		g2D.draw(ellipse);
	}
	public void compareSize(Graphics2D g2D){
		if( this.ellipse.getWidth() < 0 && this.ellipse.getHeight() < 0){
			this.ellipse.setFrame(ellipse.getX() + ellipse.getWidth(), ellipse.getY()+ellipse.getHeight(), 
					-ellipse.getWidth(), -ellipse.getHeight());	
		}else if(this.ellipse.getWidth() < 0){
			this.ellipse.setFrame(ellipse.getX() + ellipse.getWidth(), ellipse.getY(), 
					-ellipse.getWidth(), ellipse.getHeight());	
		}else if(this.ellipse.getHeight() < 0){		
			this.ellipse.setFrame(ellipse.getX(), ellipse.getY()+ellipse.getHeight(), 
					ellipse.getWidth(), -ellipse.getHeight());	
		}
	}
	public void AnchorDraw(Graphics2D g2D, Rectangle rectangle){
		Anchors anchors = new Anchors();
		anchors.draw(g2D, rectangle);
	}
}