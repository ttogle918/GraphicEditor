package shapes;

import java.awt.Graphics2D;

import constants.GConstants.EDrawingType;

public class GEllipse extends GShape {
	private int x, y, w, h;
	public GEllipse() {
		super(EDrawingType.TP);
		this.x = 0;
		this.y = 0;
		this.w = 0;
		this.h = 0;
	}
	@Override
	public void initDrawing(int x, int y, Graphics2D g2D) {
		this.x = x;
		this.y = y;		
		this.w = 0;
		this.h = 0;
	}
	@Override
	public void keepDrawing(int x, int y, Graphics2D g2D) {
		this.draw(g2D);
		this.w = x - this.x;
		this.h = y - this.y;
		this.draw(g2D);		
	}
	public void continueDrawing(int x, int y, Graphics2D g2D) {
	}
	@Override
	public void finishDrawing(int x, int y, Graphics2D g2D) {
	}
	@Override
	public void draw(Graphics2D g2D) {
		if( w < 0 && h < 0)	g2D.drawOval(x+w, y+h, -this.w, -this.h);		
		else if(w < 0)	g2D.drawOval(this.x+this.w, this.y, -this.w, this.h);		
		else if(h < 0)	g2D.drawOval(this.x, this.y+this.h, this.w, -this.h);		
		else	g2D.drawOval(this.x, this.y, this.w, this.h);		
	}
}
