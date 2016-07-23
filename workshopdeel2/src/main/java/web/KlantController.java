/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Klant;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.KlantService;

/**
 *
 * @author jeroenO
 */
@Controller
@RequestMapping("/klanten")
public class KlantController {
     private KlantService klantService;
   

  @Autowired
  public KlantController(KlantService klantService) {
    this.klantService = klantService;
  }
  
  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String showRegistrationForm() {
		return "klant";
	}
	
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String processRegistration(@Valid Klant klant, Errors errors) {    
            if (errors.hasErrors()) {
            return "klant";
            }
            klantService.create(klant);            
            return "redirect:/klanten/"; //+ klant.getVoornaam()
        }
  
  @RequestMapping(method=RequestMethod.GET)
  public List<Klant> klanten( ) {
    return klantService.findAll();
  }

  @RequestMapping(value="/{klantKlant_Id}", method=RequestMethod.GET)
  public String klant(
      @PathVariable("klantKlant_Id") long klantId, 
      Model model) {
    model.addAttribute(klantService.findByID(klantId));
    return "klanten";
  }

}
