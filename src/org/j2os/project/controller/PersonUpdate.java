package org.j2os.project.controller;

import org.j2os.project.common.wrapper.ExceptionWrapper;
import org.j2os.project.entity.Person;
import org.j2os.project.service.PersonService;

import javax.servlet.ServletException;
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
@WebServlet("/person/update.do")
public class PersonUpdate extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService.getInstance().update(new Person(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("family")));
            resp.sendRedirect("/person/findAll.do");
        } catch (Exception e) {
            req.setAttribute("error", ExceptionWrapper.getError(e));
            resp.sendError(700);
        }
    }
}
