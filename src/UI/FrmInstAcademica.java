
package UI;

import BEAN.InstAcademica;
import DAO.InstAcademicaDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmInstAcademica extends javax.swing.JInternalFrame {
    InstAcademicaDAO instDao;
    DefaultTableModel dtm;
    Vector<InstAcademica> listaInst;
    int idInst; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmInstAcademica() {
        instDao=new InstAcademicaDAO();
        initComponents();
        llenaCmbTipo();
        llenaCmbEstado();
        dtm = (DefaultTableModel)this.tblInstitucionAcademica.getModel();
        llenaTblInstAcademica("");
    }
    private void llenaTblInstAcademica(String cad){
        
        listaInst = instDao.listaInstAcademica(cad);
        dtm.setRowCount(0); //vacía la tabla cada vez que se llene algo en el cuadro de busqueda
        for(int i=0;i<listaInst.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaInst.get(i).getId_institucion());
            vec.addElement(listaInst.get(i).getNombre_institucion());
            vec.addElement(listaInst.get(i).getTipo());
            vec.addElement(listaInst.get(i).getWeb());
            vec.addElement(listaInst.get(i).getContacto());
            vec.addElement(listaInst.get(i).getTelefono());
            vec.addElement(listaInst.get(i).getEstado());
            dtm.addRow(vec);
        }
    }
    
    private void llenaCmbTipo(){
        this.cmbTipo.addItem("");
        this.cmbTipo.addItem("Colegio");
        this.cmbTipo.addItem("Instituto");
        this.cmbTipo.addItem("Universidad");
    }
    
    private void llenaCmbEstado(){
        this.cmbEstado.addItem("");
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No Activo");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreInstitucion = new javax.swing.JTextField();
        txtIdInstitucion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstitucionAcademica = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO INSTITUCIONES");

        jLabel2.setText("Id Institucion");

        jLabel3.setText("Nombre Institución");

        jLabel4.setText("Web");

        jLabel5.setText("Telefono");

        jLabel6.setText("Estado");

        txtIdInstitucion.setEnabled(false);

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

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

        tblInstitucionAcademica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Institucion", "NombreInt", "Tipo", "Web", "Contacto", "Telefono", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInstitucionAcademica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstitucionAcademicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInstitucionAcademica);

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

        jLabel8.setText("Tipo");

        jLabel9.setText("Contacto");

        jLabel12.setText("Correo");

        btnPdf.setText("Enviar PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
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
                                .addComponent(txtIdInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(txtNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(145, 145, 145)
                                .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtContacto, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(259, 259, 259))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(31, 31, 31)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnPdf)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblInstAcademica("");
        }else{
            llenaTblInstAcademica(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            String msj;
            Util u = new Util();
            
            InstAcademica empl = new InstAcademica(); //se crea xq el procedimiento inserta proveedor requiere el parámetro de proveedor
            
            empl.setNombre_institucion(this.txtNombreInstitucion.getText());
            empl.setTipo(this.cmbTipo.getSelectedItem().toString());
            empl.setWeb(this.txtWeb.getText());
            empl.setContacto(this.txtContacto.getText());
            empl.setTelefono(this.txtTelefono.getText());
            if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                empl.setEstado(1);
            }else{
                empl.setEstado(0);
            }
            if(this.btnGrabar.getText().equals("Grabar")){ //se crea para autogenerar la llave
                idInst=u.idNext("InstAcademica", "InstitucionID"); //es el nombre de la tabla y el nombre del campo de la llave primaria
                empl.setId_institucion(idInst);
                this.instDao.insertaInstAcademica(empl);
                msj="Institucion registrada satisfactoriamente";
            }else{
                empl.setId_institucion(idInst);
                this.instDao.actualizaInstAcademica(empl);
                msj="Institucion actualizada satisfactoriamente";
            }
            
            limpia();
            llenaTblInstAcademica("");
            JOptionPane.showMessageDialog(this, msj);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblInstitucionAcademicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstitucionAcademicaMouseClicked
        
        idx=this.tblInstitucionAcademica.getSelectedRow();
        this.idInst=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txtIdInstitucion.setText(dtm.getValueAt(idx, 0).toString());
        this.txtNombreInstitucion.setText(dtm.getValueAt(idx, 1).toString());
        this.cmbTipo.setSelectedItem(dtm.getValueAt(idx, 2).toString());
        this.txtWeb.setText(dtm.getValueAt(idx, 3).toString());
        this.txtContacto.setText(dtm.getValueAt(idx, 4).toString());
        this.txtTelefono.setText(dtm.getValueAt(idx, 5).toString());
        if(dtm.getValueAt(idx, 6).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
        this.btnGrabar.setText("Actualizar");
        
        this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblInstitucionAcademicaMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //int idProd;
        //idProd=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        if(this.instDao.eliminaInstAcademica(idInst)==true){
            JOptionPane.showMessageDialog(this, "Institucion eliminada satisfactoriamente");
            this.llenaTblInstAcademica("");
            limpia();
        }else{
            JOptionPane.showMessageDialog(this, "No es posible eliminar a la isntitucion, consulte con el DBA");
        }
        limpia();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaInst.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaInst);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de INS Academica");
            MailSender.sendEmail(txtEmail.getText(), "PDF INS ACADEMICA", mensaje, "REPORTE DE INS ACADEMICA", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }
    }//GEN-LAST:event_btnPdfActionPerformed
    private boolean valida(){
        boolean sw=false;
        String cad="";
        if(this.txtNombreInstitucion.getText().isEmpty()){
            cad="Debe registrar el nombre de la institucion";
        }
        if(this.cmbTipo.getSelectedItem().toString().isEmpty()){
            cad=cad+"\nDebe seleccionar el tipo";
        }
        if(this.txtWeb.getText().isEmpty()){
            cad="\nDebe registrar la web de la institucion";
        }
        if(this.txtContacto.getText().isEmpty()){
            cad="\nDebe registrar al contacto";
        }
        if(this.txtTelefono.getText().isEmpty()){
            cad=cad+"\nDebe registrar el teleono";
        }
        if(this.cmbEstado.getSelectedItem().toString().isEmpty()){
            cad=cad+"\nDebe seleccionar el estado";
        }
        if(cad.isEmpty()){
            sw=true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
    private void limpia(){
        this.txtIdInstitucion.setText("");
        this.txtNombreInstitucion.setText("");
        this.txtWeb.setText("");
        this.txtContacto.setText("");
        this.txtBuscar.setText("");
        this.cmbTipo.setSelectedItem("");
        this.txtTelefono.setText("");
        this.cmbEstado.setSelectedItem("");
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        llenaTblInstAcademica("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInstitucionAcademica;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdInstitucion;
    private javax.swing.JTextField txtNombreInstitucion;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
