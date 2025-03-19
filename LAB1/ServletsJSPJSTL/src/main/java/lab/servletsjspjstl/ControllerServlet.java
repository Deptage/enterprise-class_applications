package lab.servletsjspjstl;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet(name = "ControllerServlet", value = "/controller-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        ColorBean myBean = new ColorBean();
        myBean.setForegroundColor( request.getParameter("foreColor") );
        myBean.setBackgroundColor( request.getParameter("backColor") );
        request.setAttribute("bean", myBean);

        ServletContext ctx = this.getServletContext();
        RequestDispatcher dispatcher =
                ctx.getRequestDispatcher("/yesterday.jsp");
        dispatcher.forward(request, response);
    }
}
