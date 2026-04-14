package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminPanelController {

    @GetMapping("/panel")
    public void getAdminPanel(HttpServletRequest servletRequest) {
        System.out.println("Thread ID - " + servletRequest.getAttribute("threadId") + " - " + "Request Number - " + servletRequest.getAttribute("requestNumber") + " - " + "Admin Panel accessed");
    }

}
