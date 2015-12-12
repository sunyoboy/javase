package com.tag.jstl;

import java.io.IOException;
import java.io.PrintWriter;
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
 * ����EL���ʽ
 * @author ���Ǻ�
 * @date 2014-1-7 ����6:26:20
 * @�汾 V1.0   ���ߣ� ʱ�䣺  �޸ģ�
 */
// @WebServlet(name="TestServlet", urlPatterns={"/path", "/alt"}) 
@WebServlet(name="JstlElServlet", urlPatterns={"/JstlElServlet"}) 
public class JstlElServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public JstlElServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
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
        //��ͨ�ַ���
        request.setAttribute("hello", "hello world");
        
        request.setAttribute("name", "zhujunhua");
        
        //�ṹ
        Group group=new Group();
        group.setName("��߰����");
        
        User user=new User();
        user.setName("juyahong");
        user.setAge(25);
        user.setGroup(group);
        request.setAttribute("user", user);
        
        
        //map
        Map map=new HashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        request.setAttribute("map", map);
        
        //�ַ�������
        String[] strArray=new String[]{"����","����","����","����","ʮ��"};
        request.setAttribute("str_array", strArray);
        
        
        //��������
        User[] users=new User[5];
        for (int i = 0; i < users.length; i++) {
            users[i]=new User();
            users[i].setName("juyahong("+i+")");
        }
        request.setAttribute("users", users);
        
        
        //list
        List groupList=new ArrayList();
        for (int i = 6; i < 12; i++) {
            Group group2=new Group();
            group2.setName("��߰��"+i+"��");
            groupList.add(group2);
        }
        request.setAttribute("groupList", groupList);
        
        
        //empty
        request.setAttribute("tgb6", "");
        request.setAttribute("tgb7", new ArrayList());
        request.setAttribute("tgb8", "��߰�ڰ���");
        request.setAttribute("tgb9", null);
        //request�ķַ���
        request.getRequestDispatcher("jstl/jstl_el_01.jsp").forward(request, response);
        
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}
