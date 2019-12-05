package editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BitmapDisplay
{
  private ImagesOperationsListener operator;
  private JFrame frame;
  private JToolBar toolbar_panel;
  private JToolBar toolbar_panel_extra;
  private JPanel images_panel;
  private JLabel original_image;
  private JLabel result_image;
  private JButton button_open;
  private JButton button_save;
  private JButton button_grayscale;
  private JButton button_flip_vertical;
  private JButton button_flip_horizontal;
  private JButton button_rotate_90;
  private JButton button_rotate_180;
  private JButton button_rotate_270;
  private JButton button_negative;
  private JButton button_crop;
  private JButton button_quantization;
  private JButton button_reduce;
  private JButton button_histogram;
  private JButton button_brightness;
  private JButton button_contrast;
  private JButton button_filter_one;
  private JButton button_filter_two;
  private JButton button_portapapeles;
  private JButton button_min;
  private JButton button_max;
  private JButton button_mediana;
  private JButton button_back;
  
  public BitmapDisplay(ImagesOperationsListener _operator)
  {
    operator = _operator;
    frame = new JFrame("EDITOR DE IMAGENES");
    frame.setDefaultCloseOperation(3);
    frame.getContentPane().setLayout(new BorderLayout());
    
    images_panel = new JPanel(new GridLayout(1, 2));
    
    toolbar_panel = new JToolBar();
    toolbar_panel_extra = new JToolBar();
    
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, 1));
    
    toolbar_panel.setFloatable(false);
    toolbar_panel_extra.setFloatable(false);
    
    toolbar_panel.setRollover(true);
    toolbar_panel_extra.setRollover(true);
    
    toolbar_panel.setOrientation(0);
    toolbar_panel_extra.setOrientation(0);
    
    toolbar_panel.setBorderPainted(false);
    toolbar_panel_extra.setBorderPainted(false);
    
    panel.add(toolbar_panel);
    panel.add(toolbar_panel_extra);
    
    frame.getContentPane().add(panel, "North");
    frame.getContentPane().add(images_panel, "Center");
    
    frame.setExtendedState(6);
    
    original_image = new JLabel("Imagen Original");
    original_image.setHorizontalAlignment(0);
    original_image.setVerticalAlignment(0);
    
    result_image = new JLabel("Imagen Resultado");
    result_image.setHorizontalAlignment(0);
    result_image.setVerticalAlignment(0);
    
    images_panel.add(original_image);
    images_panel.add(result_image);
    

    button_open = initializeButton("Open", "../open.png", new ActionListener()
    {

      public void actionPerformed(ActionEvent arg0)
      {

        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("BMP Images", new String[] { "bmp" });
        file_chooser.setFileFilter(filter);
        
        int value = file_chooser.showOpenDialog(frame);
        if (value == 0)
        {
          File file = file_chooser.getSelectedFile();
          String path = file.getPath();
          operator.loadImage(path);
        }
        else
        {
          showInformationMessage("Se canceló la apertura de archivo");
        }
        
      }
    });
    toolbar_panel.add(button_open);
    

    button_save = initializeButton("Save", "../save.png", new ActionListener()
    {
      public void actionPerformed(ActionEvent arg0)
      {
        JFileChooser file_chooser = new JFileChooser();
        file_chooser.setAcceptAllFileFilterUsed(false);
        file_chooser.addChoosableFileFilter(new FileFilter()
        {
          public String getDescription()
          {
            return "BMP Files";
          }
          
          public boolean accept(File f)
          {
            if (f.isDirectory()) {
              return true;
            }
            
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');
            
            if ((i > 0) && (i < s.length() - 1))
            {
              ext = s.substring(i + 1).toLowerCase();
            }
            if (ext != null)
            {
              if (ext.equals("bmp"))
              {
                return true;
              }
              

              return false;
            }
            

            return false;
          }
        });
        int value = file_chooser.showSaveDialog(frame);
        if (value == 0)
        {
          File file = file_chooser.getSelectedFile();
          String path = file.getPath();
          operator.saveResult(path);
        }
        else
        {
          showInformationMessage("Se canceló guardar el archivo");
        }
      }
    });
    toolbar_panel.add(button_save);
    

    button_grayscale = initializeButton("Grayscale", "../gray.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.grayscale();
        }
      });
    toolbar_panel.add(button_grayscale);
    
    button_portapapeles = initializeButton("Portapapeles", "../port.png", 
    	      new ActionListener()
    	      {
    	        public void actionPerformed(ActionEvent arg0)
    	        {
    	          operator.portapapeles();
    	        }
    	      });
    	    toolbar_panel_extra.add(button_portapapeles);
    
    button_flip_vertical = initializeButton("Flip Vertical", "../ver.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.flipVertical();
        }
      });
    toolbar_panel.add(button_flip_vertical);
    
    button_flip_horizontal = initializeButton("Flip Horizontal", "../hor.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.flipHorizontal();
        }
      });
    toolbar_panel.add(button_flip_horizontal);
    
    button_rotate_90 = initializeButton("Rotate 90", "../90.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.rotate90();
        }
      });
    toolbar_panel.add(button_rotate_90);
    
    button_rotate_180 = initializeButton("Rotate 180", "../180.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.rotate180();
        }
      });
    toolbar_panel.add(button_rotate_180);
    
    button_rotate_270 = initializeButton("Rotate 180", "../270.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.rotate270();
        }
      });
    toolbar_panel.add(button_rotate_270);
    
    button_negative = initializeButton("Negative", "../neg.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.negative();
        }
      });
    toolbar_panel.add(button_negative);
    
    button_crop = initializeButton("Crop", "../recorte.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          String ingresado = JOptionPane.showInputDialog("Ingrese ventana de recorte (x1,y1);(x2,y2)", "(x1,y1);(x2,y2)");
          operator.crop(ingresado);
        }
      });
    toolbar_panel.add(button_crop);
    
    button_reduce = initializeButton("Reduce", "../reduce.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          String ingresado = JOptionPane.showInputDialog("Ingrese factor de escala (sx,sy)", "(2,2)");
          operator.reduce(ingresado);
        }
      });
    toolbar_panel.add(button_reduce);
    
    button_brightness = initializeButton("Brightness", "../brillo.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          String input = JOptionPane.showInputDialog("Ingrese brillo a aumentar o disminuir.\n Ej +20 ó -20", "20");
          operator.modifyBrightness(input);
        }
      });
    toolbar_panel.add(button_brightness);
    
    button_contrast = initializeButton("Contrast", "../cont.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          String input = JOptionPane.showInputDialog("Ingrese factor de modifiación de contraste.\n Ej 0.8 para disminuir ó 1.2 para aumentar", "1.2");
          operator.modifyContrast(input);
        }
      });
    toolbar_panel.add(button_contrast);
    
    button_quantization = initializeButton("Quantization", "../cuan.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          String ingresado = JOptionPane.showInputDialog("Ingrese cantidad de tonos", "16");
          operator.quantization(ingresado);
        }
      });
    toolbar_panel_extra.add(button_quantization);
    
    button_histogram = initializeButton("Histogram", "../histo.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.calculateHistogram();
        }
      });
    toolbar_panel_extra.add(button_histogram);
    

    button_filter_one = initializeButton("Filter 1", "../blur.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.filter();
        }
      });
    toolbar_panel_extra.add(button_filter_one);
    
    button_filter_two = initializeButton("Filter 2", "../blur2.png", 
      new ActionListener()
      {
        public void actionPerformed(ActionEvent arg0)
        {
          operator.anotherFilter();
        }
      });
    toolbar_panel_extra.add(button_filter_two);
    button_min = initializeButton("Min", "../min.png", 
  	      new ActionListener()
  	      {
  	        public void actionPerformed(ActionEvent arg0)
  	        {
  	          operator.min();
  	        }
  	      });
  	    toolbar_panel_extra.add(button_min);
  	    
  	    button_max = initializeButton("Max", "../max.png", 
  	  	      new ActionListener()
  	  	      {
  	  	        public void actionPerformed(ActionEvent arg0)
  	  	        {
  	  	          operator.max();
  	  	        }
  	  	      });
  	  	    toolbar_panel_extra.add(button_max);
  	  	button_mediana = initializeButton("Mediana", "../mediana.png", 
    	  	      new ActionListener()
    	  	      {
    	  	        public void actionPerformed(ActionEvent arg0)
    	  	        {
    	  	          operator.mediana();
    	  	        }
    	  	      });
    	  	    toolbar_panel_extra.add(button_mediana);
  	  	button_back = initializeButton("Back", "../back.png", 
    	  	      new ActionListener()
    	  	      {
    	  	        public void actionPerformed(ActionEvent arg0)
    	  	        {
    	  	          operator.back();
    	  	        }
    	  	      });
    	  	    toolbar_panel_extra.add(button_back);
    
    
    
    
    

    frame.setResizable(false);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
 
	    
  

  private JButton initializeButton(String name, String resource_path, ActionListener action_listener)
  {
    JButton button = new JButton(name);
    URL url = getClass().getResource(resource_path);
    if (url != null)
    {
      button.setIcon(new ImageIcon(url));
      button.setText("");
      button.setSize(40, 40);
    }
    else
    {
      System.out.println("No se pudo cargar la imagen, no se encontra el path a: " + resource_path);
    }
    button.addActionListener(action_listener);
    return button;
  }
  
  public void showOriginal(Pixel[][] pixels, int width, int height)
  {
    BufferedImage image = transformToBufferedImage(pixels, width, height);
    ImageIcon image_icon = new ImageIcon(image);
    original_image.setText("");
    original_image.setIcon(image_icon);
    
    frame.pack();
    frame.setExtendedState(6);
    frame.repaint();
  }
  
  public void showResult(Pixel[][] pixels, int width, int height)
  {
    BufferedImage image = transformToBufferedImage(pixels, width, height);
    ImageIcon image_icon = new ImageIcon(image);
    result_image.setText("");
    result_image.setIcon(image_icon);
    
    frame.pack();
    frame.setExtendedState(6);
    frame.repaint();
  }
  
  private BufferedImage transformToBufferedImage(Pixel[][] pixels, int width, int height)
  {
    BufferedImage image = new BufferedImage(width, height, 2);
    
    for (int i = 0; i < height; i++)
    {
      for (int j = 0; j < width; j++)
      {
        Color c = new Color(pixels[i][j].getR(), pixels[i][j].getG(), pixels[i][j].getB());
        image.setRGB(j, i, c.getRGB());
      }
    }
    return image;
  }
  


  public void showErrorMessage(String message)
  {
    JOptionPane.showMessageDialog(frame, message, "¡Error!", 0);
  }
  


  public void showWarningMessage(String message)
  {
    JOptionPane.showMessageDialog(frame, message, "¡Atención!", 2);
  }
  


  public void showInformationMessage(String message)
  {
    JOptionPane.showMessageDialog(frame, message, "Información", 1);
  }
}
