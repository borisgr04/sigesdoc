/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OrganizarDocGUI.java
 *
 * Created on 15/09/2012, 07:08:12 PM
 */
package Gui;

import ClassControl.CtrOrgazina;
import ClassEntidad.ACTASEstado;
import ClassEntidad.ActaTraslado;
import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import Servicios.ActaTrasladoService;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author borisgr04
 */
public class OrganizarDocGUI extends javax.swing.JFrame {

    CtrOrgazina c = new CtrOrgazina(Sistema.instancia().getEmf());
    private TablaBandejaArchivados modeloTabla;
    ActaTraslado at;

    /**
     * Creates new form OrganizarDocGUI
     */
    public OrganizarDocGUI() {
        initComponents();
        Habilitar(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        guardarB = new javax.swing.JButton();
        AbrirActaJ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nActaT = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cajaT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estanteT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        unidadC = new javax.swing.JComboBox();
        serieL = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Organizar Documentos - (Archivo Central)"));

        jLabel12.setText("Dependencia Origen");

        guardarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Floppy-Small-icon.png"))); // NOI18N
        guardarB.setText("Guardar");
        guardarB.setEnabled(false);
        guardarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBActionPerformed(evt);
            }
        });

        AbrirActaJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/open-icon.png"))); // NOI18N
        AbrirActaJ.setText("Abrir");
        AbrirActaJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActaJActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("N° Acta Transferencia");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/print-icon.png"))); // NOI18N
        jButton3.setText("Imprimir");

        jLabel3.setText("Caja");

        jLabel4.setText("Estante");

        jLabel5.setText("Unidad de Consulta");

        unidadC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tomo", "Caja" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(14, 14, 14)
                                .addComponent(estanteT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaT, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(unidadC, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(serieL))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(nActaT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AbrirActaJ)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(guardarB)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(177, 177, 177))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nActaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AbrirActaJ))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serieL)
                    .addComponent(jLabel12))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estanteT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(cajaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(unidadC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActaJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActaJActionPerformed
        // TODO add your handling code here:
        try {
            if(this.nActaT.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "N° de Acta vacio", Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int nroActa = Integer.parseInt(this.nActaT.getText());
            ActaTrasladoService ats = new ActaTrasladoService(Sistema.instancia().getEmf());
            at = ats.findActaTraslado(nroActa);
            if (at != null) {
                modeloTabla = new TablaBandejaArchivados();
                modeloTabla.setLstdoc(at.getDocActas());
                this.jTable1.setModel(modeloTabla);
                this.serieL.setText(at.getDependencia().getNombre());
                this.estanteT.setText(String.valueOf(at.getEstante()));
                this.cajaT.setText(String.valueOf(at.getCaja()));
                this.unidadC.setSelectedItem(at.getUnidadConsulta());
                if (at.getEstado() == ACTASEstado.TRASLADADA) {
                    Habilitar(true);
                } else {
                    Habilitar(false);
                    JOptionPane.showMessageDialog(this, "El acta ya esta en Estado Organizada.", Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                Limpiar();
                JOptionPane.showMessageDialog(this, "El acta no se encuentra registrada.", Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
                this.guardarB.setEnabled(true);
            }
        }catch (NumberFormatException exX) {
            JOptionPane.showMessageDialog(this, "Valor de Número de Acta No Válido", Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
            this.guardarB.setEnabled(false);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
            this.guardarB.setEnabled(false);
        }

    }//GEN-LAST:event_AbrirActaJActionPerformed

    private void guardarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBActionPerformed
        // TODO add your handling code here
        try{
            
       if(unidadC.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "Seleccione la Unidad", Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
            return;
        } 
       
       if(this.nActaT.getText().isEmpty()){
       JOptionPane.showMessageDialog(this, "Digite un numero de Acta", Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
       }
        ActaTrasladoService ats = new ActaTrasladoService(Sistema.instancia().getEmf());
        int nroActa = Integer.valueOf(this.nActaT.getText());
        at = ats.findActaTraslado(nroActa);
        at.setCaja(Integer.parseInt(this.cajaT.getText()));
        at.setEstante(Integer.parseInt(this.estanteT.getText()));
        
        at.setFecActaOrg(new Date());
        at.setUnidadConsulta(this.unidadC.getSelectedItem().toString());
        c.Guardar(at);
        //Verficiar Si es valido si no mandar error
        JOptionPane.showMessageDialog(this, c.getMensaje(), Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
            this.guardarB.setEnabled(false);    
    }//GEN-LAST:event_guardarBActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrganizarDocGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirActaJ;
    private javax.swing.JTextField cajaT;
    private javax.swing.JTextField estanteT;
    private javax.swing.JButton guardarB;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nActaT;
    private javax.swing.JLabel serieL;
    private javax.swing.JComboBox unidadC;
    // End of variables declaration//GEN-END:variables

    private void Habilitar(boolean v) {
        this.guardarB.setEnabled(v);
        this.cajaT.setEnabled(v);
        this.estanteT.setEnabled(v);
        this.unidadC.setEnabled(v);
    }
    
    private void Limpiar(){
      modeloTabla = new TablaBandejaArchivados();
      modeloTabla.setLstdoc(new ArrayList<Documento>());
      this.jTable1.setModel(modeloTabla);
      this.serieL.setText("");
      this.estanteT.setText("");
      this.cajaT.setText("");
      this.unidadC.setSelectedIndex(-1);
    }
    
}
