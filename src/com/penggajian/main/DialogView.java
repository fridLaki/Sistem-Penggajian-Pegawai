/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.main;

import com.stripbandunk.jglasspane.JGlassPane;
import com.stripbandunk.jglasspane.component.MessageComponent;
import javax.swing.JDialog;

/**
 *
 * @author MY-IT-STAF
 */
public abstract class DialogView extends JDialog implements View {
    
    private JGlassPane jGlassPane;
    private MessageComponent messageComponent;
    private MainView mainView;

    public DialogView(MainView mainView) {
        super(mainView, true);
        initGalssPanes();
    }

    public MainView getMainView() {
        return mainView;
    }

    private void initGalssPanes() {
        jGlassPane = new JGlassPane();
        
        messageComponent = new MessageComponent();
        jGlassPane.addGlassPaneComponent(messageComponent);
        
        setGlassPane(jGlassPane);
        getGlassPane().setVisible(true);
    }
    
    public void showWarning(String message){
        messageComponent.showWarning(message);
    }        
    
    public void showError(String message){
        messageComponent.showError(message);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
    
}
