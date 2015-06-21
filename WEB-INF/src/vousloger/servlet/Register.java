package vousloger.servlet;

import vousloger.helper.BDDHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jordanmarques on 21/06/15.
 */
public class Register extends HttpServlet {

    private BDDHelper bddHelper;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("register-name");
        String login = request.getParameter("register-login");
        String mdp = request.getParameter("register-password");

        this.bddHelper = new BDDHelper();
        bddHelper.register(name, login, mdp);
        response.sendRedirect("loadAppartements");
    }
}
