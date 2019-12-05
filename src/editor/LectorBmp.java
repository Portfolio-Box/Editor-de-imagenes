package editor;
import java.awt.Color;


import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;



public class LectorBmp
{
	public static Pixel[][] abrir(String direccion)//recibo la direccion donde se va guardar la imagen
	{
		
		Pixel[][] imgLeida;
		try
        {	FileInputStream archivo = new FileInputStream(direccion);//aqui uso la clase fileinput que es necesaria
                                                                    //para leer un archivo binario, y le paso el string
                                                                    //con la direccion
        	ImageInputStream imageInput=ImageIO.createImageInputStream(archivo);//abro el flujo hacia esa direccion
                                                               	//que sera de donde voy a leer la imagen 
        	BufferedImage image = ImageIO.read(imageInput);//creo el buffer donde voy a escribir la imagen
        	imgLeida=new Pixel[image.getHeight()][image.getWidth()];
       
           	for(int i=0;i<imgLeida.length;i++)
        	{
        		
               	for(int j=0;j<imgLeida[1].length;j++)
               	{
           			int pixel=image.getRGB(j,i);
           			Color color=new Color(pixel);
           			int r=color.getRed();
           			int g=color.getGreen();
               		int b=color.getBlue();
               		imgLeida[i][j]=new Pixel(r,g,b);
               	
               	}
               
            }
    	
        }
        catch(Exception e)
        {
           	System.out.println("Error  "+e);
        	return null;
         }
		return imgLeida;
	}   
}
