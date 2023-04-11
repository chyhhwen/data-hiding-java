import java.io.*;
import java.util.Vector;

public class read_txt
{
    public read_txt()
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
        Vector r = new Vector();
        Vector g = new Vector();
        Vector b = new Vector();
        for(int i = 0;i < v.size();i++)
        {
            System.out.print(v.get(i) + " ");
            if(i % 3 == 0)
            {
                r.add(v.get(i));
            }
            if(i % 3 == 1)
            {
                g.add(v.get(i));
            }
            if(i % 3 == 2)
            {
                b.add(v.get(i));
            }
        }
        System.out.println();
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
    }
    public static void main(String[] args) throws IOException
    {
        new read_txt();
    }
}
