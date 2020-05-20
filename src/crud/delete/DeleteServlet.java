package crud.delete;

import crud.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除人员信息
 * created by xu-jp on 2020/5/18
 **/
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        new PersonDao().delete(id);

        // 解决中文乱码，或者使用 response.setHeader("context-type","text/html;charset=utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        // 向页面输出一些文字
        resp.getWriter().println("<h1>删除成功</h1>");
    }
}
