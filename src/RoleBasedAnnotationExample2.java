//--- Custom Annotation example 3 to Role-Based Access Control----

/*
*  Role-Based Access Control
Use Case: Restrict method access based on user roles.
👉 Benefit: Enforces role-based security without modifying business logic.
* */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // it will available on runtnime
@Target(ElementType.METHOD)//deleteUser method per es annotation ko used kerna chatu hu
@interface RequiresRole2{
    String value();
}

//Usage
class UserService2{
    @RequiresRole2("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted.");
    }
}

//Processing the Annotation
public class RoleBasedAnnotationExample2 {

    public static void checkAccess(UserService2 obj,String userRole) throws InvocationTargetException, IllegalAccessException {
        for (Method method : obj.getClass().getMethods()) {
            if (method.isAnnotationPresent(RequiresRole2.class)) {
                String requiredRole = method.getAnnotation(RequiresRole2.class).value();
                if (!userRole.equals(requiredRole)) {
                    throw new SecurityException("Access Denied!");
                }
                method.invoke(obj);

            }

            }

        }

    public static void main(String[] args) throws Exception {
        UserService2 service = new UserService2();
        try {
            checkAccess(service, "USER");  // Throws exception (USER is not ADMIN)
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }

        checkAccess(service, "ADMIN");  // Works fine

    }
}
