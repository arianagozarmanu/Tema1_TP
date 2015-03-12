package T1_GMA;

import javax.swing.JOptionPane;


public class Polinom {
	  //declaram doua variable in care se retine numarul de coeficienti ai polinomului si coeficientii sai
	  protected int nrCoef;
	  protected int[] coef=new int[1000];  
	    
	    //Constructor gol pentru a putea fi apelat super(); din clasele copii
	  	Polinom(){
	  		
	  	}
	  	 
	  	//Constructor pentru initializare cu 0 a polinoamelor folosite pentru suma,diferenta,produs
	    protected Polinom (int nrCf){
	        nrCoef=nrCf;
	        coef=new int[nrCoef];
	        //initializare polinomul rezultat cu 0
	        for(int i=0;i<nrCoef;i++){
	            coef[i]=0;
	        }
	    }
	    
	    //Constructor in care se sparge string-ul extras din TextField-uri si se transforma in intregi
	    protected Polinom (String coefS){
	        int j=0;
	        int index=0;
	        for(int i=0;i<coefS.length();i++)
	        	//daca gasim spatiu spargem sirul in subsir si-l convertim
	            if(coefS.charAt(i)==' ')
	            {
	                String coeficient=coefS.substring(j,i);
	                coef[index]= Integer.parseInt(coeficient);
	                index++;
	               
	                
	            j=i+1;
	            }
	        
	        int aux=0;
	        //intoarcem sirul obtinut pentru a da senzatia in interfata ca primul coeficient introdus
	        //are gradul cel mai mare
	        for(int i=0;i<=((index-1)/2);i++){
	            aux=coef[i];
	            coef[i]=coef[index-1-i];
	            coef[index-1-i]=aux;
	        }
	        
	        nrCoef=index;
	    }
	    //functia de afisare a polinomului sub forma X^n+X^(n-1)+..
	    protected String afis(){
	        String rez="";
	        int ok=0;
	        if(nrCoef==1){
	            rez=rez+coef[0];
	        }
	       
	        else{
	          
	             for(int i=nrCoef-1;i>0;i--){
	            	
	                if(coef[i]!=0 && coef[i-1]>=0){
	                    for(int j=i-1;j>=0;j--){
	                        if(coef[j]!=0){
	                            ok=1;
	                            
	                        }
	                    }
	                
	                    if(ok==1){
	                        if(i==1 && coef[i-1]==0){
	                            rez=rez+coef[i]+"x^"+i; 
	                        }
	                        else{
	                            rez=rez+coef[i]+"x^"+i+"+";
	                        }
	                    }
	                    else{
	                       rez=rez+coef[i]+"x^"+i; 
	                    }
	                }
	                else if(coef[i]!=0 && coef[i-1]<0){
	                    rez=rez+coef[i]+"x^"+i;
	                }
	                
	            }
	            
	            if(coef[0]!=0){
	            	if(coef[0]<0 && coef[1]==0){
	            		rez=rez+"("+coef[0]+")";
	            	}
	            	else rez=rez+coef[0];
	            }
	            
	        }
	        return rez;
	    }
	    
	    //functia de calcul a valorii intr-un punct a unui polinom
	    protected static double valX(double x, Polinom p)
	    {
	       double rez=0;
	     
	        for(int i=p.nrCoef-1;i>=0;i--)
	           rez=(Math.pow(x,i) *(p.coef[i]))+rez;
	        return rez;
	    }
	    
	    //functia de calcul a sumei unui polinom
	    protected Polinom suma(Polinom p1, Polinom p2){
	    	Polinom rez;
	    	
	    	if(p1.nrCoef>p2.nrCoef)
	        {
	            rez=new Polinom(p1.nrCoef);
	            for(int i=0;i<p2.nrCoef;i++)
	               rez.coef[i]=p1.coef[i]+p2.coef[i];
	            for(int i=p2.nrCoef; i<p1.nrCoef; i++)
	                    rez.coef[i]=p1.coef[i];

	        }
	        else
	        {
	        	rez=new Polinom(p2.nrCoef);
	            for(int i=0;i<p1.nrCoef;i++)
	               rez.coef[i]=p2.coef[i]+p1.coef[i];
	            for(int i=p1.nrCoef; i<p2.nrCoef; i++)
	                    rez.coef[i]=p2.coef[i];
	        }
	    	return rez;
	    }
	  //functia de calcul a diferentei unui polinom
	    protected Polinom dif(Polinom p1, Polinom p2){
	    	Polinom rez;
	    	
	    	if(p1.nrCoef>p2.nrCoef)
	        {
	            rez=new Polinom(p1.nrCoef);
	            for(int i=0;i<p2.nrCoef;i++)
	               rez.coef[i]=p1.coef[i]-p2.coef[i];
	            for(int i=p2.nrCoef; i<p1.nrCoef; i++)
	                    rez.coef[i]=p1.coef[i];

	        }
	        else
	        {
	        	rez=new Polinom(p2.nrCoef);
	            for(int i=0;i<p1.nrCoef;i++)
	               rez.coef[i]=p1.coef[i]-p2.coef[i];
	            for(int i=p1.nrCoef; i<p2.nrCoef; i++)
	                    rez.coef[i]=p2.coef[i];
	        }
	    	return rez;
	    }
	  //functia de calcul a inmultirii unui polinom
	    //se inmulteste element cu element dupa care se aduna cei de acelasi grad
	    protected Polinom mul(Polinom p1,Polinom p2)
	    {
	       
	    	Polinom rez;
	        if(p1.nrCoef==1 && p1.coef[0]==0){
	        	 rez=new Polinom(1);
	        }
	        else if(p2.nrCoef==1 && p2.coef[0]==0){
	        	 rez=new Polinom(1);
	        }
	        else{
	        	
	         rez=new Polinom(p1.nrCoef+p2.nrCoef-1);
	         for (int i=0; i<p1.nrCoef; i++)
	            for(int j=0; j<p2.nrCoef; j++)
	            {
	                rez.coef[i+j]=p1.coef[i] * p2.coef[j]+rez.coef[i+j];
	            }
	        }
	        return rez;
	    }
	    
	    //functie de gasire a derivatei, utila in findRoots
	    protected static double getDerivValue(double x, Polinom p){
			double value = 0;
			double exp = p.nrCoef -1;
			for(int k = p.nrCoef-1; k >0;k--){
				value += exp * p.coef[k] * Math.pow(x, exp - 1);
				exp --;
			}
			return value;
		}
	    
	    //functie de gasire a radacinilor prin metoda lui Newton
	    protected double findRoots(Polinom p, double startValue){
			double precision = 1e-1;
			double x = startValue;
			double x1;
			//Do maximum 500 iterations
			for (int i=0;i<500;i++){
				try {
					
					if (Math.abs(getDerivValue(x,p)) < precision*precision){
						break;
					}
					x1 = x - valX(x,p) / getDerivValue(x,p);
					if (Math.abs(x1-x) < precision){
						break;
					}
					x = x1;
				} catch (Exception e) {
					break;
				}
			}
			if (Math.abs(valX(x,p)) > precision){
				JOptionPane.showMessageDialog(null, "Radacini complexe!"); 
				x=0;
			}
			return x;
		}

}
