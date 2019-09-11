package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author lph
 * @Date 2019/8/13 17:31
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("等待客户端连接。。");
        Socket socket = server.accept();
        //从socket中获取输入流，并建立缓存区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("接收数据为："+sb);
        OutputStream outputStream = socket.getOutputStream();
        String msg = "服务器端已接收到数据。。";
        outputStream.write(msg.getBytes("utf-8"));
        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();
    }
    public static String socketServer() throws IOException {
        ServerSocket server = new ServerSocket(55533);
        System.out.println("等待客户端连接。。");
        Socket socket = server.accept();
        //从socket中获取输入流，并建立缓存区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("接收数据为："+sb);
        OutputStream outputStream = socket.getOutputStream();
        String msg = "服务器端已接收到数据。。";
        outputStream.write(msg.getBytes("utf-8"));
        inputStream.close();
        outputStream.close();
        socket.close();
        server.close();
        return sb.toString();
    }
}
