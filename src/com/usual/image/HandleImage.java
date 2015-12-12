/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: HandleImage.java
 * Author:   DD240
 * Date:     2015-11-9 ����10:59:36
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author> sunlj     <time>      <version>    <desc>
 * �޸�������             �޸�����            �汾��                  ����
 */
package com.usual.image;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��������ϸ������
 *
 * @author sunlj
 * @see 
 * @since 1.0
 */
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
  
public class HandleImage {  
  
    public static void main(String[] args) {
        File srcFolder = new File("D:/tmp/thumbnail");
        File destFolder = new File("D:/tmp/destImage/");
        
        if(!destFolder.exists()) {
            destFolder.mkdirs();
        }
        File[] images = null;
        if(srcFolder.isDirectory()) {
            images = srcFolder.listFiles();
        }
        
        System.out.println(images[0].getName());
        System.out.println(images[0].getAbsolutePath());
        System.out.println(destFolder.getAbsolutePath());
        try {  
            BufferedImage image = null;
            File f = null;
            for(int i=0; i<images.length; i++) {
                
                f = new File(images[i].getAbsolutePath());
                image = ImageIO.read(f);
                System.out.println("size : " + f.length()/1024.0);
                // zoomImage(293,205, images[i].getAbsolutePath(), destFolder.getAbsolutePath() + "\\img" + (i+1) + ".jpg");
                // zoomImage(image.getWidth()/8,image.getHeight()/8, images[i].getAbsolutePath(),destFolder.getAbsolutePath() + "\\" + images[i].getName());
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void zoomImage(Integer width, Integer height, String srcPath, String newPath) throws Exception {      
        IMOperation op = new IMOperation();      
        op.addImage(srcPath);  
        if(width == null){//���ݸ߶�����ͼƬ    
            op.resize(null, height);        
        }else if(height == null){//���ݿ������ͼƬ    
            op.resize(width, null);    
        }else {    
            op.resize(width, height);    
        }  
        op.addImage(newPath);  
        //���ﲻ�Ӳ������߲���Ϊfalse��ʹ��ImageMagick��true��ʹ��GraphicsMagick  
        ConvertCmd convert = new ConvertCmd(true);  
//        convert.setSearchPath("g:/tool/graphicsmagick-1.3.20-q16");  
        convert.setSearchPath("D:/Program Files/GraphicsMagick-1.3.22-Q8");  
        convert.run(op);      
    }  
}  