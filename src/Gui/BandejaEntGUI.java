/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TramitarGUI.java
 *
 * Created on 13/09/2012, 01:20:43 AM
 */
package Gui;

import ClassControl.CtrTramite;
import ClassEntidad.DDEstado;
import ClassEntidad.DistribucionDoc;
import ClassEntidad.DocInternoE;
import ClassEntidad.DocInternoI;
import ClassEntidad.Funcionario;
import ClassEntidad.Sistema;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author borisgr04
 */
public class BandejaEntGUI extends javax.swing.JFrame implements Observer, TableModelListener {
    //private DefaultTableModel modeloTabla;

    private TablaBandeja modeloTabla;
    private TablaBandejaEnviados modeloTablaE;
    private TablaBandeja modeloTablaA;
    private TablaBandeja modeloTablaResp;
    private TablaBandeja modeloTablaReen;
    
    DistribucionDoc dd;
    Funcionario f= new Funcionario();
    CtrTramite ct= new CtrTramite(Sistema.instancia().getEmf());

    
    public void InicializarB() {
        modeloTabla = new TablaBandeja();
        modeloTablaE = new TablaBandejaEnviados();
        modeloTablaA= new TablaBandeja();
        modeloTablaResp= new TablaBandeja();
        modeloTablaReen= new TablaBandeja();
        dd= new DistribucionDoc();
        
        modeloTabla.setLstdoc(Sistema.instancia().getMisBandejaEntrada(DDEstado.SIN_RECIBIR));
        modeloTablaE.setLstdoc(Sistema.instancia().getMisBandejaSalida());
        modeloTablaA.setLstdoc(Sistema.instancia().getMisBandejaEntrada(DDEstado.ARCHIVADO));
        modeloTablaResp.setLstdoc(Sistema.instancia().getMisBandejaEntrada(DDEstado.RESPONDIDO));
        modeloTablaReen.setLstdoc(Sistema.instancia().getMisBandejaEntrada(DDEstado.REENVIADO));
        //enviadosJT
        
       
    }

    /** Creates new form TramitarGUI */
    public BandejaEntGUI() {
        Sistema.instancia().addObserver(this);
        InicializarB();
        initComponents();
        iniFormularios.mostrarUsuarioActual(UsuarioActual);
         this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AbrirB = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enviadosJT = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        archivadorJT = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ReenviadosJT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        respondidosJT = new javax.swing.JTable();
        archivarB = new javax.swing.JButton();
        responderB = new javax.swing.JButton();
        reenviarB = new javax.swing.JButton();
        UsuarioActual = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tramite de Documento"));

        AbrirB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/open-icon.png"))); // NOI18N
        AbrirB.setText("Abrir");
        AbrirB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirBActionPerformed(evt);
            }
        });

        jTable1.setModel(modeloTabla);
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Bandeja de Entrada", jScrollPane1);

        enviadosJT.setModel(modeloTablaE);
        jScrollPane2.setViewportView(enviadosJT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bandeja de Salida", jPanel2);

        archivadorJT.setModel(modeloTablaA);
        jScrollPane3.setViewportView(archivadorJT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Documento Archivados", jPanel5);

        ReenviadosJT.setModel(modeloTablaResp);
        jScrollPane4.setViewportView(ReenviadosJT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Documentos Respondidos", jPanel3);

        respondidosJT.setModel(modeloTablaReen);
        jScrollPane5.setViewportView(respondidosJT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Documentos Reenviados", jPanel4);

        archivarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/2-Documents-icon.png"))); // NOI18N
        archivarB.setText("Archivar");
        archivarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivarBActionPerformed(evt);
            }
        });

        responderB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Email-Reply-icon.png"))); // NOI18N
        responderB.setText("Responder");
        responderB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responderBActionPerformed(evt);
            }
        });

        reenviarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Email-Forward-icon.png"))); // NOI18N
        reenviarB.setText("Reenviar");
        reenviarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reenviarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AbrirB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(archivarB)
                        .addGap(18, 18, 18)
                        .addComponent(reenviarB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(responderB)
                        .addGap(356, 356, 356))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AbrirB)
                    .addComponent(archivarB)
                    .addComponent(reenviarB)
                    .addComponent(responderB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(UsuarioActual)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UsuarioActual)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reenviarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reenviarBActionPerformed
        // TODO add your handling code here:
        if(isSeleccionado(" Reenviar ")){
            ReenviarDoc rd=new ReenviarDoc(dd);
            rd.setVisible(true);
        }

    }//GEN-LAST:event_reenviarBActionPerformed

    private void responderBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responderBActionPerformed
        // TODO add your handling code here:
        if(isSeleccionado(" Responder "))
        responder();
    }//GEN-LAST:event_responderBActionPerformed

    private void archivarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivarBActionPerformed
        // TODO add your handling code here:
        if(isSeleccionado(" Archivar "))
        archivar();
    }//GEN-LAST:event_archivarBActionPerformed

    private void AbrirBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirBActionPerformed
        // TODO add your handling code here:
        //InicializarB();
        //JOptionPane.showMessageDialog(this,"actualizar",Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);

        boolean avanzar = true;

        int registro = jTable1.getSelectedRow();
        int columna = jTable1.getSelectedColumn();

        if (registro == -1) {
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        if (avanzar) {
            String strResultado = this.modeloTabla.getValueAt(
                jTable1.getSelectedRow(),
                jTable1.getSelectedColumn()).toString();
            JOptionPane.showMessageDialog(null, "Dato seleccionado : " + strResultado);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");
        }

    }//GEN-LAST:event_AbrirBActionPerformed

    private void archivar() {
        ct.setDd(dd);
        ct.Archivar();
        actualizarGrid();
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BandejaEntGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirB;
    private javax.swing.JTable ReenviadosJT;
    private javax.swing.JLabel UsuarioActual;
    private javax.swing.JTable archivadorJT;
    private javax.swing.JButton archivarB;
    private javax.swing.JTable enviadosJT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reenviarB;
    private javax.swing.JButton responderB;
    private javax.swing.JTable respondidosJT;
    // End of variables declaration//GEN-END:variables



    public void actualizarGrid() {

        InicializarB();
        jTable1.setModel(modeloTabla);
        this.enviadosJT.setModel(modeloTablaE);
        this.archivadorJT.setModel(modeloTablaA);
        this.respondidosJT.setModel(modeloTablaResp);
        this.ReenviadosJT.setModel(modeloTablaReen);
        
    }

    public void update(Observable o, Object arg) {
        actualizarGrid();
    }

    public void tableChanged(TableModelEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        JOptionPane.showMessageDialog(this, "actualizarTabla", Sistema.instancia().getNomApp(), JOptionPane.WARNING_MESSAGE);
    }

    private void responder() {
        if(dd.getDocumento() instanceof DocInternoE)
        {
          ProducirDocGUI p=new ProducirDocGUI(dd);
          p.setVisible(true);
        }
        else if(dd.getDocumento() instanceof DocInternoI)
        {
          ProducirDocIntGUI p=new ProducirDocIntGUI(dd);
          p.setVisible(true);
        }
        
    }

    private boolean isSeleccionado(String s) {
        int registro = jTable1.getSelectedRow();
        boolean sw=false;
        if (registro >= 0) {
            dd = modeloTabla.getDoc(registro);
            int strResultado = dd.getDocumento().getNoDocumento();
            int r = JOptionPane.showConfirmDialog(this, "Desea "+s+" el Documento N°" + strResultado, "MessageBox Title", JOptionPane.YES_NO_OPTION);
            return (r == JOptionPane.YES_OPTION) ;
        }
        return sw;
    }

 

 
}