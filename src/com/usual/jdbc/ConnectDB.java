/*
 * Copyright (C), 2002-2015, �������Ͷ���������޹�˾
 * FileName: ConnectDB.java
 * Author: DD240
 * Date: 2015-11-5 ����12:47:35
 * Description: //ģ��Ŀ�ġ���������
 * History: //�޸ļ�¼
 * <author> sunlj <time> <version> <desc>
 * �޸������� �޸����� �汾�� ����
 */
package com.usual.jdbc;

/**
 * ��һ�仰���ܼ�����<br>
 * ��������ϸ������
 * 
 * @author sunlj
 * @see
 * @since 1.0
 */

/**
 * @author ����ΰ�� ��΢����http://weibo.com/taoandtao
 * @date ��2012/12/11
 * @place�����ݴ�ѧ�������ѧԺ
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql = "";
        // MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
        // ������������Ҫָ��useUnicode��characterEncoding
        // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
        // �������֮ǰ��Ҫ�ȴ���javademo���ݿ�
        String url = "jdbc:mysql://localhost:3306/region?"
                + "user=school&password=school&useUnicode=true&characterEncoding=UTF8";

        try {
            // ֮����Ҫʹ������������䣬����ΪҪʹ��MySQL����������������Ҫ��������������
            // ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
            Class.forName("com.mysql.jdbc.Driver");// ��̬����mysql����
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or��
            // new com.mysql.jdbc.Driver();

            // һ��Connection����һ�����ݿ�����
            conn = DriverManager.getConnection(url);
            // Statement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
            Statement stmt = conn.createStatement();
            // sql =
            // "create table student(NO char(20),name varchar(20),primary key(NO))";
            // int result = stmt.executeUpdate(sql);//
            // executeUpdate���᷵��һ����Ӱ����������������-1��û�гɹ�
            /*
             * if (result != -1) {
             * // System.out.println("�������ݱ�ɹ�");
             * // sql = "insert into student(NO,name) values('2012001','��ΰ��')";
             * // result = stmt.executeUpdate(sql);
             * // sql = "insert into student(NO,name) values('2012002','��С��')";
             * // result = stmt.executeUpdate(sql);
             * // sql = "select * from student";
             * ResultSet rs = stmt.executeQuery(sql);//
             * executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
             * System.out.println("ѧ��\t����");
             * while (rs.next()) {
             * System.out
             * .println(rs.getString(1) + "\t" + rs.getString(2));//
             * ��������ص���int���Ϳ�����getInt()
             * }
             * }
             */

            int[] array = new int[33];
            sql = "select * from t_school where regionName != '';";
            ResultSet rs = stmt.executeQuery(sql);//
            int index = 0;
            while (rs.next()) {
                array[index] = rs.getInt(1) - 1 ;
                index++;
            }
            for (int j = 0; j < array.length; j++) {
                System.out.print(" " + array[j]);
            }
            System.out.println();

/*            { 
                "regionName" : "����",
                "school" : [ {
                    "id" : 1,
                    "name" : "�����г���Сѧ"
                }]
                
            }*/
            sql = "select * from t_school";
            rs = stmt.executeQuery(sql);//
            
            int max=0, min=0;
            int calc = 0;
            int count = 0;
            int tagIndex = 0;
            boolean flag = false;
            
            
            StringBuffer sb = new StringBuffer(655351);
            sb.append(" { \"schools\":["); 
            while (rs.next()) {
                calc++;
                if(!rs.getString(2).equals("")) {
                    if(count < 31) {
                        count++;
                    }

                    
                    if(flag) { 
                        sb.append(",{\"regionName\":\"").append(rs.getString(2)).append("\",");
                        sb.append("\"school\":[");
                    } else {
                        sb.append("{\"regionName\":\"").append(rs.getString(2)).append("\",");
                        sb.append("\"school\":[");
                        flag = true;
                    }
                    
                    sb.append("{").append("\"id\":").append(rs.getInt(1)).append(",")
                    .append("\"name\":\"").append(rs.getString(3)).append("\"").append("},"); 

                }   else {
                    

                    sb.append("{").append("\"id\":").append(rs.getInt(1)).append(",")
                    .append("\"name\":\"").append(rs.getString(3)).append("\"").append("},"); 
                    
                    if(rs.getInt(1) == array[count]) {

                        // System.out.println(rs.getInt(1));
                        sb.setCharAt(sb.lastIndexOf(","), ' ');
                        sb.append("]}");
                    }
                    
                    if(rs.getInt(1) == 8627) {
                        sb.setCharAt(sb.lastIndexOf(","), ' ');
                        sb.append("]}");
                    }
                }  

                 
/*                if(!rs.getString(2).equals("") && flag ) {
                    sb.append("]");
                }

                
                if(!rs.getString(2).equals("")) {
                    if(flag) { 
                        sb.setCharAt(sb.lastIndexOf(","), ' ');
                        sb.append("]");

                        sb.append("\",regionName\":\"").append(rs.getString(2)).append("\",");
                        sb.append("\"school\":[");
                    } else {
                        sb.append("\"regionName\":\"").append(rs.getString(2)).append("\",");
                        sb.append("\"school\":[");
                    }

                }   else {
                    sb.append("{").append("\"id\":").append(rs.getInt(1)).append(",")
                    .append("\"name\":\"").append(rs.getString(3)).append("\"").append("},");                    
                }*/


            }
            sb.append(" ]} ");
            
             System.out.println(sb.toString());

        } catch (SQLException e) {
            System.out.println("MySQL��������");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }
    
    public static String generateJsonFile() {
        return null;
    }

}