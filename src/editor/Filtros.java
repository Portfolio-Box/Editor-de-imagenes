package editor;



public class Filtros {
	private static int[] rarray;
	private static int[] garray;
	private static int[] barray;

	public static Pixel[][] media(Pixel p[][]) {
		Pixel[][] f = new Pixel[p.length][p[1].length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[1].length; j++) {
				if (i > 0 && i < p.length - 1 && j > 0 && j < p[1].length - 1) {
					mascara(p, i, j);
					f[i][j] = new Pixel(mediaaux()[0],mediaaux()[1],mediaaux()[2]);
				} else {
					f[i][j] = new Pixel(p[i][j].getR(),p[i][j].getG(),p[i][j].getB());
				}
			}
		}
		return f;

	}

	public static Pixel[][] mediana(Pixel p[][]) {
		
		Pixel[][] f = new Pixel[p.length][p[1].length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[1].length; j++) {
				if (i > 0 && i < p.length - 1 && j > 0 && j < p[1].length - 1) {
					mascara(p, i, j);
					f[i][j] = new Pixel(medianaaux()[0],medianaaux()[1],medianaaux()[2]);
				} else {
					f[i][j] = new Pixel(p[i][j].getR(),p[i][j].getG(),p[i][j].getB());
				}
			}
		}
		return f;

	}

	public static Pixel[][] minimo(Pixel p[][]) {
		Pixel[][] f = new Pixel[p.length][p[1].length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[1].length; j++) {
				if (i > 0 && i < p.length - 1 && j > 0 && j < p[1].length - 1) {
					mascara(p, i, j);
					f[i][j] = new Pixel(minaux()[0],minaux()[1],minaux()[2]);
				} else {
					f[i][j] = new Pixel(p[i][j].getR(),p[i][j].getG(),p[i][j].getB());
				}
			}
		}
		return f;

	}

	public static Pixel[][] maximo(Pixel p[][]) {
		Pixel[][] f = new Pixel[p.length][p[1].length];
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[1].length; j++) {
				if (i > 0 && i < p.length - 1 && j > 0 && j < p[1].length - 1) {
					mascara(p, i, j);
					f[i][j] = new Pixel(maxaux()[0],maxaux()[1],maxaux()[2]);
				} else {
					f[i][j] = new Pixel(p[i][j].getR(),p[i][j].getG(),p[i][j].getB());
				}
			}
		}
		return f;

	}

	public static void mascara(Pixel[][] p, int i, int j) {
		int runo = p[i - 1][j - 1].getR();
		int rdos = p[i - 1][j].getR();
		int rtres = p[i - 1][j + 1].getR();
		int rcuatro = p[i][j - 1].getR();
		int rcinco = p[i][j].getR();
		int rseis = p[i][j + 1].getR();
		int rsiete = p[i + 1][j - 1].getR();
		int rocho = p[i + 1][j].getR();
		int rnueve = p[i + 1][j + 1].getR();

		rarray = new int[] { runo, rdos, rtres, rcuatro, rcinco, rseis, rsiete, rocho, rnueve };

		int guno = p[i - 1][j - 1].getG();
		int gdos = p[i - 1][j].getG();
		int gtres = p[i - 1][j + 1].getG();
		int gcuatro = p[i][j - 1].getG();
		int gcinco = p[i][j].getG();
		int gseis = p[i][j + 1].getG();
		int gsiete = p[i + 1][j - 1].getG();
		int gocho = p[i + 1][j].getG();
		int gnueve = p[i + 1][j + 1].getG();

		garray = new int[] { guno, gdos, gtres, gcuatro, gcinco, gseis, gsiete, gocho, gnueve };

				
		int buno = p[i - 1][j - 1].getB();
		int bdos = p[i - 1][j].getB();
		int btres = p[i - 1][j + 1].getB();
		int bcuatro = p[i][j - 1].getB();
		int bcinco = p[i][j].getB();
		int bseis = p[i][j + 1].getB();
		int bsiete = p[i + 1][j - 1].getB();
		int bocho = p[i + 1][j].getB();
		int bnueve = p[i + 1][j + 1].getB();

		barray = new int[] { buno, bdos, btres, bcuatro, bcinco, bseis, bsiete, bocho, bnueve };

	}

	static int [] medianaaux() {
		burbujamenormayor(rarray);
		burbujamenormayor(garray);
		burbujamenormayor(barray);
		return new int[]{rarray[4],garray[4],barray[4]};
	}

	static int [] minaux() {
		int r = minimo(rarray);
		int g = minimo(garray);
		int b = minimo(barray);
		return new int[] {r, g, b};
	}

	static int [] maxaux() {
		int r = maximo(rarray);
		int g = maximo(garray);
		int b = maximo(barray);
		return new int[] {r, g, b};
	}

	static int[] mediaaux() {
		int r = 0, g = 0, b = 0;
		for (int i = 0; i < 9; i++) {
			r = r + rarray[i];
			g = g + garray[i];
			b = b + barray[i];
		}
		return new int[]{(int) r / 9,(int)g / 9, (int) b / 9};
	}

	static void burbujamenormayor(int[] enteros) {
		int aux;
		int b = 1;
		for (int i = 0; i < enteros.length - 1 && b == 1; i++) {
			b = 0;
			for (int j = 0; j < enteros.length - 1 - i; j++) {
				if (enteros[j] > enteros[j + 1]) {
					aux = enteros[j];
					enteros[j] = enteros[j + 1];
					enteros[j + 1] = aux;
					b = 1;
				}
			}
		}

	}

	static int maximo(int enteros[]) {
		int maximo = enteros[0];

		for (int i = 0; i < enteros.length; i++) {
			if (maximo < enteros[i]) {
				maximo = enteros[i];
			}
		}

		return maximo;
	}

	static int minimo(int enteros[]) {
		int minimo = enteros[0];
    	
		for (int i = 0; i < enteros.length; i++) {
			if (minimo > enteros[i]) {
				minimo = enteros[i];
			}
		}
		return minimo;
	}

}
