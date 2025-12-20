/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;


/**
 *
 * @author DELL
 */
public  class MainStartUp {
    private Catalog catalog;
    private Control control;
    
    public MainStartUp(Catalog catalog, Control control) {
        this.catalog = catalog;
        this.control = control;
    }

    public void start() {
        
        StartStrategy start = new StartProxy(catalog, control, this);  //MTAGEN NESHUF HWAR EL CONTROL DA!!
        start.start();
        
    }
    

   
}
