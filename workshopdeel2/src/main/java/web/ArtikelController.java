/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Artikel;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import service.ArtikelService;

/**
 *
 * @author jeroenO
 */
@Controller
@RequestMapping("/catalogus")
public class ArtikelController {
    private ArtikelService artikelService;
    
@Autowired
public ArtikelController(ArtikelService artikelService) {
    this.artikelService = artikelService;
}
 
@RequestMapping(method=RequestMethod.GET)
public List<Artikel> artikelen()  {
    return artikelService.findAll();
  }

@RequestMapping(value="/{artikelArtikelID}", method=RequestMethod.GET)
  public String artikel(
      @PathVariable("artikelArtikelID") long artikelId, 
      Model model) {
    model.addAttribute(artikelService.findById(artikelId));
    return "artikelen";
  }

@RequestMapping(value="/register", method=GET)
  public String showRegistrationForm() {
    return "artikelCatalogus";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @Valid Artikel artikel, 
      Errors errors) {
    if (errors.hasErrors()) {
      return "artikelCatalogus";
    }
    
    artikelService.create(artikel);
    return "redirect:/catalogus/"; //  /" + artikel.getArtikelNaam();
  }
 
  
  
  
}
