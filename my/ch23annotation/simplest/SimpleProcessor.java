package my.ch23annotation.simplest;

import java.lang.reflect.Executable;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;

// 简单的注解处理器

@SupportedAnnotationTypes("my.ch23annotation.simplest.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_16)

public class SimpleProcessor extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations, 
    RoundEnvironment roundEnv) {
        for (TypeElement t : annotations)
            System.out.println(t);
        // 显示所有被注解的元素
        for (Element el : roundEnv.getElementsAnnotatedWith(Simple.class)) 
            display(el);
        return false;
    }
    private void display(Element el) {
        System.out.println("==== " + el + " ====");
        System.out.println(el.getKind() + " : " + 
        el.getModifiers() + " : " + el.getSimpleName() + " : " + el.asType());
        if (el.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement) el;
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements());
        }
        if (el.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement) el;
            System.out.println(ex.getReturnType() + " ");
            System.out.println(ex.getSimpleName() + "(");
            System.out.println(ex.getParameters() + ")");
        }
    }

}
