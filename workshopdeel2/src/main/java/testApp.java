import web.Padvinder;



public class testApp {
  
	public static void main(String[] args) {
            System.out.println("pad:  " +  Padvinder.getPath());
            /*
            ApplicationContext context = new AnnotationConfigApplicationContext(Workshopdeel2Config.class);
          //  AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
            
           
		KlantService klantService = context.getBean(KlantService.class);
		AccountService accountService = context.getBean(AccountService.class);//new AccountService();
		//KlantDao dao = new KlantDao();
                AdresDao adresDao = new AdresDao();
				
		Klant klant1 = new Klant();
		klant1.setAchternaam("tester");
		klant1.setTussenvoegsel("de");
		klant1.setVoornaam("testertje");
		klant1.setEmail("test@testen.com");
		
		Klant klant2 = new Klant();
		klant2.setAchternaam("controlerd");
		klant2.setTussenvoegsel("die");
		klant2.setVoornaam("controletest");
		klant2.setEmail("test@control.com");
		
		Klant klant3 = new Klant();
		klant3.setAchternaam("extra");
		klant3.setTussenvoegsel("eens");
		klant3.setVoornaam("testnog");
		klant3.setEmail("nogeens@extra.com");
		klant3 = klantService.findByID(5);
		Account account1 = context.getBean(Account.class); //(Account) klant3.getAccountSet().toArray()[0];//context.getBean(Account.class); //(Account) klant3.getAccountSet().toArray()[0];//new Account(); ////new Account();
		klant1.setKlantID(5);
		account1.setKlant(klant1);
	//	account1.setNaam(klant1.getAchternaam());
              //  account1.setAccount_id(8);
		
		Bestelling bestelling1 = new Bestelling();
               Set<Account> accountSet = new HashSet();
               accountSet.add(account1);
               klant1.setAccountSet(accountSet);
		Account account2 = new Account();
		klant2.setKlantID(2);
		account2.setKlant(klant2);
		account2.setNaam(klant2.getAchternaam());
		
		
		
		Account account3 = new Account();
		//klant3.setKlantID(3);
		//account3.setKlant(klant3);
		//account3.setNaam(klant3.getAchternaam());
                
                
                Adres adres1 = new Adres();
                adres1.setPostcode("2345AB");
                adres1.setHuisnummer(3);
                adres1.setStraatnaam("straatje");
                adres1.setWoonplaats("grote stad");
		
		
		System.out.println("--------toevogen gestart------");
	//	klantService.create(klant1);
		//dao.create(klant1);
          //       adresDao.save(adres1);
		//accountService.findByID(2);//create(account1);
             accountService.update(account1);
		//klantService.create(klant2);
		//dao.create(klant2);
		//accountService.create(account2);
		//klantService.create(klant3);
		//dao.create(klant3);
		//accountService.create(account3);
		/*List<Klant> klanten = klantService.findAll();
		//List<Klant> klanten = dao.findAll();
		System.out.println("toegevoegd zijn: ");
		for (Klant k : klanten) {
			System.out.println("-" + k.toString());
		} */
		/*
		System.out.println("---------updaten gestart------");
		klant1.setAchternaam("geluktte");
		klant1.setKlantID(2);
		klantService.update(klant1);
		account2.setNaam("Nieuwe naam");
		account2.setAccount_id(7);
		accountService.update(account2);
		
		System.out.println("geupdate klant is:" + klantService.findByID(klant1.getKlantID()).toString());
		
		System.out.println("---------zoeken gestart-------");
		int id = 4; //klant2.getKlantID();
		Klant gevonde = klantService.findByID(id);
		System.out.println("gezocht met " + id + " gevonden " + gevonde.toString());
		
		int acountid = 7;
		Account gevondeA = accountService.findByID(acountid);
		System.out.println("gezocht met id: " + acountid + " gevonden " + gevondeA.toString());
		
		System.out.println("---------verwijderen gestart---");
		klant3.setKlantID(3);
		int verwijderen = klant3.getKlantID();
		klantService.delete(klant3); 
		account3.setAccount_id(8);
		accountService.delete(account3);		
		System.out.println("klant verwijdert met id: " + verwijderen);
		System.out.println("nu zijn er " + klantService.findAll().size() + "klanten");
		
		System.out.println("---------zoek alle gestart-----");
		List<Klant> klanten2 = klantService.findAll();
		//List<Klant> klanten2 = dao.findAll();
		System.out.println("gevonden klanten zijn: ");
		for (Klant k2 : klanten2) {
			System.out.println("-" + k2.toString());
		}
		
		List<Account> accounten = accountService.findAll();
		System.out.println("gevonden acounten zijn: ");
		for (Account a : accounten) {
			System.out.println("-" + a.toString());
		}
*/
	//	HibernateUtil.DestroyRegistery();	
	//	JPAUtil.DestroyRegistery();	
	//	System.out.println("--------Tests klaar------------");
                
	}	
}
