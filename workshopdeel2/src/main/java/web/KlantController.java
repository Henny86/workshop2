/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Klant;
import POJOs.Adres;
import POJOs.AdresType;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AdresService;

import service.KlantService;

/**
 *
 * @author jeroenO
 */
@Controller
@RequestMapping("/klanten")
public class KlantController {
     private KlantService klantService;
     private AdresService adresService;
   //  private AdresTypeServiceTijdelijk adresService2;
   

  @Autowired
  public KlantController(KlantService klantService, AdresService adresService) {
    this.klantService = klantService;
    this.adresService = adresService;
  }
  
  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String showRegistrationForm() {
		return "klant";
	}
	
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String processRegistration(@Valid Klant klant, @Valid Adres adres, 
          Errors errors) {    
            if (errors.hasErrors()) {
            return "klant";
            }
            AdresType type = new AdresType();
            type.setAdres_type(0);            // enkel postadressen nog
            klant.getAdressen().put(adres, type);
            adresService.create(adres);
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
      Klant klant = klantService.findByID(klantId);
      Adres adres = new Adres();//adresService2.findByKlant_id(klantId);//(Adres)klant.getAdressen().keySet().toArray()[0];
    model.addAttribute(klant);
    model.addAttribute(adres);
    return "klantscherm";
  }

}
