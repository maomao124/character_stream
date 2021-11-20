import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 * Project name(项目名称)：字符流
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 字符缓冲区输入流
 * BufferedReader 类主要用于辅助其他字符输入流，它带有缓冲区，可以先将一批数据读到内存缓冲区。
 * 接下来的读操作就可以直接从缓冲区中获取数据，而不需要每次都从数据源读取数据并进行字符编码转换，这样就可以提高数据的读取效率。
 * BufferedReader 类的构造方法有如下两种重载形式。
 * BufferedReader(Reader in)：创建一个 BufferedReader 来修饰参数 in 指定的字符输入流。
 * BufferedReader(Reader in,int size)：创建一个 BufferedReader 来修饰参数 in 指定的字符输入流，参数 size 则用于指定缓冲区的大小，单位为字符。
 * 除了可以为字符输入流提供缓冲区以外，BufferedReader 还提供了 readLine() 方法，该方法返回包含该行内容的字符串，
 * 但该字符串中不包含任何终止符，如果已到达流末尾，则返回 null。readLine() 方法表示每次读取一行文本内容，
 * 当遇到换行（\n）、回车（\r）或回车后直接跟着换行标记符即可认为某行已终止。
 * 字符缓冲区输出流
 * BufferedWriter 类主要用于辅助其他字符输出流，它同样带有缓冲区，可以先将一批数据写入缓冲区，当缓冲区满了以后，
 * 再将缓冲区的数据一次性写到字符输出流，其目的是为了提高数据的写效率。
 * BufferedWriter 类的构造方法有如下两种重载形式。
 * BufferedWriter(Writer out)：创建一个 BufferedWriter 来修饰参数 out 指定的字符输出流。
 * BufferedWriter(Writer out,int size)：创建一个 BufferedWriter 来修饰参数 out 指定的字符输出流，参数 size 则用于指定缓冲区的大小，单位为字符。
 * 该类除了可以给字符输出流提供缓冲区之外，还提供了一个新的方法 newLine()，该方法用于写入一个行分隔符。
 * 行分隔符字符串由系统属性 line.separator 定义，并且不一定是单个新行（\n）符。
 */

@SuppressWarnings("all")
public class test2
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        File file = new File("fileTest2.txt");
        FileWriter fileWriter = null;
        //BufferedWriter bufferedWriter = null;
        try
        {
            fileWriter = new FileWriter(file, false);
            //bufferedWriter = new BufferedWriter(fileWriter);
            String str;
            for (int i = 0; i < 10000; i++)
            {
                str = Integer.toHexString(getIntRandom(1048576, 16777215));
                fileWriter.write(str);
                //bufferedWriter.newLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("文件打开失败！！！");
            Toolkit.getDefaultToolkit().beep();
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileWriter != null)
                {
                    fileWriter.close();
                }
                //if (bufferedWriter != null)
                //{
                //   bufferedWriter.close();
                //}
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        {
            //------------------------------------------------------
            long startTime = System.nanoTime();   //获取开始时间
            //------------------------------------------------------
            FileReader fr = null;
            BufferedReader br = null;
            try
            {
                fr = new FileReader(file); // 创建 FileReader 对象
                br = new BufferedReader(fr); // 创建 BufferedReader 对象
                System.out.println("路径" + file.getAbsolutePath() + "文件中的内容如下：");
                String strLine;
                while ((strLine = br.readLine()) != null)
                {
                    System.out.println(strLine);
                }
            }
            catch (FileNotFoundException e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("文件打开失败");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                System.out.println("其它错误");
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (fr != null)
                    {
                        fr.close(); // 关闭 FileReader 对象
                    }
                    if (br != null)
                    {
                        br.close();
                    }
                }
                catch (IOException e)
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

        {          //速度对比
            //------------------------------------------------------
            long startTime = System.nanoTime();   //获取开始时间
            //------------------------------------------------------
            FileReader fr = null;
            try
            {
                fr = new FileReader(file); // 创建 FileReader 对象
                System.out.println("路径" + file.getAbsolutePath() + "文件中的内容如下：");
                int str;
                while ((str = fr.read()) != -1)
                {
                    System.out.print((char) str);
                }
            }
            catch (FileNotFoundException e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("文件打开失败");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                System.out.println("其它错误");
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (fr != null)
                    {
                        fr.close(); // 关闭 FileReader 对象
                    }
                }
                catch (IOException e)
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
        System.out.println();
        System.out.println("文件" + file.getName() + "的长度：" + file.length() + "字节 =" +
                String.format("%.2f",(float)file.length() / 1024) + "KB");
    }
}
