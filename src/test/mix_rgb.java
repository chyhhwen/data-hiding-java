import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class mix_rgb
{
    public static void jointPic(List<File> files, String newFileName,int use)
    {
        File pic = new File("C:/Users/User/Desktop/data-hiding/pic/data.jpg");
        int width = 0;
        int height = 0;
        try
        {
            BufferedImage img = ImageIO.read(new FileInputStream(pic));
            width = img.getWidth();
            height = img.getHeight();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            BufferedImage[] imgs = new BufferedImage[files.size()];

            for (int i = 0; i < files.size(); i++)
            {
                imgs[i] = ImageIO.read(files.get(i));
            }

            BufferedImage imgNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < width; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    Color img1 = new Color(imgs[0].getRGB(i,j));
                    Color img2 = new Color(imgs[1].getRGB(i,j));
                    Color img3 = new Color(imgs[2].getRGB(i,j));
                    int r = img1.getRed();
                    int g = img2.getGreen();
                    int b = img3.getBlue();
                    if(use == 1)
                    {
                        if(r > 4)
                        {
                            r -= 4;
                        }
                        if(g > 4)
                        {
                            g -= 4;
                        }
                        if(b > 4)
                        {
                            b -= 4;
                        }
                    }
                    int rgb=new Color(r,g,b).getRGB();
                    imgNew.setRGB(i, j,rgb);
                }
            }

            File outFile = new File("C:/Users/User/Desktop/data-hiding/pic/" + newFileName);
            ImageIO.write(imgNew, "jpg", outFile);// 寫圖片
            System.out.println("===合併成功===");
        }
        catch (Exception e)
        {
            System.out.println("===合併失敗===");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        List<File> files = new ArrayList<>();
        String newFileName = "key.jpg";
        File file1 = new File("C:/Users/User/Desktop/data-hiding/pic/r.jpg");
        File file2 = new File("C:/Users/User/Desktop/data-hiding/pic/g.jpg");
        File file3 = new File("C:/Users/User/Desktop/data-hiding/pic/b.jpg");
        files.add(file1);
        files.add(file2);
        files.add(file3);
        jointPic(files, newFileName,0);
        newFileName = "box.jpg";
        jointPic(files, newFileName,1);
    }
}
