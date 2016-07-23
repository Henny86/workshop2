package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import POJOs.Adres;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import service.AdresService;

import javax.validation.Valid;

import org.springframework.validation.Errors;

@Controller
@RequestMapping("/Adres")
public class AdresController {
	
	private AdresService adresService;
	
	@Autowired
	public AdresController(AdresService adresService) {
		this.adresService = adresService;
	}
	/* Wordt nu door KlantController gedaan
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm() {
		return "adres";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid Adres adres, Errors errors) {    
            if (errors.hasErrors()) {
            return "adres";
            }
            adresService.create(adres);
            return "redirect:/adressen/list"; //+ adres.getStraatnaam()
        }

	*/
	@RequestMapping(method=RequestMethod.GET)
	public List<Adres> adressen() {
		return adresService.findAll();
	}
        
        @RequestMapping(value="/{adresAdresID}", method=RequestMethod.GET)
        public String adres(
        @PathVariable("adresAdresID") long adresId, Model model) {
            model.addAttribute(adresService.findById(adresId));
            return "adres";
  }
 
}
