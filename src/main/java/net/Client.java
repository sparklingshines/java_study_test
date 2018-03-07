package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//往Socket里面写数据，需要新开一个线程
class sendMessThread extends Thread {

    //定义一个Socket对象
    Socket socket = null;

    public sendMessThread(String host, int port) {
        try {
            //需要服务器的IP地址和端口号，才能获得正确的Socket对象
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        super.run();
        //写操作
        Scanner scanner = null;
        OutputStream os = null;
        try {
            scanner = new Scanner(System.in);
            os = socket.getOutputStream();
            String in = "";
            do {
                in = scanner.next();
                os.write(("客户端:" + in).getBytes());
                os.flush();
            } while (!in.equals("bye"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Client implements Runnable {

    //定义一个Socket对象
    Socket socket = null;

    public Client(String host, int port) {
        try {
            //需要服务器的IP地址和端口号，才能获得正确的Socket对象
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        Scanner scanner = null;
        OutputStream os = null;
        try {
            scanner = new Scanner(System.in);
            os = socket.getOutputStream();
            String in = "";
            do {
                in = scanner.next();
                os.write(("客户端:" + in).getBytes());
                os.flush();
            } while (!in.equals("bye"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            // 读Sock里面的数据
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = s.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("192.168.1.237", 6768);
        Thread thread = new Thread(client, "client");
        thread.setDaemon(true);
        thread.start();
    }
}
