/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Artikel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
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
import org.springframework.web.bind.annotation.RequestPart;
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

@RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new Artikel());  
    return "artikelCatalogus";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration( @RequestPart("profilePicture") Part profilePicture,
      @Valid Artikel artikel, 
      Errors errors) {
    if (errors.hasErrors()) {
      return "artikelCatalogus";
    }
    
        try {
            profilePicture.write("/resources/images/artikel/" + artikel.getArtikelNaam() );
        } catch (IOException ex) {
            Logger.getLogger(ArtikelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(ArtikelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    artikelService.create(artikel);
    return "redirect:/catalogus"; //  /" + artikel.getArtikelNaam();
  }
 
 
   @RequestMapping(value= "/remover/{artikelArtikelID}", method=RequestMethod.POST)
    public String removeArtikel( @PathVariable("artikelArtikelID") long artikelID)  {
        
        artikelService.delete(artikelID);
        return "redirect:/catalogus";
    }
  
  
  
}
