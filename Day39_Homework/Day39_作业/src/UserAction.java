import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import exception.PasswordWrongException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by fwj on 2018/1/15.
 */
public class UserAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
    UserService userService = new UserService();
    UserDao userDao = new UserDao();
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
    public String register() throws InvocationTargetException, IllegalAccessException, SQLException {
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        BeanUtils.populate(user,parameterMap);
        userService.insert(user);
        return "success";
    }

    public String login() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        BeanUtils.populate(user,parameterMap);
        try {
            try {
                userService.login(user);
            } catch (PasswordWrongException e) {
                System.out.println(1);
                e.getMessage();
                System.out.println(2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "success";
    }


}
