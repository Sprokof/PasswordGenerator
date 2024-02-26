package password.controller;

import password.generator.PasswordGenerator;
import password.model.Password;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GeneratorServlet extends HttpServlet {
    private PasswordGenerator generator;

    @Override
    public void init()  {
        this.generator = new PasswordGenerator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String len = req.getParameter("length");
        String path = "/WEB-INF/jsp/generator.jsp";
        if(len != null){

            int length = Integer.parseInt(len);
            boolean lower = Boolean.parseBoolean(req.getParameter("l"));
            boolean upper = Boolean.parseBoolean(req.getParameter("u"));
            boolean digits = Boolean.parseBoolean(req.getParameter("d"));
            boolean punctuation = Boolean.parseBoolean(req.getParameter("p"));

            Password generated = this.generator.useUpper(upper)
                    .useLower(lower)
                    .useDigits(digits)
                    .usePunctuation(punctuation)
                    .generate(length);
            req.setAttribute("generated", generated);

            path = "/WEB-INF/jsp/result.jsp";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
