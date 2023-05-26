package chat.room.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer
{
    public static void main(String[] args) throws IOException
    {
        //创建服务器socket对象
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("等待连接中...");
        //监听并接受服务器端连接
        Socket socket = serverSocket.accept();
        //获取客户端输入流，获取客户输入内容
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if(scanner.hasNext())
        {
            System.out.println("客户端发来信息:" + scanner.next());
        }
        //获取客户端输出流，向客户端输出内容
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("客户端你好！我是服务端" + serverSocket.getLocalPort());
        //关闭流
        serverSocket.close();
    }
}