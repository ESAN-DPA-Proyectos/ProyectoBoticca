
package UI;

import BEAN.Cliente;
import BEAN.Empleado;
import BEAN.Medicamento;
import BEAN.Sede;
import BEAN.cab_venta;
import BEAN.det_venta;
import DAO.ClienteDAO;
import DAO.cab_ventaDAO;
import DAO.det_ventaDAO;
import UTIL.DbBean;
import UTIL.MailSender;
import UTIL.PdfGenerator;
import UTIL.Util;
import java.io.ByteArrayOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVentas extends javax.swing.JFrame { //JFrame
    
    DefaultTableModel dtm,dtml,dtml2,dtml3,dtml4,dtml5;
    Vector<det_venta> listaItem;
    cab_ventaDAO cabDao;
    det_ventaDAO detDao;
    ClienteDAO clieDao;
    Cliente clie;
    cab_venta cab;
    det_venta det;
    public FrmVentas() {
        initComponents();
        clie=new Cliente();
        cab=new cab_venta();
        det=new det_venta();
        cabDao=new cab_ventaDAO();
        detDao=new det_ventaDAO();
        clieDao=new ClienteDAO();
        this.jTabbedPane1.setSelectedIndex(1);
        dtm = (DefaultTableModel)this.tblCliente.getModel();
        dtml = (DefaultTableModel)this.tblCabVenta.getModel();
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        dtml3 = (DefaultTableModel)this.tblDetVenta.getModel();
        dtml4 = (DefaultTableModel)this.tblActCabVenta.getModel();
        dtml5 = (DefaultTableModel)this.tblActDetVenta.getModel();
        llenaTblCliente("");
        llenaTblCabVenta(false,"");
        llenaTblDetVenta(false,"");
        llenaTblActCabVenta(false,"");
        llenaTblActDetVenta(false,"");
        llenaCmbEstado();
    }
    
    private void llenaTblCliente(String cad){
        Vector<Cliente> listaCliente;
        listaCliente=clieDao.listaClientes(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaCliente.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaCliente.get(i).getId_cliente());
            vec.addElement(listaCliente.get(i).getNombre());
            vec.addElement(listaCliente.get(i).getApellido());
            dtm.addRow(vec);
        }
        
    }
    
    private void llenaTblCabVenta(boolean sw,String cad){
        Vector<cab_venta> listaItem;
        listaItem=cabDao.listaItem(sw,cad);
        dtml.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_venta());
            vec.addElement(listaItem.get(i).getEmpleado());
            vec.addElement(listaItem.get(i).getFecha());
            vec.addElement(listaItem.get(i).getSede());
            vec.addElement(listaItem.get(i).getEstado());
            dtml.addRow(vec);
        }
        
        this.jTabbedPane1.setSelectedIndex(0);
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        
    }
    
    private void llenaTblDetVenta(boolean sw,String cad){
        
        listaItem=detDao.listaItem(sw,cad);
        dtml3.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_detventa());
            vec.addElement(listaItem.get(i).getId_venta());
            vec.addElement(listaItem.get(i).getMedicamento());
            vec.addElement(listaItem.get(i).getCantidad());
            vec.addElement(listaItem.get(i).getPreciounit());
            vec.addElement(listaItem.get(i).getPreciototal());
            dtml3.addRow(vec);
        }
        
    }
    
    private void llenaTblActCabVenta(boolean sw,String cad){
        Vector<cab_venta> listaItem;
        listaItem=cabDao.listaItem(sw,cad);
        dtml4.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_venta());
            vec.addElement(listaItem.get(i).getEmpleado());
            vec.addElement(listaItem.get(i).getFecha());
            vec.addElement(listaItem.get(i).getSede());
            vec.addElement(listaItem.get(i).getEstado());
            dtml4.addRow(vec);
        }
        
        this.jTabbedPane1.setSelectedIndex(0);
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        
    }
    
    private void llenaTblActDetVenta(boolean sw,String cad){
        Vector<det_venta> listaItem;
        listaItem=detDao.listaItem(sw,cad);
        dtml5.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_detventa());
            vec.addElement(listaItem.get(i).getId_venta());
            vec.addElement(listaItem.get(i).getMedicamento());
            vec.addElement(listaItem.get(i).getCantidad());
            vec.addElement(listaItem.get(i).getPreciounit());
            vec.addElement(listaItem.get(i).getPreciototal());
            dtml5.addRow(vec);
        }
        
    }
    
    private void llenaCmbEstado(){
        this.cmbEstado.addItem("Activo");
        this.cmbEstado.addItem("No activo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCabVenta = new javax.swing.JTable();
        btnBorrarVenta = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetVenta = new javax.swing.JTable();
        btnBorrarDetalle = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        btnBuscarClie = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdMed = new javax.swing.JTextField();
        txtNomMed = new javax.swing.JTextField();
        txtDescMed = new javax.swing.JTextField();
        txtPrecioUnit = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnBuscarMed = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        btnBuscarSede = new javax.swing.JButton();
        btnBuscarEmpleado = new javax.swing.JButton();
        txtSede = new javax.swing.JTextField();
        txtEmpleado = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblActCabVenta = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblActDetVenta = new javax.swing.JTable();
        btnBuscarEmpleado2 = new javax.swing.JButton();
        btnBuscarSede2 = new javax.swing.JButton();
        txtSede2 = new javax.swing.JTextField();
        txtEmpleado2 = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnBuscarMed2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad2 = new javax.swing.JTextField();
        txtMed2 = new javax.swing.JTextField();
        txtPrecioUnit2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtClieCod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        txtIdSede = new javax.swing.JTextField();
        txtIdEmpleado = new javax.swing.JTextField();
        txtCabCod = new javax.swing.JTextField();
        txtDetCod = new javax.swing.JTextField();
        txtDetCod1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DE VENTAS");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Buscar cliente");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras del cliente"));

        tblCabVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Venta", "Empleado", "Fecha", "Sede", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCabVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCabVentaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCabVenta);

        btnBorrarVenta.setText("Borrar venta");
        btnBorrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarVenta)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarVenta)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de compras del cliente"));

        tblDetVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Detalle", "Id venta", "Medicamento", "Cantidad", "Precio unit", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetVentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDetVenta);

        btnBorrarDetalle.setText("Borrar detalle");
        btnBorrarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBorrarDetalle)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarDetalle)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar Ventas", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));

        jLabel3.setText("Id Cliente");

        txtIdCliente.setEnabled(false);

        jLabel4.setText("Apellidos");

        txtApellidos.setEnabled(false);

        jLabel5.setText("Nombres");

        txtNombres.setEnabled(false);

        btnBuscarClie.setText("Buscar Cliente");
        btnBuscarClie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnBuscarClie))
                    .addComponent(txtApellidos)
                    .addComponent(txtNombres))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClie))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));

        jLabel6.setText("Id Medicamento");

        jLabel7.setText("Nombre");

        jLabel8.setText("Descripcion");

        jLabel9.setText("Precio unitario");

        jLabel10.setText("Cantidad");

        txtIdMed.setEnabled(false);
        txtIdMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMedActionPerformed(evt);
            }
        });

        txtNomMed.setEnabled(false);
        txtNomMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomMedActionPerformed(evt);
            }
        });

        txtDescMed.setEnabled(false);
        txtDescMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescMedActionPerformed(evt);
            }
        });

        txtPrecioUnit.setEnabled(false);
        txtPrecioUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitActionPerformed(evt);
            }
        });

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        btnBuscarMed.setText("Buscar Medicamento");
        btnBuscarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescMed)
                            .addComponent(txtNomMed)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtIdMed, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarMed)))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarMed))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNomMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDescMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id med", "Medicamento", "Descripcion", "Cantidad", "Precio unit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblProducto);

        btnBuscarSede.setText("Buscar Sede");
        btnBuscarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSedeActionPerformed(evt);
            }
        });

        btnBuscarEmpleado.setText("Buscar Empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        txtSede.setEnabled(false);

        txtEmpleado.setEnabled(false);
        txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSede, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnBuscarSede)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnBuscarEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarSede)
                    .addComponent(btnBuscarEmpleado)
                    .addComponent(btnAgregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ventas", jPanel4);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras del cliente"));

        tblActCabVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Venta", "Empleado", "Fecha", "Sede", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblActCabVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActCabVentaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblActCabVenta);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de compras del cliente"));

        tblActDetVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Detalle", "Id venta", "Medicamento", "Cantidad", "Precio unit", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblActDetVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActDetVentaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblActDetVenta);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnBuscarEmpleado2.setText("Buscar Empleado");
        btnBuscarEmpleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleado2ActionPerformed(evt);
            }
        });

        btnBuscarSede2.setText("Buscar Sede");
        btnBuscarSede2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSede2ActionPerformed(evt);
            }
        });

        txtSede2.setEnabled(false);

        txtEmpleado2.setEnabled(false);
        txtEmpleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleado2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado");

        btnBuscarMed2.setText("Buscar Medicamento");
        btnBuscarMed2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMed2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Cantidad");

        txtCantidad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidad2ActionPerformed(evt);
            }
        });

        txtMed2.setEnabled(false);

        txtPrecioUnit2.setEnabled(false);

        jLabel13.setText("Medicamento");

        jLabel14.setText("Precio unitario");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(txtMed2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecioUnit2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btnBuscarMed2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(119, 119, 119))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSede2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnBuscarSede2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmpleado2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarEmpleado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel11)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarSede2)
                            .addComponent(btnBuscarEmpleado2)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEmpleado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMed2)
                    .addComponent(jLabel12)
                    .addComponent(txtCantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMed2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioUnit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Actualizar", jPanel7);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        jLabel15.setText("Correo");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel1)
                        .addGap(179, 179, 179)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(txtClieCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCabCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDetCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDetCod1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdSede, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(35, 35, 35)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addGap(149, 149, 149)
                                .addComponent(btnLimpiar)
                                .addGap(158, 158, 158)
                                .addComponent(jButton1)))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtClieCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCabCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDetCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDetCod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGrabar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnPdf)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        int idx = this.tblCliente.getSelectedRow();
        if (idx == -1) {
            return; // Nada seleccionado, no hacemos nada
        }

        // Obtener directamente el ID del cliente desde la tabla
        String idCli = this.tblCliente.getValueAt(idx, 0).toString().trim();
        this.txtClieCod.setText(idCli);

        // Cada vez que cambias de cliente:
        // 1) recargas las ventas de ese cliente
        // 2) limpias la selección de venta y su detalle
        llenaTblCabVenta(true, idCli);

        this.txtCabCod.setText("");
        dtml3.setRowCount(0);  // limpia la tabla tblDetVenta
    }//GEN-LAST:event_tblClienteMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblCliente("");
        }else{
            llenaTblCliente(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClieActionPerformed
        Cliente clie;
        SelCliente dialog=new SelCliente(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        clie=dialog.getCliente(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdCliente.setText(String.valueOf(clie.getId_cliente()));
        this.txtApellidos.setText(clie.getApellido());
        this.txtNombres.setText(clie.getNombre());
    }//GEN-LAST:event_btnBuscarClieActionPerformed

    private void txtIdMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMedActionPerformed

    private void txtNomMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomMedActionPerformed

    private void txtDescMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescMedActionPerformed

    private void txtPrecioUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUnitActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnBuscarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedActionPerformed
        Medicamento med;
        SelMedicamento dialog=new SelMedicamento(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        med=dialog.getMedicamento(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdMed.setText(String.valueOf(med.getId_medicamento()));
        this.txtNomMed.setText(med.getNombre());
        this.txtDescMed.setText(med.getDescripcion());
        this.txtPrecioUnit.setText(med.getPrecio().toString());
    }//GEN-LAST:event_btnBuscarMedActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiaDetalle();
        limpiaCabecera();
        dtml2.setRowCount(0);
        limpiaPrimeraHoja();
        this.btnGrabar.setText("Grabar");
        llenaTblActCabVenta(false,"");
        llenaTblActDetVenta(false,"");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        Util u = new Util();
        int idVent;
        int idDetVent;
        DbBean con = new DbBean();
        String fech;

        // MODO 1: GRABAR NUEVA VENTA
        if (this.btnGrabar.getText().equals("Grabar")) {
            if (this.txtIdCliente.getText().isEmpty()
                    || dtml2.getRowCount() == 0
                    || this.txtSede.getText().isEmpty()
                    || this.txtEmpleado.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un cliente y por lo menos un producto");
            } else {
                // Insertando en la cabecera: cab_venta
                idVent = u.idNext("ventas", "ventaid"); // tabla, campo llave
                fech = u.obtenerFecha();
                cab_venta cv = new cab_venta();
                cv.setId_venta(idVent);
                cv.setId_cliente(Integer.parseInt(this.txtIdCliente.getText()));
                cv.setId_empleado(Integer.parseInt(this.txtIdEmpleado.getText()));
                cv.setFecha(fech);
                cv.setId_sede(Integer.parseInt(this.txtIdSede.getText()));
                cv.setEstado(1);
                this.cabDao.procesaItem(cv, "insert");

                // Insertando en el detalle: det_venta
                for (int i = 0; i < dtml2.getRowCount(); i++) {
                    det_venta dv = new det_venta();
                    idDetVent = u.idNext("DetallesVenta", "detalleventaid"); // tabla,campo llave
                    dv.setId_detventa(idDetVent);
                    dv.setId_venta(idVent);
                    dv.setId_medicamento(Integer.parseInt(dtml2.getValueAt(i, 0).toString()));
                    dv.setCantidad(Integer.parseInt(dtml2.getValueAt(i, 3).toString()));
                    dv.setPreciounit(Float.parseFloat(dtml2.getValueAt(i, 4).toString()));
                    this.detDao.procesaItem(dv, "insert");
                }

                limpiaCabecera();
                limpiaDetalle();
                JOptionPane.showMessageDialog(this, "Venta registrada satisfactoriamente");

                // Refrescar pestaña "Buscar Ventas"
                llenaTblCabVenta(false, "");
                llenaTblDetVenta(false, "");
                this.jTabbedPane1.setSelectedIndex(0);
            }

        // MODO 2: ACTUALIZAR DETALLE (pestaña Actualizar)
        } else { 
            if (this.txtMed2.getText().isEmpty()
                    || this.txtPrecioUnit2.getText().isEmpty()
                    || this.txtCantidad2.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un medicamento y elegir la cantidad");
            } else {
                det_venta dv = new det_venta();
                dv.setId_detventa(Integer.parseInt(this.txtDetCod.getText()));
                dv.setId_medicamento(Integer.parseInt(this.txtIdMed.getText()));
                dv.setCantidad(Integer.parseInt(this.txtCantidad2.getText()));
                dv.setPreciounit(Float.parseFloat(this.txtPrecioUnit2.getText()));
                this.detDao.procesaItem(dv, "update");

                // Recargar detalle en pestaña Actualizar
                llenaTblActDetVenta(true, this.txtCabCod.getText());
                this.jTabbedPane1.setSelectedIndex(2);
                JOptionPane.showMessageDialog(this, "Detalle actualizado satisfactoriamente");
            }
        }

        // limpiar la tabla temporal del registro de venta
        dtml2.setRowCount(0);
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(this.txtIdMed.getText().isEmpty() || this.txtCantidad.getText().isEmpty()
                || this.txtSede.getText().isEmpty()|| this.txtEmpleado.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un medicamento, cantidad, sede y empleado");
        }else{    
            Vector vec = new Vector();
            vec.addElement(this.txtIdMed.getText());
            vec.addElement(this.txtNomMed.getText());
            vec.addElement(this.txtDescMed.getText());
            vec.addElement(this.txtCantidad.getText());
            vec.addElement(this.txtPrecioUnit.getText());
            dtml2.addRow(vec);
            limpiaAgregar();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSedeActionPerformed
        Sede sede;
        SelSede dialog=new SelSede(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        sede=dialog.getSede(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdSede.setText(String.valueOf(sede.getId_sede()));
        this.txtSede.setText(sede.getNombre());
    }//GEN-LAST:event_btnBuscarSedeActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        Empleado empl;
        SelEmpleado dialog=new SelEmpleado(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        empl=dialog.getEmpleado(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdEmpleado.setText(String.valueOf(empl.getId_empleado()));
        this.txtEmpleado.setText(empl.getApellido());

    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void tblCabVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCabVentaMouseClicked
        int idx = this.tblCabVenta.getSelectedRow();
        if (idx == -1) {
            return;
        }

        String idVenta = this.tblCabVenta.getValueAt(idx, 0).toString().trim();
        this.txtCabCod.setText(idVenta);

        // Cargar siempre el detalle de la venta seleccionada
        llenaTblDetVenta(true, idVenta);
    }//GEN-LAST:event_tblCabVentaMouseClicked

    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoActionPerformed

    private void btnBorrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVentaActionPerformed
        // 1. Validar que exista código de cabecera seleccionado
        if (txtCabCod.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay una venta seleccionada.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Confirmar con el usuario
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar la venta y todos sus detalles?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return;    // el usuario canceló
        }

        // 3. Ejecutar borrado: primero detalle, luego cabecera
        int idVe = Integer.parseInt(txtCabCod.getText());

        // Elimina TODOS los detalles de esa venta (SP vía det_ventaDAO)
        detDao.borraDeta(idVe);

        // Elimina la cabecera (SP vía cab_ventaDAO)
        cabDao.borraCab(idVe);

        // Como borraCab es void, asumimos éxito si no lanzó excepción
        int r = 1;

        // 4. Evaluar resultado y refrescar pantallas
        if (r > 0) {
            JOptionPane.showMessageDialog(this,
                    "Venta eliminada correctamente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            // Pestaña BUSCAR: limpia filtros y recarga tablas
            limpiaPrimeraHoja();               // txtClieCod, txtCabCod, tblCabVenta, tblDetVenta

            // Pestaña ACTUALIZAR: recarga cabeceras y detalles
            llenaTblActCabVenta(false, "");
            llenaTblActDetVenta(false, "");

            // Dejamos el botón en modo registro por si estabas actualizando
            btnGrabar.setText("Grabar");
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar la venta.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarVentaActionPerformed

    private void btnBorrarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDetalleActionPerformed
        // 1. Validar que exista un detalle seleccionado
        if (txtDetCod.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay un detalle de venta seleccionado.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Confirmar con el usuario
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este detalle de la venta?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return;   // el usuario canceló
        }

        // 3. Si confirmó, eliminamos el detalle
        int idDet = Integer.parseInt(txtDetCod.getText());

        try {
            // borraDetaUnit elimina por DetalleVentaID en det_ventaDAO
            this.detDao.borraDetaUnit(idDet);

            // 4. Avisar y limpiar/recargar pantallas
            JOptionPane.showMessageDialog(this,
                    "Detalle de venta eliminado correctamente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiaPrimeraHoja();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar el detalle de la venta.\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarDetalleActionPerformed

    private void tblDetVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetVentaMouseClicked
        int idx;
        idx=this.tblDetVenta.getSelectedRow();
        det.setId_detventa(Integer.parseInt(dtml3.getValueAt(idx, 0).toString()));
        this.txtDetCod.setText(String.valueOf(det.getId_detventa()));
        
    }//GEN-LAST:event_tblDetVentaMouseClicked

    private void tblActCabVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActCabVentaMouseClicked
        DbBean con = new DbBean();
        int idx;
        idx = this.tblActCabVenta.getSelectedRow();

        // Datos visibles
        this.txtCabCod.setText(dtml4.getValueAt(idx, 0).toString());
        this.txtSede2.setText(dtml4.getValueAt(idx, 3).toString());
        this.txtEmpleado2.setText(dtml4.getValueAt(idx, 1).toString());
        if (dtml4.getValueAt(idx, 4).toString().equals("1")) {
            this.cmbEstado.setSelectedItem("Activo");
        } else {
            this.cmbEstado.setSelectedItem("No activo");
        }

        // 1) Recuperar empleado
        String queryemp = "select empleadoid from ventas where ventaid = '" 
                          + this.txtCabCod.getText() + "'";

        try {
            ResultSet resultado = con.resultadoSQL(queryemp);
            while (resultado.next()) {
                this.txtIdEmpleado.setText(resultado.getString(1));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        // 2) Recuperar sede
        String querysede = "select sedeid from ventas where ventaid = '" 
                           + this.txtCabCod.getText() + "'";
        try {
            ResultSet resultado = con.resultadoSQL(querysede);
            while (resultado.next()) {
                this.txtIdSede.setText(resultado.getString(1));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        // 3) Recuperar cliente
        String querycli = "select clienteid from ventas where ventaid = '" 
                          + this.txtCabCod.getText() + "'";
        try {
            ResultSet resultado = con.resultadoSQL(querycli);
            while (resultado.next()) {
                this.txtIdCliente.setText(resultado.getString(1));
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

        this.btnGrabar.setText("Actualizar detalle");
    }//GEN-LAST:event_tblActCabVentaMouseClicked

    private void tblActDetVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActDetVentaMouseClicked
        DbBean con = new DbBean();
        int idx;
        idx=this.tblActDetVenta.getSelectedRow();
        this.txtDetCod.setText(dtml5.getValueAt(idx, 0).toString());
        this.txtCabCod.setText(dtml5.getValueAt(idx, 1).toString());
        this.txtMed2.setText(dtml5.getValueAt(idx, 2).toString());
        this.txtCantidad2.setText(dtml5.getValueAt(idx, 3).toString());
        this.txtPrecioUnit2.setText(dtml5.getValueAt(idx, 4).toString());

        String querymed;
        querymed="select medicamentoid from DetallesVenta where detalleventaid= '"+this.txtDetCod.getText()+"'";

        try{
            ResultSet resultado = con.resultadoSQL(querymed);

            while(resultado.next()){
                this.txtIdMed.setText(resultado.getString(1));
                
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        
        this.btnGrabar.setText("Actualizar detalle");
    }//GEN-LAST:event_tblActDetVentaMouseClicked

    private void btnBuscarEmpleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleado2ActionPerformed
        Empleado empl;
        SelEmpleado dialog=new SelEmpleado(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        empl=dialog.getEmpleado(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdEmpleado.setText(String.valueOf(empl.getId_empleado()));
        this.txtEmpleado2.setText(empl.getApellido()+" "+empl.getNombre());
    }//GEN-LAST:event_btnBuscarEmpleado2ActionPerformed

    private void btnBuscarSede2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSede2ActionPerformed
        Sede sede;
        SelSede dialog=new SelSede(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        sede=dialog.getSede(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdSede.setText(String.valueOf(sede.getId_sede()));
        this.txtSede2.setText(sede.getNombre());
    }//GEN-LAST:event_btnBuscarSede2ActionPerformed

    private void txtEmpleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleado2ActionPerformed

    private void btnBuscarMed2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMed2ActionPerformed
        Medicamento med;
        SelMedicamento dialog=new SelMedicamento(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        med=dialog.getMedicamento(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdMed.setText(String.valueOf(med.getId_medicamento()));
        this.txtMed2.setText(med.getNombre());
        //this.txtDescMed.setText(med.getDescripcion());
        this.txtPrecioUnit2.setText(med.getPrecio().toString());
    }//GEN-LAST:event_btnBuscarMed2ActionPerformed

    private void txtCantidad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad2ActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        String mensajeError = Util.validaCorreoYTabla(txtEmail.getText(), listaItem.isEmpty());

        if(!mensajeError.isEmpty()){
            JOptionPane.showMessageDialog(this, mensajeError);
        } else {
            String mensaje = "Hola,\n\nAdjunto encontrarás el reporte generado automáticamente.\n\nSaludos,\nSistema";

            List<Object> listaObjetos = new ArrayList<>(listaItem);
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Ventas");
            MailSender.sendEmail(txtEmail.getText(), "PDF VENTAS", mensaje, "REPORTE DE VENTAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpiaCabecera();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void limpiaDetalle(){
        this.txtIdMed.setText("");
        this.txtNomMed.setText("");
        this.txtDescMed.setText("");
        this.txtPrecioUnit.setText("");
        this.txtCantidad.setText("");
        this.txtEmpleado.setText("");
        this.txtIdEmpleado.setText("");
        this.txtIdSede.setText("");
        
    } 
    
    private void limpiaAgregar(){
        this.txtIdMed.setText("");
        this.txtNomMed.setText("");
        this.txtDescMed.setText("");
        this.txtPrecioUnit.setText("");
        this.txtCantidad.setText("");
        
    } 
    
    private void limpiaCabecera(){
        this.txtIdCliente.setText("");
        this.txtApellidos.setText("");
        this.txtNombres.setText("");
    }
    
    private void limpiaPrimeraHoja(){
        this.txtClieCod.setText("");
        llenaTblCabVenta(false,"");
        this.txtCabCod.setText("");
        llenaTblDetVenta(false,"");
    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarDetalle;
    private javax.swing.JButton btnBorrarVenta;
    private javax.swing.JButton btnBuscarClie;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarEmpleado2;
    private javax.swing.JButton btnBuscarMed;
    private javax.swing.JButton btnBuscarMed2;
    private javax.swing.JButton btnBuscarSede;
    private javax.swing.JButton btnBuscarSede2;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPdf;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblActCabVenta;
    private javax.swing.JTable tblActDetVenta;
    private javax.swing.JTable tblCabVenta;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblDetVenta;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCabCod;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidad2;
    private javax.swing.JTextField txtClieCod;
    private javax.swing.JTextField txtDescMed;
    private javax.swing.JTextField txtDetCod;
    private javax.swing.JTextField txtDetCod1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtEmpleado2;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdMed;
    private javax.swing.JTextField txtIdSede;
    private javax.swing.JTextField txtMed2;
    private javax.swing.JTextField txtNomMed;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPrecioUnit;
    private javax.swing.JTextField txtPrecioUnit2;
    private javax.swing.JTextField txtSede;
    private javax.swing.JTextField txtSede2;
    // End of variables declaration//GEN-END:variables
}
