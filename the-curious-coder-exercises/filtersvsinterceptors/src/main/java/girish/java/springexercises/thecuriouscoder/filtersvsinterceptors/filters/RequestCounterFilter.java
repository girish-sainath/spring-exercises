package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestCounterFilter implements Filter {

    private int counter = 0;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("FILTER - RequestCounterFilter - Preprocessing called");
        counter++;
        servletRequest.setAttribute("requestNumber", counter);

        filterChain.doFilter(servletRequest, servletResponse);

        servletResponse.getWriter().write("Request #" + servletRequest.getAttribute("requestNumber") + " processed");
        System.out.println("FILTER - RequestCounterFilter - Postprocessing called");
    }
}
