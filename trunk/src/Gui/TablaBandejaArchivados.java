/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import ClassEntidad.Documento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author borisgr04
 */
class TablaBandejaArchivados extends AbstractTableModel {

    private String[] columnNames = {"N° Doc","PARA","DE", "ASUNTO", "FECHA","ESTADO"};
    List<Documento> data;

    public List<Documento> getLstdoc() {
        return data;
    }
 @Override
    public boolean isCellEditable (int row, int column)
   {
       // Aquí devolvemos true o false según queramos que una celda
       // identificada por fila,columna (row,column), sea o no editable
    
       return false;
   }
    public void setLstdoc(List<Documento> lstdoc) {
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

        Object value = this.getValueAt(0, c);
        return (value == null ? Object.class : value.getClass());
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
//    @Override
//    public boolean isCellEditable(int row, int col) {
//        //Note that the data/cell address is constant,
//        //no matter where the cell appears onscreen.
//        if (col < 2) {
//            return false;
//        } else {
//            return true;
//        }
//    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        /*
        DistribucionDoc macData = (DistribucionDoc) (data.get(row));
        switch (col) {
            case 0:
                macData.setIdPerProd((String)value);
                break;
            case 1:
                macData.setIdPerDest((String)value);
                break;
            case 2:
                macData.setAsunto((String)value);
                break;
            case 3:
                //macData.setf((Date)value);
                break;
            case 4:
                macData.setEstado((String) value);
                break;

        }*/
    }

    public  Documento getDoc(int row){
        return (Documento) (data.get(row));
    }
 
    @Override
    public Object getValueAt(int row, int col) {
        Documento macData = (Documento) (data.get(row));

        switch (col) {
            case 0:
                return macData.getNoDocumento();
            case 1:
                return macData.getPara().getNombres();   
            case 2:
                return macData.getDe().getNombres();
            case 3:
                return macData.getAsunto();
            case 4:
                return macData.getFechaReg();
            case 5:
                return macData.getEstado();
            
        }

        return new String();
    }
}
