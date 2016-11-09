package shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public class Anchors extends Vector<Ellipse2D.Double>{
	private static final long serialVersionUID = 1L;
	public final static int ANCHORWIDTH = 8;
	public final static int ANCHORHEIGHT = 8;
	
	enum EAnchors {NN, NE, NW, SS, SW, SE, EE, WW, RR};
	public Anchors() {
		for (int i=0; i<EAnchors.values().length; i++) {			
			this.add(new Ellipse2D.Double(0, 0, ANCHORWIDTH, ANCHORHEIGHT));
		}
	}
	private void computeCoordinates(Rectangle r) {
		for (int i=0; i<EAnchors.values().length; i++) {			
			switch (EAnchors.values()[i]) {
			case NN:
				this.get(i).x = r.x+r.width/2-ANCHORWIDTH/2;
				this.get(i).y = r.y-ANCHORHEIGHT/2;
				break;
			case NE:
				this.get(i).x = r.x+r.width-ANCHORWIDTH/2;
				this.get(i).y = r.y-ANCHORHEIGHT/2;
				break;
			case NW:
				this.get(i).x = r.x-ANCHORWIDTH/2;
				this.get(i).y = r.y-ANCHORHEIGHT/2;
				break;
			case SS:
				this.get(i).x = r.x+r.width/2-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height-ANCHORHEIGHT/2;
				break;
			case SW:
				this.get(i).x = r.x-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height-ANCHORHEIGHT/2;
				break;
			case SE:
				this.get(i).x = r.x+r.width-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height-ANCHORHEIGHT/2;
			break;
			case EE:
				this.get(i).x = r.x+r.width-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height/2-ANCHORHEIGHT/2;
				break;
			case WW:
				this.get(i).x = r.x-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height/2-ANCHORHEIGHT/2;
				break;
			case RR:
				this.get(i).x = r.x+r.width/2-ANCHORWIDTH/2;
				this.get(i).y = r.y+r.height/2-ANCHORHEIGHT/2;
				break;
			}
		}
	}
	public void draw(Graphics2D g2D, Rectangle boundRectangle) {
		g2D.setXORMode(g2D.getBackground());
		this.computeCoordinates(boundRectangle);
		for (int i=0; i<EAnchors.values().length; i++) {
			g2D.draw(this.get(i));
		}
	}
}
