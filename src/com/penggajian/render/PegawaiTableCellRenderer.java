/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penggajian.render;

import com.penggajian.entity.MasterPegawai;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author echo
 */
public class PegawaiTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof MasterPegawai ) {
            MasterPegawai pegawai = (MasterPegawai) value;
            label.setText(pegawai.getNip());
            if (pegawai.getStatusKepegawaian().equals("Pegawai Tetap (PT)")) {
                label.setText("<html><font color=\"green\">" + pegawai.getNip() + "</font></html>");
            } else if(pegawai.getStatusKepegawaian().equals("Calon Pegawai (CP)")) {
                label.setText("<html><font color=\"blue\">" + pegawai.getNip() + "</font></html>");
            } else {
                label.setText("<html><font color=\"black\">" + pegawai.getNip() + "</font></html>");
            }
        }
        return label;
    }
}
