/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TranferirDocGUI.java
 *
 * Created on 13/09/2012, 02:31:13 AM
 */
package Gui;

import ClassEntidad.ActaTraslado;
import ClassEntidad.Dependencia;
import ClassEntidad.Documento;
import ClassEntidad.Sistema;
import ClassEntidad.TRD;
import Servicios.ActaTrasladoService;
import Servicios.DependenciaService;
import Servicios.DocumentoService;
import Servicios.TRDService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import util.CparaCombo;

/**
 *
 * @author borisgr04
 */
public class TranferirDocGUI extends javax.swing.JFrame {
    List<Documento> ld;
    private TablaBandejaArchivados modeloTabla;
    /**
     * Creates new form TranferirDocGUI
     */
    public TranferirDocGUI() {
        initComponents();
        inicializar();
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
        jLabel13 = new javax.swing.JLabel();
        serieC = new javax.swing.JComboBox();
        depOrigenC = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        generarActaB = new javax.swing.JButton();
        consultaB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        fechaJC = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setText("Dependencia Origen");

        jLabel13.setText("Serie Documental");

        depOrigenC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depOrigenCActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TRANFERENCIA A ARCHIVO CENTRAL");

        jLabel1.setText("Fecha de Corte");

        generarActaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/report-icon.png"))); // NOI18N
        generarActaB.setText("Generar Acta");
        generarActaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActaBActionPerformed(evt);
            }
        });

        consultaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search-b-icon.png"))); // NOI18N
        consultaB.setText("Consultar");
        consultaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaBActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("N° Acta Transferencia");

        jTextField2.setEditable(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/print-icon.png"))); // NOI18N
        jButton3.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(42, 42, 42)
                        .addComponent(serieC, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(consultaB, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGap(131, 131, 131))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2)
                                .addGap(150, 150, 150))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(depOrigenC, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(51, 51, 51)
                                        .addComponent(fechaJC, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generarActaB)
                        .addGap(1, 1, 1)
                        .addComponent(jButton3)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel12)
                    .addContainerGap(510, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depOrigenC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(serieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultaB))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(fechaJC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(generarActaB)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel12)
                    .addContainerGap(309, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void depOrigenCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depOrigenCActionPerformed
        // TODO add your handling code here:
        this.InicializaTRD();
    }//GEN-LAST:event_depOrigenCActionPerformed

     public void InicializarB() {
        //enviadosJT
    }
    private void consultaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaBActionPerformed
        DocumentoService ds=new DocumentoService(Sistema.instancia().getEmf());
        TRD serie= this.SerieActual();
        Calendar fecha=this.fechaJC.getCalendar();
        fecha.set(Calendar.YEAR, fecha.get(Calendar.YEAR) -serie.gettRetAG());
        Date dfecha=fecha.getTime();
        ld= ds.findxTrasladar(this.SerieActual(), dfecha);
//        for(Documento doc:ld){
//          if( doc.getFechaReg().before(this.fechaJC.getDate())){
//              System.out.println("Si"+doc.getAsunto());
//          }else
//          {
//          System.out.println("No"+doc.getAsunto());
//          }
//        }
        modeloTabla = new TablaBandejaArchivados();
        
        modeloTabla.setLstdoc(ld);
        this.jTable1.setModel(modeloTabla);
      
    }//GEN-LAST:event_consultaBActionPerformed

    private void generarActaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActaBActionPerformed
        // TODO add your handling code here:
        ActaTraslado at=new ActaTraslado();
        at.setFecActa(this.fechaJC.getCalendar().getTime());
        at.setDocActas(ld);
        ActaTrasladoService ats=new ActaTrasladoService(Sistema.instancia().getEmf());
        ats.create(at);
        
        
        JOptionPane.showMessageDialog(this, "Se Realizo "+at.getNroActa(), Sistema.instancia().getNomApp(), JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_generarActaBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TranferirDocGUI().setVisible(true);
            }
        });
    }

    private void InicializaDependencias() {
        //Llena Comobo Box Dependencia
        List<Dependencia> lstDep = Sistema.instancia().getDependencias();
        for (Dependencia d : lstDep) {
            this.depOrigenC.addItem(new CparaCombo(d.getId(), d.getNombre()));
        }
    }

    private void InicializaTRD() {
        //Llena Comobo Box Serie
        //Inicialziando
        serieC.removeAllItems();
        Dependencia d = DepActual();
        if (!(d == null)) {
            int i = 0;
            for (TRD serie : d.gettRDs()) {
                //if (i > 0) {//ojo la primera serie es la serie Externa
                this.serieC.addItem(new CparaCombo(String.valueOf(serie.getId()), serie.getSerie().toUpperCase()));
                //}
                i++;
                //System.out.print(serie.getSerie());
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultaB;
    private javax.swing.JComboBox depOrigenC;
    private com.toedter.calendar.JDateChooser fechaJC;
    private javax.swing.JButton generarActaB;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox serieC;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        this.InicializaDependencias();
        this.InicializaTRD();
    }

    private Dependencia DepActual() {
        DependenciaService ds = new DependenciaService(Sistema.instancia().getEmf());
        CparaCombo dpOr = (CparaCombo) depOrigenC.getSelectedItem();
        Dependencia d = ds.findDependencia(dpOr.getCodigo());
        return d;
    }
    
     private TRD SerieActual() {
        TRDService ss = new TRDService(Sistema.instancia().getEmf());
        CparaCombo dpSr = (CparaCombo)this.serieC.getSelectedItem();
        TRD t =ss.findTRD(Long.valueOf(dpSr.getCodigo()));
        return t;
    }
}
