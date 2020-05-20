package crud.update;

import crud.dao.PersonDao;
import crud.dao.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 编辑人员信息
 * created by xu-jp on 2020/5/18
 **/
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        req.setCharacterEncoding("UTF-8");
        Person person = new Person();
        person.setId(Integer.parseInt(req.getParameter("id")));
        person.setName(req.getParameter("name"));
        person.setAge(Integer.parseInt(req.getParameter("age")));
        person.setGender(Integer.parseInt(req.getParameter("gender")));
        String birthday = req.getParameter("birthday");
        Date date = Date.valueOf(birthday);
        person.setBirthday(date);
        person.setMobile(req.getParameter("mobile"));
        person.setHome(req.getParameter("home"));

        PersonDao personDao = new PersonDao();
        personDao.update(person);

        // 解决中文乱码，或者使用 response.setHeader("context-type","text/html;charset=utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        // 向页面输出一些文字
        resp.getWriter().println("<h1>修改成功</h1>");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // servlet人员页
//        resp.sendRedirect("/servlet/listPerson");
        // jsp人员页
        resp.sendRedirect("/servlet/listJsp");
    }
}
