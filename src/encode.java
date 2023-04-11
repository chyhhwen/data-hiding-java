import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;

public class encode
{
    public static void get_rgb(List<File> files, String newFileName, int time)
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
            System.out.println("===新增成功===");
        }
        catch (Exception e)
        {
            System.out.println("===新增失敗===");
            e.printStackTrace();
        }
    }
    public static void mix_rgb(List<File> files, String newFileName,int use, Vector r1, Vector g1 ,Vector b1)
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
            int o = 0;
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
                    if(r > 9)
                    {
                        r -= 9;
                    }
                    if(g > 9)
                    {
                        g -= 9;
                    }
                    if(b > 9)
                    {
                        b -= 9;
                    }
                    if(use == 1)
                    {
                        if(o < r1.size())
                        {
                            r += (int) r1.get(o);
                        }
                        if(o < g1.size())
                        {
                            g += (int) g1.get(o);
                        }
                        if(o < b1.size())
                        {
                            b += (int) b1.get(o);
                        }
                        o += 1;
                    }
                    int rgb=new Color(r,g,b).getRGB();
                    imgNew.setRGB(i, j,rgb);
                }
            }

            File outFile = new File("C:/Users/User/Desktop/data-hiding/pic/" + newFileName);
            ImageIO.write(imgNew, "jpg", outFile);// 寫圖片
            System.out.println("===合成成功===");
        }
        catch (Exception e)
        {
            System.out.println("===合成失敗===");
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

    public static void main(String[] args) throws IOException
    {
        /*產生rgb*/
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
            get_rgb(files, newFileName , i);
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
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
        /*產生公鑰和傳送檔*/
        List<File> files1 = new ArrayList<>();
        File file1 = new File("C:/Users/User/Desktop/data-hiding/pic/r.jpg");
        File file2 = new File("C:/Users/User/Desktop/data-hiding/pic/g.jpg");
        File file3 = new File("C:/Users/User/Desktop/data-hiding/pic/b.jpg");
        files1.add(file1);
        files1.add(file2);
        files1.add(file3);
        newFileName = "key.jpg";
        mix_rgb(files1, newFileName,0,r,g,b);
        newFileName = "box.jpg";
        mix_rgb(files1, newFileName,1,r,g,b);

    }
}
