package editor;

;

public class Recorte {

	public Recorte() {
		// TODO Auto-generated constructor stub
	}

	public static Pixel[][] recortar(Pixel p[][], int i1, int j1, int i2, int j2) {
		if(i1<0 || i2>=p[1].length || j1<0 || j2>=p.length) {
			return null;
		}
		
		Pixel aux[][] = new Pixel[(i2 - i1) + 1][(j2 - j1) + 1];
		int y = 0;
		int x = 0;
		for (int i = i1; i <= i2; i++) {
			for (int j = j1; j <= j2; j++) {
				aux[y][x] = p[i][j];
				x++;
			}
			x = 0;
			y++;
		}
		return aux;

	}

}
