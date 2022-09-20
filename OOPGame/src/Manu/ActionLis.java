package Manu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import DAoandBean.GameDAO;
import Game.Game;


public class ActionLis extends KeyAdapter implements ActionListener{
	private StartManu sm;
	private Help help;

	private EndMenu em;
	private GameDAO dao;
	private LeaderBord bord;
	private static ActionLis instance =new ActionLis();

	private ActionLis() {
		this.dao=GameDAO.getInstance();
	}
	public static ActionLis getInstance() {
		if (instance == null) instance = new ActionLis();
		return instance;
	}

	public void setSm(StartManu sm) {
		this.sm = sm;
	}
	public void setEm(EndMenu em) {
		this.em = em;
	}
	/**
	 *This function telling the button what to do when clicked
	 *for the JTextField when pressing enter sending the data to the DAO
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button;
		if(e.getSource() instanceof JButton) {
			button=(JButton) e.getSource();
			switch (button.getText()) {
			case "start":
				sm.stop();
				new Game();
				break;
			case "help":
				this.help=new Help();
				break;
			case "Start Again":
				this.em.close();
				new Game();
				break;
			case"LeaderBord":
				this.bord=new  LeaderBord(300,600,"LeaderBord");
				break;
			case "close":
				this.bord.close();
			}//switch
		}//if
		if(e.getSource() instanceof JTextField) {
			JTextField name= (JTextField) e.getSource();
			this.dao.create(name.getText());
			name.removeActionListener(this);
		}

	}
	/**
	 *this function making the key ESC terminate the application 
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
	}
}
