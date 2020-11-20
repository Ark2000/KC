package com.example.kc;
import java.util.regex.*;

public class GlobalHelper {

    //用户名：   ---（由字母数字下划线组成且开头必须是字母
    public static boolean isUsernameValid(String username) {
        Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]{1,15}");
        Matcher m = p.matcher(username);
        return m.matches();
    }

    //密码：---（字母和数字构成，不能超过16位）
    public static boolean isPasswordValid(String password) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]{1,16}");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
