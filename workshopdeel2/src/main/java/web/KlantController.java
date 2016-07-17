/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import POJOs.Klant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     private static final String MAX_LONG_AS_STRING = "9223372036854775807";

  @Autowired
  public KlantController(KlantService klantService) {
    this.klantService = klantService;
  }

  @RequestMapping(method=RequestMethod.GET)
  public List<Klant> klanten(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return klantService.findAll();
  }

  @RequestMapping(value="/{klantKlant_Id}", method=RequestMethod.GET)
  public String klant(
      @PathVariable("klantKlant_Id") long klantId, 
      Model model) {
    model.addAttribute(klantService.findByID(klantId));
    return "klanten";
  }
/*
  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) throws Exception {
    spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
        form.getLongitude(), form.getLatitude()));
    return "redirect:/spittles";
  }
*/
}
