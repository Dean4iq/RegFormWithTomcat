package ua.training.service;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class GetDataServletClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/index.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }
}
