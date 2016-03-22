package com.simon.base;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file=new RandomAccessFile("E:/11.txt", "rw");
        System.out.println("start.......");
        FileChannel  inChannel=file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int read = inChannel.read(buf);
        System.out.println("begin"+read);
        while(read!=-1){
            System.out.println("========"+read);
            buf.flip();
            while(buf.hasRemaining()){
               // System.out.println("--------------"+(char)buf.get());
                System.out.println("--------------"+buf.getChar());
            }
            buf.clear();
            read=inChannel.read(buf);
        }
        file.close();
    }
}
