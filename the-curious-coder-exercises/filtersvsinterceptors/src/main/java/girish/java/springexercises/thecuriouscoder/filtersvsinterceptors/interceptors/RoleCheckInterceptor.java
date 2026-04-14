package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RoleCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler) throws Exception {
        System.out.println("INTERCEPTOR - RoleCheckInterceptor - Preprocessing called");
        String role = servletRequest.getHeader("role");
        if (role == null || !role.equals("admin")) {
            System.out.println("INTERCEPTOR - RoleCheckInterceptor - Unauthorized access attempt");
            servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletResponse.getWriter().write("Unauthorized: Admin role required");
            return false;
        }
        System.out.println("INTERCEPTOR - RoleCheckInterceptor - Authorized access");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("INTERCEPTOR - RoleCheckInterceptor - Postprocessing called");
    }

    @Override
    public void afterCompletion(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler, Exception ex) throws Exception {
        System.out.println("INTERCEPTOR - RoleCheckInterceptor - After completion called");
    }
}
