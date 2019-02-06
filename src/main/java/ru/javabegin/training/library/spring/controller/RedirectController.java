package ru.javabegin.training.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javabegin.training.library.dao.impl.AuthorService;
import ru.javabegin.training.library.domain.Author;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@Log
public class RedirectController {

    // при запуске проекта - первый запрос попадает сюда
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        // перенаправление на страницу индекс
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }

//    @RequestMapping(value = "/pages/books.xhtml", method = RequestMethod.POST)
//    public String pages(HttpServletRequest request, HttpServletResponse httpServletResponse) {
//        // перенаправление на страницу индекс
//        return "redirect:" + request.getRequestURL().append("/pages/books.xhtml").toString();
//    }

}
