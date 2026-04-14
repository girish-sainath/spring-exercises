package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ThreadIDFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FILTER - ThreadIDFilter - Preprocessing called");
        long threadId = Thread.currentThread().getId();
        servletRequest.setAttribute("threadId", threadId);
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FILTER - ThreadIDFilter - Postprocessing called");
    }

}
