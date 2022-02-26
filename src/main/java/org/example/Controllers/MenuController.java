package org.example.Controllers;


import org.apache.commons.logging.Log;
import org.example.dao.ClientDAO;
import org.example.dao.TourDAO;
import org.example.dao.WorkerDAO;
import org.example.models.Client;
import org.example.models.Tour;
import org.example.models.Worker;
import org.example.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
public class MenuController {

    private final ClientDAO clientDAO;
    private final TourDAO tourDAO;
    private final WorkerDAO workerDAO;

    public MenuController(ClientDAO clientDAO, TourDAO tourDAO, WorkerDAO workerDAO) {
        this.clientDAO = clientDAO;
        this.tourDAO = tourDAO;
        this.workerDAO=workerDAO;
    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("tours",tourDAO.findAll());
        modelAndView.setViewName("menu/main");
        return modelAndView;
    }
    @RequestMapping(value = "/autorize", method = RequestMethod.GET)
    public ModelAndView autorize(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/autorize");
        return modelAndView;
    }
    @RequestMapping(value = "/mainUserEnter", method = RequestMethod.GET)
    public ModelAndView mainUserEnter(Model model,Model model1) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("client", clientDAO.findAll().get(clientDAO.findAll().size() - 1).getFirstName());
        model1.addAttribute("tours",tourDAO.findAll());
        modelAndView.setViewName("menu/mainUserEnter");
        return modelAndView;
    }
    @RequestMapping(value = "/mainUserAurorize", method = RequestMethod.GET)
    public ModelAndView mainUserAurorize(Model model,Model model1) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("client", clientDAO.findAll().get(clientDAO.findAll().size() - 1).getFirstName());
        model1.addAttribute("tours",tourDAO.findAll());
        modelAndView.setViewName("menu/mainUserAurorize");
        return modelAndView;
    }
    @RequestMapping(value = "/inter", method = RequestMethod.GET)
    public ModelAndView inter(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("menu/inter");
        return modelAndView;
    }
    @RequestMapping(value = "/interEror", method = RequestMethod.POST)
    public ModelAndView interEror(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/interEror");
        return modelAndView;
    }
    @RequestMapping(value = "/autorizeEror", method = RequestMethod.POST)
    public ModelAndView interErorClient(@ModelAttribute("client") Client client)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/autorizeEror");
        return modelAndView;
    }
    @RequestMapping(value = "/mainUserAurorize", method = RequestMethod.POST)
    public ModelAndView interRegister(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        Logger log = Logger.getLogger(MenuController.class.getName());
        boolean flag=false;
        for(int i=0;i<clientDAO.findAll().size();i++) {
            if (clientDAO.findAll().get(i).getNumbers().equals(client.getNumbers())) {
                modelAndView.setViewName("forward:/autorizeEror");
                flag=true;
                break;
            }
        }
        if(flag==false) {
            modelAndView.setViewName("redirect:/mainUserAurorize");
            ClientService clientService = new ClientService();
            clientService.saveClient(client);
        }
        return modelAndView;
    }
    @RequestMapping(value = "/mainUserEnter", method = RequestMethod.POST)
    public ModelAndView interClient(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        boolean flag=false;
        for (int i = 0; i < clientDAO.findAll().size() ; i++) {
            if (client.getFirstName().equals(clientDAO.findAll().get(i).getFirstName())
                    && client.getSecondName().equals(clientDAO.findAll().get(i).getSecondName())
                    && client.getNumbers().equals(clientDAO.findAll().get(i).getNumbers()))
            {
                modelAndView.setViewName("redirect:/mainUserEnter");
                flag=true;
                break;
            }}
        if(flag==false)
            modelAndView.setViewName("forward:/interEror");
            return modelAndView;
        }
    @RequestMapping(value = "/tims", method = RequestMethod.GET)
    public ModelAndView tims(@ModelAttribute("worker") Worker worker) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/tims");
        return modelAndView;
    }
    @RequestMapping(value = "/mainAdminEnter", method = RequestMethod.POST)
    public ModelAndView interAdmin(@ModelAttribute("worker") Worker worker) {
        ModelAndView modelAndView = new ModelAndView();
        boolean flag=false;
        for (int i = 0; i < workerDAO.findAll().size() ; i++) {
            if (worker.getFirstName().equals(workerDAO.findAll().get(i).getFirstName())
                    && worker.getSecondName().equals(workerDAO.findAll().get(i).getSecondName())
                    && worker.getNumbers().equals(workerDAO.findAll().get(i).getNumbers()))
            {
                modelAndView.setViewName("redirect:/mainAdminEnter");
                flag=true;
                break;
            }}
        if(flag==false)
            modelAndView.setViewName("forward:/worlerEror");
        return modelAndView;
    }
    @RequestMapping(value = "/worlerEror", method = RequestMethod.POST)
    public ModelAndView interErorAdmin(@ModelAttribute("worker") Worker worker)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu/worlerEror");
        return modelAndView;
    }
    @RequestMapping(value = "/mainAdminEnter", method = RequestMethod.GET)
    public ModelAndView mainAdminEnter(Model model,Model model1) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("worker",workerDAO.findAll().get(workerDAO.findAll().size()-1).getFirstName());
        model1.addAttribute("tours",tourDAO.findAll());
        modelAndView.setViewName("menu/mainAdminEnter");
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("tour", tourDAO.findById(id));
        return "menu/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("tour") Tour tour, @PathVariable("id") int id) {
        tourDAO.update(tour);
        return "redirect:/mainAdminEnter";
    }
    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable("id") int id) {
        model.addAttribute("tour", tourDAO.findById(id));
        return "menu/delete";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
       tourDAO.delete(id);
        return "redirect:/mainAdminEnter";
    }
}
