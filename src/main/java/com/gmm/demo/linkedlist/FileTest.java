package com.gmm.demo.linkedlist;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class FileTest {
    public static void main(String[] args) {
//        io1();
//        io2();
//        io3();
//        io4();
        io5();
    }

    private static void io5() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(80));
            SocketChannel accept = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            accept.read(buffer);
            buffer.flip();
            System.out.println(Charset.defaultCharset().decode(buffer));
            buffer.clear();
            buffer.put(Byte.decode("97"));
            accept.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void io4() {
        try (Socket socket = new Socket("hencoder.com", 80);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            writer.write("GET / HTTP/1.1\n" + "Host: www.baidu.com \n\n");
            writer.flush();
            char[] buffer = new char[1024];
            String msg;
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
//            System.out.println(reader.readLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void io3() {
        try {
            Reader fileReader = new FileReader("src/a.txt");
            char[] bytes = new char[4];
            int len = 0;
            while ((len = fileReader.read(bytes)) != -1) {
                System.out.println(new java.lang.String(bytes,0, len));
            }
//            int read = fileReader.read();
//            System.out.println((char) read);
            InputStream inputStream = new FileInputStream("src/a.txt");
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            java.lang.String s = bufferedReader.readLine();
            System.out.println(s);
            inputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void io2() {
        try {
            InputStream inputStream = new FileInputStream("src/a.txt");
            System.out.println((char) inputStream.read());
            System.out.println(inputStream.read());
            System.out.println(inputStream.read());
            System.out.println(inputStream.read());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void io1() {
        try (OutputStream outputStream = new FileOutputStream("src/a.txt");) {
            outputStream.write('a');
            outputStream.write('b');
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
