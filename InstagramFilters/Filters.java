import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class Filters {

  public static void main(String[] args)throws IOException {
    Scanner scanner = new Scanner(System.in);
    // TODO: modify this main method as you wish, to run and test your filter implementations.

    // Read in the image file.
    File f = new File("dog.png");
    BufferedImage img = ImageIO.read(f);
    BufferedImage img1 = ImageIO.read(f);
    BufferedImage img2 = ImageIO.read(f);
    BufferedImage img3 = ImageIO.read(f);
    BufferedImage img4 = ImageIO.read(f);
    BufferedImage img5 = ImageIO.read(f);

    // For debugging
    System.out.println("Before:");
    System.out.println(Utilities.getRGBArray(1, 1, img)[0]);
    System.out.println(Utilities.getRGBArray(1, 1, img)[1]);
    System.out.println(Utilities.getRGBArray(1, 1, img)[2]);
    // 92 40 27

    // Apply a filter implementation on img.
    applyGrayscale(img);

    // For debugging
    System.out.println("After:");
    System.out.println(Utilities.getRGBArray(0, 0, img)[0]);
    System.out.println(Utilities.getRGBArray(0, 0, img)[1]);
    System.out.println(Utilities.getRGBArray(0, 0, img)[2]);
    // 53 53 53

    // Write the result to a new image file.
    f = new File("dog_filtered.png");
    ImageIO.write(img, "png", f);

    applyNorak(img1);
    f = new File("dog_filtered1.png");
    ImageIO.write(img1, "png", f);
    int color1=0;
    int color2=0;
    int color3=0;
    int borderThickness=0;
    int borderColor[]=new int[3];
    System.out.println("What is your border color? Insert the coordinates one each time from 0 to 255.");
    color1 = scanner.nextInt();
    borderColor[0]=color1; 
    color2 = scanner.nextInt();
    borderColor[1]=color2; 
    color1 = scanner.nextInt();
    borderColor[2]=color2;    
    System.out.println("What is gonna be the thickness of your border?");
    borderThickness=scanner.nextInt();
    applyBorder(img2,borderThickness,borderColor);
    f = new File("dog_filtered2.png");
    ImageIO.write(img2, "png", f);

    //System.out.println("After:");
    //System.out.println(Utilities.getRGBArray(0, 0, img)[0]);
    //System.out.println(Utilities.getRGBArray(0, 0, img)[1]);
    //System.out.println(Utilities.getRGBArray(0, 0, img)[2]);
    // 53 53 53

    // Write the result to a new image file.
   

    applyMirror(img3);
    f = new File("dog_filtered3.png");
    ImageIO.write(img3, "png", f);

    //System.out.println("After:");
    //System.out.println(Utilities.getRGBArray(0, 0, img)[0]);
    //System.out.println(Utilities.getRGBArray(0, 0, img)[1]);
    //System.out.println(Utilities.getRGBArray(0, 0, img)[2]);
    // 53 53 53

    // Write the result to a new image file.
    //f = new File("dog_filtered3.png");
    //ImageIO.write(img, "png", f);

    applyBlur(img4);
    f = new File("dog_filtered4.png");
    ImageIO.write(img4, "png", f);

    applyCustom(img5);
    f = new File("dog_filtered5.png");
    ImageIO.write(img5, "png", f);

  }


  public static void applyGrayscale(BufferedImage img) {
    int average1=0;
    int [] average=new int [3];

      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
        
          average1=(Utilities.getRGBArray(x,y,img)[0]+Utilities.getRGBArray(x,y,img)[1]+Utilities.getRGBArray(x,y,img)[2])/3;

          average[0] = average1;
          average[1] = average1;
          average[2] = average1;
          // average={average1,average1,average1};
          Utilities.setRGB(average,x,y,img);
          average1=0;
          //average[]={};

        
        
    }
    // TODO
  }
}
 public static void applyNorak(BufferedImage img) {
     int [] average=new int [3];
     int average1=0;
      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
          average1=(Utilities.getRGBArray(x,y,img)[0]+Utilities.getRGBArray(x,y,img)[1]+Utilities.getRGBArray(x,y,img)[2])/3;
          if(average1>153){
          average[0] = average1;
          average[1] = average1;
          average[2] = average1;
          Utilities.setRGB(average,x,y,img);
          average1=0;
          }
        }
      }
    // TODO
  }

  public static void applyBorder(BufferedImage img, int borderThickness, int[] borderColor) {
    int [] RGB=new int [3];
    int [][][]ImagePicture=new int[img.getHeight()][img.getWidth()][3];
      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
        
              ImagePicture[x][y][0]=Utilities.getRGBArray(x, y, img)[0];
              ImagePicture[x][y][1]=Utilities.getRGBArray(x, y, img)[1];
              ImagePicture[x][y][2]=Utilities.getRGBArray(x, y, img)[2];

        }
      }
          // average={average1,average1,average1};
      for(int a=0;a<img.getHeight();a++){
        for(int b=0;b<img.getWidth();b++){
          if(a<borderThickness || b<borderThickness || a>=img.getHeight()-borderThickness || b>=img.getWidth()-borderThickness){

            Utilities.setRGB(borderColor,a,b,img);
          

          }else{
          RGB[0]=ImagePicture[a][b][0];
          RGB[1]=ImagePicture[a][b][1];
          RGB[2]=ImagePicture[a][b][2];
          
          Utilities.setRGB(RGB,a,b,img);
          }

       } 
    
    // TODO
  }
    // TODO
  }

  public static void applyMirror(BufferedImage img) {

    int [] RGB=new int [3];
    int [][][]ImagePicture=new int[img.getHeight()][img.getWidth()][3];
      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
        
              ImagePicture[x][y][0]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[0];
              ImagePicture[x][y][1]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[1];
              ImagePicture[x][y][2]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[2];

        }
      }
          // average={average1,average1,average1};
      for(int a=0;a<img.getHeight();a++){
        for(int b=0;b<img.getWidth();b++){
          RGB[0]=ImagePicture[a][b][0];
          RGB[1]=ImagePicture[a][b][1];
          RGB[2]=ImagePicture[a][b][2];
          Utilities.setRGB(RGB,a,b,img);

          //average[]={};

        
       } 
    
    // TODO
  }
    // TODO
  }

  public static void applyBlur(BufferedImage img) {
    // TODO
    int [] RGB=new int [3];
    int [][][]ImagePicture=new int[img.getHeight()][img.getWidth()][3];
      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
        
              ImagePicture[x][y][0]=Utilities.getRGBArray(x, y, img)[0];
              ImagePicture[x][y][1]=Utilities.getRGBArray(x, y, img)[1];
              ImagePicture[x][y][2]=Utilities.getRGBArray(x, y, img)[2];

        }
      }
          // average={average1,average1,average1};
      for(int a=0;a<img.getHeight();a++){
        for(int b=0;b<img.getWidth();b++){
          if(a==0 || b==0 || a==img.getHeight()-1||b==img.getWidth()-1){
            RGB[0]=Utilities.getRGBArray(a,b,img)[0];
            RGB[1]=Utilities.getRGBArray(a,b,img)[1];
            RGB[2]=Utilities.getRGBArray(a,b,img)[2];
            Utilities.setRGB(RGB,a,b,img);
          

          }else{
          RGB[0]=(ImagePicture[a][b][0]+ImagePicture[a+1][b][0]+ImagePicture[a+1][b+1][0]+ImagePicture[a][b+1][0]+ImagePicture[a-1][b][0]+ImagePicture[a-1][b-1][0]+ImagePicture[a][b-1][0]+ImagePicture[a+1][b-1][0]+ImagePicture[a-1][b+1][0])/9;
          RGB[1]=(ImagePicture[a][b][1]+ImagePicture[a+1][b][1]+ImagePicture[a+1][b+1][1]+ImagePicture[a][b+1][1]+ImagePicture[a-1][b][1]+ImagePicture[a-1][b-1][1]+ImagePicture[a][b-1][1]+ImagePicture[a+1][b-1][1]+ImagePicture[a-1][b+1][1])/9;
          RGB[2]=(ImagePicture[a][b][2]+ImagePicture[a+1][b][2]+ImagePicture[a+1][b+1][2]+ImagePicture[a][b+1][2]+ImagePicture[a-1][b][2]+ImagePicture[a-1][b-1][2]+ImagePicture[a][b-1][2]+ImagePicture[a+1][b-1][2]+ImagePicture[a-1][b+1][2])/9;
          
          Utilities.setRGB(RGB,a,b,img);
          }

       } 
    
    // TODO
  }
    // TODO
}

  public static void applyCustom(BufferedImage img) {
        int [] RGB=new int [3];
    int [][][]ImagePicture=new int[img.getHeight()][img.getWidth()][3];
      for(int x=0;x<img.getHeight();x++){
        for(int y=0;y<img.getWidth();y++){
        
              ImagePicture[x][y][0]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[0];
              ImagePicture[x][y][1]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[1];
              ImagePicture[x][y][2]=Utilities.getRGBArray(x, img.getWidth()-1-y, img)[2];

        }
      }
          // average={average1,average1,average1};
      for(int a=0;a<img.getHeight();a++){
        for(int b=0;b<img.getWidth();b++){
          RGB[0]=255-ImagePicture[a][b][0];
          RGB[1]=(255-ImagePicture[a][b][1])/2;
          RGB[2]=(255-ImagePicture[a][b][2])/3;
          Utilities.setRGB(RGB,a,b,img);

          //average[]={};

        
       } 
    
    // TODO
  }
    // TODO
  }
}
