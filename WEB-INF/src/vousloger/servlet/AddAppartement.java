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
public class AddAppartement extends HttpServlet {

    private BDDHelper bddHelper;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("appart-type");
        String adress = request.getParameter("appart-adress");
        String price = request.getParameter("appart-price");

        if(!(type.equals("") || adress.equals("") || price.equals(""))) {
            this.bddHelper = new BDDHelper();
            HttpSession session = request.getSession(true);
            bddHelper.addAppartement(type, adress, price, (String) session.getAttribute("login") );
            session = request.getSession(true);
            session.setAttribute("newAppart", "1");
            response.sendRedirect("manage");
        }else{
            out.print("<h1>Error on Appartement Creation</h1");
        }
    }
}
