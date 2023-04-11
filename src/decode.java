import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class decode
{
    public static void fix(List<File> files)
    {
        try
        {
            BufferedImage[] imgs = new BufferedImage[files.size()];

            for (int i = 0; i < files.size(); i++)
            {
                imgs[i] = ImageIO.read(files.get(i));
            }

            BufferedImage imgNew = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < 255; i++)
            {
                for (int j = 0; j < 255; j++)
                {
                    int r0 = (imgs[0].getRGB(i,j) >> 16) & 0xFF;
                    int g0 = (imgs[0].getRGB(i,j) >> 8) & 0xFF;
                    int b0 = (imgs[0].getRGB(i,j) >> 0) & 0xFF;
                    int r1 = (imgs[1].getRGB(i,j) >> 16) & 0xFF;
                    int g1 = (imgs[1].getRGB(i,j) >> 8) & 0xFF;
                    int b1 = (imgs[1].getRGB(i,j) >> 0) & 0xFF;
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
        File file1 = new File("C:/Users/User/Desktop/data-hiding/pic/mix.jpg");
        File file2 = new File("C:/Users/User/Desktop/data-hiding/pic/key.jpg");
        files.add(file1);
        files.add(file2);
        fix(files);
    }
}
