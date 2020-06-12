package konkuk;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Myframe extends JFrame implements ActionListener{ 
	Container frame;
	int screenHeight;
	int screenWidth;
	JButton button_add;
	JButton button_che;
	Data data;
	
	JPanel b_panel;
	AddDialog Adlg = null;
	CheckDialog Cdlg = null;
	Myframe(Map map){
		super("Nutrition Control System");
		Toolkit kit = this.getToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.screenWidth = screenSize.width;
		this.screenHeight = screenSize.height;
		this.setSize(this.screenHeight/2,this.screenWidth/4
				);
		data = new Data(map);
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	void init() {
		frame = getContentPane();
		button_add = new JButton("섭취한 음식 추가");
		button_che = new JButton("1주일 동안 섭취양");
		
		button_add.addActionListener(this);
		button_che.addActionListener(this);
		b_panel = new JPanel();
		
		b_panel.add(button_add);
		b_panel.add(button_che);
		
		frame.add(b_panel,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button_add) {
			Adlg = new AddDialog(this, "섭취한 음식 추가",false,data);
		}
		else if( e.getSource()==button_che) {
			Cdlg = new CheckDialog(this,"1주일 동안 섭취양",false,data);
		}
	}
	
}