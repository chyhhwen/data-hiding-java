import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class get_rgb
{
    public static void jointPic(List<File> files, String newFileName, int time)
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
            int size = 4;
            for (int i = 0; i < width; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    Color img = new Color(imgs[0].getRGB(i,j));
                    int r = img.getRed();
                    int g = img.getGreen();
                    int b = img.getBlue();
                    if(time == 0)
                    {
                        g = 0;
                        b = 0;
                    }
                    if(time == 1)
                    {
                        r = 0;
                        b = 0;
                    }
                    if(time == 2)
                    {
                        r = 0;
                        g = 0;
                    }
                    int rgb=new Color(r,g ,b).getRGB();
                    imgNew.setRGB(i, j,rgb);
                }
            }

            File outFile = new File("C:/Users/User/Desktop/data-hiding/pic/" + newFileName);
            ImageIO.write(imgNew, "jpg", outFile);
            System.out.println("===更改成功===");
        }
        catch (Exception e)
        {
            System.out.println("===更改失敗===");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        List<File> files = new ArrayList<>();
        String newFileName = "";
        File file = new File("C:/Users/User/Desktop/data-hiding/pic/data.jpg");
        files.add(file);
        for(int i=0;i<3;i++)
        {
            if(i == 0)
            {
                newFileName = "r.jpg";
            }
            if(i == 1)
            {
                newFileName = "g.jpg";
            }
            if(i == 2)
            {
                newFileName = "b.jpg";
            }
            jointPic(files, newFileName , i);
        }

    }
}
