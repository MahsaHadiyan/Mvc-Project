package org.j2os.project.controller;

import org.j2os.project.common.wrapper.ExceptionWrapper;
import org.j2os.project.service.PersonService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.11   Mahsa.h
 */
@WebServlet("/person/findAll.do")
public class PersonFindAll extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.setAttribute("list", PersonService.getInstance().findAll());
            req.getRequestDispatcher("/person/index.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", ExceptionWrapper.getError(e));
            resp.sendError(700);
        }
    }
}
