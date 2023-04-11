import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;

public class encode
{
    public static void get_key(List<File> files, String newFileName)
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
                    int r = (imgs[0].getRGB(i,j) >> 16) & 0xFF;
                    int g = (imgs[0].getRGB(i,j) >> 8) & 0xFF;
                    int b = (imgs[0].getRGB(i,j) >> 0) & 0xFF;
                    if(r > size)
                    {
                        r -= size;
                    }
                    if(g > size)
                    {
                        g -= size;
                    }
                    if(b > size)
                    {
                        b -= size;
                    }
                    int rgb=new Color(r,g ,b).getRGB();
                    imgNew.setRGB(i, j,rgb);
                }
            }

            File outFile = new File("C:/Users/User/Desktop/data-hiding/pic/" + newFileName);
            ImageIO.write(imgNew, "jpg", outFile);
            System.out.println("===生產成功===");
        }
        catch (Exception e)
        {
            System.out.println("===生產失敗===");
            e.printStackTrace();
        }
    }
    public static void get_rgb(List<File> files, String newFileName, int time)
    {
        File pic = new File("C:/Users/User/Desktop/data-hiding/pic/key.jpg");
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
                    int r = (imgs[0].getRGB(i,j) >> 16) & 0xFF;
                    int g = (imgs[0].getRGB(i,j) >> 8) & 0xFF;
                    int b = (imgs[0].getRGB(i,j) >> 0) & 0xFF;
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
    public static void read_txt(Vector r,Vector g, Vector b)
    {
        File input = new File( "C:/Users/User/Desktop/data-hiding/txt/input.txt");
        Vector v = new Vector();
        try
        {
            FileReader read = new FileReader(input);
            BufferedReader buff = new BufferedReader(read);
            try
            {
                String text;
                while((text = buff.readLine()) != null)
                {
                    System.out.println(text);
                    for(int i = 0;i < text.length();i++)
                    {
                        if((int)text.charAt(i) == 32)
                        {
                            v.add(0);
                        }
                        else
                        {
                            if((int)text.charAt(i) > 64 && (int)text.charAt(i) <= 90)
                            {
                                v.add((int)text.charAt(i) - 64);
                            }
                            if((int)text.charAt(i) > 96 && (int)text.charAt(i) <= 121)
                            {
                                v.add((int)text.charAt(i) - 96);
                            }
                        }

                    }
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        for(int i = 0;i < v.size();i++)
        {
            System.out.print(v.get(i) + " ");
            if(i % 3 == 0)
            {
                r.add((int)v.get(i) / 10);
                r.add((int)v.get(i) % 10);
            }
            if(i % 3 == 1)
            {
                g.add((int)v.get(i) / 10);
                g.add((int)v.get(i) % 10);
            }
            if(i % 3 == 2)
            {
                b.add((int)v.get(i) / 10);
                b.add((int)v.get(i) % 10);
            }
        }
        System.out.println();
    }

    public static void put_rgb(List<File> files, String newFileName,int time,Vector v)
    {
        File pic = new File("C:/Users/User/Desktop/data-hiding/pic/key.jpg");
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
            int max = v.size();
            BufferedImage imgNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int o = 0;
            for (int i = 0; i < width; i++)
            {
                for (int j = 0; j < height; j++)
                {
                    int r = (imgs[time].getRGB(i,j) >> 16) & 0xFF;
                    int g = (imgs[time].getRGB(i,j) >> 8) & 0xFF;
                    int b = (imgs[time].getRGB(i,j) >> 0) & 0xFF;
                    if(time == 0)
                    {
                        if(o < max)
                        {
                            r += (int)v.get(o) - 36;
                            System.out.print(r + " ");
                            o += 1;
                        }
                    }
                    if(time == 1)
                    {
                        if(o < max)
                        {
                            g += (int)v.get(o) - 37;
                            System.out.print(g + " ");
                            o += 1;
                        }
                    }
                    if(time == 2)
                    {
                        if(o < max)
                        {
                            b += (int)v.get(o) - 36;
                            System.out.print(b + " ");
                            o += 1;
                        }
                    }
                    int rgb=new Color(r,g ,b).getRGB();
                    imgNew.setRGB(i, j,rgb);
                }
            }

            File outFile = new File("C:/Users/User/Desktop/data-hiding/pic/" + newFileName);
            ImageIO.write(imgNew, "jpg", outFile);
            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("===生產失敗===");
            e.printStackTrace();
        }
    }

    public static void mix_rgb(List<File> files, String newFileName)
    {
        File pic = new File("C:/Users/User/Desktop/data-hiding/pic/key.jpg");
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
                    int r = (imgs[0].getRGB(i,j) >> 16) & 0xFF;
                    int g = (imgs[1].getRGB(i,j) >> 8) & 0xFF;
                    int b = (imgs[2].getRGB(i,j) >> 0) & 0xFF;
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
        /*產生公鑰*/
        List<File> files1 = new ArrayList<>();
        String newFileName = "key.jpg";
        File file = new File("C:/Users/User/Desktop/data-hiding/pic/data.jpg");
        files1.add(file);
        get_key(files1, newFileName);
        /*產生rgb*/
        List<File> files2 = new ArrayList<>();
        files2.add(file);
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
            get_rgb(files2, newFileName , i);
        }
        /*讀取txt*/
        Vector r = new Vector();
        Vector g = new Vector();
        Vector b = new Vector();
        read_txt(r,g,b);
        for(int i = 0;i < r.size();i++)
        {
            System.out.print(r.get(i) + " ");
        }
        System.out.println();
        for(int i = 0;i < g.size();i++)
        {
            System.out.print(g.get(i) + " ");
        }
        System.out.println();
        for(int i = 0;i < b.size();i++)
        {
            System.out.print(b.get(i) + " ");
        }
        System.out.println();
        /*資料寫入*/
        List<File> files3 = new ArrayList<>();
        File file1 = new File("C:/Users/User/Desktop/data-hiding/pic/r.jpg");
        File file2 = new File("C:/Users/User/Desktop/data-hiding/pic/g.jpg");
        File file3 = new File("C:/Users/User/Desktop/data-hiding/pic/b.jpg");
        files3.add(file1);
        files3.add(file2);
        files3.add(file3);
        newFileName = "put_r.jpg";
        put_rgb(files3, newFileName , 0,r);
        newFileName = "put_g.jpg";
        put_rgb(files3, newFileName , 1,g);
        newFileName = "put_b.jpg";
        put_rgb(files3, newFileName , 2,b);
        /*照片合成*/
        List<File> files4 = new ArrayList<>();
        newFileName = "mix.jpg";
        File file4 = new File("C:/Users/User/Desktop/data-hiding/pic/put_r.jpg");
        File file5 = new File("C:/Users/User/Desktop/data-hiding/pic/put_g.jpg");
        File file6 = new File("C:/Users/User/Desktop/data-hiding/pic/put_b.jpg");
        files4.add(file4);
        files4.add(file5);
        files4.add(file6);
        mix_rgb(files4, newFileName);
    }
}
