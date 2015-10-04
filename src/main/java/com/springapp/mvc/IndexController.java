package com.springapp.mvc;

import com.springapp.mvc.Model.Vare;
import com.springapp.mvc.dao.VareDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by benny on 29.09.15.
 */
@Controller
public class IndexController {

    @Autowired
    private VareDAO vareDAO;


    @RequestMapping(value="/")
    public ModelAndView listVare(ModelAndView model) throws IOException{
        List<Vare> listVare = vareDAO.list();
        model.addObject("listVare", listVare);
        model.setViewName("home");

        return model;
    }

//ny vare kontroller
    @RequestMapping(value = "/newVare", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Vare nyVare = new Vare();
        model.addObject("vare", nyVare);
        model.setViewName("VareForm");
        return model;
    }


    //Kontrolelr for å lagre vare
    @RequestMapping(value = "/saveVare", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Vare vare)  {
        vareDAO.saveOrUpdate(vare);
        return new ModelAndView("redirect:/");
    }

    //Kontroller for å slette vare
    @RequestMapping(value = "/deleteVare", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        vareDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }


    //Kontroller for å endre vare
    @RequestMapping(value = "/editVare", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int vareId = Integer.parseInt(request.getParameter("id"));
        Vare vare = vareDAO.get(vareId);
        ModelAndView model = new ModelAndView("VareForm");
        model.addObject("vare", vare);

        return model;
    }


}
