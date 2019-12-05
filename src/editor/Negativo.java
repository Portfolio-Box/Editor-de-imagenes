package editor;



public class Negativo {

	public Negativo() {
		// TODO Auto-generated constructor stub
	}
	public static void neg(Pixel p[][]){
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p[1].length;j++) {
				p[i][j]=new Pixel(255-p[i][j].getR(),255-p[i][j].getG(),255-p[i][j].getB());
			}
			}
		
	}

}
