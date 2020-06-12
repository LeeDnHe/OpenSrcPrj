package konkuk;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CheckDialog extends JDialog implements ActionListener{
	Myframe parent;
	CardLayout card = new CardLayout();
	JPanel cardpanel = new JPanel(card);
	JButton one = new JButton("1일차 확인");
	JButton two = new JButton("2일차 확인");
	JButton three = new JButton("3일차 확인");
	JButton four = new JButton("4일차 확인");
	JButton five = new JButton("5일차 확인");
	JButton six = new JButton("6일차 확인");
	JButton seven = new JButton("7일차 확인");
	JButton total = new JButton("전체 확인");
	JPanel panel = new JPanel(new GridLayout(8,1,10,10));
	Data data;
	JTable table;
	JTable[] ntable = new JTable[7];
	
	public CheckDialog(Myframe frame,String title,boolean modal,Data data) {
		// TODO Auto-generated constructor stub
		super(frame,title,modal);
		parent = frame;
		this.data = data;
		for(int i=0;i<7;i++){
			ntable[i] = new JTable();
		}
		init();
		this.setSize(1000,700);
		this.setLocation(500,100);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	void init() {
		String header[] = {"일차","칼로리","탄수화물","단백질"};
		String[][] content = new String[9][4];
		double tkcal =0;
		double tprot =0;
		double tcarb =0;
		for(int i =0;i<8;i++) {
			for(int j=0;j<4;j++) {
				content[i][j] = "";
			}
		}
		for(int i =0;i<7;i++) {
			content[i][0] = Integer.toString(i+1)+"일차";
			content[i][1] =	String.format("%.2f",((double) data.getkcal().get(i)))+"kcal";
			content[i][2] = String.format("%.2f",((double) data.getcarb().get(i)))+"g";
			content[i][3] = String.format("%.2f",((double) data.getprot().get(i)))+"g";
			tkcal += (double) data.getkcal().get(i);
			tprot += (double) data.getprot().get(i);
			tcarb += (double) data.getcarb().get(i);
		}
		
		content[7][0] = "합계";
		content[7][1] = (String.format("%.2f", tkcal))+"kcal";
		content[7][2] = (String.format("%.2f", tcarb))+"g";
		content[7][3] = (String.format("%.2f", tprot))+"g";
		content[8][0] = "평균";
		content[8][1] = (String.format("%.2f", tkcal/7))+"kcal";
		content[8][2] = (String.format("%.2f", tcarb/7))+"g";
		content[8][3] = (String.format("%.2f", tprot/7))+"g";
		table = new JTable(content, header);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(four);
		panel.add(five);
		panel.add(six);
		panel.add(seven);
		panel.add(total);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		total.addActionListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		cardpanel.add(scrollPane,"0");
		for(int i =0;i<7;i++) {
			String tempHeader[] = {"이름","칼로리","탄수화물","단백질"};
			String[][] tempContent = new String[data.getData(i).size()+1][4];
			for(int j =0;j<data.getData(i).size();j++) {
				tempContent[j][0] = ((API) data.getData(i).get(j)).getName();
				tempContent[j][1] = ((API) data.getData(i).get(j)).getKcal();
				tempContent[j][2] = ((API) data.getData(i).get(j)).getCarb();
				tempContent[j][3] = ((API) data.getData(i).get(j)).getProt();
			}
			tempContent[data.getData(i).size()][0] = "합계";
			tempContent[data.getData(i).size()][1] = Double.toString((double) data.getkcal().get(i))+"kcal";
			tempContent[data.getData(i).size()][2] = Double.toString((double) data.getcarb().get(i))+"g";
			tempContent[data.getData(i).size()][3] = Double.toString((double) data.getprot().get(i))+"g";
			ntable[i] = new JTable(tempContent,tempHeader);
			scrollPane = new JScrollPane(ntable[i]);
			cardpanel.add(scrollPane,Integer.toString(i+1));
			
		}
		
		this.add(cardpanel,BorderLayout.CENTER);
		this.add(panel,BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==total) {
			card.show(cardpanel, "0");
		}
		else if(e.getSource()==one) {
			card.show(cardpanel, "1");
		}
		else if(e.getSource()==two) {
			card.show(cardpanel, "2");
		}
		else if(e.getSource()==three) {
			card.show(cardpanel, "3");
		}
		else if(e.getSource()==four) {
			card.show(cardpanel, "4");
		}
		else if(e.getSource()==five) {
			card.show(cardpanel, "5");
		}
		else if(e.getSource()==six) {
			card.show(cardpanel, "6");
		}
		else if(e.getSource()==seven) {
			card.show(cardpanel, "7");
		}
	}
}
