package editor;

import java.awt.datatransfer.UnsupportedFlavorException;

import java.io.IOException;

import javax.swing.UIManager;

public class Logica implements ImagesOperationsListener {

	private Pixel[][] p;
	private Comando c = new Comando();
	private static BitmapDisplay bd;
	private String ruta;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

		} catch (Exception ex) {
		}

		Logica l = new Logica();
		bd = new BitmapDisplay(l);
	}

	public void anotherFilter() {

	}

	public void actualizar() {
		Pixel[][] nuevo = new Pixel[1][1];
		nuevo[0][0] = new Pixel(255, 255, 255);
		bd.showResult(nuevo, nuevo.length, nuevo.length);
	}

	public void calculateHistogram() {

	}

	public void crop(String arg0) {
		if (arg0 != null) {
			if (c.procesarFormato(arg0, 1)) {
				if (c.procesarComandoCrop(arg0) != null) {
					int[] res = new int[4];
					res = c.procesarComandoCrop(arg0);
					if (Recorte.recortar(p, res[0], res[1], res[2], res[3]) != null) {
						bd.showResult(Recorte.recortar(p, res[0], res[1], res[2], res[3]),
								Recorte.recortar(p, res[0], res[1], res[2], res[3])[1].length,
								Recorte.recortar(p, res[0], res[1], res[2], res[3]).length);
						p = Recorte.recortar(p, res[0], res[1], res[2], res[3]);
					} else {
						bd.showErrorMessage("coodernadas incorrectas");
					}

				}
			} else {
				bd.showErrorMessage("formato incorrecto");
			}

		}
	}

	public void filter() {
		if (p != null) {
			p = Filtros.media(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void flipHorizontal() {
		if (p != null) {
			p = Espejo.horizontal(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void flipVertical() {
		if (p != null) {
			p = Espejo.vertical(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void grayscale() {
		if (p != null) {
			Grey.escala(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void loadImage(String arg0) {
		ruta = arg0;
		p = LectorBmp.abrir(arg0);
		bd.showOriginal(LectorBmp.abrir(arg0), LectorBmp.abrir(arg0)[1].length, LectorBmp.abrir(arg0).length);
		actualizar();

	}

	public void modifyBrightness(String arg0) {
		if (arg0 != null) {
			if (p != null) {
				if (arg0.startsWith("+")) {
					if (c.procesarAumentarBrillo(arg0) != -1) {
						Brillo.aumentar(p, c.procesarAumentarBrillo(arg0));
						bd.showResult(p, p[1].length, p.length);
					}
				}

				else if (arg0.startsWith("-")) {
					if (c.procesarDisminuirBrillo(arg0) != -2) {
						Brillo.disminuir(p, c.procesarDisminuirBrillo(arg0));
						bd.showResult(p, p[1].length, p.length);
					}

					else {
						bd.showErrorMessage("comando incorrecto");
					}

				}
			}
		}
	}

	public void modifyContrast(String arg0) {
		if (arg0 != null)
			if (p != null)
				if (c.esDecimal(arg0)) {
					double d = Double.parseDouble(arg0);
					if (d > 1) {
						Contraste.aumentarCon(p, d);
						bd.showResult(p, p[1].length, p.length);
					} else if (d < 1 && d > 0) {
						Contraste.disminuirCon(p, d);
						bd.showResult(p, p[1].length, p.length);
					} else {
						bd.showErrorMessage("numero invalido");
					}

				} else {
					bd.showErrorMessage("comando incorrecto");
				}

	}

	public void negative() {
		if (p != null) {
			Negativo.neg(p);
			bd.showResult(p, p[1].length, p.length);
		}
	}

	public void quantization(String arg0) {
			if (Quantificacion.quan(arg0, p)!=null) {
				p = Quantificacion.quan(arg0, p);
				bd.showResult(p, p[1].length, p.length);
				//bd.showErrorMessage("numero invalido");
			} 
		

	}

	public void reduce(String arg0) {
		if (arg0 != null && p != null) {

			if (c.procesarFormato(arg0, 2)) {
				if (c.procesarComandoEscala(arg0) != null) {
					int[] res = new int[2];
					res = c.procesarComandoEscala(arg0);
					if (res[0] > 0 && res[0] < 10 && res[1] > 0 && res[1] < 10) {
						p = Reduccion.reduce(p, res[0], res[1]);
						bd.showResult(p, p[1].length, p.length);
					} else {
						bd.showErrorMessage("valores invalidos");
					}
				}

			} else {
				bd.showErrorMessage("formato incorrecto");
			}
		}
	}

	public void rotate180() {
		if (p != null) {
			p = Rotar.cientoochenta(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void rotate270() {
		if (p != null) {
			p = Rotar.docientossetenta(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void rotate90() {
		if (p != null) {
			p = Rotar.noventa(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	public void saveResult(String arg0) {
		EscritorBmp.guardar(p, arg0);

	}

	@Override
	public void portapapeles() {
		try {

			bd.showOriginal(PegarPortapapeles.abrir(), PegarPortapapeles.abrir()[1].length,
					PegarPortapapeles.abrir().length);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedFlavorException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			p = PegarPortapapeles.abrir();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void min() {
		// TODO Auto-generated method stub
		if (p != null) {
			p = Filtros.minimo(p);
			bd.showResult(p, p[1].length, p.length);
		}
	}

	@Override
	public void max() {
		// TODO Auto-generated method stub
		if (p != null) {
			p = Filtros.maximo(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		if (ruta != null) {
			p = LectorBmp.abrir(ruta);
			bd.showOriginal(LectorBmp.abrir(ruta), LectorBmp.abrir(ruta)[1].length, LectorBmp.abrir(ruta).length);
			// bd.showResult(p,p[1].length,p.length);
			actualizar();
		}

	}

	@Override
	public void mediana() {
		// TODO Auto-generated method stub
		if (p != null) {
			p = Filtros.mediana(p);
			bd.showResult(p, p[1].length, p.length);
		}

	}

}
