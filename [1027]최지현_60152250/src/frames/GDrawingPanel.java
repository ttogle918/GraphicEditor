package frames;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import constants.GConstants.EDrawingType;
import shapes.Anchors;
import shapes.GPolygon;
import shapes.GShape;

public class GDrawingPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// object states
	private enum EState {idleTP, drawingTP, idleNP, drawingNP};
	private EState eState = EState.idleTP;
	// components
	private Vector<GShape> shapeVector;	
	// associative attributes
	private GShape selectedShape;
	private GShape onshape;

	// working objects;
	private GShape currentShape;
	
	public void setSelectedShape(GShape selectedShape) {
		this.selectedShape = selectedShape;
		switch(this.selectedShape.geteDrawingType()){
			case TP :	eState = EState.idleTP;	break;
			case NP	:	eState = EState.idleNP;	break;
		}
	}	
	public GDrawingPanel() {
		MouseEventHandler mouseEventHandler = new MouseEventHandler();
		this.addMouseListener(mouseEventHandler);
		this.addMouseMotionListener(mouseEventHandler);
		
		this.shapeVector = new Vector<GShape>();
	}
	public void initialize() {
	}
	
	private void changePointShape(int x, int y) {
		for(GShape shape:this.shapeVector){
			if(shape.on(x, y)){
				this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
				this.onshape = shape;
			}else{
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}
	public void paint(Graphics g) {
		for (GShape shape: this.shapeVector) {
			shape.draw((Graphics2D)g);
		}
	}
	private void initDrawing(int x, int y) {
		this.currentShape= this.selectedShape.clone();
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		
		if(this.getCursor()==Cursor.getDefaultCursor()){
			this.currentShape.initDrawing(x, y, g2D);
		}else{
			onshape.AnchorDraw(g2D, onshape.getShape().getBounds());
			if(eState == EState.drawingNP)	eState = EState.idleNP;
			else if(eState == EState.drawingTP) eState = EState.idleTP;
			else{}	
			}
		}
	
	private void keepDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.keepDrawing(x, y, g2D);
	}
	private void continueDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.continueDrawing(x, y, g2D);
	}
	private void finishDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.finishDrawing(x, y, g2D);
		this.shapeVector.add(this.currentShape);
	}	
	class MouseEventHandler 
		implements MouseInputListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				mouse1Clicked(e);
			} else if (e.getClickCount() == 2) {
				mouse2Clicked(e);
			}
 		}
		private void mouse1Clicked(MouseEvent e) {
			if (eState == EState.idleNP) {
				initDrawing(e.getX(), e.getY());
				eState = EState.drawingNP;
			} else if (eState == EState.drawingNP) {	
				continueDrawing(e.getX(), e.getY());			
			}
		}
		private void mouse2Clicked(MouseEvent e) {
			if (eState == EState.drawingNP) {		
				finishDrawing(e.getX(), e.getY());
				eState = EState.idleNP;
			}			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if (eState == EState.idleTP) {
				initDrawing(e.getX(), e.getY());
				eState = EState.drawingTP;
			}		
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (eState == EState.drawingTP) {		
				finishDrawing(e.getX(), e.getY());
				eState = EState.idleTP;
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			if (eState == EState.drawingNP) {
				keepDrawing(e.getX(), e.getY());
			}else if(eState == EState.idleNP || eState == EState.idleTP){
				changePointShape(e.getX(), e.getY());
			}
		}	
		@Override
		public void mouseDragged(MouseEvent e) {
			if (eState == EState.drawingTP) {
				keepDrawing(e.getX(), e.getY());
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
	}

}
