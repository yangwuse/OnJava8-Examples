package my.ch23annotation.database;

import bookcode.annotations.database.Constraints;

// 嵌套注解使用

public @interface Uniqueness {
    Constraints constraints() 
    default @Constraints(unique = true);
}
