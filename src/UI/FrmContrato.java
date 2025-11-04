
package UI;

import BEAN.Area;
import BEAN.Categoria;
import BEAN.Contrato;
import BEAN.Empleado;
import BEAN.Medicamento;
import BEAN.Proveedor;
import BEAN.Rol;
import DAO.ContratoDAO;
import DAO.MedicamentoDAO;
import UTIL.DbBean;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmContrato extends javax.swing.JInternalFrame {
    ContratoDAO contDao;
    Vector<Contrato> listaCont;
    DefaultTableModel dtm;
    int idCont; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmContrato() {
        contDao=new ContratoDAO();
        initComponents();
        dtm = (DefaultTableModel)this.tblContrato.getModel();
        llenaTblContrato(false,"");
        llenaCmbEstado();
    }
    private void llenaTblContrato(Boolean sw,String cad){
        listaCont = contDao.listaItem(sw,cad);
        dtm.setRowCount(0); //vacía la tabla cada vez que se llene algo en el cuadro de busqueda
        for(int i=0;i<listaCont.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaCont.get(i).getId_contrato());
            vec.addElement(listaCont.get(i).getEmpleado());
            vec.addElement(listaCont.get(i).getFecini());
            vec.addElement(listaCont.get(i).getFecfin());
            vec.addElement(listaCont.get(i).getArea());
            vec.addElement(listaCont.get(i).getRol());
            vec.addElement(listaCont.get(i).getSueldo());
            dtm.addRow(vec);
        }
    }
    
    private void llenaCmbEstado(){
        this.cmbEstado.addItem(" ");
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
        txtFechaini = new javax.swing.JTextField();
        txtIdContrato = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContrato = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtFecfin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnBuscarEmpleado = new javax.swing.JButton();
        btnBuscarArea = new javax.swing.JButton();
        txtEmpleado = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtIdCat = new javax.swing.JTextField();
        txtIdProv = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBuscarArea1 = new javax.swing.JButton();
        txtRol = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        txtidArea = new javax.swing.JTextField();
        txtidRol = new javax.swing.JTextField();
        txtidEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setEnabled(false);
        setVisible(true);

        jLabel1.setText("BUSCA CONTRATOS");

        jLabel2.setText("Id Contrato");

        jLabel3.setText("Fecha inicio");

        jLabel4.setText("Area");

        txtIdContrato.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        jLabel7.setText("Buscar:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 40, 60, 20);

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

        tblContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Contrato", "Empleado", "Fecha inicio", "Fecha fin", "Area", "Rol", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContratoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContrato);

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

        jLabel8.setText("Fecha fin");

        jLabel9.setText("Sueldo");

        txtSueldo.setEnabled(false);

        jLabel11.setText("Empleado");

        btnBuscarEmpleado.setText("Buscar Empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        btnBuscarArea.setText("Buscar Area");
        btnBuscarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAreaActionPerformed(evt);
            }
        });

        txtEmpleado.setEnabled(false);

        txtArea.setEnabled(false);

        txtIdCat.setEnabled(false);

        txtIdProv.setEnabled(false);

        jLabel12.setText("Correo");

        btnPdf.setText("Enviar PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        jLabel6.setText("Rol");

        btnBuscarArea1.setText("Buscar Rol");
        btnBuscarArea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArea1ActionPerformed(evt);
            }
        });

        txtRol.setEnabled(false);

        jLabel13.setText("Estado");

        txtidArea.setEnabled(false);

        txtidRol.setEnabled(false);

        txtidEmpleado.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnGrabar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13))
                                .addGap(207, 207, 207)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarArea, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscarEmpleado)
                                            .addComponent(btnBuscarArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtRol, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                    .addComponent(txtArea)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(5, 5, 5))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtIdContrato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                            .addComponent(txtFechaini, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtidArea, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtidRol, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(txtFecfin, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(243, 243, 243))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(btnSalir)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(31, 31, 31)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(547, 547, 547))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnPdf)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(btnBuscarEmpleado)
                                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFecfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(btnBuscarArea)
                                    .addComponent(txtidArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(btnBuscarArea1)
                            .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(27, 27, 27))
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
            llenaTblContrato(true,"");
        }else{
            llenaTblContrato(true,this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            String msj;
            Util u = new Util();
            
            Contrato cont = new Contrato(); //se crea xq el procedimiento inserta proveedor requiere el parámetro de proveedor
            
            //cont.setId_contrato(Integer.parseInt(this.txtIdContrato.getText()));
            cont.setId_empleado(Integer.parseInt(this.txtidEmpleado.getText()));
            cont.setFecini(this.txtFechaini.getText());
            cont.setFecfin(this.txtFecfin.getText());
            cont.setId_area(Integer.parseInt(this.txtidArea.getText()));
            cont.setId_rol(Integer.parseInt(this.txtidRol.getText()));
            cont.setSueldo(Float.parseFloat(this.txtSueldo.getText()));
            if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                cont.setEstado(1);
            }else{
                cont.setEstado(0);
            }

            if(this.btnGrabar.getText().equals("Grabar")){ //se crea para autogenerar la llave
                idCont=u.idNext("contrato", "contratoID"); //es el nombre de la tabla y el nombre del campo de la llave primaria
                cont.setId_contrato(idCont);
                this.contDao.procesaItem(cont,"insert");
                msj="Contrato registrado satisfactoriamente";
            }else{
                cont.setId_contrato(Integer.parseInt(this.txtIdContrato.getText()));
                this.contDao.procesaItem(cont,"update");
                msj="Contrato actualizado satisfactoriamente";
            }
            
            limpia();
            llenaTblContrato(false,"");
            JOptionPane.showMessageDialog(this, msj);
        }
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblContratoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContratoMouseClicked
        DbBean db=new DbBean();
        idx=this.tblContrato.getSelectedRow();
        this.txtIdContrato.setText(dtm.getValueAt(idx, 0).toString());
        this.txtEmpleado.setText(dtm.getValueAt(idx, 1).toString());
        this.txtFechaini.setText(dtm.getValueAt(idx, 2).toString());
        this.txtFecfin.setText(dtm.getValueAt(idx, 3).toString());
        this.txtArea.setText(dtm.getValueAt(idx, 4).toString());
        this.txtRol.setText(dtm.getValueAt(idx, 5).toString());
        this.txtSueldo.setText(dtm.getValueAt(idx, 6).toString());
        String sql="select empleadoid from contrato where ContratoID = "+this.dtm.getValueAt(idx, 0).toString();
        try {
            ResultSet rstContratos = db.resultadoSQL(sql);
            if (rstContratos.next()) {
                this.txtidEmpleado.setText(rstContratos.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2="select areaid from contrato where ContratoID = "+this.dtm.getValueAt(idx, 0).toString();
        try {
            ResultSet rstArea = db.resultadoSQL(sql2);
            if (rstArea.next()) {
                this.txtidArea.setText(rstArea.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql3="select rolid from contrato where ContratoID = "+this.dtm.getValueAt(idx, 0).toString();
        try {
            ResultSet rstRol = db.resultadoSQL(sql3);
            if (rstRol.next()) {
                this.txtidRol.setText(rstRol.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql4="select estado from contrato where ContratoID = "+this.dtm.getValueAt(idx, 0).toString();
        try {
            ResultSet rstEstado = db.resultadoSQL(sql4);
            if (rstEstado.next()) {
                if(rstEstado.getString(1).equals("1")){
                    this.cmbEstado.setSelectedItem("Activo");
                }else{
                    this.cmbEstado.setSelectedItem("No Activo");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.btnGrabar.setText("Actualizar");
        
        this.btnEliminar.setEnabled(true);
        
    }//GEN-LAST:event_tblContratoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int idVe;
        idVe=Integer.parseInt(txtIdContrato.getText());
        this.contDao.borraDeta(idVe);
        limpia();
        llenaTblContrato(false,"");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        Empleado empl;
        SelEmpleado dialog=new SelEmpleado(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        empl=dialog.getEmpleado(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtEmpleado.setText(String.valueOf(empl.getApellido())+" "+String.valueOf(empl.getNombre()));
        this.txtidEmpleado.setText(String.valueOf(empl.getId_empleado()));
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void btnBuscarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAreaActionPerformed
        Area area;
        SelArea dialog=new SelArea(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        area=dialog.getArea(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtArea.setText(area.getDescripcion());
        this.txtidArea.setText(String.valueOf(area.getId_area()));
    }//GEN-LAST:event_btnBuscarAreaActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaCont.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaCont);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Contratos");
            MailSender.sendEmail(txtEmail.getText(), "PDF CONTRATOS", mensaje, "REPORTE DE CONTRATOS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnBuscarArea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArea1ActionPerformed
        Rol rol;
        SelRol dialog=new SelRol(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        rol=dialog.getRol(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtRol.setText(rol.getDescripcion());
        this.txtidRol.setText(String.valueOf(rol.getId_rol()));
        this.txtSueldo.setText(String.valueOf(rol.getSueldo()));
    }//GEN-LAST:event_btnBuscarArea1ActionPerformed
    private boolean valida(){
        boolean sw=false;
        String cad="";
        if(this.txtFechaini.getText().isEmpty()){
            cad="Debe registrar la fecha de inicio";
        }
        if(this.txtFecfin.getText().isEmpty()){
            cad="\nDebe registrar la fecha de fin";
        }
        if(this.txtSueldo.getText().isEmpty()){
            cad="\nDebe registrar el sueldo";
        }
        if(this.txtArea.getText().isEmpty()){
            cad="\nDebe registrar en área";
        }
        if(this.txtEmpleado.getText().isEmpty()){
            cad="\nDebe elegir a un empleado";
        }
        if(this.txtRol.getText().isEmpty()){
            cad="\nDebe elegir un rol";
        }
        if(cad.isEmpty()){
            sw=true;
        }else{
            JOptionPane.showMessageDialog(this, cad);
        }
        return sw;
    }
    
    private void limpia(){
        this.txtIdContrato.setText("");
        this.txtFechaini.setText("");
        this.txtFecfin.setText("");
        this.txtSueldo.setText("");
        this.txtidEmpleado.setText("");
        this.txtEmpleado.setText("");
        this.txtBuscar.setText("");
        this.txtArea.setText("");
        this.txtEmpleado.setText("");
        this.txtidRol.setText("");
        this.txtRol.setText("");
        this.txtidArea.setText("");

        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarArea;
    private javax.swing.JButton btnBuscarArea1;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContrato;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtFecfin;
    private javax.swing.JTextField txtFechaini;
    private javax.swing.JTextField txtIdCat;
    private javax.swing.JTextField txtIdContrato;
    private javax.swing.JTextField txtIdProv;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtidArea;
    private javax.swing.JTextField txtidEmpleado;
    private javax.swing.JTextField txtidRol;
    // End of variables declaration//GEN-END:variables
}
