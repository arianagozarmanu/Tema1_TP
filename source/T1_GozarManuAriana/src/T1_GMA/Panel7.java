package T1_GMA;

import java.awt.*;

import javax.swing.*;


public class Panel7 extends JPanel{
	JButton b;
	JTextField tx;
	Panel7(){
		setLayout(new FlowLayout());
		add(new JLabel("Diferenta: "));
		b=new JButton("Calculeaza");
		add(b);
		tx=new JTextField(30);
		add(tx);
	}
}
