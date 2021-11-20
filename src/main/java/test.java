import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Project name(项目名称)：字符流
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)：
 * 字符输入流
 * Reader 类是所有字符流输入类的父类，该类定义了许多方法，这些方法对所有子类都是有效的。
 * Reader 类的常用子类如下。
 * CharArrayReader 类：将字符数组转换为字符输入流，从中读取字符。
 * StringReader 类：将字符串转换为字符输入流，从中读取字符。
 * BufferedReader 类：为其他字符输入流提供读缓冲区。
 * PipedReader 类：连接到一个 PipedWriter。
 * InputStreamReader 类：将字节输入流转换为字符输入流，可以指定字符编码。
 * Reader类中的read()方法
 * 方法名及返回值类型	说明
 * int read()	从输入流中读取一个字符，并把它转换为 0~65535 的整数。如果返回 -1， 则表示
 * 已经到了输入流的末尾。为了提高 I/O 操作的效率，建议尽量使用下面两种 read()方法
 * int read(char[] cbuf)	从输入流中读取若干个字符，并把它们保存到参数 cbuf 指定的字符数组中。 该方
 * 法返回读取的字符数，如果返回 -1，则表示已经到了输入流的末尾
 * int read(char[] cbuf,int off,int len)	从输入流中读取若干个字符，并把它们保存到参数 cbuf 指定的字符数组中。其中，
 * off 指定在字符数组中开始保存数据的起始下标，len 指定读取的字符数。该方法返
 * 回实际读取的字符数，如果返回 -1，则表示已经到了输入流的末尾
 * 字符输出流
 * 与 Reader 类相反，Writer 类是所有字符输出流的父类，该类中有许多方法，这些方法对继承该类的所有子类都是有效的。
 * Writer 类的常用子类如下。
 * CharArrayWriter 类：向内存缓冲区的字符数组写数据。
 * StringWriter 类：向内存缓冲区的字符串（StringBuffer）写数据。
 * BufferedWriter 类：为其他字符输出流提供写缓冲区。
 * PipedWriter 类：连接到一个 PipedReader。
 * OutputStreamReader 类：将字节输出流转换为字符输出流，可以指定字符编码。
 * Writer类中的write()方法和append()方法
 * 方法名及返回值类型	说明
 * void write(int c)	向输出流中写入一个字符
 * void write(char[] cbuf)	把参数 cbuf 指定的字符数组中的所有字符写到输出流中
 * void write(char[] cbuf,int off,int len)	把参数 cbuf 指定的字符数组中的若干字符写到输出流中。其中，off 指定
 * 字符数组中的起始下标，len 表示元素个数
 * void write(String str)	向输出流中写入一个字符串
 * void write(String str, int off,int len)	向输出流中写入一个字符串中的部分字符。其中，off 指定字符串中的起
 * 始偏移量，len 表示字符个数
 * append(char c)	将参数 c 指定的字符添加到输出流中
 * append(charSequence esq)	将参数 esq 指定的字符序列添加到输出流中
 * append(charSequence esq,int start,int end)	将参数 esq 指定的字符序列的子序列添加到输出流中。其中，start 指定
 * 子序列的第一个字符的索引，end 指定子序列中最后一个字符后面的字符
 * 的索引，也就是说子序列的内容包含 start 索引处的字符，但不包括 end索引处的字符
 * 字符文件输入流
 * 为了读取方便，Java 提供了用来读取字符文件的便捷类——FileReader。该类的构造方法有如下两种重载形式。
 * FileReader(File file)：在给定要读取数据的文件的情况下创建一个新的 FileReader 对象。其中，file 表示要从中读取数据的文件。
 * FileReader(String fileName)：在给定从中读取数据的文件名的情况下创建一个新 FileReader 对象。
 * 其中，fileName 表示要从中读取数据的文件的名称，表示的是一个文件的完整路径。
 */

@SuppressWarnings("all")
public class test
{
    public static void main(String[] args)
    {
        File file = new File("test.txt");
        System.out.println("即将读取的文件名：" + file.getName());
        System.out.println("路径：" + file.getAbsolutePath());
        System.out.println("长度：" + file.length());
        FileReader FileReader = null;
        try
        {
            int i;
            FileReader = new FileReader(file);
            System.out.println("内容：");
            while ((i = FileReader.read()) != -1)
            {
                System.out.print((char) i);
            }
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
            System.out.println(e.getMessage());
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
                if (FileReader != null)
                {
                    FileReader.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        test1.main(null);
        System.out.println();
        test2.main(null);
    }
}
