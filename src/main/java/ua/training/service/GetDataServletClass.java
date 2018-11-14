package ua.training.service;

import ua.training.model.IllegalLoginException;
import ua.training.model.Record;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.RecordBookDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class GetDataServletClass extends HttpServlet {
    private static DaoFactory daoFactory;
    private static RecordBookDao recordBookDao;

    @Override
    public void init() throws ServletException {
        daoFactory = DaoFactory.getInstance();
        recordBookDao = daoFactory.createRecordBookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("tableData", recordBookDao.findAll());

        request.getRequestDispatcher("/view/index.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("addValue") != null) {
            try {
                recordBookDao.create(new Record(
                        request.getParameter("firstNameField"),
                        request.getParameter("lastNameField"),
                        request.getParameter("loginField"),
                        request.getParameter("commentField"),
                        request.getParameter("phoneField"),
                        request.getParameter("emailField")));
            } catch (IllegalLoginException ex) {
                ex.printStackTrace();
            }
        }

        doGet(request, response);
    }
}
