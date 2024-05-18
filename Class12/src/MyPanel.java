import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

public class MyPanel extends JPanel {
	
	int xLoc = 50;
	int yLoc = 50;
	float red = 1.0f;
	float green = 0.0f;
	float blue = 0.0f;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MyPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(e.getID());
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				xLoc = e.getX();
				yLoc = e.getY();
				red = (float) Math.random();
				green = (float) Math.random();
				blue = (float) Math.random();
			}
		});
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		g.setColor(new Color(red, green, blue));
		g.fillRect(xLoc, yLoc, 30, 80); 
		repaint();
	}
}
