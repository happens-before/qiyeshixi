package com.chinasoft.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * @author: zhaowanyue
 * @date: 2018/9/3
 * @description:
 */
public class TestEnc {
    public static void main(String[] args) throws Exception{
        byte enc=56;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要加密的文件名");
        String org= scanner.next();
        System.out.println("请输入加密后的文件名");
        String newName= scanner.next();
        FileInputStream fileInputStream=new FileInputStream(org);
        FileOutputStream fileOutputStream=new FileOutputStream(newName);

        byte [] buffer=new byte[2048];
        int len=-1;
        while((len=fileInputStream.read(buffer))>0)
        {
            for(int i=0;i<len;i++)
            {
                buffer[i] ^= enc;
            }
            fileOutputStream.write(buffer,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("ok...........");
    }
}
