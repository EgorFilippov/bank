package servlets.card;

import services.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/card/create")
public class CreateCard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String tmp = req.getParameter("accountnumber");
        Long accountNumber = Long.parseLong(tmp);
        CardServiceImpl cardServiceImpl = new CardServiceImpl();
        cardServiceImpl.createCard(accountNumber);
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Create card");
        printWriter.close();
    }
}