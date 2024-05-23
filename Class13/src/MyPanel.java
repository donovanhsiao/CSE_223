import java.awt.Graphics;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel {
	
	
	double xMin, xMax, yMin, yMax;

	private static final long serialVersionUID = 1L;
	
	public MyPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Mouse clicked @ [" + e.getX() + ", " + e.getY() + "]");
				for (int x = (int) xMin; x < xMax; x++) {
					
					for (int y = (int) yMin; y < yMax; y++) {
						
						if (e.getX() > xCoordToPixel(x) && e.getX() < xCoordToPixel(x + 1) && e.getY() > yCoordToPixel(y) && e.getY() < yCoordToPixel(y + 1)) {
							
							System.out.println("Mouse clicked in: [" + x + ", " + y + "]");
							return;
						}
					}
				
				}
			}
		});
	}
	
	void setScale(double xMin, double xMax, double yMin, double yMax) {
		
		this.xMin = xMin;
		this.xMax = xMax;
		this.yMin = yMin;
		this.yMax = yMax;
	}
	
	int xCoordToPixel(double x) {
		
		return (int) (getWidth() / (xMax - xMin) * (x - xMin));
	}
	
	int yCoordToPixel(double y) {
		
		return (int) (getHeight() / (xMax - xMin) * (y - yMin));
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		setScale(2, 6, 2, 6);
		
		// draw vertical lines
		for (double x = xMin; x < xMax; x++) {
			g.drawLine(xCoordToPixel(x), yCoordToPixel(yMin), xCoordToPixel(x), yCoordToPixel(yMax));;
		}
		
		// draw horizontal lines
		for (double y = yMin; y < yMax; y++) {
			
			g.drawLine(xCoordToPixel(xMin),  yCoordToPixel(y), xCoordToPixel(xMax), yCoordToPixel(y));
		}
		
		for (int x = (int) xMin; x < xMax; x++) {
			
			for (int y = (int) yMin; y < yMax; y++) {
				
				g.drawString("[" + x + ", " + y + "]", (int) (xCoordToPixel(x) + getWidth() / (2 * (xMax - xMin))), (int) (yCoordToPixel(y) + getHeight() / (2 * (yMax-yMin))));
			}
		}
		
		
	}
	
	
}
