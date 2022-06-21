package main;

import java.awt.Color;
import java.awt.Font;

import controller.Con_BGM;
import controller.Con_GameSystem;
import model.Item;
import model.SpaceTrash;
import view_panel.A_MainFrame;

public class Main {

	// 고정 프레임 사이즈
	public static final int FRAME_WIDTH = 1280;
	public static final int FRAME_HEIGHT = 720;
	

	//게임 세팅 컬러
	public static Color color_transparent = new Color(0,0,0,0);
	public static Color color_transparent100 = new Color(255,255,255,100);

	//setting font
	public static Font font_hp = new Font("Verdana", Font.BOLD, 35); //임시설정
	public static Font font_score = new Font("Verdana", Font.BOLD, 140); //임시설정

	//게임 프로젝트의 객체 생성
	public static Con_BGM bgm = new Con_BGM();	//음악 객체
	public static Con_GameSystem game = new Con_GameSystem();
	public static SpaceTrash trash = new SpaceTrash(); //쓰레기객체
	public static Item item = new Item(); //아이템객체
	
	
	public static void main(String[] args) {
		new A_MainFrame().setFrame();

	}

}
