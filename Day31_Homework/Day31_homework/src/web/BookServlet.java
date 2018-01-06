package web;

import dao.BookDao;
import domain.Book;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "web.BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        BookDao bookDao = new BookDao();
        try {
            BeanUtils.populate(book,parameterMap);
            String bkname = book.getBkname();
            Book query = bookDao.Query(bkname);

            if (query!=null){
                System.out.println("书名已存在！");
                response.sendRedirect("/index.jsp");
            }else {
                bookDao.Insert(book);
             response.sendRedirect("/index.jsp");

            }



        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.QueryAll();
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());
    }
}
