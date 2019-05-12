/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.main;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Windows
 */
public class Main implements Runnable{

    private MainView mainView;
    
    public Main() {
        mainView = new MainView();
    }
    
    public void start(){
        SwingUtilities.invokeLater(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
            if("Windows".equals(info.getName())){
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                } finally {
                    //Spring
                    SpringManager.getInstance();
                    
                    //Run App
                    Main main = new Main();
                    main.start();
                }
            }
        }
        /*MainView mainView = new MainView();
        mainView.setVisible(true);*/
    }

    @Override
    public void run() {
        mainView.setVisible(true);

    }
    
}
