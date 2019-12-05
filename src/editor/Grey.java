package editor;



public class Grey {

	public Grey() {
		// TODO Auto-generated constructor stub
	}
	
	public static void escala(Pixel p[][]){
		int r,g,b=0;
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p[1].length;j++) {
				 r=p[i][j].getR();
				 g=p[i][j].getG();
				 b=p[i][j].getB();
				 int rgb= (int) (0.299*r+ 0.587*g + 0.114*b);
				p[i][j]=new Pixel(rgb,rgb,rgb);
			}
			}
	}
}
