package T1_GMA;

import javax.swing.*;
import java.awt.*;
public class Panel6 extends JPanel{
	JButton b;
	JTextField tx;
	Panel6(){
		setLayout(new FlowLayout());
		add(new JLabel("Suma:      "));
		b=new JButton("Calculeaza");
		add(b);
		tx=new JTextField(30);
		add(tx);
	}
}
