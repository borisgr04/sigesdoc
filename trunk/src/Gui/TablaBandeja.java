/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import ClassEntidad.Documento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author borisgr04
 */
class TablaBandeja extends AbstractTableModel {

    private String[] columnNames={"DE","PARA","ASUNTO","XXX"};
    ArrayList<Documento> data;

    public ArrayList<Documento> getLstdoc() {
        return data;
    }
    public void setLstdoc(ArrayList<Documento> lstdoc) {
        this.data = lstdoc;
    }

  
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }
@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }


    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
@Override
    public Class getColumnClass(int c) {
        
        Object value=this.getValueAt(0,c);
        return (value==null?Object.class:value.getClass());
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
@Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
@Override
public void setValueAt(Object value, int row, int col) {
      Documento macData = (Documento) (data.get(row));
      Documento v=(Documento)value;
      switch (col) {
      case 0:
        //macData.set;
        break;
      case 1:
        //macData.set
        break;
      case 2:
        macData.setAsunto(v.getAsunto());
        break;
      case 3:
        macData.setFecha(v.getFecha());
        break;

      }
    }

@Override
    public Object getValueAt(int row, int col) {
        Documento macData = (Documento) (data.get(row));

        switch (col) {
            case 0:
                return "de";
            case 1:
                return "destino";
            case 2:
                return macData.getAsunto();
            case 3:
                return macData.getFecha();
        }

        return new String();
    }
}
