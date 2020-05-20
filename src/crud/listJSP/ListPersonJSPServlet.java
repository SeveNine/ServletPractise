package crud.listJSP;

import crud.dao.PersonDao;
import crud.dao.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 人员列表JSP版本
 * created by xu-jp on 2020/5/11
 **/
public class ListPersonJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Person> persons = new PersonDao().list(0,5);
        req.setAttribute("persons",persons);
        req.getRequestDispatcher("/listPerson.jsp").forward(req,resp);

    }
}
