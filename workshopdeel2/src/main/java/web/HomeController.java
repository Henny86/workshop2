/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Klant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.AdresService;
import service.KlantService;

/**
 *
 * @author jeroenO
 */

    @Controller
@RequestMapping("/")
 
public class HomeController {
   private KlantService klantService;
  
 @Autowired
  public HomeController(KlantService klantService) {
    
      this.klantService = klantService;
    
  }  
   
   
  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home";
  }
  
  @RequestMapping(value="/{klantKlant_Id}", method=RequestMethod.GET)
  public String log(@PathVariable("klantKlant_Id") long klantId, Model model) {
      if (! model.containsAttribute("klant")) {
          
          Klant klant = klantService.findByID(klantId);
          
          model.addAttribute(klant);
      } 
    
    
    return "home";
  }
  

}

