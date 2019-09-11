package com.example.demo;

import com.example.demo.controller.SocketServerTest;
import com.example.demo.controller.SocketTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Description lambda表达式测试
 * @Author lph
 * @Date 2019/5/24 14:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LambdaTest {
    @Test
    public void lambda1(){
        String str = " dfasdf ";
        System.out.println(str);
        System.out.println(str.trim());
        new Thread(() -> System.out.println(2)).start();
    }
    @Test
    public void lambda2(){
        Arrays.asList("d","g","r","b","j","a","z").forEach(e -> System.out.println(e));
    }

    /**
     * java8 新特性 流库
     */
    @Test
    public void streamLib(){
        try {
            String con = new String(Files.readAllBytes(Paths.get("F:\\aa.txt")), StandardCharsets.UTF_8);
            //\PL+ 正则表达式 以非字母分隔符;
            List<String> words = Arrays.asList(con.split("\\PL+"));
            //使用一般方法
            /*long count = 0;
            for (String word:words) {
                if(word.length() > 10){
                    count++;
                }
            }*/
            //使用流时
            long count = words.stream().filter(w -> w.length() > 10).count();
            Stream stream = words.stream().filter(w -> w.length() > 10);
            Object[] arr = stream.toArray();
            for (Object obj:arr) {
                System.out.println(obj.toString());
            }
            System.out.println("长度大于10的单词的个数："+count);
            int[] array = {1,5,4,8,6,9};
            List l = Arrays.asList(array);
            l.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //io流操作
    @Test
    public void inputstream(){
        File file = new File("F:\\aa.txt");
        byte[] bytes = new byte[10];
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            os = new FileOutputStream("F:\\a.txt");
            int len = 0;
            while ((len = is.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
            os.write("000000".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //使用ZipOutputStream时要记得关闭流，不然会导致文件丢失错误
    @Test
    public void zipIO(){
        File file = new File("C:\\Users\\mayura\\Desktop\\a.zip");
        File f = new File("F:\\aa.txt");
        OutputStream os = null;
        byte[] bytes = new byte[1024];
        InputStream is = null;
        ZipOutputStream zipOutputStream = null;
        try {
            is = new FileInputStream(f);
            os = new FileOutputStream("C:\\Users\\mayura\\Desktop\\a.txt");
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            zipOutputStream.putNextEntry(new ZipEntry(f.getName()));
            int len;
            while ((len = is.read(bytes)) != -1) {
                zipOutputStream.write(bytes,0,len);
                os.write(bytes,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                os.close();
                zipOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void myThread(){
        String con = "my thread";
        boolean f = false;
    }

    @Test
    public void socket() throws IOException {
        String str = SocketTest.getStr();
        System.out.println(str);
    }
    @Test
    public void server() throws IOException {
        String s = SocketServerTest.socketServer();
        System.out.println();
    }
}
