import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;

/**
 * Project name(项目名称)：字符流
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)：
 * 字符文件输出流
 * Java 提供了写入字符文件的便捷类——FileWriter，该类的构造方法有如下 4 种重载形式。
 * FileWriter(File file)：在指定 File 对象的情况下构造一个 FileWriter 对象。其中，file 表示要写入数据的 File 对象。
 * FileWriter(File file,boolean append)：在指定 File 对象的情况下构造一个 FileWriter 对象，
 * 如果 append 的值为 true，则将字节写入文件末尾，而不是写入文件开始处。
 * FileWriter(String fileName)：在指定文件名的情况下构造一个 FileWriter 对象。其中，fileName 表示要写入字符的文件名，表示的是完整路径。
 * FileWriter(String fileName,boolean append)：在指定文件名以及要写入文件的位置的情况下构造 FileWriter 对象。
 * 其中，append 是一个 boolean 值，如果为 true，则将数据写入文件末尾，而不是文件开始处。
 * FileWriter 类的创建不依赖于文件存在与否，如果关联文件不存在，则会自动生成一个新的文件。在创建文件之前，
 * FileWriter 将在创建对象时打开它作为输出。如果试图打开一个只读文件，将引发一个 IOException 异常。
 */

@SuppressWarnings("all")
public class test1
{
    public static double getDoubleRandom(double min, double max)  //double型随机数
    {
        if (min > max)
        {
            min = max;
        }
        return min + (Math.random() * (max - min));
    }

    public static double getDoubleRandom(double min, double max, String format)
    {            //空间复杂度和时间复杂度都特别高，只适合获取非常少的格式化的随机数使用。farmat：##.##或00.00
        DecimalFormat decimalFormat = new DecimalFormat(format);
        if (min > max)
        {
            min = max;
        }
        return Double.parseDouble(decimalFormat.format(min + (Math.random() * (max - min))));
    }

    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        FileWriter fileWriter1 = null;
        FileWriter fileWriter2 = null;
        try
        {
            fileWriter1 = new FileWriter("fileWrite-out1.txt");
            fileWriter2 = new FileWriter("fileWrite-out2.txt", true);
            for (int i = 1; i <= 500; i++)
            {
                String str = i + ":" + getDoubleRandom(5000, 2000000) + "\n";
                fileWriter1.write(str);
            }
            for (int i = 1; i <= 500; i++)
            {
                String str = i + ":" + getDoubleRandom(5000, 2000000) + "\n";
                fileWriter2.write(str);
            }
            System.out.println("写入完成");
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到");
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileWriter1 != null)
                {
                    fileWriter1.close();
                }
                if (fileWriter2 != null)
                {
                    fileWriter2.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
