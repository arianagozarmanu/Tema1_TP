package T1_GMA;

import java.awt.*;

import javax.swing.*;

public class Panel1 extends JPanel {
	JTextField t1;
	Panel1(){
		setLayout(new FlowLayout(3));
		add(new JLabel("Introduceti coeficientii pentru primul polinom:"));
		t1=new JTextField(30);
		add(t1);
	}
}
