package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Description
 * @Author lph
 * @Date 2019/8/13 17:48
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress("111.203.21.29",8080);
        socket.connect(socketAddress,5000);
        //建立输出流
        OutputStream outputStream = socket.getOutputStream();
        String mes = "Hello,世界";
        outputStream.write(mes.getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("响应数据为："+sb);
        outputStream.close();
        socket.close();
    }
    public static String getStr() throws IOException {
        Socket socket = new Socket("localhost",55533);
        //建立输出流
        OutputStream outputStream = socket.getOutputStream();
        String mes = "Hello,世界";
        outputStream.write(mes.getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("响应数据为："+sb);
        outputStream.close();
        socket.close();
        return sb.toString();
    }
}
