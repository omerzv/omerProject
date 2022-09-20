package Manu;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameFactory extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected JFrame frame;
	protected ActionLis actionLis;

	
	/**
	 * @param x width of the frame
	 * @param y height of the frame
	 * @param name 
	 * 
	 * making default frame for all the menus in the game 
	 * with actionLis
	 */
	public FrameFactory(int x, int y,String name) {
		frame = new JFrame(name);
		actionLis=ActionLis.getInstance();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(x,y));
		frame.setMaximumSize(new Dimension(x,y));
		frame.setMinimumSize(new Dimension(x,y));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		this.setLayout(null);

	}
	public void close() {
		this.frame.dispose();
	}
	

}
