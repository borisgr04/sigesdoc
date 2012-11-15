/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BuscarPerExtGUI.java
 *
 * Created on 24/10/2012, 11:35:34 PM
 */

package Gui;



/**
 *
 * @author LENOVO
 */
public class BuscarPerExtGUI extends javax.swing.JFrame {
private ModeloTablaPersona modeloTabla;
IRecibir rdg;

    public IRecibir getRdg() {
        return rdg;
    }

    public void setRdg(IRecibir rdg) {
        this.rdg = rdg;
    }
private seleccionarPerExt bPerExt= new seleccionarPerExt();
private nuevaPerExt cPerExt= new nuevaPerExt ();;
    /** Creates new form BuscarPerExtGUI */
    public BuscarPerExtGUI() {
        initComponents();
        mostrarBuscar();
          
    }

    public BuscarPerExtGUI(IRecibir rdg) {
        this.rdg = rdg;
        initComponents();
        mostrarBuscar();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        buscarB = new javax.swing.JButton();
        crearB = new javax.swing.JButton();

        setTitle("PERSONAS EXTERNAS");

        panelPrincipal.setAutoscrolls(true);
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search-b-icon.png"))); // NOI18N
        buscarB.setText("Buscar");
        buscarB.setFocusable(false);
        buscarB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });
        jToolBar1.add(buscarB);

        crearB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/New.png"))); // NOI18N
        crearB.setText("Crear");
        crearB.setFocusable(false);
        crearB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crearB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        crearB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearBActionPerformed(evt);
            }
        });
        jToolBar1.add(crearB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarBuscar(){
        panelPrincipal.setVisible(false);
       panelPrincipal.removeAll();
       bPerExt.setIr(rdg);
       panelPrincipal.add(bPerExt);
       bPerExt.setjFPapa(this);
       panelPrincipal.setVisible(true);
       
         this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        // TODO add your handling code here:
        mostrarBuscar();
       
    }//GEN-LAST:event_buscarBActionPerformed

    private void crearBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearBActionPerformed
        // TODO add your handling code here:
       panelPrincipal.setVisible(false);
       panelPrincipal.removeAll();

       panelPrincipal.add(cPerExt);

       panelPrincipal.setVisible(true);


    }//GEN-LAST:event_crearBActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPerExtGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarB;
    private javax.swing.JButton crearB;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
