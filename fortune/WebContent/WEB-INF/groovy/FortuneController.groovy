package org.springframework.showcase.fortune.web;

import org.springframework.showcase.fortune.service.FortuneService;
import org.springframework.showcase.fortune.domain.Fortune;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FortuneController implements Controller {

    @Property Fortune fortune1

    @Property Fortune fortune2

    public ModelAndView handleRequest(
            HttpServletRequest request, HttpServletResponse httpServletResponse) {
        return new ModelAndView("tell", "fortune", this.fortune1)
    }

}
