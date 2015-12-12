package com.tag.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * ��ʾJSTL���Ŀ�
 * @author ���Ǻ�
 * @date 2014-1-7 ����9:19:15
 * @�汾 V1.0   ���ߣ� ʱ�䣺  �޸ģ�
 */
@WebServlet(name="JstlCoreServlet", urlPatterns={"/JstlCoreServlet"})
public class JstlCoreServlet extends HttpServlet {

    /**
     * @author ���Ǻ�
     * @date 2014-1-8 ����5:36:05
     * @�汾 V1.0   ���ߣ� ʱ�䣺  �޸ģ�
     */
    private static final long serialVersionUID = 1L;
    /**
     * Constructor of the object.
     */
    public JstlCoreServlet() {
        super();
    }

    

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ��ͨ�ַ���
        request.setAttribute("hello", "hello world");
        
        //HTML�ַ���
        request.setAttribute("welcome", "<font color='red'>��ӭ�������������</font>");
    
        //�������Ʊ�ǩ
        request.setAttribute("v1", 10);
        request.setAttribute("v2", 20);
        
        request.setAttribute("userList", new ArrayList());
    
        //�ṹ
            
        
        Group group = new Group();
        group.setName("��߰�ڰ���");
                
        List users = new ArrayList();
        for (int i=0; i<10; i++) {
                User user = new User();
                user.setName("juyahong(" + i+")");
                user.setAge(23 + i);
                user.setGroup(group);
                users.add(user);
        }
        request.setAttribute("users", users);
        
        
        //map
        Map map=new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        request.setAttribute("map", map);
        
        
        //forTokens
        request.setAttribute("strTokens", "1#2#3#4#5");
        
        request.getRequestDispatcher("jstl/jstl_core_02.jsp").forward(request, response);
        
    }

    
    
}
