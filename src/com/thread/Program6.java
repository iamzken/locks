package com.thread;
import java.io.*;  
import java.nio.*;  
import java.nio.channels.*;  
  
public class Program6 {  
    static public void main( String args[] ) throws Exception {  
        String infile = "E:\\1.txt";  
        FileInputStream fin = new FileInputStream( infile );  
        FileChannel fcin = fin.getChannel();  
          
        String outfile = String.format("E:\\1-1.txt");  
        FileOutputStream fout = new FileOutputStream( outfile );      
        FileChannel fcout = fout.getChannel();  
          
        // 使用allocateDirect，而不是allocate  
        ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );  
          
        while (true) {  
            buffer.clear();  
              
            int r = fcin.read( buffer );  
              
            if (r==-1) {  
                break;  
            }  
              
            buffer.flip();  
              
            fcout.write( buffer );  
        }  
    }  
}  