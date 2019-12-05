package editor;

public class Comando {
	//String comando;

	public Comando() {
		//this.comando=comando;
	}
	public int procesarAumentarBrillo(String s) {
		String copia="";
		int num;
    	for(int i=0;i<s.length();i++) {
				if(s.charAt(i)!='+') {
					copia=copia+s.charAt(i);
				}
			}
	    if(esEntero2(copia)) {
        	num=Integer.parseInt(copia);
        	if(num>=0 && num <=255) {
        		return num;
        	}
        }
	
       return -1;
	
	}
	public int procesarDisminuirBrillo(String s) {
		String copia="";
		int num;
    	for(int i=0;i<s.length();i++) {
				if(s.charAt(i)!='-') {
					copia=copia+s.charAt(i);
				}
			}
    	System.out.println(copia);
	    if(esEntero2(copia)) {
        	num=Integer.parseInt(copia);
        	if(num>=0 && num <=255) {
        		return num;
        	}
        }
	
       return -2;
	}
	
	public boolean procesarFormato(String s,int opc) {
		String valido="(,);(,)";
		String valido2="(,)";
		String copia="";
		if(esEntero(s.charAt(0)) || esEntero(s.charAt(s.length()-1))) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			if(!esEntero(s.charAt(i))) {
				copia=copia+s.charAt(i);
			}
		}
		if(opc==1) {
			if(copia.equals(valido)) {
				return true;
				}
		}
		if(opc==2) {
			if(copia.equals(valido2)) {
				return true;
				}
		}
		
		return false;
		
	}
	 public int [] procesarComandoEscala(String s){
		 String[] resultado=s.split("[(),]");
		    int[] resultado2= new int[2];
		    int j=0;
		    for(int i=0;i<resultado.length;i++) {
				try 
				 {
				     resultado2[j] = Integer.parseInt(resultado[i]);
				    j++;
				    }
				    catch (NumberFormatException nfe)   
				    {
				       
				    }
			}
				return resultado2;
	 }
	 
   public int [] procesarComandoCrop(String s) {
	   int j=0;
	   String[] resultado=s.split("[();,]");
	    int[] resultado2= new int[4];
		for(int i=0;i<resultado.length;i++) {
		if(j>3){
		return null;
		}
			try 
		    {
		     resultado2[j] = Integer.parseInt(resultado[i]);
		     j++;
		    }
		    catch (NumberFormatException nfe)   
		    {
		       
		    }
		
		}
		return resultado2;
	}
	public boolean esEntero(char c) {
	    try { 
	      Integer.parseInt(String.valueOf(c));  
	      return true;

	    } catch (Exception e) {
	      return false;
	    }
	  }

	public  boolean esEntero2(String s) {
		try {
			Integer.parseInt(s);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public  boolean esDecimal(String s) {
		try {
			Double.parseDouble(s);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
}
