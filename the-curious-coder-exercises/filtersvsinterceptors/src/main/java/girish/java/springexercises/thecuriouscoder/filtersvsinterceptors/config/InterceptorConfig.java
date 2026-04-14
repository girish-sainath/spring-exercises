package girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.config;

import girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.interceptors.RoleCheckInterceptor;
import girish.java.springexercises.thecuriouscoder.filtersvsinterceptors.interceptors.TimingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    RoleCheckInterceptor roleCheckInterceptor;

    @Autowired
    TimingInterceptor timingInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(roleCheckInterceptor).addPathPatterns("/admin/**");
        registry.addInterceptor(timingInterceptor);
    }
}
