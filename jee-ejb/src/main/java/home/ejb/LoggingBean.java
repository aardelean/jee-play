package home.ejb;

import home.api.interceptors.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by alex on 6/27/2015.
 */
@Log @Interceptor
public class LoggingBean {

    @AroundInvoke
    public Object manageLogging(InvocationContext ctx) throws Exception {
        System.out.println("logger " + ctx.getMethod());
        return ctx.proceed();
    }
}
