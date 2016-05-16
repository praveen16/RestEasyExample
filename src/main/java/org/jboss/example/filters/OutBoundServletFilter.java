package org.jboss.example.filters;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.jboss.logging.Logger;

import javax.servlet.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author pnuthulapati@paypal.com
 */
public class OutBoundServletFilter implements Filter{

//    private static final Logger logger = LoggerFactory.getLogger(OutBoundServletFilter.class);
    private static final Logger logger = Logger.getLogger(OutBoundServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("In OutBoundServletFilter Init method");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            logger.info("In OutBoundServletFilter doFilter method-passing on to JAX-RS resource");
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e){
          logger.error(" Catching UnChecked exception thrown from resource");
            servletResponse.setContentType(MediaType.TEXT_PLAIN);
            PrintWriter pw = servletResponse.getWriter();
            pw.write("Exception caught, RESTEASY-851 test complete");
            pw.flush();
        }
        logger.info("In OutBoundServletFilter doFilter method-back from JAX-RS resource");
    }

    @Override
    public void destroy() {
        logger.info("In OutBoundServletFilter destroy method");
    }
}
