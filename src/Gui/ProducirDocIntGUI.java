/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProducirDocGUI.java
 *
 * Created on 13/09/2012, 12:54:54 AM
 */
package Gui;

import ClassControl.CtrProdDoc;
import ClassControl.ValDocInternoI;
import ClassEntidad.Sistema;
import ClassEntidad.Dependencia;
import ClassEntidad.DocInternoI;
import ClassEntidad.Documento;
import ClassEntidad.Funcionario;
import ClassEntidad.Persona;
import ClassEntidad.TRD;
import javax.swing.JOptionPane;
import util.CparaCombo;

/**
 *
 * @author borisgr04
 */
public class ProducirDocIntGUI extends javax.swing.JFrame {

    CtrProdDoc cd = new CtrProdDoc();

    /** Creates new form ProducirDocGUI */
    public ProducirDocIntGUI() {
        initComponents();
        inicializar();
    }

    void inicializar() {
        //Llena Comobo Box Dependencia
        for (Dependencia d : Sistema.instancia().getLstDep()) {
            this.depOrigenC.addItem(new CparaCombo(d.getId(), d.getNombre()));
        }
        Funcionario f= new Funcionario();
        for (Persona d : f.getFuncionario()) {
            this.destinoC.addItem(new CparaCombo(d.getNroIde(), d.getNombres()));
        }

        //Llena Comobo Box Serie
        //Inicialziando
        TRD trd= new TRD();
        for (TRD serie : trd.getTRD()) {
            this.serieC.addItem(new CparaCombo(serie.getId_Serie(), serie.getSerie().toUpperCase()));
            //System.out.print(serie.getSerie());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        nuevoB = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        guardaB = new javax.swing.JButton();
        cancelarB = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        cerrarB = new javax.swing.JButton();
        misDocC = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        depOrigenC = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        serieC = new javax.swing.JComboBox();
        ndocumentoT = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        destinoC = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        asuntoT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenT = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        autorT = new javax.swing.JTextField();
        foliosN = new javax.swing.JSpinner();
        anexosCH = new javax.swing.JCheckBox();

        jToolBar1.setRollover(true);

        nuevoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/New.png"))); // NOI18N
        nuevoB.setText("Nuevo");
        nuevoB.setFocusable(false);
        nuevoB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevoB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBActionPerformed(evt);
            }
        });
        jToolBar1.add(nuevoB);
        jToolBar1.add(jSeparator3);

        guardaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/save.png"))); // NOI18N
        guardaB.setText("Guardar");
        guardaB.setFocusable(false);
        guardaB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardaB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardaBActionPerformed(evt);
            }
        });
        jToolBar1.add(guardaB);

        cancelarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/undo.png"))); // NOI18N
        cancelarB.setText("Cancelar");
        cancelarB.setFocusable(false);
        cancelarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelarB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelarB);
        jToolBar1.add(jSeparator2);

        cerrarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Log Out_32x32.png"))); // NOI18N
        cerrarB.setText("Cerrar");
        cerrarB.setFocusable(false);
        cerrarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarB.setName("cerrarB"); // NOI18N
        cerrarB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cerrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBActionPerformed(evt);
            }
        });
        jToolBar1.add(cerrarB);

        jToolBar1.add(misDocC);

        jLabel12.setText("Dependencia Origen");

        depOrigenC.setEnabled(false);

        jLabel13.setText("Serie Documental");

        jLabel5.setText("Destino");

        serieC.setEnabled(false);

        ndocumentoT.setEditable(false);

        jTextField4.setEditable(false);

        jLabel1.setText("Fecha y Hora");

        jLabel4.setText("N° Documento");

        jTextField7.setEnabled(false);

        jLabel8.setText("N° Documento Rel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serieC, 0, 319, Short.MAX_VALUE)
                    .addComponent(depOrigenC, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoC, 0, 319, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ndocumentoT, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(depOrigenC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(serieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ndocumentoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel6.setText("Asunto");

        asuntoT.setEnabled(false);

        jLabel7.setText("Resumen");

        resumenT.setColumns(20);
        resumenT.setRows(5);
        resumenT.setEnabled(false);
        jScrollPane1.setViewportView(resumenT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(asuntoT)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(asuntoT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );

        jLabel9.setText("Autor");

        jLabel11.setText("No de Folios");

        autorT.setEditable(false);

        foliosN.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        foliosN.setEnabled(false);

        anexosCH.setText("Anexos");
        anexosCH.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(36, 36, 36)
                .addComponent(autorT, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foliosN, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(anexosCH)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autorT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(foliosN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(anexosCH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBActionPerformed
        // TODO add your handling code here:
        //this.setVisible(true);
    }//GEN-LAST:event_cerrarBActionPerformed

    private void Guardar() {
        try {
            DocInternoI d = new DocInternoI();
            
            CparaCombo ser = (CparaCombo) serieC.getSelectedItem();
            if (ser==null){
                JOptionPane.showMessageDialog(this,"Seleccione Serie",Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
                return;
            }
            CparaCombo depDest = (CparaCombo) destinoC.getSelectedItem();
            if (depDest==null){
                JOptionPane.showMessageDialog(this,"Seleccione Destino",Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
                return;
            }

             CparaCombo depOrg = (CparaCombo) depOrigenC.getSelectedItem();
            if (depOrg==null){
                JOptionPane.showMessageDialog(this,"Seleccione Dependencia Origen",Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
                return;
            }
            //d.setAnexos(anexosCH.ch/);
            d.setAsunto(asuntoT.getText());
            d.setResumen(resumenT.getText());
            d.setSerieTRD(ser.getCodigo());
            d.setIdeDepOrigen(depOrg.getCodigo());
            d.setIdPerDest(depDest.getCodigo());
            d.setAnexos(anexosCH.isSelected());
            d.setFolios(Integer.parseInt(this.foliosN.getValue().toString()));
            d.setIdPerProd(autorT.getText().toString());
            cd.setDoc(d);
            cd.Guardar(new ValDocInternoI());
            if(cd.isValido()){
                this.ndocumentoT.setText(String.valueOf(cd.getDoc().getNoDocumento()));
                JOptionPane.showMessageDialog(this, "Se Guardó el Documento", Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
            }
             else{
                JOptionPane.showMessageDialog(this, cd.getMensaje(), Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
             }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), Sistema.instancia().getNomApp(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private void guardaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardaBActionPerformed
        // TODO add your handling code here:
        int r = JOptionPane.showConfirmDialog(this, "Desea Guardar y Enviar el Documento", "MessageBox Title", JOptionPane.YES_NO_OPTION);

        System.out.print(r);
        if (r == JOptionPane.YES_OPTION) {
            Guardar();
            CargarMisDoc();
        } else {
            System.out.print("xxx");
        }


    }//GEN-LAST:event_guardaBActionPerformed

    private void Habilitar(boolean val) {
        asuntoT.setEnabled(val);
        resumenT.setEnabled(val);
        anexosCH.setEnabled(val);
        foliosN.setEnabled(val);
        destinoC.setEnabled(val);
        this.depOrigenC.setEnabled(val);
        this.serieC.setEnabled(val);
    }

    private void Limpiar(String val) {
        asuntoT.setText(val);
        resumenT.setText(val);
        anexosCH.setSelected(false);
        foliosN.setValue(0);
        destinoC.setSelectedIndex(-1);
        this.depOrigenC.setSelectedIndex(-1);
        this.serieC.setSelectedIndex(-1);
    }

    private void CargarMisDoc() {
        for (Documento d : Sistema.instancia().getLstDoc()) {
            this.misDocC.addItem(new CparaCombo(String.valueOf(d.getNoDocumento()), d.getAsunto()));
            //System.out.print(serie.getSerie());
        }
    }
    private void nuevoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBActionPerformed
        // TODO add your handling code here:
        this.Habilitar(true);
        this.Limpiar("");
    }//GEN-LAST:event_nuevoBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        // TODO add your handling code here:
        this.Habilitar(false);
        this.Limpiar("");
    }//GEN-LAST:event_cancelarBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProducirDocIntGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox anexosCH;
    private javax.swing.JTextField asuntoT;
    private javax.swing.JTextField autorT;
    private javax.swing.JButton cancelarB;
    private javax.swing.JButton cerrarB;
    private javax.swing.JComboBox depOrigenC;
    private javax.swing.JComboBox destinoC;
    private javax.swing.JSpinner foliosN;
    private javax.swing.JButton guardaB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox misDocC;
    private javax.swing.JTextField ndocumentoT;
    private javax.swing.JButton nuevoB;
    private javax.swing.JTextArea resumenT;
    private javax.swing.JComboBox serieC;
    // End of variables declaration//GEN-END:variables
}
