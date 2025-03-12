
import java.lang.reflect.Method;

class MyClass {
    public void sayHello() {}
}

public class ReflectionApiExample {
    public static void main(String[] args) {
        Class<?> obj = MyClass.class;
        for (Method method : obj.getDeclaredMethods()) {
            System.out.println("Method Name: " + method.getName());//Method Name: sayHello

        }
    }
}
