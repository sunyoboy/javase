package com.usual.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;

public class TestGM {

/**
 * * ���ͼƬ�ļ���С[С���������ͼƬ��С] * * @param filePath * �ļ�·�� *
 * 
 * @return �ļ���С
 */

public int getSize(String imagePath) {
    int size = 0;
    FileInputStream inputStream = null;
    try {
        inputStream = new FileInputStream(imagePath);
        size = inputStream.available();
        inputStream.close();
        inputStream = null;
    } catch (FileNotFoundException e) {
        size = 0;
        System.out.println("�ļ�δ�ҵ�!");
    } catch (IOException e) {
        size = 0;
        System.out.println("��ȡ�ļ���С����!");
    } finally {
        // �����쳣Ϊ�ر�������,������Ҫ�ر�������
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("�ر��ļ��������쳣");
            }
            inputStream = null;

        }
    }
    return size;
}

/**
 * ���ͼƬ�Ŀ��
 * 
 * @param filePath
 *            �ļ�·��
 * @return ͼƬ���
 */
public int getWidth(String imagePath) {
    int line = 0;
    try {
        IMOperation op = new IMOperation();
        op.format("%w"); // ���û�ȡ��Ȳ���
        op.addImage(1);
        IdentifyCmd identifyCmd = new IdentifyCmd(true);
        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
        identifyCmd.setOutputConsumer(output);
        identifyCmd.run(op, imagePath);
        ArrayList<String> cmdOutput = output.getOutput();
        assert cmdOutput.size() == 1;
        line = Integer.parseInt(cmdOutput.get(0));
    } catch (Exception e) {
        line = 0;
        System.out.println("����ָ�����!");
    }
    return line;
}

/**
 * ���ͼƬ�ĸ߶�
 * 
 * @param imagePath
 *            �ļ�·��
 * @return ͼƬ�߶�
 */
public int getHeight(String imagePath) {
    int line = 0;
    try {
        IMOperation op = new IMOperation();

        op.format("%h"); // ���û�ȡ�߶Ȳ���
        op.addImage(1);
        IdentifyCmd identifyCmd = new IdentifyCmd(true);
        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
        identifyCmd.setOutputConsumer(output);
        identifyCmd.run(op, imagePath);
        ArrayList<String> cmdOutput = output.getOutput();
        assert cmdOutput.size() == 1;
        line = Integer.parseInt(cmdOutput.get(0));
    } catch (Exception e) {
        line = 0;
        System.out.println("����ָ�����!"+e.toString());
    }
    return line;
}

/**
 * ͼƬ��Ϣ
 * 
 * @param imagePath
 * @return
 */
public static String getImageInfo(String imagePath) {
    String line = null;
    try {
        IMOperation op = new IMOperation();
        op.format("width:%w,height:%h,path:%d%f,size:%b%[EXIF:DateTimeOriginal]");
        op.addImage(1);
        IdentifyCmd identifyCmd = new IdentifyCmd(true);
        ArrayListOutputConsumer output = new ArrayListOutputConsumer();
        identifyCmd.setOutputConsumer(output);
        identifyCmd.run(op, imagePath);
        ArrayList<String> cmdOutput = output.getOutput();
        assert cmdOutput.size() == 1;
        line = cmdOutput.get(0);

    } catch (Exception e) {
        e.printStackTrace();
    }
    return line;
}

/**
 * �ü�ͼƬ
 * 
 * @param imagePath
 *            ԴͼƬ·��
 * @param newPath
 *            �����ͼƬ·��
 * @param x
 *            ��ʼX����
 * @param y
 *            ��ʼY����
 * @param width
 *            �ü����
 * @param height
 *            �ü��߶�
 * @return ����true˵���ü��ɹ�,����ʧ��
 */
public boolean cutImage(String imagePath, String newPath, int x, int y,
        int width, int height) {
    boolean flag = false;
    try {
        IMOperation op = new IMOperation();
        op.addImage(imagePath);
        /** width���ü��Ŀ�� * height���ü��ĸ߶� * x���ü��ĺ����� * y���ü������� */
        op.crop(width, height, x, y);
        op.addImage(newPath);
        ConvertCmd convert = new ConvertCmd(true);
        convert.run(op);
        flag = true;
    } catch (IOException e) {
        System.out.println("�ļ���ȡ����!");
        flag = false;
    } catch (InterruptedException e) {
        flag = false;
    } catch (IM4JavaException e) {
        flag = false;
    } finally {

    }
    return flag;
}

/**
 * ���ݳߴ�����ͼƬ[�ȱ�������:����heightΪnull,��������ű�������;����widthΪnull,���߶����ű�������]
 * 
 * @param imagePath
 *            ԴͼƬ·��
 * @param newPath
 *            �����ͼƬ·��
 * @param width
 *            ���ź��ͼƬ���
 * @param height
 *            ���ź��ͼƬ�߶�
 * @return ����true˵�����ųɹ�,����ʧ��
 */
public boolean zoomImage(String imagePath, String newPath, Integer width,
        Integer height) {

    boolean flag = false;
    try {
        IMOperation op = new IMOperation();
        op.addImage(imagePath);
        if (width == null) {// ���ݸ߶�����ͼƬ
            op.resize(null, height);
        } else if (height == null) {// ���ݿ������ͼƬ
            op.resize(width);
        } else {
            op.resize(width, height);
        }
        op.addImage(newPath);
        ConvertCmd convert = new ConvertCmd(true);
        convert.run(op);
        flag = true;
    } catch (IOException e) {
        System.out.println("�ļ���ȡ����!");
        flag = false;
    } catch (InterruptedException e) {
        flag = false;
    } catch (IM4JavaException e) {
        flag = false;
    } finally {

    }
    return flag;
}

/**
 * ͼƬ��ת
 * 
 * @param imagePath
 *            ԴͼƬ·��
 * @param newPath
 *            �����ͼƬ·��
 * @param degree
 *            ��ת�Ƕ�
 */
public boolean rotate(String imagePath, String newPath, double degree) {
    boolean flag = false;
    try {
        // 1.���Ƕ�ת����0-360��֮��
        degree = degree % 360;
        if (degree <= 0) {
            degree = 360 + degree;
        }
        IMOperation op = new IMOperation();
        op.addImage(imagePath);
        op.rotate(degree);
        op.addImage(newPath);
        ConvertCmd cmd = new ConvertCmd(true);
        cmd.run(op);
        flag = true;
    } catch (Exception e) {
        flag = false;
        System.out.println("ͼƬ��תʧ��!");
    }
    return flag;
}

	public static void main(String[] args) throws Exception {
	    TestGM imageUtil = new TestGM();
	
	    System.out.println("ԭͼƬ��С:" + imageUtil.getSize("d://test.jpg") + "Bit");
	    System.out.println("ԭͼƬ���:" + imageUtil.getWidth("d://test.jpg"));
	    System.out.println("ԭͼƬ�߶�:" + imageUtil.getHeight("d://test.jpg"));
/*	    if (imageUtil.zoomImage("d://test.jpg", "d://test.jpg", 500, null)) {
	        if (imageUtil.rotate("d://test.jpg", "d://test2.jpg", 15)) {
	            if (imageUtil.cutImage("d://test2.jpg", "d://test3.jpg", 32,
	                    105, 200, 200)) {
	                System.out.println("�༭�ɹ�");
	            } else {
	                System.out.println("�༭ʧ��03");
	            }
	        } else {
	            System.out.println("�༭ʧ��02");
	        }
	    } else {
	        System.out.println("�༭ʧ��01");
	    }*/
	
	}

}