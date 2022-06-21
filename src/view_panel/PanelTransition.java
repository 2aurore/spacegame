package view_panel;

import javax.swing.JFrame;

import controller.Con_GameSystem;

public class PanelTransition extends A_MainFrame {


	
	void changeEnd(String t, Con_GameSystem game) {
		if (t.equals("��������")) {
			//getContentPane().removeAll();
			mainPane.removeAll();
			//getContentPane().add(new GameEndingPanel());
			mainPane.add(new GameEndingPanel(game));
			revalidate();
			repaint();
		}
	}
		
	void changeIntro(String t) {
		if(t.equals("���ư���")) {
			getContentPane().removeAll();
			getContentPane().add(new GameIntroPanel());
			revalidate();
			repaint();
		}
		
	}
	
	
}
