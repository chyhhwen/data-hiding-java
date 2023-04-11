import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class decode
{
    public static void fix(List<File> files)
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
            for (int i = 0; i < 1; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    Color img1 = new Color(imgs[0].getRGB(i,j));
                    int r0 = img1.getRed();
                    int g0 = img1.getGreen();
                    int b0 = img1.getBlue();
                    Color img2 = new Color(imgs[1].getRGB(i,j));
                    int r1 = img2.getRed();
                    int g1 = img2.getGreen();
                    int b1 = img2.getBlue();
                    System.out.println("("+(r1 - r0)+","+(g1 - g0)+","+(b1 - b0)+")");

                }
            }

        }
        catch (Exception e)
        {
            System.out.println("===讀取失敗===");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        List<File> files = new ArrayList<>();
        File file1 = new File("C:/Users/User/Desktop/data-hiding/pic/key.jpg");
        File file2 = new File("C:/Users/User/Desktop/data-hiding/pic/box.jpg");
        files.add(file1);
        files.add(file2);
        fix(files);
    }
}
