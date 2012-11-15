/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * seleccionarPerExt.java
 *
 * Created on 23/10/2012, 11:19:59 PM
 */

package Gui;

import ClassEntidad.PerExterna;
import ClassEntidad.Persona;
import ClassEntidad.Sistema;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class seleccionarPerExt extends javax.swing.JPanel {
   private ModeloTablaPersona modeloTabla;
   private JFrame jFPapa;

    public JFrame getjFPapa() {
        return jFPapa;
    }

    public void setjFPapa(JFrame jFPapa) {
        this.jFPapa = jFPapa;
    }
   private IRecibir ir;

    public IRecibir getIr() {
        return ir;
    }

    public void setIr(IRecibir ir) {
        this.ir = ir;
    }
    /** Creates new form seleccionarPerExt */
    public seleccionarPerExt() {
        Inicializar();
        initComponents();
        
        
    }
    

    public seleccionarPerExt(IRecibir ir) {
        this.ir = ir;
        Inicializar();
        initComponents();
    }

   


public void Inicializar(){
        modeloTabla = new ModeloTablaPersona();
        modeloTabla.setLstdatos(Sistema.instancia.getPerExternas());
        //System.out.println(Sistema.instancia().getLstPer().size());
        
                //this.PersonaJtab.setModel(modeloTabla);
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
        enviarB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PersonaJtab = new javax.swing.JTable();

        enviarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Sign-Select-icon.png"))); // NOI18N
        enviarB.setText("Enviar");
        enviarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addComponent(enviarB)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(enviarB)
        );

        PersonaJtab.setModel(modeloTabla);
        PersonaJtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaJtabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PersonaJtab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enviarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBActionPerformed
   Seleccionar();
   jFPapa.setVisible(false);
                  // TODO add your handling code here:
    }//GEN-LAST:event_enviarBActionPerformed

    private void PersonaJtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaJtabMouseClicked
        // TODO add your handling code here:
    //    int row = modeloTabla.rowAtPoint(evt.getPoint());
     //   JOptionPane.showMessageDialog(null, row);

    }//GEN-LAST:event_PersonaJtabMouseClicked
   private boolean Seleccionar() {
        int registro = this.PersonaJtab.getSelectedRow();
        boolean sw=false;
        if (registro >= 0) {
            Persona p = modeloTabla.getPer(registro);
            ir.Recibir(p);
            System.out.println(p.getApellidos());
        }
        return sw;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PersonaJtab;
    private javax.swing.JButton enviarB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
