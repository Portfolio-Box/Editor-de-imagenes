package editor;



public class Brillo {

	public Brillo() {
		// TODO Auto-generated constructor stub
	}
	public  static void aumentar(Pixel p[][],int a){
		int r,g,b=0;
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p[1].length;j++) {
				 r=p[i][j].getR()+a;
				 g=p[i][j].getG()+a;
				 b=p[i][j].getB()+a;
				
					if (r < 0)
						r = 0;
					if (r > 255)
						r = 255;
					if (g < 0)
						g = 0;
					if (g > 255)
						g = 255;
					if (b < 0)
						b = 0;
					if (b > 255)
						b = 255;
					p[i][j] = new Pixel(r, g, b);
							
			}
			}
		
	}
	public  static void disminuir(Pixel p[][],int a){
		int r,g,b=0;
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p[1].length;j++) {
				 r=p[i][j].getR()-a;
				 g=p[i][j].getG()-a;
				 b=p[i][j].getB()-a;
				 if (r < 0)
						r = 0;
					if (r > 255)
						r = 255;
					if (g < 0)
						g = 0;
					if (g > 255)
						g = 255;
					if (b < 0)
						b = 0;
					if (b > 255)
						b = 255;
					p[i][j] = new Pixel(r, g, b);
			   	}
			}
		
	}
	
}
