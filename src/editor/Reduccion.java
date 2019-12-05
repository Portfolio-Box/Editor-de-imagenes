package editor;



public class Reduccion {
	
	
	public static Pixel [][] reduce(Pixel p [][] ,int sx,int sy){
		Pixel r[][] = null;
		int alto=0;
		int ancho=0;
		int x=0;
		int y=0;
		int i=0;
		int j=0;
		int cx=0;
		int cy=0;
		if(multiplo(p.length,sx) && multiplo(p[1].length,sy))
		{
			 alto=p.length/sx;
		     ancho=p[1].length/sy;
			int []rgb=new int[3];
		    r=new Pixel[alto][ancho];
			for(i=0;i<p.length;i+=sx) {
				for( j=0;j<p[1].length;j+=sy) {
					rgb=promedio(p,i,j,sx,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				y=0;
				x++;
			}	
		}
		else if(!multiplo(p.length,sx) && multiplo(p[1].length,sy))
		{
			System.out.println("paso por aca");
			cx= (int)p.length/sx;
			alto=p.length-(cx*sx)+cx;
			ancho=p[1].length/sy;
			int []rgb=new int[3];
		    r=new Pixel[alto][ancho];
			for(i=0;i<(cx*sx);i+=sx) {
				for(j=0;j<p[1].length;j+=sy) {
					rgb=promedio(p,i,j,sx,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				y=0;
				x++;
			}
			for(int ix=i;ix<p.length;ix++) {
				for(int jy=0;jy<p[1].length;jy+=sy) {
					rgb=promedioFila(p,ix,jy,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				y=0;
				x++;
			}	
		}
		else if(multiplo(p.length,sx) && !multiplo(p[1].length,sy))
		{
			alto=p.length/sx;
		    cy= (int)p[1].length/sy;
			ancho=p[1].length-(cy*sy)+cy;
			int []rgb=new int[3];
		    r=new Pixel[alto][ancho];
			for(i=0;i<p.length;i+=sx) {
				y=0;
				for(j=0;j<(cy*sy);j+=sy) {
					rgb=promedio(p,i,j,sx,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				x++;
			}
			x=0;
			for(int ix=0;ix<p.length;ix+=sx) {
				int y1=y;
				for(int jy=j;jy<p[1].length;jy++) {
					rgb=promedioColu(p,ix,jy,sx);
					r[x][y1]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y1++;
				}
				x++;
			}	
		}
		else if(!multiplo(p.length,sx) && !multiplo(p[1].length,sy))
		{
			 cx= (int)p.length/sx;
			alto=p.length-(cx*sx)+cx;
			cy= (int)p[1].length/sy;
			ancho=p[1].length-(cy*sy)+cy;
			int []rgb=new int[3];
		    r=new Pixel[alto][ancho];
			for(i=0;i<(cx*sx);i+=sx) {
				y=0;
				for(j=0;j<(cy*sy);j+=sy) {
					rgb=promedio(p,i,j,sx,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				x++;
			}
			int y1=y;
			for(int ix=i;ix<p.length;ix++) {
				y=0;
				for(int jy=0;jy<j;jy+=sy) {
					rgb=promedioFila(p,ix,jy,sy);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				x++;
			}
			x=0;
			for(int ix=0;ix<i;ix+=sx) {
				y=y1;
				for(int jy=j;jy<p[1].length;jy++) {
					rgb=promedioColu(p,ix,jy,sx);
					r[x][y]=new Pixel(rgb[0],rgb[1],rgb[2]);
					y++;
				}
				x++;
			}	
			for(int ix=i;ix<p.length;ix++) {
				y=y1;
				for(int jy=j;jy<p[1].length;jy++) {
					r[x][y]=p[ix][jy];
					y++;
				}
				x++;
			}	
		}
		return r;
	}
	public static boolean multiplo(int tamaño,int escala) {
		if(tamaño%escala==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int [] promedio(Pixel p [][],int i1,int j1,int sx,int sy) {
		int sumacolorR=0;
		int sumacolorG=0;
		int sumacolorB=0;
		int cont=0;
		int[] promedio=new int[3];
		for(int i=i1;i<sx+i1;i++) {
			for(int j=j1;j<sy+j1;j++) {
				sumacolorR+=p[i][j].getR();
				sumacolorG+=p[i][j].getG();
				sumacolorB+=p[i][j].getB();
				cont++;
			}
		}
		
		promedio[0]=(int)sumacolorR/cont;
		promedio[1]=(int)sumacolorG/cont;
		promedio[2]=(int)sumacolorB/cont;
		return promedio;
	}
	public static int [] promedioColu(Pixel p [][],int i1,int j1,int sx) {
		int sumacolorR=0;
		int sumacolorG=0;
		int sumacolorB=0;
		int cont=0;
		int[] promedio=new int[3];
		for(int i=i1;i<sx+i1;i++) {
				sumacolorR+=p[i][j1].getR();
				sumacolorG+=p[i][j1].getG();
				sumacolorB+=p[i][j1].getB();
				cont++;
		}
		
		promedio[0]=(int)sumacolorR/cont;
		promedio[1]=(int)sumacolorG/cont;
		promedio[2]=(int)sumacolorB/cont;
		return promedio;
	}
	public static int [] promedioFila(Pixel p [][],int i1,int j1,int sy) {
		int sumacolorR=0;
		int sumacolorG=0;
		int sumacolorB=0;
		int cont=0;
		int[] promedio=new int[3];
			for(int j=j1;j<sy+j1;j++) {
				sumacolorR+=p[i1][j].getR();
				sumacolorG+=p[i1][j].getG();
				sumacolorB+=p[i1][j].getB();
				cont++;
			}
		
		promedio[0]=(int)sumacolorR/cont;
		promedio[1]=(int)sumacolorG/cont;
		promedio[2]=(int)sumacolorB/cont;
		return promedio;
	}  
}
