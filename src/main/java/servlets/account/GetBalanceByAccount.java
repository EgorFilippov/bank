package servlets.account;

import services.AccountService;
import services.AccountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account/getbalancebyaccount")
public class GetBalanceByAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String tmp = req.getParameter("accountnumber");
        long accountNumber = Long.parseLong(tmp);
        AccountService accountService = new AccountServiceImpl();
        String result = accountService.getBalance(accountNumber);
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(result);
        printWriter.close();
    }
}