
package UI;

import BEAN.Area;
import DAO.AreaDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmArea extends javax.swing.JInternalFrame {
    AreaDAO areaDao;
    DefaultTableModel dtm;
    Vector<Area> listaArea;
    int idArea; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmArea() {
        areaDao=new AreaDAO();
        initComponents();
        llenaCmbCentCosto();
        dtm = (DefaultTableModel)this.tblArea.getModel();
        llenaTblAreas("");
    }
    private void llenaTblAreas(String cad){
        
        listaArea = areaDao.listaArea(cad);
        dtm.setRowCount(0); //vacía la tabla cada vez que se llene algo en el cuadro de busqueda
        for(int i=0;i<listaArea.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaArea.get(i).getId_area());
            vec.addElement(listaArea.get(i).getDescripcion());
            vec.addElement(listaArea.get(i).getSubArea());
            vec.addElement(listaArea.get(i).getCentCosto());
            dtm.addRow(vec);
        }
    }
    
    
    private void llenaCmbCentCosto(){
        this.cmbCentCosto.addItem("");
        this.cmbCentCosto.addItem("1001");
        this.cmbCentCosto.addItem("1002");
        this.cmbCentCosto.addItem("1003");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtIdArea = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArea = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSubarea = new javax.swing.JTextField();
        cmbCentCosto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO AREAS");

        jLabel2.setText("Id Area");

        jLabel3.setText("Descripción");

        jLabel6.setText("Centro de Costo");

        txtIdArea.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel7.setText("Buscar:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 40, 60, 16);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar);
        txtBuscar.setBounds(120, 30, 300, 30);

        tblArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Area", "Descripcion", "Sub area", "Centro de costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 490, 180);

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel8.setText("Subarea");

        cmbCentCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCentCostoActionPerformed(evt);
            }
        });

        jLabel4.setText("Correo");

        btnPDF.setText("Enviar PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)
                                .addGap(275, 275, 275)
                                .addComponent(btnSalir)
                                .addGap(203, 203, 203))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSubarea, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(cmbCentCosto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(259, 259, 259))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPDF))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(489, 489, 489)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPDF)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSubarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbCentCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblAreas("");
        }else{
            llenaTblAreas(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            String msj;
            Util u = new Util();
            
            Area area = new Area(); //se crea xq el procedimiento inserta proveedor requiere el parámetro de proveedor
            
            area.setDescripcion(this.txtDescripcion.getText());
            area.setSubArea(this.txtSubarea.getText());
            area.setCentCosto(Integer.parseInt(this.cmbCentCosto.getSelectedItem().toString()));

            if(this.btnGrabar.getText().equals("Grabar")){ //se crea para autogenerar la llave
                idArea=u.idNext("area", "areaID"); //es el nombre de la tabla y el nombre del campo de la llave primaria
                area.setId_area(idArea);
                this.areaDao.insertaAreas(area);
                msj="Area registrada satisfactoriamente";
            }else{
                area.setId_area(idArea);
                this.areaDao.actualizaAreas(area);
                msj="Area actualizada satisfactoriamente";
            }
            
            limpia();
            llenaTblAreas("");
            JOptionPane.showMessageDialog(this, msj);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAreaMouseClicked
        
        idx=this.tblArea.getSelectedRow();
        this.idArea=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txtIdArea.setText(dtm.getValueAt(idx, 0).toString());
        this.txtDescripcion.setText(dtm.getValueAt(idx, 1).toString());
        this.txtSubarea.setText(dtm.getValueAt(idx, 2).toString());
        this.cmbCentCosto.setSelectedItem(dtm.getValueAt(idx, 3).toString());        

        this.btnGrabar.setText("Actualizar");
        
        this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblAreaMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //int idProd;
        //idProd=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        if(this.areaDao.eliminaAreas(idArea)==true){
            JOptionPane.showMessageDialog(this, "Area eliminada satisfactoriamente");
            this.llenaTblAreas("");
            limpia();
        }else{
            JOptionPane.showMessageDialog(this, "No es posible eliminar el area, consulte con el DBA");
        }
        limpia();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cmbCentCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCentCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCentCostoActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaArea.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaArea);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Areas");
            MailSender.sendEmail(txtEmail.getText(), "PDF AREAS", mensaje, "REPORTE DE AREAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }

    }//GEN-LAST:event_btnPDFActionPerformed
    private boolean valida(){
        boolean sw=false;
        String cad="";
        if(this.txtDescripcion.getText().isEmpty()){
            cad="Debe registrar la descripcion";
        }
        if(this.txtSubarea.getText().isEmpty()){
            cad="\nDebe registrar la subarea";
        }
        if(this.cmbCentCosto.getSelectedItem().toString().isEmpty()){
            cad=cad+"\nDebe seleccionar el centro de costo";
        }

        if(cad.isEmpty()){
            sw=true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
    private void limpia(){
        this.txtIdArea.setText("");
        this.txtDescripcion.setText("");
        this.txtSubarea.setText("");
        this.txtBuscar.setText("");
        this.cmbCentCosto.setSelectedItem("");
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        llenaTblAreas("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCentCosto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArea;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdArea;
    private javax.swing.JTextField txtSubarea;
    // End of variables declaration//GEN-END:variables
}
