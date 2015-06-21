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
public class Deconnexion extends HttpServlet {



    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        session.invalidate();
        response.sendRedirect("loadAppartements");

    }
}
