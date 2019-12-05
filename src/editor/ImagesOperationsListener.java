package editor;

public abstract interface ImagesOperationsListener
{
  public abstract void loadImage(String paramString);
  
  public abstract void saveResult(String paramString);
  
  public abstract void grayscale();
  
  public abstract void negative();
  
  public abstract void flipVertical();
  
  public abstract void flipHorizontal();
  
  public abstract void rotate90();
  
  public abstract void rotate180();
  
  public abstract void rotate270();
  
  public abstract void crop(String paramString);
  
  public abstract void quantization(String paramString);
  
  public abstract void reduce(String paramString);
  
  public abstract void calculateHistogram();
  
  public abstract void modifyBrightness(String paramString);
  
  public abstract void modifyContrast(String paramString);
  
  public abstract void filter();
  
  public abstract void anotherFilter();

  public abstract void portapapeles();

  public abstract void min();

  public abstract void max();

  public abstract void back();

  public abstract void mediana();
}
