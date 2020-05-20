import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * servlet 入门类
 * created by xu-jp on 2020/5/7
 **/
// 继承 HttpServlet
public class HelloServlet extends HttpServlet {

    // 重写doGet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决中文乱码，或者使用 response.setHeader("context-type","text/html;charset=utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 向页面输出一些文字
        resp.getWriter().println("<h1>Hello Servlet</h1>");
        resp.getWriter().println("<h6>你好 小🐏</h6>");
        resp.getWriter().println(new Date().toString());
    }
}
