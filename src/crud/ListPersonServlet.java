package crud;

import crud.dao.PersonDao;
import crud.dao.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 人员列表
 * created by xu-jp on 2020/5/11
 **/
public class ListPersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        List<Person> persons = new PersonDao().list();

        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>age</td><td>gender</td><td>birthday</td><td>mobile</td><td>home</td><td>edit</td><td>delete</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%d</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td><a href='editPerson?id=%d'>edit</a></td><td><a href='deletePerson?id=%d'>delete</a></tr>\r\n";

        for (Person person : persons) {
            String tr = String.format(trFormat, person.getId(), person.getName(), person.getAge(), person.getGender(),person.getBirthday(),person.getMobile(),person.getHome(),person.getId(),person.getId());
            sb.append(tr);
        }

        sb.append("</table>");

        resp.getWriter().write(sb.toString());
    }
}
