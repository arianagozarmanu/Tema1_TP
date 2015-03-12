package T1_GMA;

import javax.swing.JOptionPane;

public class PolG2 extends Polinom {
	public PolG2(){
		super();
	}
	
	//pentru polinom de grad 2 nu este necesara calcularea radacinii cu findRoots, avand formula consacrata
	public double[] findRoots(Polinom p){
		double[] rez =new double[]{0,0};;
		double aux1,aux2,delta=0.0;
		aux1=p.coef[2]*p.coef[0];
		aux2=4*aux1;
		delta=p.coef[1]*p.coef[1]-aux2;
		
		if(delta>0){
			rez[0]=(p.coef[1]+Math.sqrt(delta))/(2*p.coef[2]);
			rez[1]=(p.coef[1]-Math.sqrt(delta))/(2*p.coef[2]);
		}
		else if(delta==0){
			rez[0]=(p.coef[1])/(2*p.coef[2]);
			rez[1]=(p.coef[1])/(2*p.coef[2]);
		}
		else
			JOptionPane.showMessageDialog(null, "Radacini complexe!");

		return rez;
	 }

}
