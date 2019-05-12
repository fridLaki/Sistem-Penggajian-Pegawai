/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penggajian.view;

import com.penggajian.main.DialogView;
import com.penggajian.main.MainView;
import java.awt.Window;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author echo
 */
public class CetakLaporanView extends DialogView {

    public CetakLaporanView(MainView formApp, JasperPrint print) {
        super(formApp);
        initComponents();

        JRViewer viewer = new JRViewer(print);
        getContentPane().add(viewer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laporan Penggajian Bulanan");

        setSize(new java.awt.Dimension(1407, 997));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void display(Window formApp, Object parameter) {
        setLocationRelativeTo(formApp);
        setVisible(true);
    }
}