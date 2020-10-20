package com.unis.common_module.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesUtils {

    public static boolean checkPhone(String phone) {
        if (phone == null || phone.equals("")) {
            return false;
        }
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
        if (phone.matches(PHONE_NUMBER_REG)) {
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String email) {
        if (email == null || email.equals("")) {
            return false;
        }
        String EMAIL_REG = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        if (email.matches(EMAIL_REG)) {
            return true;
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        if (password == null || password.equals("")) {
            return false;
        }
        if (password.length() < 6) {
            return false;
        }
        return checkPwd(password);
    }

    public static boolean checkPwd(String str) {
        Pattern p = Pattern.compile("^(?![A-Z]*$)(?![a-z]*$)(?![0-9]*$)(?![^a-zA-Z0-9]*$)\\S+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean checkIsnumber(String str) {
        String NUMBER_REG = "[0-9]+";
        if (str.matches(NUMBER_REG)) {
            return true;
        }
        return false;
    }

    public static boolean checkIsChar(String str) {
        String CHAR_REG = "[a-zA-Z]+";
        if (str.matches(CHAR_REG)) {
            return true;
        }
        return false;
    }
}
