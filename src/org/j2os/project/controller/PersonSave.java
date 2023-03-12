package org.j2os.project.controller;

import org.j2os.project.common.wrapper.ExceptionWrapper;
import org.j2os.project.entity.Person;
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
 * 2023.03.11   Hadian
 */
@WebServlet("/person/save.do")
public class PersonSave extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            PersonService.getInstance().save(new Person(req.getParameter("name"), req.getParameter("family")));
            resp.sendRedirect("/person/findAll.do");
        } catch (Exception ex) {
            ExceptionWrapper.getError(ex);
            resp.sendError(700);
        }
    }
}
