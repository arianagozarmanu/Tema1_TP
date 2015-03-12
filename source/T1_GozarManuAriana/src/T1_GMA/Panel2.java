package T1_GMA;

import java.awt.*;

import javax.swing.*;

public class Panel2 extends JPanel {
	JTextField tx;
	Panel2(){
	tx=new JTextField(30);
	FlowLayout f=new FlowLayout(3);
	setLayout(f);
	add(new JLabel("Introduceti coeficientii pentru cel de-al doilea:"));
	add(tx);
	}
}
