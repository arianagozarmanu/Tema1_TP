package T1_GMA;

public class PolG1 extends Polinom {
	public PolG1(){
		super();
	}
	
	@Override
	//pentru polinom de grad 1 nu este necesara calcularea radacinii cu findRoots, avand formula consacrata
	public double findRoots(Polinom p,double x){
		double rez=0;
			rez=(-p.coef[0])/(double)p.coef[1];
		return rez;
	 }
}
