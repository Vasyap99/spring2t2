package kok.spring21;

import org.springframework.stereotype.Component;
import java.io.RandomAccessFile;


@Component
public class myLogger{
    public static void log(String s){
        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");

            raf.seek(raf.length());
            //������ ������, ������� � �������� ��������� ������� � �� ����� ������
            raf.writeBytes(">>"+s+"\r\n");

            //��������� ����
            raf.close();
        }catch(Exception e){}
    }
}