package editor;

import java.awt.Color;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;

import java.io.IOException;



public class PegarPortapapeles {

	public static Pixel [][] abrir() throws ClassNotFoundException, UnsupportedFlavorException, IOException
	{
		Pixel[][] imgLeida;
		 Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		 
	        //obtenemos el contenido del portapapeles representado por un objeto Transferable
	        Transferable t = cb.getContents(null);
	 
	        //construimos el DataFlavor que representa una imagen
	        DataFlavor dfImagen = new DataFlavor("image/x-java-image; class=java.awt.Image");
	 
	        //verificamos si el objeto Transferable soporta imagenes
	        if (t.isDataFlavorSupported(dfImagen) == true) {
	            //obtenemos el objeto almacenado y lo convertimos en un BufferedImage
	            BufferedImage imagen = (BufferedImage) t.getTransferData(dfImagen);
	            imgLeida=new Pixel[imagen.getHeight()][imagen.getWidth()];//creo el buffer donde voy a escribir la imagen
	            for(int i=0;i<imgLeida.length;i++)
	          	{
	          		
	                 	for(int j=0;j<imgLeida[1].length;j++)
	                 	{
	             			int pixel=imagen.getRGB(j,i);
	             			Color color=new Color(pixel);
	             			int r=color.getRed();
	             			int g=color.getGreen();
	                 		int b=color.getBlue();
	                 		imgLeida[i][j]=new Pixel(r,g,b);
	                 		//System.out.println(imgLeida[i][j]);
	                 	
	                 	}
	             }
	          
	        } else {
	            //generamos una excepción
	            throw new UnsupportedFlavorException(dfImagen);
	        }
	        return imgLeida;
	    }
	 
}
