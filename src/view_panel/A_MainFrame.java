package view_panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

public class A_MainFrame extends JFrame {

	//GamePlayingPanel playing = new GamePlayingPanel();

	public final String PAGE_PLAY = "play page";
	public final String PAGE_INTRO = "intro page";
	public final String PAGE_END = "end page";

	private CardLayout cardLayout;
	boolean isCardVisible;

	//this cards
	public JPanel mainPane;
	private JPanel panel_playing;
	private JPanel panel_Intro;
	private JPanel panel_End;

	//BG IMAGE
	private Image image_BG = Toolkit.getDefaultToolkit().createImage("source/Back/BG_intro2.gif");


	//setting button's IMAGE
	private ImageIcon image_btn_easy;
	private ImageIcon image_btn_normal;
	private ImageIcon image_btn_hard;


	private ImageIcon image_StartBT;
	private ImageIcon image_StartBT_pressed;

	//button to change cards
	private JButton BT_Playing ;

	//level setting 
	private JPanel set_Panel;
	private JButton BT_setting;
	private JButton btn_Easy;
	private JButton btn_Normal;
	private JButton btn_Hard;

	
	private JLabel label_mode;
	
	/**
	 * game default speed set = normal
	 */
	private String mode = "Normal";

	public String getMode() {	return mode;	}
	public void setMode(String mode) {	this.mode = mode;	}

	int speedBG = Main.game.getGame_Speed(mode);

	Container c = getContentPane();

	public A_MainFrame(){

	}

	public void setFrame(){	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//check Screen Size
		setTitle("Floating in SPACE");
		setSize(Main.FRAME_WIDTH, Main.FRAME_HEIGHT);	//Set Frame size
		//Set Frame location to screen's CENTER
		setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cardLayout = new CardLayout();

		mainPane = new JPanel();
		mainPane.setLayout(cardLayout);

		panel_Intro = new GameIntroPanel();
		panel_playing = new GamePlayingPanel(getMode());
		panel_End = new GameEndingPanel();

		mainPane.add(PAGE_INTRO, panel_Intro);
		mainPane.add(PAGE_PLAY,panel_playing);
		mainPane.add(PAGE_END,panel_End);

		c.add(mainPane);


		showIntroPane();

		setResizable(false);
		setLayout(new BorderLayout());

		add(mainPane);
		setVisible(true);

		createBufferStrategy(2);
	}


	/**
	 * 게임오버나 엔딩에서 넘어가기 위함
	 */
	void goIntroPanel() {
		showIntroPane();
	}

	////////////////////////////////////////////////////////////////

	void showIntroPane() {
		cardLayout.show(mainPane, PAGE_INTRO);
		setPlayButton();
		setLevelButton();
		panel_Intro.add(BT_setting);
		panel_Intro.add(BT_Playing);
	}


	////////////////////////////////////////////////////
	//create card's button
	/**
	 * this button is set game level
	 */
	private void setLevelButton() {

		//int speedBG = Main.game.getGame_Speed(mode);

		//btn_setting
		BT_setting = new JButton("LEVEL");
		BT_setting.setSize(220, 35);
		BT_setting.setLocation((Main.FRAME_WIDTH-200)/2, 380);
		BT_setting.setFont(Main.font_hp);

		BT_setting.setOpaque(false); 
		BT_setting.setContentAreaFilled(false);
		BT_setting.setBorderPainted(false);
		BT_setting.setForeground(Main.color_transparent100);

		panel_Intro.add(BT_setting);	

		// setting panel
		set_Panel = new JPanel();

		image_btn_easy = new ImageIcon("source/Buttons/setting_easy_button.png"); 
		//image_btn_easy_pressed = new ImageIcon("source/Buttons/setting_easy_button_pressed.png"); 
		image_btn_hard = new ImageIcon("source/Buttons/setting_hard_button.png"); 
		//image_btn_hard_pressed = new ImageIcon("source/Buttons/setting_hard_button_pressed.png"); 
		image_btn_normal = new ImageIcon("source/Buttons/setting_normal_button.png"); 
		//image_btn_normal_pressed = new ImageIcon("source/Buttons/setting_normal_button_pressed.png"); 

		btn_Easy = new JButton(image_btn_easy);
		btn_Normal = new JButton(image_btn_normal);
		btn_Hard = new JButton(image_btn_hard);

		btn_Easy.setSize(image_btn_easy.getIconWidth(), image_btn_easy.getIconHeight());
		btn_Easy.setLocation(Main.FRAME_WIDTH/2 -image_btn_easy.getIconWidth()/2 , 200);
		btn_Easy.setContentAreaFilled(false);
		btn_Easy.setBorderPainted(false);

		btn_Normal.setSize(image_btn_normal.getIconWidth(), image_btn_normal.getIconHeight());
		btn_Normal.setLocation(Main.FRAME_WIDTH/2 -image_btn_normal.getIconWidth()/2 , 300);
		btn_Normal.setContentAreaFilled(false);
		btn_Normal.setBorderPainted(false);

		btn_Hard.setSize(image_btn_hard.getIconWidth(), image_btn_hard.getIconHeight());
		btn_Hard.setLocation(Main.FRAME_WIDTH/2 -image_btn_hard.getIconWidth()/2 , 400);
		btn_Hard.setContentAreaFilled(false);
		btn_Hard.setBorderPainted(false);

		set_Panel.setSize(500, 80);
		set_Panel.setLayout(new GridLayout(1, 3));
		set_Panel.setBackground(Main.color_transparent100);
		set_Panel.setLocation(Main.FRAME_WIDTH/2-set_Panel.getWidth()/2, Main.FRAME_HEIGHT/2-set_Panel.getHeight()/2+20);

		set_Panel.add(btn_Easy);
		set_Panel.add(btn_Normal);
		set_Panel.add(btn_Hard);	
		panel_Intro.add(set_Panel);		
		set_Panel.setVisible(false);

		BT_setting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				set_Panel.setVisible(!set_Panel.isVisible());
				setting();					
			}
		});
	}

	private void setting() { //설정패널
		btn_Easy.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				speedBG = Main.game.getGame_SpeedEasy();
				Main.game.setCleardistance(Main.game.getEasygoal());
				mode = "Easy";
				//label_mode.setText(mode);
				set_Panel.setVisible(false);
			}
		});

		btn_Normal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				speedBG = Main.game.getGame_SpeedNomal();
				Main.game.setCleardistance(Main.game.getNormalgoal());
				mode = "Normal";
				//label_mode.setText(mode);
				set_Panel.setVisible(false);
			}
		});


		btn_Hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				speedBG = Main.game.getGame_SpeedHard();
				Main.game.setCleardistance(Main.game.getHardgoal());
				mode = "Hard";
				//label_mode.setText(mode);
				set_Panel.setVisible(false);			
			}
		});


	}

	/**
	 * this button is goto panel_intro
	 */
	void setIntroButton() {

	}

	/**
	 * this button is goto panel_playing
	 */
	private void setPlayButton() {
		image_StartBT = new ImageIcon("source/Buttons/start_button.png");
		image_StartBT_pressed = new ImageIcon("source/Buttons/start_button_pressed.png");

		panel_Intro.setLayout(null);
		//버튼의 위치를 가운데 놓으려고 조정함
		int MID_FRAME_WIDTH = (Main.FRAME_WIDTH-image_StartBT.getIconWidth())/2;

		BT_Playing = new JButton(image_StartBT);

		// 버튼 뒤 투명화 처리
		BT_Playing.setOpaque(false); 
		BT_Playing.setContentAreaFilled(false);
		BT_Playing.setBorderPainted(false);

		BT_Playing.setSize(image_StartBT.getIconWidth(), image_StartBT.getIconHeight());
		BT_Playing.setLocation(MID_FRAME_WIDTH, 450);
		add(BT_Playing);

		BT_Playing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BT_Playing.setIcon(image_StartBT_pressed);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BT_Playing.setIcon(image_StartBT);
			}

		});

		BT_Playing.addActionListener(new ActionListener() {
			/**
			 게임 시작 버튼을 누르면 게임플레이 화면으로 넘어감
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
				nextPanel(true);
			}
		});
	}
	
	private void setLevelLabel() {
		label_mode = new JLabel(mode);
		label_mode.setFont(Main.font_hp);
		label_mode.setSize(500,35);
		label_mode.setLocation(820, 42);
		label_mode.setForeground(Color.WHITE);
		label_mode.setBackground(Main.color_transparent);
		label_mode.setHorizontalAlignment(JLabel.CENTER);
		panel_playing.add(label_mode);
	

	}

	/**
	 * this button is goto panel_endding
	 */
	void setEndButton() {

	}

	
	public void nextPanel(boolean show) {
		cardLayout.next(mainPane);

		if(show) {
			setLevelLabel();
			panel_playing.setFocusable(true);
			panel_playing.requestFocusInWindow();
		}
		else {
			panel_End.setFocusable(true);
			panel_End.requestFocusInWindow();
		}
	}










}