package main;

import java.awt.Color;
import java.awt.Font;

import controller.Con_BGM;
import controller.Con_GameSystem;
import model.Item;
import model.SpaceTrash;
import view_panel.A_MainFrame;

public class Main {

	// ���� ������ ������
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	

	//���� ���� �÷�
	public static Color color_transparent = new Color(0,0,0,0);
	public static Color color_transparent100 = new Color(255,255,255,100);

	//setting font
	public static Font font_hp = new Font("Verdana", Font.BOLD, 35); //�ӽü���
	public static Font font_score = new Font("Verdana", Font.BOLD, 140); //�ӽü���

	//���� ������Ʈ�� ��ü ����
	public static Con_BGM bgm = new Con_BGM();	//���� ��ü
	public static Con_GameSystem game = new Con_GameSystem();
	public static SpaceTrash trash = new SpaceTrash(); //�����ⰴü
	public static Item item = new Item(); //�����۰�ü
	
	
	public static void main(String[] args) {
		new A_MainFrame().setFrame();

	}

}
