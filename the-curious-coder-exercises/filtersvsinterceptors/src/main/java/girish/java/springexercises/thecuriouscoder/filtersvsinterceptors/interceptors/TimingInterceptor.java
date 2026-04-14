package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TimingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("INTERCEPTOR - TimingInterceptor - Preprocessing called");
        servletRequest.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) servletRequest.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("INTERCEPTOR - TimingInterceptor - Postprocessing called");
        System.out.println("INTERCEPTOR - TimingInterceptor - Execution time: " + executionTime + " ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest servletRequest, HttpServletResponse servletResponse, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(servletRequest, servletResponse, handler, ex);
    }
}
