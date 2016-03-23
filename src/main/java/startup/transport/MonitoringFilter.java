package startup.transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import startup.service.WhoAmIService;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by poussma on 17/03/16.
 */
@Component
public class MonitoringFilter implements Filter {

    @Autowired
    private WhoAmIService whoAmI;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // void
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ((HttpServletResponse) servletResponse).addHeader("X-Served-By", whoAmI.tellMe());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // void
    }
}
