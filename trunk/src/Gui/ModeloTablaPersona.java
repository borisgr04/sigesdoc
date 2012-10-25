/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;



import ClassEntidad.Persona;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author borisgr04
 */
class ModeloTablaPersona extends AbstractTableModel {

    private String[] columnNames = {"NIT", "NOMBRES", "E-MAIL","TELEFONO","DIRECCION"};;
    ArrayList<Persona> data;

    public ArrayList<Persona> getLstdatos() {
        return data;
    }

    public void setLstdatos(ArrayList<Persona> lstdoc) {
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
      Persona macData = (Persona) (data.get(row));

        switch (col) {
            case 0:
                macData.setNroIde((String)value);
                break;
            case 1:
                macData.setNombres((String)value);
                break;
            case 2:
                macData.setEmail((String)value);
                break;
            case 3:
                macData.setTelefono((String)value);
                break;
            case 4:
                macData.setDireccion((String)value);
                break;


        }
    }

    @Override
    public Object getValueAt(int row, int col) {
    Persona macData = (Persona) (data.get(row));

        switch (col) {
            case 0:
                return macData.getNroIde();
            case 1:
                return macData.getNombres();
            case 2:
                return macData.getEmail();
            case 3:
                return macData.getTelefono();
            case 4:
                return macData.getDireccion();
        }


        return new String();
    }
}