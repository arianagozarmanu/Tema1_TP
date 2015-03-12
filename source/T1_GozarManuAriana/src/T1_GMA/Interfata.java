package T1_GMA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfata extends JFrame implements ActionListener{
	
	 /**
	 * 
	 */
	//am adaugat automat aceasta constanta pentru a scapa de Warning
	private static final long serialVersionUID = 1L;
	Panel1 p1;
	 Panel2 p2;
	 Panel3 p3;
	 Panel4 p4;
	 Panel5 p5;
	 Panel6 p6;
	 Panel7 p7;
	 Panel8 p8;
	 Panel9 p9;
	 Panel10 p10;
	 Panel11 p11;
	 Panelaux paux;
	 
	 JTextField t2;
	 
	 Polinom polinom1,polinom2,auxp;
	
	private Interfata(){
		
		//Setare titlu interfata grafica
		setTitle("Procesare Polinoame");
		//setare dimensiuni
		setBounds(0, 0, 1200, 500);
		
		//am realizat un container cu un GridLayout de 14 linii
		Container contp=getContentPane();
		contp.setLayout(new GridLayout(14,1)); 
		
		//FlowLayout layout=new FlowLayout();
		
		//fiecarei linii din GridLayout ii corespunde un Panel in care am aranjat componentele
		p1=new Panel1();
		p2=new Panel2();
		p3=new Panel3();
		p4=new Panel4();
		p5=new Panel5();
		p6=new Panel6();
		p7=new Panel7();
		p8=new Panel8();
		p9=new Panel9();
		p10=new Panel10();
		p11=new Panel11();
		//Panel-ul auxiliar este un panel gol
		paux=new Panelaux();
		
		//adaugam componentele in container
		contp.add(p1);
		contp.add(p2);
		contp.add(p3);
		contp.add(paux);
		contp.add(p4);
		contp.add(p5);
		contp.add(new JLabel("  Alte operatii:"));
		contp.add(p6);
		contp.add(p7);
		contp.add(p8);
		contp.add(paux);
		contp.add(p9);
		contp.add(p10);
		contp.add(p11);
		
		//setarea butoanelor pentru a produce un eveniment la actionarea lor
		p3.b.addActionListener(this);
		p5.b.addActionListener(this);
		p6.b.addActionListener(this);
		p7.b.addActionListener(this);
		p8.b.addActionListener(this);
		p10.b.addActionListener(this);
				
		
	}
	
	public static void main(String[] args){
		//setare interfata vizibila
		Interfata inter=new Interfata();
		inter.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
        //luam fiecare buton in parte si ii descriem actiunile ce se vor declansa la actionarea lui	
		if(e.getSource()==p3.b){
			//Butonul din Panel-ul 3 este responsabil cu generarea polinoamelor sub forma grafica
			String s1=new String();
			String s2=new String();
			//in s1 si s2 se retin sub forma de text coeficientii polinomului
			s1=p1.t1.getText();
			s2=p2.tx.getText();
			int ok1=0,ok2=0;
			for(int i=0;i<s1.length();i++)
				//daca s1 are doar cifre, spatiu si semnul negatiei "-" ok=1, altel 0
	            if((s1.charAt(i)=='-')||(s1.charAt(i)==' ')||((s1.charAt(i)>='0')&&(s1.charAt(i)<='9')))
	                ok1=1;
	            else{
	                ok1=0;
	                break;
	            }
			
			for(int i=0;i<s2.length();i++)
				//daca s2 are doar cifre, spatiu si semnul negatiei "-" ok=1, altel 0
	            if((s2.charAt(i)=='-')||(s2.charAt(i)==' ')||((s2.charAt(i)>='0')&&(s2.charAt(i)<='9')))
	                ok2=1;
	            else{
	                ok2=0;
	                break;
	            }
			if(ok1==1) {
				//adaugam spatiu la sfarsitul coeficientul reprezentati sub forma sir de caractere
				//pentru a-l putea sparge in substring-uri pe care le vom converti la integer
	            s1=s1+" ";   
	            polinom1=new Polinom(s1);
	            //apelam functia de creare a polinomului sub forma X^n+X^(n-1)+..
	            s1=polinom1.afis();
	            //punem textul in TextField-ul din interfata de pe linia 3
	            p3.tx1.setText(s1);
			}
			 else JOptionPane.showMessageDialog(null, "Nu ati introdus coeficienti numere intregi in primul polinom!");
			
			if(ok2==1) {
	            s2=s2+" ";   
	            polinom2=new Polinom(s2);
	            s2=polinom2.afis();
	            p3.tx2.setText(s2);
			}
	        else JOptionPane.showMessageDialog(null, "Nu ati introdus coeficienti numere intregi in ce de-al doilea polinom!");		
			
		}
		else if(e.getSource()==p5.b){
			String s=new String();
	        s=p4.tx.getText();
	        int ok=0;
	        for(int i=0;i<s.length();i++)
				//daca s1 are doar cifre, spatiu si semnul negatiei "-" ok=1, altel 0
	            if((s.charAt(i)>='0')&&(s.charAt(i)<='9'))
	                ok=1;
	            else{
	                ok=0;
	                break;
	            }
	        
	        
			//alegem polinomul pentru ca dorim sa calculam o valoare data de noi, selectand RadioButton-ul corespunzator
	        double rez;
	        if(p4.rb1.isSelected()){
	            if(polinom1!=null)
	                auxp=polinom1;
	            else
	               auxp=null;
	        }
	        else if(p4.rb2.isSelected()){
	            if(polinom2!=null)
	                auxp=polinom2;
	            else
	               auxp=null;
	        }
	        else JOptionPane.showMessageDialog(null, "Nu ati selectat niciun polinom!");
	        
	        if(p4.rb2.isSelected() || p4.rb1.isSelected()){
	        //daca unul dintre butoane este selectat se va apela functia se calcularea a valorii x in polinomul ales
	        if(auxp!=null)
	        {
	        if(s.isEmpty()){
	        	JOptionPane.showMessageDialog(null, "Nu ati introdus o valoare in care sa se calculeze polinomul!");
	        }
	        else if(ok==0){
	        	JOptionPane.showMessageDialog(null, "Nu ati introdus o valoare reala in care sa se calculeze polinomul!");
	        }
	        else{
	        rez=Polinom.valX(Double.parseDouble(s),auxp);
	        s=Double.toString(rez);
	        p5.tx.setText(s);
	        }
	        }
	        else
	           JOptionPane.showMessageDialog(null, "Reincercati sa introduceti o valoare reala!"); 
	        }
		}
		else if(e.getSource()==p6.b){
			//daca se selecteaza Butonul "Suma", se fa apela functia pentru suma 
			Polinom rez=new Polinom(0);  
			if(polinom1==null || polinom2==null){
				JOptionPane.showMessageDialog(null, "Introduceti si celalalt polinom!"); 
			}
			else{
	        rez=rez.suma(polinom1,polinom2);
	        p6.tx.setText(rez.afis());}
		}
		else if(e.getSource()==p7.b){
			//daca se selecteaza Butonul "Diferenta", se fa apela functia pentru diferenta 
			if(polinom1==null || polinom2==null){
				JOptionPane.showMessageDialog(null, "Introduceti si celalalt polinom!"); 
			}
			else{
			Polinom rez=new Polinom(0);    
	        rez=rez.dif(polinom1,polinom2);
	        p7.tx.setText(rez.afis());
			}
			
		}
		else if(e.getSource()==p8.b){
			//daca se selecteaza Butonul "Produs", se fa apela functia pentru produs
			if(polinom1==null || polinom2==null){
				JOptionPane.showMessageDialog(null, "Introduceti si celalalt polinom!"); 
			}
			else{
			Polinom rez=new Polinom(0);    
	        rez=rez.mul(polinom1,polinom2);
	        p8.tx.setText(rez.afis());
			}
		}
		else if(e.getSource()==p10.b){
			//Alegem polinomul pentru care dorim sa calculam radacinile
	        double rez;
	        if(p9.rb1.isSelected()){
	            if(polinom1!=null)
	                auxp=polinom1;
	            else
	               auxp=null;
	        }
	        else if(p9.rb2.isSelected()){
	            if(polinom2!=null)
	                auxp=polinom2;
	            else
	               auxp=null;
	        }
	        else JOptionPane.showMessageDialog(null, "Nu ati selectat niciun polinom!");
	        
	        if(p9.rb2.isSelected() || p9.rb1.isSelected()){
	        if(auxp!=null)
	        {
	        	if(auxp.nrCoef==1){
	        		//daca polinomul e de grad 0 doar se rescrie valoarea
	        		p10.tx1.setText(null);
	        		p10.tx2.setText(null);
	        		
	        		String s;
	        		s=Integer.toString(auxp.coef[0]);
	        		p10.tx1.setText(s);
	        	}
	        	else if(auxp.nrCoef==2){
	        		//daca e un polinom de grad 1, apelam functia suprascrisa din clasa PolG1
	        		p10.tx1.setText(null);
	        		p10.tx2.setText(null);
	        		
	        		PolG1 obj=new PolG1();
	        		rez=obj.findRoots(auxp, 0);
	        		String s;
	        		s=Double.toString(rez);
	        		p10.tx1.setText(s);
	        	}
	        	else if(auxp.nrCoef==3){
	        		//daca e un polinom de grad 2, apelam functia suprascrisa din clasa PolG2
	        		p10.tx1.setText(null);
	        		p10.tx2.setText(null);
	        		
	        		PolG2 obj=new PolG2();
	        		double[] r= new double[]{0,0};
	        		r=obj.findRoots(auxp);
	        		String s1,s2;
	        		s1=Double.toString(r[0]);
	        		s2=Double.toString(r[1]);
	        		p10.tx1.setText(s1);
	        		p10.tx2.setText(s2);
	        	}
	        	
	        	else{
	        		//altfel, se apeleaza findRoots din clasa parinte Polinom
	        		p10.tx1.setText(null);
	        		p10.tx2.setText(null);	
	        		Polinom obj=new Polinom();
	        		rez=obj.findRoots(auxp, 1);
	        		String s;
	        		s=Double.toString(rez);
	        		p11.tx1.setText(s);
	        	}
	        }
	        else
	           JOptionPane.showMessageDialog(null, "Introduceti coeficienti pentru polinomul ales!"); 
	        }
	        //
		}
	}
	

}
