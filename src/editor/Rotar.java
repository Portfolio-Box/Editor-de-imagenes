package editor;



public class Rotar {
	
	public Rotar() {
		
	}
	

	public static Pixel[][] noventa(Pixel p[][]) {
		
			Pixel aux[][] = new Pixel[p[1].length][p.length];
			
			int t=0;
			for(int j=p[1].length-1;j>=0;j--)
			{
				for(int i=0;i<p.length;i++)
				{
					aux[t][i]=p[i][j];
				}
				t++;
			}
			
			return aux;
	
	}
  
	 public static Pixel[][] cientoochenta(Pixel p[][]) {
		   	
		    Pixel aux[][] = new Pixel[p.length][p[1].length];
		   
		  
		    
		    for(int i=0;i<p.length;i++)
			{
				for(int j=0;j<p[1].length;j++)
				{
					aux[aux.length-i-1][aux[1].length-j-1]=p[i][j];
				}
				
			}
		    return aux;
		    }
  
    public static Pixel[][] docientossetenta(Pixel p[][]) {
     Pixel aux[][] = new Pixel[p[1].length][p.length];
      
    
      for(int j=0;j<p[1].length;j++)
  	{
    	 int t=0;
  		for(int i=p.length-1;i>=0;i--)
  		{
  			aux[j][t]=p[i][j];
  			t++;
  		}
  	}
      
		return aux;
	}
   

}