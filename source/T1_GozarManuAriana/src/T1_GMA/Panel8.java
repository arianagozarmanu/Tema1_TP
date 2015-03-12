package T1_GMA;

import java.awt.*;

import javax.swing.*;


public class Panel8 extends JPanel {
	JButton b;
	JTextField tx;
	Panel8(){
		setLayout(new FlowLayout());
		add(new JLabel("Produs:     "));
		b=new JButton("Calculeaza");
		add(b);
		tx=new JTextField(30);
		add(tx);
	}
}
