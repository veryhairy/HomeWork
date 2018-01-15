package exception;

/**
 * Created by fwj on 2018/1/15.
 */
public class PasswordWrongException extends Exception{
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
