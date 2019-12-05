package editor;



public class Quantificacion {
public static   Pixel[][]  quan(String input,Pixel p[][]) {
		if (validate(input)) {
			int q = getNum(input);
			int xLength = p[1].length;
			int yLength = p.length;
			Pixel[][] pixels = new Pixel[yLength][xLength];
			int increase = 256 / q;
			if (increase > 0) {
				for (int y = 0; y < yLength; y++) {
					for (int x = 0; x < xLength; x++) {
						//Pixel px = p[y][x].getPixel(y, x);
						int gray = (int) (p[y][x].getR() * 0.299F + p[y][x].getG() * 0.587F + p[y][x].getB() * 0.114F);
						for (int z = 0; z < 256; z += increase) {
							if ((gray >= z) && (gray <= z + increase)) {
								int newTono = z + increase / 2;
								if (newTono < 0)
									newTono = 0;
								if (newTono > 255)
									newTono = 255;
								pixels[y][x] = new Pixel(newTono, newTono, newTono);
								break;
							}
						}
					}
				}
			}
			return pixels;
		} else {
			return null;
		}
	}
public static boolean validate(String input) {
	try {
		int n = Integer.parseInt(input);
		return (n >= 1 && n <= 256);
	} catch (NumberFormatException e) {
		return false;
	}
}

public static int getNum(String input) {
	int n;
	try {
		n = Integer.parseInt(input);
	} catch (NumberFormatException e) {
		n = 0;
	}
	return n;
}

}
