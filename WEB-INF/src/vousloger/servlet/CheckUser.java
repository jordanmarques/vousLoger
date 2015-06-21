package vousloger.servlet;

import vousloger.helper.BDDHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jordanmarques on 21/06/15.
 */
public class CheckUser extends HttpServlet {

    private BDDHelper bddHelper;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String login = request.getParameter("authentication-login");
        String mdp = request.getParameter("authentication-password");


        this.bddHelper = new BDDHelper();
        String name = bddHelper.checkUser(login, mdp);
        if(!name.equals(null)){
            HttpSession session = request.getSession(true);
            session.setAttribute("name", name);
            session.setAttribute("login", login);
            session.setAttribute("mdp", name);
        }

        response.sendRedirect("loadAppartements");

    }
}
