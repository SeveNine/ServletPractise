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
        int start = 0;
        int count = 5;
        PersonDao personDao = new PersonDao();
        start = Integer.parseInt(req.getParameter("start") == null ? "0" : req.getParameter("start"));
        List<Person> persons = personDao.list(start,count);
        int next = start + count;
        int pre = start - count;
        int total = personDao.getTotal();
        int last = total%count == 0 ? total - count : total- total%count;
        // 处理边界
        pre = pre < 0 ? 0 : pre;
        next = next > last ? last : next;

        req.setAttribute("persons",persons);
        req.setAttribute("next", next);
        req.setAttribute("pre", pre);
        req.setAttribute("last", last);
        req.getRequestDispatcher("/listPerson.jsp").forward(req,resp);

    }
}
