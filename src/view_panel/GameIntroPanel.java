package view_panel;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
	게임 실행 시 가장 먼저 나타나는 인트로 패널
 */
public class GameIntroPanel extends JPanel {
	
	//배경 gif 참조변수
	private Image image_BG;

	public GameIntroPanel() {
		initBG();
	}
		
	private void initBG() {
		//toolkit으로 gif 삽입
		image_BG = Toolkit.getDefaultToolkit().createImage("source/Back/BG_intro2.gif");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image_BG != null) {
			g.drawImage(image_BG, 0, 0, this);
		}

	}
	
}
