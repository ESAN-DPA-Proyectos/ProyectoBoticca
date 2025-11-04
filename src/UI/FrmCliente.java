
package UI;

import BEAN.Cliente;
import DAO.ClienteDAO;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends javax.swing.JInternalFrame {
    ClienteDAO clienDao;
    DefaultTableModel dtm;
    Vector<Cliente> listaClien;
    int idClien; //se usa porque el idProv es una llave primaria en la tabla y el sistema la debe autogenerar
    int idx;
    public FrmCliente() {
        clienDao=new ClienteDAO();
        initComponents();
        llenaCmbEstCivil();
        llenaCmbGenero();
        llenaCmbEstado();
        dtm = (DefaultTableModel)this.tblClientes.getModel();
        llenaTblClientes("");
    }
    private void llenaTblClientes(String cad){
        
        listaClien = clienDao.listaClientes(cad);
        dtm.setRowCount(0); //vacía la tabla cada vez que se llene algo en el cuadro de busqueda
        for(int i=0;i<listaClien.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaClien.get(i).getId_cliente());
            vec.addElement(listaClien.get(i).getNombre());
            vec.addElement(listaClien.get(i).getApellido());
            vec.addElement(listaClien.get(i).getDireccion());
            vec.addElement(listaClien.get(i).getTelefono());
            vec.addElement(listaClien.get(i).getDni());
            vec.addElement(listaClien.get(i).getGenero());
            vec.addElement(listaClien.get(i).getEstcivil());
            vec.addElement(listaClien.get(i).getEstado());
            dtm.addRow(vec);
        }
    }
    
    private void llenaCmbEstCivil(){
        this.cmbEstCivil.addItem("");
        this.cmbEstCivil.addItem("Soltero");
        this.cmbEstCivil.addItem("Casado");
        this.cmbEstCivil.addItem("Viudo");
        this.cmbEstCivil.addItem("Divorciado");
    }
    
    private void llenaCmbGenero(){
        this.cmbGenero.addItem("");
        this.cmbGenero.addItem("Masculino");
        this.cmbGenero.addItem("Femenino");
        this.cmbGenero.addItem("Otros");
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
        txtNombre = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbEstCivil = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("MANTENIMIENTO CLIENTES");

        jLabel2.setText("Id Cliente");

        jLabel3.setText("Nombre");

        jLabel4.setText("Estado civil");

        jLabel5.setText("Telefono");

        jLabel6.setText("Estado");

        txtIdCliente.setEnabled(false);

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

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Nombre", "Apellido", "Direccion", "Telefono", "DNI", "Genero", "E.Civil", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

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

        jLabel8.setText("Apellido");

        jLabel9.setText("Dirección");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        jLabel10.setText("DNI");

        jLabel11.setText("Genero");

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
                .addGap(489, 489, 489)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10))
                                .addGap(96, 96, 96))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(93, 93, 93)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(106, 106, 106)
                                .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnGrabar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(86, 86, 86)
                        .addComponent(cmbEstCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(96, 96, 96)
                        .addComponent(cmbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addGap(31, 31, 31)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnPdf)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel9)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4))
                            .addComponent(cmbEstCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addGap(27, 27, 27))
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
            llenaTblClientes("");
        }else{
            llenaTblClientes(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        if(valida()==true){
            String msj;
            Util u = new Util();
            
            Cliente clien = new Cliente(); //se crea xq el procedimiento inserta proveedor requiere el parámetro de proveedor
            
            clien.setNombre(this.txtNombre.getText());
            clien.setApellido(this.txtApellido.getText());
            clien.setDireccion(this.txtDireccion.getText());
            clien.setTelefono(this.txtTelefono.getText());
            clien.setDni(this.txtDni.getText());
            
            if(this.cmbGenero.getSelectedItem().toString().equals("Masculino")){
                clien.setGenero(1);
            }else if(this.cmbGenero.getSelectedItem().toString().equals("Femenino")){
                clien.setGenero(2);
            }else if(this.cmbGenero.getSelectedItem().toString().equals("Otros")){
                clien.setGenero(3);
            }else{
                clien.setGenero(0);
            }
            
            if(this.cmbEstCivil.getSelectedItem().toString().equals("Soltero")){
                clien.setEstcivil(1);
            }else if(this.cmbEstCivil.getSelectedItem().toString().equals("Casado")){
                clien.setEstcivil(2);
            }else if(this.cmbEstCivil.getSelectedItem().toString().equals("Viudo")){
                clien.setEstcivil(3);
            }else if(this.cmbEstCivil.getSelectedItem().toString().equals("Divorciado")){
                clien.setEstcivil(4);
            }else{
                clien.setEstcivil(0);
            }

            if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                clien.setEstado(1);
            }else{
                clien.setEstado(0);
            }
            if(this.btnGrabar.getText().equals("Grabar")){ //se crea para autogenerar la llave
                idClien=u.idNext("Clientes", "ClienteID"); //es el nombre de la tabla y el nombre del campo de la llave primaria
                clien.setId_cliente(idClien);
                this.clienDao.insertaClientes(clien);
                msj="Cliente registrado satisfactoriamente";
            }else{
                clien.setId_cliente(idClien);
                this.clienDao.actualizaClientes(clien);
                msj="Cliente actualizado satisfactoriamente";
            }
            
            limpia();
            llenaTblClientes("");
            JOptionPane.showMessageDialog(this, msj);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        
        idx=this.tblClientes.getSelectedRow();
        this.idClien=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        this.txtIdCliente.setText(dtm.getValueAt(idx, 0).toString());
        this.txtNombre.setText(dtm.getValueAt(idx, 1).toString());
        this.txtApellido.setText(dtm.getValueAt(idx, 2).toString());
        this.txtDireccion.setText(dtm.getValueAt(idx, 3).toString());
        this.txtTelefono.setText(dtm.getValueAt(idx, 4).toString());
        this.txtDni.setText(dtm.getValueAt(idx, 5).toString());
        
        if(dtm.getValueAt(idx, 6).toString().equals("1")){
            this.cmbGenero.setSelectedItem("Masculino");
        }else if(dtm.getValueAt(idx, 6).toString().equals("2")){
            this.cmbGenero.setSelectedItem("Femenino");
        }else if(dtm.getValueAt(idx, 6).toString().equals("3")){
            this.cmbGenero.setSelectedItem("Otros");
        }else{
            this.cmbGenero.setSelectedItem("");
        }
        
        if(dtm.getValueAt(idx, 7).toString().equals("1")){
            this.cmbEstCivil.setSelectedItem("Soltero");
        }else if(dtm.getValueAt(idx, 7).toString().equals("2")){
            this.cmbEstCivil.setSelectedItem("Casado");
        }else if(dtm.getValueAt(idx, 7).toString().equals("3")){
            this.cmbEstCivil.setSelectedItem("Viudo");
        }else if(dtm.getValueAt(idx, 7).toString().equals("4")){
            this.cmbEstCivil.setSelectedItem("Divorciado");
        }else{
            this.cmbEstCivil.setSelectedItem("");
        }
        
        if(dtm.getValueAt(idx, 8).toString().equals("1")){
            this.cmbEstado.setSelectedItem("Activo");
        }else{
            this.cmbEstado.setSelectedItem("No Activo");
        }
        this.btnGrabar.setText("Actualizar");
        
        this.btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //int idProd;
        //idProd=Integer.parseInt(dtm.getValueAt(idx, 0).toString());
        if(this.clienDao.eliminaClientes(idClien)==true){
            JOptionPane.showMessageDialog(this, "Cliente eliminado satisfactoriamente");
            this.llenaTblClientes("");
            limpia();
        }else{
            JOptionPane.showMessageDialog(this, "No es posible eliminar al Cliente, consulte con el DBA");
        }
        limpia();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaClien.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaClien);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Clientes");
            MailSender.sendEmail(txtEmail.getText(), "PDF CLIENTE", mensaje, "REPORTE DE CLIENTES", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpia();
        }
    }//GEN-LAST:event_btnPdfActionPerformed
    private boolean valida(){
        boolean sw=false;
        String cad="";
        if(this.txtNombre.getText().isEmpty()){
            cad="Debe registrar el nombre";
        }
        if(this.txtApellido.getText().isEmpty()){
            cad="\nDebe registrar el apellido";
        }
        if(this.txtDireccion.getText().isEmpty()){
            cad="\nDebe registrar la direccion";
        }
        if(this.txtTelefono.getText().isEmpty()){
            cad=cad+"\nDebe registrar el teleono";
        }
        if(this.txtDni.getText().isEmpty()){
            cad="\nDebe registrar el DNI";
        }
        if(this.cmbGenero.getSelectedItem().toString().isEmpty()){
            cad=cad+"\nDebe seleccionar el genero";
        }
        if(this.cmbEstCivil.getSelectedItem().toString().isEmpty()){
            cad=cad+"\nDebe seleccionar el estado civil";
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
        this.txtIdCliente.setText("");
        this.txtNombre.setText("");
        this.txtApellido.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
        this.txtDni.setText("");
        this.txtBuscar.setText("");
        this.cmbEstCivil.setSelectedItem("");
        
        this.cmbGenero.setSelectedItem("");
        this.cmbEstado.setSelectedItem("");
        this.btnGrabar.setText("Grabar");
        this.btnEliminar.setEnabled(false);
        
        llenaTblClientes("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstCivil;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
