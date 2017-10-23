package com.centrabank.bik.server.controller;

import com.centrabank.bik.server.domain.BnkseekEntity;
import com.centrabank.bik.server.domain.PznEntity;
import com.centrabank.bik.server.service.BnkseekServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Transactional
public class ViewController {
    @Autowired
    private BnkseekServ bnkseekServ;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<BnkseekEntity> getAll() {
        return bnkseekServ.returnAll();
    }

    @RequestMapping(value = "/allPzn", method = RequestMethod.GET)
    @ResponseBody
    public List<PznEntity> getAllPZN() {
        return bnkseekServ.returnPzn();
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index2(Model model) {
        model.addAttribute("biks", bnkseekServ.returnAll());
        model.addAttribute("pznList", bnkseekServ.returnPzn());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String returnFilter(HttpServletRequest request, Model model) {
        model.addAttribute("pznList", bnkseekServ.returnPzn());
        if (request.getParameter("bikField") != null) {
            model.addAttribute("biks", bnkseekServ.returnByBIKFilter(request.getParameter("bikField").toString()));

        } else if (request.getParameter("bikRegion") != null) {
            model.addAttribute("biks", bnkseekServ.returnByBikRegion(request.getParameter("bikRegion")));

        } else if (request.getParameter("bikPznType") != null) {
            model.addAttribute("biks", bnkseekServ.returnByPznType(request.getParameter("bikPznType")));
        }
        return "index";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBnkseek(@PathVariable("id") long id, Model model) {
        model.addAttribute("bik", bnkseekServ.returnOneBnkseek(id));
        model.addAttribute("pznList", bnkseekServ.returnPzn());
        model.addAttribute("realyList", bnkseekServ.returnRealy());
        model.addAttribute("regList", bnkseekServ.returnReg());
        model.addAttribute("tnpList", bnkseekServ.returnTnp());
        model.addAttribute("uerList", bnkseekServ.returnUer());
        return "bik";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBnkseek(Model model, @ModelAttribute BnkseekEntity bnkseek, HttpServletRequest request) {
        bnkseek.setTnp(bnkseekServ.returnOneTnp(request.getParameter("bikTnpType")));
        bnkseek.setUer(bnkseekServ.returnOneUer(request.getParameter("bikUerType")));
        bnkseek.setPzn(bnkseekServ.returnOnePzn(request.getParameter("bikPznType")));
        bnkseek.setRealy(bnkseekServ.returnOneRealy(request.getParameter("bikRealyType")));
        bnkseek.setRgn(bnkseekServ.returnOneRgn(request.getParameter("bikRegType")));
        manager.merge(bnkseek);
        // bnkseekServ.saveBnkseek(bnkseek);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBnkseek(Model model, @PathVariable("id") long id) {
        bnkseekServ.deleteBnkseek(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newBik(Model model) {
        model.addAttribute("bik", new BnkseekEntity());
        model.addAttribute("pznList", bnkseekServ.returnPzn());
        model.addAttribute("realyList", bnkseekServ.returnRealy());
        model.addAttribute("regList", bnkseekServ.returnReg());
        model.addAttribute("tnpList", bnkseekServ.returnTnp());
        model.addAttribute("uerList", bnkseekServ.returnUer());
        return "bikNew";
    }
}
