/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.File;

/**
 *
 * @author jeroenO
 */

public class Padvinder {
    public static String filePath;
    
    public static String getPath(){
        
        final File f = new File(Padvinder.class.getProtectionDomain().getCodeSource().getLocation().getPath());
         if (filePath == null) filePath = f.getPath();
         return filePath;
    }
    
}
