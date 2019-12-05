package editor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;




public class EscritorBmp
{
	public static boolean guardar(Pixel [][]  imagenAGuardar, String nombre)
	{
	try
        {	File archivo = new File(nombre+".bmp");//utilizo la clase file para representar un archivo o directorio
                                            //le paso el string con la direccion
        	ImageOutputStream imageOutput=ImageIO.createImageOutputStream(archivo);//con imageoutput abro un flujo
        	                                                            //de datos hacia la direcion destino
        	                                                            //para poder guardar la imagen
        	BufferedImage image =new BufferedImage(imagenAGuardar[1].length,imagenAGuardar.length,BufferedImage.TYPE_3BYTE_BGR);
        	//uso la clse bufferimage para crear un buffer donde se escribira en memoria la imagen a guardar
        	
             for(int i=0;i<imagenAGuardar.length;i++)
            {
            	
                for(int j=0;j<imagenAGuardar[1].length;j++){ //en este for hago la conversion de mi objeto tipo imagen al tipo de imagen que usa bufferimage
               		int r=imagenAGuardar[i][j].getR();//obtengo el color de un pixel de esa posicion de mi
               		int g=imagenAGuardar[i][j].getG();// objeto de tipo pixel lo guardo en un entero, para 
              		int b=imagenAGuardar[i][j].getB();//pasarselo luego como parametro a la clase color
               		 Color color= new Color(r, g, b); 
               		image.setRGB(j,i,color.getRGB());//mando los parametros a mi objeto de tipo bufferimage
                                            //tanto la posicion de pixel y el color de esa posicion
                }                                   //para java la columna es la x, y la fila la y
                
            }
      
            ImageIO.write(image, "BMP", imageOutput);//grabo la imagen que escribi en el buffer
            imageOutput.close();
            return true;
        }
		catch (IOException x) {
			System.err.format("IOException %s%n",x);
		}
        catch(Exception e)
        {
        	System.out.println("Error  "+e);
        }
		return false;
	}   
}

