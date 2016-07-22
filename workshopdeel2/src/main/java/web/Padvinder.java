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
        
        
         if (filePath == null) filePath = new File("").getAbsolutePath();
         return filePath;
    }
    
}
