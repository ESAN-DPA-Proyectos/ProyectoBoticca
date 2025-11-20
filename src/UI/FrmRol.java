
package UI;

import BEAN.Rol;
import DAO.RolDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRol extends javax.swing.JInternalFrame {
    RolDAO rolDao;
    DefaultTableModel dtm;
    Vector<Rol> listaRol;
    int idRol; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmRol() {
        rolDao = new RolDAO();
        initComponents();
        dtm = (DefaultTableModel) this.tblRol.getModel(); // puedes renombrar la tabla luego
        llenaTblRoles("");
    }

    private void llenaTblRoles(String cad){

    listaRol = rolDao.listaRol(cad);
    dtm.setRowCount(0);

    for (int i = 0; i < listaRol.size(); i++) {
        Vector vec = new Vector();
        Rol r = listaRol.get(i);
        vec.addElement(r.getId_rol());
        vec.addElement(r.getDescripcion());
        vec.addElement(r.getRequisito());
        vec.addElement(r.getAniosexp());
        vec.addElement(r.getSueldo());
        dtm.addRow(vec);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtIdRol = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRol = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtAnioExp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO ROL");

        jLabel2.setText("Id Rol");

        jLabel3.setText("Descripción");

        txtIdRol.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
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

        tblRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Rol", "Descripción", "Requisito", "Años Exp", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRol);

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

        jLabel8.setText("Requisito");

        jLabel4.setText("Correo a enviar PDF");

        btnPdf.setText("Enviar");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        jLabel5.setText("Años de experiencia");

        txtAnioExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioExpActionPerformed(evt);
            }
        });

        jLabel6.setText("Sueldo");

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
                                .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(txtAnioExp)
                                    .addComponent(txtSueldo))))
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
                                        .addComponent(txtEmail)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPdf))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPdf)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtAnioExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159)))
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
            llenaTblRoles("");
        }else{
            llenaTblRoles(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (valida() == true) {
            String msj;
            Util u = new Util();

            Rol rol = new Rol();

            rol.setDescripcion(this.txtDescripcion.getText());
            rol.setRequisito(this.txtObservaciones.getText());  // si usas este textbox como requisito
            // si creas txtRequisito aparte, usa ese
            rol.setAniosexp(Integer.parseInt(this.txtAnioExp.getText()));   // nuevo campo
            rol.setSueldo(Float.parseFloat(this.txtSueldo.getText()));      // nuevo campo

            if (this.btnGrabar.getText().equals("Grabar")) {
                idRol = u.idNext("Rol", "RolID");        // usa nombres reales de la tabla
                rol.setId_rol(idRol);
                this.rolDao.insertaRols(rol);
                msj = "Rol registrado satisfactoriamente";
            } else {
                rol.setId_rol(idRol);
                this.rolDao.actualizaRols(rol);
                msj = "Rol actualizado satisfactoriamente";
            }

            limpia();
            llenaTblRoles("");
            JOptionPane.showMessageDialog(this, msj);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolMouseClicked
        
    idx = this.tblRol.getSelectedRow();
    this.idRol = Integer.parseInt(dtm.getValueAt(idx, 0).toString());

    this.txtIdRol.setText(dtm.getValueAt(idx, 0).toString());  // puedes renombrar luego a txtIdRol
    this.txtDescripcion.setText(dtm.getValueAt(idx, 1).toString());
    this.txtObservaciones.setText(dtm.getValueAt(idx, 2).toString());  // requisito
    this.txtAnioExp.setText(dtm.getValueAt(idx, 3).toString());
    this.txtSueldo.setText(dtm.getValueAt(idx, 4).toString());

    this.btnGrabar.setText("Actualizar");
    this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblRolMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (this.rolDao.eliminaRols(idRol) == true) {
            JOptionPane.showMessageDialog(this, "Rol eliminado satisfactoriamente");
            this.llenaTblRoles("");
            limpia();
        } else {
            JOptionPane.showMessageDialog(this, "No es posible eliminar el rol, consulte con el DBA");
        }
        limpia();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaRol.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaRol);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Categoria");
            MailSender.sendEmail(txtEmail.getText(), "PDF CATEGORIA", mensaje, "REPORTE DE CATEGORIAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }

    }//GEN-LAST:event_btnPdfActionPerformed

    private void txtAnioExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioExpActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked
    private boolean valida(){
        boolean sw=false;
        String cad="";
        if(this.txtDescripcion.getText().isEmpty()){
            cad="Debe registrar la descripción";
        }
        if(this.txtObservaciones.getText().isEmpty()){
            cad="\nDebe registrar la observación";

        }
        if(cad.isEmpty()){
            sw=true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
   private void limpia(){
    this.txtIdRol.setText(""); // luego puedes renombrar a txtIdRol
    this.txtDescripcion.setText("");
    this.txtObservaciones.setText("");
    this.txtAnioExp.setText("");
    this.txtSueldo.setText("");
    this.txtBuscar.setText("");
    this.btnGrabar.setText("Grabar");
    this.btnEliminar.setEnabled(false);
    llenaTblRoles("");
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRol;
    private javax.swing.JTextField txtAnioExp;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdRol;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
