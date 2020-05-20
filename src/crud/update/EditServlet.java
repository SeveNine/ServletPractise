package crud.update;

import crud.dao.PersonDao;
import crud.dao.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编辑人员信息
 * created by xu-jp on 2020/5/18
 **/
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Person person = new PersonDao().get(id);

        // 解决中文乱码，或者使用 response.setHeader("context-type","text/html;charset=utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        StringBuffer format = new StringBuffer();
        format.append("<!DOCTYPE html>");

        format.append("<form action=\"updatePerson\" method=\"post\">\n" +
                "        姓名 ： <input type=\"text\" name=\"name\" value='%s'> <br>\n" +
                "        年龄 ： <input type=\"text\" name=\"age\" value='%d'> <br>\n" +
                "        性别：\n" +
                "                <select name=\"gender\" value='%d'>\n" +
                "                    <option value=\"1\">男</option>\n" +
                "                    <option value=\"2\">女</option>\n" +
                "                </select><br>\n" +
                "        出生日期 ： <input type=\"date\" name=\"birthday\" value='%s'> <br>\n" +
                "        手机号码 ： <input type=\"text\" name=\"mobile\" value='%s'> <br>\n" +
                "        家庭住址 ： <input type=\"text\" name=\"home\" value='%s'> <br>\n" +
                "        <input type=\"submit\" value=\"保存修改 \">\n" +
                "        <input type='hidden' name='id' value='%d'>" +
                "    </form>");


        String html = String.format(format.toString(), person.getName(), person.getAge(), person.getGender(), person.getBirthday(), person.getMobile(), person.getHome(),person.getId());

        resp.getWriter().write(html);
    }
}
