
package UI;

import BEAN.Categoria;
import DAO.CategoriaDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCategoria extends javax.swing.JInternalFrame {
    CategoriaDAO catDao;
    DefaultTableModel dtm;
    Vector<Categoria> listaCat;
    int idCat; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmCategoria() {
        catDao=new CategoriaDAO();
        initComponents();
        dtm = (DefaultTableModel)this.tblCateogira.getModel();
        llenaTblCategorias("");
    }
    private void llenaTblCategorias(String cad){
        
        listaCat = catDao.listaCategorias(cad);
        dtm.setRowCount(0); //vacía la tabla cada vez que se llene algo en el cuadro de busqueda
        for(int i=0;i<listaCat.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaCat.get(i).getId_categoria());
            vec.addElement(listaCat.get(i).getDescripcion());
            vec.addElement(listaCat.get(i).getObs());
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
        txtIdCategoria = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCateogira = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO CATEGORIA");

        jLabel2.setText("Id Categoia");

        jLabel3.setText("Descripción");

        txtIdCategoria.setEnabled(false);

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

        tblCateogira.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Categoria", "Descripción", "Obseervaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCateogira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCateogiraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCateogira);

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

        jLabel8.setText("Observaciones");

        jLabel4.setText("Correo a enviar PDF");

        btnPdf.setText("Enviar");
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
                                .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(265, 265, 265)))
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
            llenaTblCategorias("");
        }else{
            llenaTblCategorias(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            String msj;
            Util u = new Util();
            
            Categoria cat = new Categoria(); //se crea xq el procedimiento inserta proveedor requiere el parámetro de proveedor
            
            cat.setDescripcion(this.txtDescripcion.getText());
            cat.setObs(this.txtObservaciones.getText());
            
            if(this.btnGrabar.getText().equals("Grabar")){ //se crea para autogenerar la llave
                idCat=u.idNext("categoria", "categoriaID"); //es el nombre de la tabla y el nombre del campo de la llave primaria
                cat.setId_categoria(idCat);
                this.catDao.insertaCategorias(cat);
                msj="Categoria registrada satisfactoriamente";
            }else{
                cat.setId_categoria(idCat);
                this.catDao.actualizaCategorias(cat);
                msj="Categoria actualizada satisfactoriamente";
            }
            
            limpia();
            llenaTblCategorias("");
            JOptionPane.showMessageDialog(this, msj);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblCateogiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCateogiraMouseClicked
        
        idx=this.tblCateogira.getSelectedRow();
        this.idCat=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txtIdCategoria.setText(dtm.getValueAt(idx, 0).toString());
        this.txtDescripcion.setText(dtm.getValueAt(idx, 1).toString());
        this.txtObservaciones.setText(dtm.getValueAt(idx, 2).toString());
        
        this.btnGrabar.setText("Actualizar");
        
        this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblCateogiraMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //int idProd;
        //idProd=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        if(this.catDao.eliminaCategorias(idCat)==true){
            JOptionPane.showMessageDialog(this, "Categoria eliminada satisfactoriamente");
            this.llenaTblCategorias("");
            limpia();
        }else{
            JOptionPane.showMessageDialog(this, "No es posible eliminar la categoria, consulte con el DBA");
        }
        limpia();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaCat.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaCat);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Categoria");
            MailSender.sendEmail(txtEmail.getText(), "PDF CATEGORIA", mensaje, "REPORTE DE CATEGORIAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }

    }//GEN-LAST:event_btnPdfActionPerformed
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
        this.txtIdCategoria.setText("");
        this.txtDescripcion.setText("");
        this.txtObservaciones.setText("");
        this.txtBuscar.setText("");
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        llenaTblCategorias("");
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCateogira;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
