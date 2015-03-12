package T1_GMA;

import java.awt.*;

import javax.swing.*;

public class Panel4 extends JPanel {
	JTextField tx;
	ButtonGroup group;
	JRadioButton rb1;
	JRadioButton rb2;
	Panel4(){
	tx=new JTextField(5);
	rb1=new JRadioButton();
	rb2=new JRadioButton();
	FlowLayout f=new FlowLayout(3);
	setLayout(f);
	add(new JLabel("Introduceti valoarea punctului in care doriti sa calculati unul dintre polinoame:   "));
	add(tx);
	add(new JLabel("                "));
	add(new JLabel("         Alegeti polinomul:  "));
	add(rb1);
	add(new JLabel("Primul polinom  "));
	add(rb2);
	add(new JLabel("Al II-lea polinom"));
	
	group=new ButtonGroup();
	group.add(rb1);
	group.add(rb2);
	}
}
