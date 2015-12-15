package com.javase.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConvertVideoFormat {
    // ��������
    public void runCmd(String command) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    // ��Ƶת�룬infile�����ļ�(��������·��)��outfile����ļ�
    public boolean transfer(String infile, String outfile) {
        String avitoflv = "ffmpeg -i " + infile
                + " -ar 22050 -ab 56 -f flv -y -s 320x240 " + outfile;

        String convertMp4 = "ffmpeg -i " + infile
                + " -c:v libx264 -strict -2 -acodec copy -s 720*576 " + outfile;

        String flvto3gp = "ffmpeg -i "
                + infile
                + " -ar 8000 -ac 1 -acodec amr_nb -vcodec h263 -s 176x144 -r 12 -b 30 -ab 12 "
                + outfile;
        String avito3gp = "ffmpeg -i "
                + infile
                + " -ar 8000 -ac 1 -acodec amr_nb -vcodec h263 -s 176x144 -r 12 -b 30 -ab 12 "
                + outfile;
        // avi -> jpg
        String avitojpg = "ffmpeg -i " + infile
                + " -y -f image2 -ss 00:00:10 -t 00:00:01 -s 350x240 "
                + outfile;
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println(convertMp4);
            Process proc = rt.exec(convertMp4);
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            System.out.println("<ERROR>");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            System.out.println("</ERROR>");
            int exitVal = proc.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
        return true;
    }

    // ��ȡ�ļ�,fileName�����ļ���id����
    public static String readFile(String fileName, int id) {
        String dataStr = "";
        FileInputStream fis = null;
        try {
            FileReader file = new FileReader(fileName);// ����FileReader���󣬲�ʵ����Ϊfr
            BufferedReader br = new BufferedReader(file);// ����BufferedReader���󣬲�ʵ����Ϊbr
            int i = 1;
            String Line = br.readLine();// ���ļ���ȡһ���ַ���
            // System.out.println("Line1="+Line+"="+Line);
            // �ж϶�ȡ�����ַ����Ƿ�Ϊ��
            // while(Line!=null){
            // System.out.println(Line + "<br>");//������ļ��ж�ȡ������
            // if(i==line){dataStr=Line;break;}else{i=i+1;}
            // Line=br.readLine();//���ļ��м�����ȡһ������
            // }
            dataStr = Line;
            br.close();// �ر�BufferedReader����
        } catch (Exception e) {
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (Exception e) {
            }
        }
        return dataStr;
    }

    // ��ʱ����Ϣ
    public String readtime(String file) {
        String str = "/root/sunlj/java/93.mp4";
        String timelen = "";
        String cmd = "timelen " + file;
        runCmd(cmd);
        timelen = readFile(str, 1);

        return timelen;
    }

    public static void main(String args[]) {
        ConvertVideoFormat me = new ConvertVideoFormat();
        String infile = "/root/sunlj/java/93.mp4";
        String outfile = "/root/sunlj/93.mp4";

        // ʱ��
        // String timelen = me.readtime(infile);
        // System.out.println("02.avi timelen is :" + timelen);
        // ת��
        if (me.transfer(infile, outfile)) {
            System.out.println("the transfer is ok!");
        } else {
            System.out.println("the transfer is error!");
        }
    }
}