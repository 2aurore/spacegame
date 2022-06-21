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
	���� ���� �� ���� ���� ��Ÿ���� ��Ʈ�� �г�
 */
public class GameIntroPanel extends JPanel {
	
	//��� gif ��������
	private Image image_BG;

	public GameIntroPanel() {
		initBG();
	}
		
	private void initBG() {
		//toolkit���� gif ����
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
