package servlets.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import entitys.Account;
import services.AccountService;
import services.AccountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account/changebalancebyaccount")
public class ChangeBalance extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder jb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) { /**/ }

        ObjectMapper mapper = new ObjectMapper();
        Account inputAccount = mapper.readValue(jb.toString(), Account.class);
        AccountService accountService = new AccountServiceImpl();
        String json = accountService.changeBalance(inputAccount.getAccountNumber(), inputAccount.getBalance());

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        printWriter.write(json);
        printWriter.close();
    }

}