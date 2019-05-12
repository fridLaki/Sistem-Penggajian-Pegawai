/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.render;

import com.penggajian.util.TextComponentUtils;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ifnu
 */
public class FormatCurencyRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof String){
            label.setText(TextComponentUtils.formatNumber((String)value));
        }
        return label;
    }

}
