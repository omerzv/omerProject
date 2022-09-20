package Manu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAoandBean.GameDAO;
import DAoandBean.Player;

public class LeaderBord extends FrameFactory {

	private JTable table;
	private JScrollPane scrollPane;
	private JButton close;
	private GameDAO dao=GameDAO.getInstance();

	public static void main(String[] args) {
		new LeaderBord(300,600,"LeaderBord");
		
	}
	public LeaderBord(int x, int y, String name) {
		super(x, y, name);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String[][] data =this.Make2DArray();
		String[] columnNames = { "Name", "Score", "Level" };
		
		this.table= new JTable(data,columnNames);

		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(40, 170, 200, 300);

		this.close=new JButton("close");
		this.close.setBounds(90,500,100,40);
		this.close.setFont(new Font("Monospaced", 1, 15));
		this.close.setBackground(new Color(100, 90, 175));
		this.close.addActionListener(actionLis);
		this.add(this.close);

		this.add(scrollPane);
		this.frame.add(this);
		this.frame.pack();
		this.frame.setVisible(true);
	}
	private String[][] Make2DArray() {
		List<Player> list= dao.getAll();
		
		String[][] data =new String[list.size()][3];
		int j=list.size()-1;
		for (int i = 0; i < list.size(); i++) {
			data[i][0]=list.get(j).getName();
			data[i][1]=list.get(j).getScore();
			data[i][2]=list.get(j).getLevel();
			j--;
		}
		return data;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d= (Graphics2D) g;
		g2d.setColor(new Color(47,38,38));
		g2d.fillRect(0, 0, 300,600);
		
		g2d.setColor(new Color(0,68,68));
		g2d.setFont(new Font("Ariel", 1, 30));
		g2d.drawString("LeaderBord", 60, 100);
		
		
	}

}
