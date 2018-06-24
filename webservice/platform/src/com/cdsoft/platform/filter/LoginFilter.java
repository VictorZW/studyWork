package com.cdsoft.platform.filter;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig req) throws ServletException {
        System.out.println("==========================android登陆过滤器Filter初始化了==========================");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (isOutsidePage(request.getRequestURI()) && session.getAttribute("user") != null) {
            PrintWriter out = response.getWriter();
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();
            String contextPath = servletContext.getContextPath();
            out.println("<script>window.top.location.href='" + contextPath + "/pages/platform/jsp/home/index.jsp" + "'</script>");
            out.flush();
            out.close();
        } else if (isOutsidePage(request.getRequestURI()) || session.getAttribute("user") != null) {
            chain.doFilter(req, resp);
        } else {
            PrintWriter out = response.getWriter();
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();
            String contextPath = servletContext.getContextPath();
            out.println("<script>window.top.location.href='" + contextPath + "/pages/platform/jsp/login.jsp" + "'</script>");
            out.flush();
            out.close();
        }

    }

    @Override
    public void destroy() {
        System.out.println("==========================过滤器Filter销毁了==========================");
    }

    /**
     * 判断是否是登录之前 外边的公共页面
     *
     * @param reqURI
     * @return
     */
    private boolean isOutsidePage(String reqURI) {
        if (reqURI.endsWith("/loginForPC.do") || reqURI.contains("android") || reqURI.endsWith("/login.jsp") || reqURI.endsWith("/loginForAndroidController.do")) {
            return true;
        } else {
            return false;
        }
    }
}
