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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBUtil {
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
            // Statement stmt = conn.createStatement();
            sql = "select * from t_school where regionName=? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "������");
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
            
            ResultSet rs = stmt.executeQuery();//
            int index = 0;
            while (rs.next()) {
                System.out.println(rs.getString("regionName"));
                System.out.println(rs.toString());
                System.out.println(rs.getConcurrency());
                ResultSetMetaData rsmetaData = rs.getMetaData();
                System.out.println(rsmetaData.getColumnCount());
                
                int colCount = rsmetaData.getColumnCount();
                for(int i=1; i<=colCount; i++) {
                    System.out.print(rsmetaData.getColumnName(i) + "\t" );
                    System.out.print(rsmetaData.getColumnClassName(i) + "\t");
                    // System.out.println(rsmetaData.getTableName(i));
                    System.out.print("schemaName " + rsmetaData.getSchemaName(i) + "\t");
                    System.out.print(rsmetaData.isAutoIncrement(i)+ "\t");
                    System.out.print(rsmetaData.isReadOnly(i)+ "\t");
                    System.out.print(rsmetaData.isNullable(i)+ "\t");
                    System.out.print(rsmetaData.isSearchable(i)+ "\t");
                    System.out.print(rsmetaData.getColumnLabel(i) + "\t");
                    System.out.print(rsmetaData.getCatalogName(i) + "\t");
                    System.out.print(rsmetaData.getColumnDisplaySize(i) + "\t");
                    System.out.println(rsmetaData.isWritable(i));
                    
                    
                    


                }
                
                
            }
            for (int j = 0; j < array.length; j++) {
                // System.out.print(" " + array[j]);
            }


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