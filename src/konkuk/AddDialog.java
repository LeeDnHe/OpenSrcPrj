package konkuk;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddDialog extends JDialog{
	Myframe parent;
	JTextField day = new JTextField(10);
	JTextField name = new JTextField(10);
	JLabel daylabel = new JLabel("일차");
	JLabel namelabel = new JLabel("음식명");
	JButton button = new JButton("추가");
	JPanel panel = new JPanel(new GridLayout(3,2));
	
	public AddDialog(Myframe frame,String title,boolean modal,Data data) {
		// TODO Auto-generated constructor stub
		super(frame,title,modal);
		parent = frame;
		panel.add(daylabel);
		panel.add(namelabel);
		panel.add(day);
		panel.add(name);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==button) {
					data.addData(Integer.parseInt(day.getText()),name.getText());
					JOptionPane.showMessageDialog(panel, "성공적으로 추가되었습니다.","안내",JOptionPane.INFORMATION_MESSAGE);
					revalidate();
					repaint();
				}
			}
		});
		this.add(panel);
		this.setSize(300,300);
		this.setLocation(500,500);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
}
