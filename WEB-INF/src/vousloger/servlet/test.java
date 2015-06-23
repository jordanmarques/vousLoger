package vousloger.servlet;

import vousloger.helper.BDDHelper;
import vousloger.pojo.Appartement;
import vousloger.pojo.Proprietaire;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by jordanmarques on 23/06/15.
 */


public class Test extends HttpServlet {

    private BDDHelper bddHelper;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);
        out.print(session.getAttribute("login").toString());

        BDDHelper bddHelper = new BDDHelper();
        List<Appartement> appartementList = bddHelper.loadAppartementsOnSaleByUser((String) session.getAttribute("login"));

        for(Appartement appart : appartementList){out.println("<tr>");
            out.println("<td>"+appart.getTypeAppat()+"</td>");
            out.println("<td>"+appart.getAdresse()+"</td>");
            out.println("<td>"+appart.getMontantVente()+" "+"&#8364"+"</td>");
            out.println("</tr>");
        }

    }
}
