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
    
    private Load l ;
        boolean current;
        boolean allModesExsist;
    
    public static void main(String[] args)
    {   MainStartUp app = new MainStartUp();
        app.start();
    }
    
    public MainStartUp() {
        catalog = new Catalog(current, allModesExsist);
        control = new Control(catalog,l);
    }
        
       
    
    public void start() {
        
        StartStrategy start = new StartProxy(catalog, control, this);  //MTAGEN NESHUF HWAR EL CONTROL DA!!
        start.start();
        
    }
    public static void restart(){
       MainStartUp app = new MainStartUp();
        app.start();
    }
    

   
}
