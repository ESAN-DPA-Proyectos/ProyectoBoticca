package UI;

import BEAN.Empresa;
import DAO.EmpresaDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEmpresa extends javax.swing.JInternalFrame {
    EmpresaDAO empDao;
    DefaultTableModel dtm;
    Vector<Empresa> listEmp;
    int idEmp;
    int idx;
    
    public FrmEmpresa() {
        empDao = new EmpresaDAO(); 
        
        initComponents();
        dtm = (DefaultTableModel)this.tblEmpresas.getModel();
        LlenaTblEmpresas("");
    }
    
    private void LlenaTblEmpresas(String cad) {
        
        listEmp = empDao.listaEmpresas(cad);
        dtm.setRowCount(0);
        for (int i=0; i<listEmp.size(); i++) {
            Vector vec = new Vector();
            vec.addElement(listEmp.get(i).getEmpresaId());
            vec.addElement(listEmp.get(i).getDescEmpresa());
            vec.addElement(listEmp.get(i).getRUC());
            vec.addElement(listEmp.get(i).getContacto());
            vec.addElement(listEmp.get(i).getTlfConta());
            vec.addElement(listEmp.get(i).getWeb());
            dtm.addRow(vec);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpresas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDEmpresa = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        txtNombreContacto = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtWeb = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mantenimiento de Empresas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre empresa", "RUC", "Contacto", "Teléfono", "Web"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpresas);

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("ID Empresa");

        jLabel4.setText("Nombre Empresa");

        jLabel5.setText("Número RUC");

        jLabel6.setText("Nombre Contacto");

        jLabel7.setText("Teléfono de contacto");

        jLabel8.setText("Página Web");

        txtIDEmpresa.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreEmpresa)
                    .addComponent(txtNombreContacto)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtWeb))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(375, 375, 375)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel12)
                        .addGap(42, 42, 42)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnGrabar)
                .addGap(179, 179, 179)
                .addComponent(btnEliminar)
                .addGap(185, 185, 185)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(btnPdf)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpia();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (this.txtBuscar.getText().isEmpty()) {
           LlenaTblEmpresas("");
       } else {
           LlenaTblEmpresas(this.txtBuscar.getText());
       }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if (valida() == true) {
            String msj;
            Util u = new Util();
            Empresa emp;
            emp = new Empresa();
            emp.setDescEmpresa(this.txtNombreEmpresa.getText());
            emp.setRUC(this.txtRUC.getText());
            emp.setContacto(this.txtNombreContacto.getText());
            emp.setTlfConta(this.txtTelefono.getText());
            emp.setWeb(this.txtWeb.getText());
            if (this.btnGrabar.getText().equals("Grabar")) {
                idEmp = u.idNext("Empresa", "EmpresaID");
                emp.setEmpresaId(idEmp);
                this.empDao.insertaEmpresas(emp);
                msj = "Empresa registrada satisfactoriamente";
            } else {
                idEmp = Integer.parseInt(this.txtIDEmpresa.getText());
                emp.setEmpresaId(idEmp);
                this.empDao.actualizaEmpresas(emp);
                msj = "Empresa actualizada satisfactoriamente";
            }
            this.limpia();
            this.LlenaTblEmpresas("");
            JOptionPane.showMessageDialog(this, msj);
        }        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        System.out.println(idEmp);
        if (this.empDao.eliminaEmpresas(idEmp) == true) {
            JOptionPane.showMessageDialog(this, "Empresa eliminada");
            this.LlenaTblEmpresas("");
        } else {
            JOptionPane.showMessageDialog(this, "No es posible la eliminación, consulte con el DBA");
        }
        limpia();        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpresasMouseClicked
        idx = this.tblEmpresas.getSelectedRow();
        this.idEmp = Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txtIDEmpresa.setText(dtm.getValueAt(idx, 0).toString());
        this.txtNombreEmpresa.setText(dtm.getValueAt(idx, 1).toString());
        this.txtRUC.setText(dtm.getValueAt(idx, 2).toString());
        this.txtNombreContacto.setText(dtm.getValueAt(idx, 3).toString());
        this.txtTelefono.setText(dtm.getValueAt(idx, 4).toString());
        this.txtWeb.setText(dtm.getValueAt(idx, 5).toString());
        this.btnGrabar.setText("Actualiza");
        this.btnEliminar.setEnabled(true);        
    }//GEN-LAST:event_tblEmpresasMouseClicked

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listEmp.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listEmp);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Empresas");
            MailSender.sendEmail(txtEmail.getText(), "PDF EMPRESAS", mensaje, "REPORTE DE EMPRESAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private boolean valida() {
        boolean sw = false;
        String cad = "";
        if (this.txtNombreEmpresa.getText().isEmpty()) {
            cad = "Debe registrar el nombre de la empresa";
        }
        if (this.txtRUC.getText().isEmpty()) {
            cad = cad + "Debe registrar el número de RUC";
        }
        if (this.txtNombreContacto.getText().isEmpty()) {
            cad = cad + "Debe registrar el nombre del contacto";
        }
        if (this.txtTelefono.getText().isEmpty()) {
            cad = cad + "Debe registrar el teléfono del contacto";
        }
        if (this.txtWeb.getText().isEmpty()) {
            cad = cad + "Debe registrar la web de la empresa";
        }
        if (cad.isEmpty()) {
            sw = true;
        } else {
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
    private void limpia() {
        this.txtIDEmpresa.setText("");
        this.txtNombreEmpresa.setText("");
        this.txtRUC.setText("");
        this.txtNombreContacto.setText("");
        this.txtTelefono.setText("");
        this.txtWeb.setText("");
        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        LlenaTblEmpresas("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpresas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDEmpresa;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
