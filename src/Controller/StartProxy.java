/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Catalog;

/**
 *
 * @author DELL
 */
public class StartProxy implements StartStrategy {
    private StartStrategy realStart;
    private Catalog catalog;
    private Control control;
    private MainStartUp startup;

    public StartProxy(Catalog catalog, Control control, MainStartUp startup) {
        this.catalog = catalog;
        this.control = control;
        this.startup = startup;
    }

    @Override
    public void start() {
        if (catalog.isCurrent()) {
            realStart = new ContinueGame(startup);
        } else if (catalog.isAllModesExist()) {
            realStart = new StartNewGame(startup);
        } else {
            realStart = new SolutionFinder(control);   //bnb3t control 3shan haga kda, MHTAGEN N CHECK!!!!
        }

        realStart.start();
    }
}

