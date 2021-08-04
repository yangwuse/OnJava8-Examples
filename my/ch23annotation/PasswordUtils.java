package my.ch23annotation;

import java.util.List;

// 用例注解使用

public class PasswordUtils {
    @UseCase(id = 47, description = 
    "Passwords must contain at least one numeric")
    public boolean validatePassword(String passwd) {
        return (passwd.matches("\\w*\\d\\w*"));
    }
    @UseCase(id = 48)
    public String encryptPassword(String passwd) {
        return new StringBuffer(passwd).reverse().toString();
    }
    @UseCase(id = 49, description = 
    "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String passwd) {
        return !prevPasswords.contains(passwd);
    }
}
