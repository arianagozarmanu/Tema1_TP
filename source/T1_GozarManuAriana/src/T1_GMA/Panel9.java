package T1_GMA;

import java.awt.*;

import javax.swing.*;

public class Panel9 extends JPanel {
	
	ButtonGroup group;
	JRadioButton rb1;
	JRadioButton rb2;
	
	Panel9(){

	rb1=new JRadioButton();
	rb2=new JRadioButton();
	FlowLayout f=new FlowLayout(3); //de la 3 spatii de la margine incepe scrierea Label-ului
	setLayout(f);
	add(new JLabel("Alegeti polinomul pentru care doriti aflarea radacinii:   "));

	add(new JLabel("                "));
	
	add(rb1);
	add(new JLabel("Primul polinom  "));
	add(rb2);
	add(new JLabel("Al II-lea polinom"));
	
	group=new ButtonGroup();
	group.add(rb1);
	group.add(rb2);
	}
}

