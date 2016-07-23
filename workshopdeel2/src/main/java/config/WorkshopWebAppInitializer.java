/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.Padvinder;

/**
 *
 * @author jeroenO
 */
public class WorkshopWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { Workshopdeel2Config.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
    //    String filePath = Padvinder.getPath();
        registration.setMultipartConfig(   
                 new MultipartConfigElement("/home/jeroen/NetBeansProjects/workshop2/workshopdeel2/src/main/webapp", 2097152, 4194304, 0));
          //  new MultipartConfigElement(filePath  + "/src/main/webapp" , 2097152, 4194304, 0));
          // /home/jeroen/NetBeansProjects/workshop2/workshopdeel2/src/main/webapp/resources/images/artikel
  }
}
