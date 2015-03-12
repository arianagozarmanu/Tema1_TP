package T1_GMA;

import java.awt.*;

import javax.swing.*;

public class Panel3 extends JPanel {
	JButton b;
	JTextField tx1;
	JTextField tx2;
	Panel3(){
		b=new JButton("Gata!");
		tx1=new JTextField(20);
		tx2=new JTextField(20);
		setLayout(new FlowLayout(3));
		add(b);
		add(new JLabel("                                                               "));
		add(new JLabel("Primul polinom:"));
		add(tx1);
		add(new JLabel("     Al II-lea polinom:"));
		add(tx2);
	}
	
}
