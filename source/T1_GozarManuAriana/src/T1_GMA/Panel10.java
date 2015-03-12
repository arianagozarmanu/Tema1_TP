package T1_GMA;

import javax.swing.*;

import java.awt.*;

public class Panel10 extends JPanel {
	JTextField tx1;
	JTextField tx2;
	
	JButton b;
	Panel10(){
		setLayout(new FlowLayout());
		
		b=new JButton("Radacinile:");
		add(b);
		tx1=new JTextField(15);
		add(tx1);
		tx2=new JTextField(15);
		add(tx2);
		
		add(new JLabel("  (conform formulelor cunoscute)"));
	}
}
