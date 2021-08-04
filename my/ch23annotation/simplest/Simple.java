package my.ch23annotation.simplest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE,
         ElementType.CONSTRUCTOR, ElementType.FIELD,
         ElementType.LOCAL_VARIABLE, ElementType.METHOD,
         ElementType.PACKAGE})
public @interface Simple {
    String value() default "-default-";
}
