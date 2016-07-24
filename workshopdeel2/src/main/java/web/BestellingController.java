/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import POJOs.BestelArtikel;
import service.BestellingService;
import POJOs.Bestelling;
import java.util.HashSet;

@Controller
public class BestellingController {
	
	private BestellingService bestellingService;
	
	@Autowired(required=true)
	@Qualifier(value="bestellingService")
	public void setBestellingService(BestellingService ps){
		this.bestellingService = ps;
	}
	
	@RequestMapping(value = "/bestelling", method = RequestMethod.GET)
	public String listBestelling(Model model, Long ID) {
            
		model.addAttribute("bestelartikel", new BestelArtikel());
		//model.addAttribute("listArtikel", this.bestellingService.findById(ID).getBestelArtikelSet());
               // model.addAttribute("listArtikel", new HashSet<BestelArtikel>());
                 model.addAttribute("listArtikel", new Bestelling());
		return "bestelling";
	}
        
	//For add and update person both
	@RequestMapping(value= "/bestelling/add", method = RequestMethod.POST)
	public String addArtikel(@ModelAttribute("bestelartikel") BestelArtikel p, Long ID){
		
		if(p.getBestelling_artikel_id() == 0){
			//new person, add it
                        BestellingService b = new BestellingService();
                        Bestelling bestelling = b.findById(ID);
                        bestelling.getBestelArtikelSet().add(p);
			this.bestellingService.update(bestelling);
		}
		
		return "redirect:/bestelling";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeArtikel(@PathVariable("id") Long id, BestelArtikel bestelArtikel){
                        BestellingService b = new BestellingService();
                        Bestelling bestelling = b.findById(id);
                        bestelling.getBestelArtikelSet().remove(bestelArtikel);
			this.bestellingService.update(bestelling);		
        return "redirect:/bestelling";
    }
 
    @RequestMapping("/edit/{id}")
    public String editArtikel(@PathVariable("id") Long id, Model model, BestelArtikel bestelArtikel){
		model.addAttribute("bestelartikel", new BestelArtikel());
		model.addAttribute("listArtikel", this.bestellingService.findById(id).getBestelArtikelSet());
                        BestellingService b = new BestellingService();
                        Bestelling bestelling = b.findById(id);
                        bestelling.getBestelArtikelSet().remove(bestelArtikel); //haal bestelArtikel met oude gegevens eerst weg
                        bestelling.getBestelArtikelSet().add(bestelArtikel); // voeg bestelArtikel met geupdate gegevens toe.
			this.bestellingService.update(bestelling);
        return "bestelling";
    }
	
}