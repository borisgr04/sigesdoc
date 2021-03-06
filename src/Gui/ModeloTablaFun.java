/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;



import ClassEntidad.Funcionario;
import ClassEntidad.PerExterna;
//import ClassEntidad.Persona;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author borisgr04
 */
class ModeloTablaFun extends AbstractTableModel {

    private String[] columnNames = {"NIT", "NOMBRES", "E-MAIL","TELEFONO","DIRECCION"};
    List<Funcionario> data;

    public List<Funcionario> getLstdatos() {
        return data;
    }

    public void setLstdatos(List<Funcionario> lstdoc) {
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

    @Override
    public boolean isCellEditable (int row, int column)
   {
       // Aquí devolvemos true o false según queramos que una celda
       // identificada por fila,columna (row,column), sea o no editable
    
       return false;
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


     public  Funcionario getPer(int row){
        return (Funcionario) (data.get(row));
    }
    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    
   

    @Override
    public void setValueAt(Object value, int row, int col) {
      Funcionario macData = (Funcionario) (data.get(row));

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
   Funcionario macData = (Funcionario) (data.get(row));

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
