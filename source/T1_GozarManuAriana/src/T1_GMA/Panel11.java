package T1_GMA;

import javax.swing.*;

import java.awt.*;

public class Panel11 extends JPanel {
	JTextField tx1;

	Panel11(){
		setLayout(new FlowLayout());
		
		add(new JLabel("                                                                                                     "));
		add(new JLabel("                                                                                                     "));
		tx1=new JTextField(15);
		add(tx1);
		
		add(new JLabel("  (conform teoremei lui Newton)"));
	}
}