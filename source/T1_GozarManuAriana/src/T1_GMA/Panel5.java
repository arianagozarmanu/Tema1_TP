package T1_GMA;

import javax.swing.*;

import java.awt.*;

public class Panel5 extends JPanel {
	JButton b;
	JTextField tx;
	Panel5(){
		setLayout(new FlowLayout());
		b=new JButton("Generare rezultat");
		add(b);
		tx=new JTextField(30);
		add(tx);
	}
}
