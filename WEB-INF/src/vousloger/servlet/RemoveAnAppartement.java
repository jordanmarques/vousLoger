package vousloger.servlet;

import vousloger.helper.BDDHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jordanmarques on 21/06/15.
 */
public class RemoveAnAppartement extends HttpServlet {

    private BDDHelper bddHelper;

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

        this.bddHelper = new BDDHelper();
        bddHelper.removeAnAppartement(request.getParameter("appartement-id"));
        response.sendRedirect("manage");

    }
}
