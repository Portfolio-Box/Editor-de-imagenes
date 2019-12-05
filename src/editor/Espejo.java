package editor;



public class Espejo {
	
	public Espejo() {
		
	}

	public static Pixel[][] horizontal(Pixel p[][]) {
		Pixel aux[][] = new Pixel[p.length][p[1].length];
		  
		for(int i=0;i<p.length;i++)
		{    
			int t=0;
			for(int j=p[1].length-1;j>=0;j--)
			{
				aux[i][t]=p[i][j];
				t++;
			}
		}
		
		return aux;
	
	}
	public static Pixel[][] vertical(Pixel p[][]) {
	   Pixel aux[][] = new Pixel[p.length][p[1].length];
		
	     int t=0;
		for(int i=p.length-1;i>=0;i--)
		{
			for(int j=0;j<p[1].length;j++)
			{
				aux[t][j]=p[i][j];
			}
			t++;
		}
	   
			return aux;
	
	}

}
