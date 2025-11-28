
package UI;

import BEAN.Cliente;
import BEAN.Empleado;
import BEAN.Medicamento;
import BEAN.Proveedor;
import BEAN.Sede;
import BEAN.cab_compra;
import BEAN.cab_venta;
import BEAN.det_compra;
import BEAN.det_venta;
import DAO.ProveedorDAO;
import DAO.cab_compraDAO;
import DAO.det_compraDAO;
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

public class FrmCompras extends javax.swing.JInternalFrame { //JFrame
    
    DefaultTableModel dtm,dtml,dtml2,dtml3,dtml4,dtml5;
    Vector<det_compra> listaItem;
    cab_compraDAO cabDao;
    det_compraDAO detDao;
    ProveedorDAO provDao;
    Cliente clie;
    cab_venta cab;
    det_venta det;
    public FrmCompras() {
        initComponents();
        clie=new Cliente();
        cab=new cab_venta();
        det=new det_venta();
        cabDao=new cab_compraDAO();
        detDao=new det_compraDAO();
        provDao=new ProveedorDAO();
        this.jTabbedPane1.setSelectedIndex(1);
        dtm = (DefaultTableModel)this.tblProveedor.getModel();
        dtml = (DefaultTableModel)this.tblCabCompra.getModel();
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        dtml3 = (DefaultTableModel)this.tblDetCompra.getModel();
        dtml4 = (DefaultTableModel)this.tblActCabVenta.getModel();
        dtml5 = (DefaultTableModel)this.tblActDetVenta.getModel();
        llenaTblProveedor("");
        llenaTblCabCompra(false,"");
        llenaTblDetCompra(false,"");
        llenaTblActCabCompra(false,"");
        llenaTblActDetCompra(false,"");
        llenaCmbEstado();
    }
    
    private void llenaTblProveedor(String cad){
        Vector<Proveedor> listaProveedor;
        listaProveedor=provDao.listarProveedores(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaProveedor.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaProveedor.get(i).getId_proveedor());
            vec.addElement(listaProveedor.get(i).getNombre());
            vec.addElement(listaProveedor.get(i).getNombreContacto());
            vec.addElement(listaProveedor.get(i).getDireccion());
            vec.addElement(listaProveedor.get(i).getCiudad());
            vec.addElement(listaProveedor.get(i).getTelefono());
            vec.addElement(listaProveedor.get(i).getEstado());
            dtm.addRow(vec);
        }
        
    }
    
    private void llenaTblCabCompra(boolean sw,String cad){
        Vector<cab_compra> listaItem;
        listaItem=cabDao.listaItem(sw,cad);
        dtml.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_compra());
            vec.addElement(listaItem.get(i).getProveedor());
            vec.addElement(listaItem.get(i).getEmpleado());
            vec.addElement(listaItem.get(i).getFecha());
            vec.addElement(listaItem.get(i).getEstado());
            dtml.addRow(vec);
        }
        
        this.jTabbedPane1.setSelectedIndex(0);
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        
    }
    
    private void llenaTblDetCompra(boolean sw,String cad){
        
        listaItem=detDao.listaItem(sw,cad);
        dtml3.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_compra());
            vec.addElement(listaItem.get(i).getMedicamento());
            vec.addElement(listaItem.get(i).getCantidad());
            vec.addElement(listaItem.get(i).getPreciounit());
            vec.addElement(listaItem.get(i).getPreciototal());
            dtml3.addRow(vec);
        }
        
    }
    
    private void llenaTblActCabCompra(boolean sw,String cad){
        Vector<cab_compra> listaItem;
        listaItem=cabDao.listaItem(sw,cad);
        dtml4.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_compra());
            vec.addElement(listaItem.get(i).getProveedor());
            vec.addElement(listaItem.get(i).getFecha());
            vec.addElement(listaItem.get(i).getEmpleado());
            vec.addElement(listaItem.get(i).getEstado());
            dtml4.addRow(vec);
        }
        
        this.jTabbedPane1.setSelectedIndex(0);
        dtml2 = (DefaultTableModel)this.tblProducto.getModel();
        
    }
    
    private void llenaTblActDetCompra(boolean sw,String cad){
        Vector<det_compra> listaItem;
        listaItem=detDao.listaItem(sw,cad);
        dtml5.setRowCount(0);
        for(int i=0; i<listaItem.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaItem.get(i).getId_compra());
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
        tblProveedor = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCabCompra = new javax.swing.JTable();
        btnBorrarVenta = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetCompra = new javax.swing.JTable();
        btnBorrarDetalle = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
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
        btnBuscarEmpleado = new javax.swing.JButton();
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
        txtProv2 = new javax.swing.JTextField();
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
        txtProvCod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        txtIdProv = new javax.swing.JTextField();
        txtIdEmpleado = new javax.swing.JTextField();
        txtCabCod = new javax.swing.JTextField();
        txtDetCod = new javax.swing.JTextField();
        txtDetCod1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO DE COMPRAS");

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Buscar proveedor");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id proveedor", "Proveedor", "Contacto", "Direccion", "Ciudad", "Tlf", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras al proveedor"));

        tblCabCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id compra", "Proveedor", "Empleado", "Fecha", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCabCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCabCompraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCabCompra);

        btnBorrarVenta.setText("Borrar compra");
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de compras al proveedor"));

        tblDetCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Compra", "Medicamento", "Cantidad", "Precio unit", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetCompraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDetCompra);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jTabbedPane1.addTab("Buscar Compras", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del proveedor"));

        jLabel3.setText("Id Proveedor");

        txtIdProveedor.setEnabled(false);

        jLabel4.setText("Proveedor");

        txtProveedor.setEnabled(false);

        jLabel5.setText("Contacto");

        txtContacto.setEnabled(false);

        btnBuscarClie.setText("Buscar Proveedor");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnBuscarClie))
                    .addComponent(txtProveedor)
                    .addComponent(txtContacto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarClie))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnBuscarEmpleado.setText("Buscar Empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBuscarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(12, 12, 12)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado)
                    .addComponent(btnAgregar))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Compras", jPanel4);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));

        tblActCabVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id compra", "Proveedor", "Fecha", "Empleado", "Estado"
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

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de compras"));

        tblActDetVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Compra", "Medicamento", "Cantidad", "Precio unit", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnBuscarSede2.setText("Buscar Proveedor");
        btnBuscarSede2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSede2ActionPerformed(evt);
            }
        });

        txtProv2.setEnabled(false);

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
                            .addComponent(txtProv2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(txtProv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtProvCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCabCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDetCod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDetCod1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProvCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int idx;
        idx=this.tblProveedor.getSelectedRow();
        clie.setId_cliente(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        this.txtProvCod.setText(String.valueOf(clie.getId_cliente()));

        if(this.txtProvCod.getText().isEmpty()){
            llenaTblCabCompra(true,"");
        }else{

            llenaTblCabCompra(true,this.txtProvCod.getText());
        }
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblProveedor("");
        }else{
            llenaTblProveedor(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarClieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClieActionPerformed
        Proveedor prov;
        SelProveedor dialog=new SelProveedor(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        prov=dialog.getProveedor(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdProveedor.setText(String.valueOf(prov.getId_proveedor()));
        this.txtProveedor.setText(prov.getNombre());
        this.txtContacto.setText(prov.getNombreContacto());
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
        llenaTblActCabCompra(false,"");
        llenaTblActDetCompra(false,"");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        Util u = new Util();
        int idComp;
        int idDetComp;
        DbBean con = new DbBean();
        String fech;
        if (this.btnGrabar.getText().equals("Grabar")) {
            if (this.txtIdProveedor.getText().isEmpty() || dtml2.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un proveedor y por lo menos un producto");
            } else {
                // 1. Insertar CABECERA de la compra
                fech = u.obtenerFecha();
                // Genero UN SOLO ID para la compra
                idComp = u.idNext("Compras", "CompraID");   // tabla, campo llave

                cab_compra cc = new cab_compra();
                cc.setId_compra(idComp);
                cc.setId_proveedor(Integer.parseInt(this.txtIdProveedor.getText()));
                cc.setId_empleado(Integer.parseInt(this.txtIdEmpleado.getText()));
                cc.setFecha(fech);
                cc.setEstado(1);
                this.cabDao.procesaItem(cc, "insert");

                // 2. Insertar DETALLES de la compra
                for (int i = 0; i < dtml2.getRowCount(); i++) {
                    det_compra dc = new det_compra();
                    dc.setId_compra(idComp); // mismo ID de la cabecera
                    dc.setId_medicamento(Integer.parseInt(
                            dtml2.getValueAt(i, 0).toString()));
                    dc.setCantidad(Integer.parseInt(
                            dtml2.getValueAt(i, 3).toString()));
                    dc.setPreciounit(Float.parseFloat(
                            dtml2.getValueAt(i, 4).toString()));
                    this.detDao.procesaItem(dc, "insert");
                }

                limpiaCabecera();
                limpiaDetalle();
                JOptionPane.showMessageDialog(this,
                        "Compra registrada satisfactoriamente");
                // Refrescar las tablas de la pestaña "Buscar Compras"
                llenaTblCabCompra(false, "");
                llenaTblDetCompra(false, "");
            }

        }else if(this.btnGrabar.getText().equals("Actualizar cabecera")){
            if(this.txtProv2.getText().isEmpty() || this.txtEmpleado2.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un proveedor y empleado");
            }else{
                // Actualizando la cabecera: cab_compra
                //idVent=u.idNext("ventas", "ventaid"); //tabla,campo llave
                fech=u.obtenerFecha();
                cab_compra cc= new cab_compra();
                //cv.setId_venta(idVent);
                cc.setId_compra(Integer.parseInt(this.txtCabCod.getText()));
                cc.setId_empleado(Integer.parseInt(this.txtIdEmpleado.getText()));
                cc.setFecha(fech);
                cc.setId_proveedor(Integer.parseInt(this.txtIdProv.getText()));
                if(this.cmbEstado.getSelectedItem().toString().equals("Activo")){
                    cc.setEstado(1);
                    }else{
                    cc.setEstado(0);
                }
                this.cabDao.procesaItem(cc,"update");
                llenaTblActCabCompra(false,"");
                this.jTabbedPane1.setSelectedIndex(2);
                JOptionPane.showMessageDialog(this, "Compra actualizada satisfactoriamente");
            }
        }else{
            if(this.txtMed2.getText().isEmpty() || this.txtPrecioUnit2.getText().isEmpty() || this.txtCantidad2.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe seleccionar un medicamento y elegir la cantidad");
            }else{
                det_compra dc=new det_compra();
                dc.setId_compra(Integer.parseInt(this.txtDetCod.getText()));
                dc.setId_medicamento(Integer.parseInt(this.txtIdMed.getText()));
                dc.setCantidad(Integer.parseInt(this.txtCantidad2.getText()));
                dc.setPreciounit(Float.parseFloat(this.txtPrecioUnit2.getText()));
                this.detDao.procesaItem(dc, "update");
                llenaTblActDetCompra(false,"");
                this.jTabbedPane1.setSelectedIndex(2);
                JOptionPane.showMessageDialog(this, "Detalle actualizado satisfactoriamente");
            }
        }
        dtml2.setRowCount(0);
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(this.txtIdMed.getText().isEmpty() || this.txtCantidad.getText().isEmpty()
                || this.txtIdProveedor.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un medicamento, cantidad y proveedor");
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

    private void tblCabCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCabCompraMouseClicked
        int idx;
        idx=this.tblCabCompra.getSelectedRow();
        cab.setId_venta(Integer.parseInt(dtml.getValueAt(idx, 0).toString()));
        this.txtCabCod.setText(String.valueOf(cab.getId_venta()));

        if(this.txtCabCod.getText().isEmpty()){
            llenaTblDetCompra(true,"");
        }else{

            llenaTblDetCompra(true,this.txtCabCod.getText());
        }
    }//GEN-LAST:event_tblCabCompraMouseClicked

    private void btnBorrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVentaActionPerformed
        // 1. Validar que exista código de cabecera
        if (txtCabCod.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No hay una compra seleccionada.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Confirmar con el usuario
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar la compra y todos sus detalles?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return;    // el usuario canceló
        }

        // 3. Si confirmó, eliminamos detalle y cabecera
        int idVe = Integer.parseInt(txtCabCod.getText());

        this.detDao.borraDeta(idVe);        // elimina todos los detalles (SP vía DAO)
        int r = this.cabDao.borraCab(idVe); // elimina la cabecera (SP vía DAO)

        // 4. Evaluamos resultado y limpiamos pantalla
        if (r > 0) {
            JOptionPane.showMessageDialog(this,
                    "Compra eliminada correctamente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            // Limpia y recarga la pestaña "Buscar Compras"
            limpiaPrimeraHoja();

            // NUEVO: recargar también las tablas de la pestaña "Actualizar"
            llenaTblActCabCompra(false, "");
            llenaTblActDetCompra(false, "");

        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar la compra.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarVentaActionPerformed

    private void btnBorrarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDetalleActionPerformed
        // 1. Validar que exista una compra seleccionada
        if (txtCabCod.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar primero una compra.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Validar que haya un detalle seleccionado en la tabla
        int fila = tblDetCompra.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un detalle de la tabla.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Confirmar con el usuario
        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar el detalle seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (opcion != JOptionPane.YES_OPTION) {
            return; // el usuario canceló
        }

        // 4. Obtener datos de la fila seleccionada
        int idCompra = Integer.parseInt(tblDetCompra.getValueAt(fila, 0).toString());
        String nomMed = tblDetCompra.getValueAt(fila, 1).toString();
        int cant = Integer.parseInt(tblDetCompra.getValueAt(fila, 2).toString());
        float precioUnit = Float.parseFloat(tblDetCompra.getValueAt(fila, 3).toString());

        // 5. Pedir al DAO todos los detalles de esa compra
        Vector<det_compra> detalles = detDao.listaItem(true, String.valueOf(idCompra));

        Integer idMedicamento = null;
        for (det_compra dc : detalles) {
            // Comparamos por nombre, cantidad y precio unitario
            if (dc.getMedicamento().equals(nomMed)
                    && dc.getCantidad() == cant
                    && Float.compare(dc.getPreciounit(), precioUnit) == 0) {
                idMedicamento = dc.getId_medicamento();
                break;
            }
        }

        if (idMedicamento == null) {
            JOptionPane.showMessageDialog(this,
                    "No se pudo determinar el código del medicamento para el detalle seleccionado.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 6. Eliminar SOLO ese detalle usando el DAO (SP DetalleCompra_EliminarUnit)
        int r = detDao.eliminarUnit(idCompra, idMedicamento);

        // 7. Evaluar resultado y recargar la tabla
        if (r > 0) {
            JOptionPane.showMessageDialog(this,
                    "Detalle eliminado correctamente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            // Volvemos a cargar los detalles de la compra actual
            llenaTblDetCompra(true, String.valueOf(idCompra));
        } else {
            JOptionPane.showMessageDialog(this,
                    "No se pudo eliminar el detalle.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarDetalleActionPerformed

    private void tblDetCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetCompraMouseClicked
        int idx;
        idx=this.tblDetCompra.getSelectedRow();
        det.setId_detventa(Integer.parseInt(dtml3.getValueAt(idx, 0).toString()));
        this.txtDetCod.setText(String.valueOf(det.getId_detventa()));
        
    }//GEN-LAST:event_tblDetCompraMouseClicked

    private void tblActCabVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActCabVentaMouseClicked
        // 1. Obtener la fila seleccionada de la tabla de cabeceras
        int idx = this.tblActCabVenta.getSelectedRow();
        if (idx == -1) {
            return;
        }

        // Columnas en dtml4:
        // 0 = Id compra, 1 = Proveedor, 2 = Fecha, 3 = Empleado, 4 = Estado
        this.txtCabCod.setText(dtml4.getValueAt(idx, 0).toString());
        this.txtProv2.setText(dtml4.getValueAt(idx, 1).toString());
        this.txtEmpleado2.setText(dtml4.getValueAt(idx, 3).toString());

        if (dtml4.getValueAt(idx, 4).toString().equals("1")) {
            this.cmbEstado.setSelectedItem("Activo");
        } else {
            this.cmbEstado.setSelectedItem("No activo");
        }

        // 2. Obtener datos completos de la cabecera desde el DAO (sin SQL directo)
        int idCompra = Integer.parseInt(this.txtCabCod.getText());
        cab_compra cc = cabDao.obtenerPorId(idCompra);

        if (cc != null) {
            this.txtIdProv.setText(String.valueOf(cc.getId_proveedor()));
            this.txtIdEmpleado.setText(String.valueOf(cc.getId_empleado()));
        } else {
            this.txtIdProv.setText("");
            this.txtIdEmpleado.setText("");
            JOptionPane.showMessageDialog(this,
                    "No se encontró la cabecera de la compra seleccionada.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        // 3. NUEVO: filtrar el detalle de la compra seleccionada
        //    para la tabla tblActDetVenta
        llenaTblActDetCompra(true, this.txtCabCod.getText());

        // 4. Poner el botón Grabar en modo "Actualizar cabecera"
        this.btnGrabar.setText("Actualizar cabecera");
    }//GEN-LAST:event_tblActCabVentaMouseClicked

    private void tblActDetVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActDetVentaMouseClicked
        // 1. Obtener la fila seleccionada
        int idx = this.tblActDetVenta.getSelectedRow();
        if (idx == -1) {
            return;
        }

        // 2. Llenar los campos visibles desde la tabla
        this.txtDetCod.setText(dtml5.getValueAt(idx, 0).toString());   // Id compra
        this.txtCabCod.setText(dtml5.getValueAt(idx, 0).toString());   // Id compra
        this.txtMed2.setText(dtml5.getValueAt(idx, 1).toString());     // Nombre medicamento
        this.txtCantidad2.setText(dtml5.getValueAt(idx, 2).toString()); // Cantidad
        this.txtPrecioUnit2.setText(dtml5.getValueAt(idx, 3).toString()); // Precio unitario

        // 3. Usar el DAO para recuperar el id_medicamento (sin SQL directo en la UI)
        int idCompra = Integer.parseInt(this.txtDetCod.getText());
        String nomMed = this.txtMed2.getText();
        int cant = Integer.parseInt(this.txtCantidad2.getText());

        // Lista de detalles de esa compra
        Vector<det_compra> detalles = detDao.listaItem(true, String.valueOf(idCompra));

        Integer idMed = null;
        for (det_compra dc : detalles) {
            // Comparamos por nombre de medicamento y cantidad
            if (dc.getMedicamento().equals(nomMed) && dc.getCantidad() == cant) {
                idMed = dc.getId_medicamento();
                break;
            }
        }

        if (idMed != null) {
            this.txtIdMed.setText(String.valueOf(idMed));
        } else {
            this.txtIdMed.setText("");
            JOptionPane.showMessageDialog(this,
                    "No se pudo determinar el código del medicamento para el detalle seleccionado.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        // 4. Cambiar el modo del botón Grabar
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
        Proveedor prov;
        SelProveedor dialog=new SelProveedor(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        prov=dialog.getProveedor(); //recibe la información del cliente al que se le hizoc clic
        
        this.txtIdProv.setText(String.valueOf(prov.getId_proveedor()));
        this.txtProv2.setText(prov.getNombre());
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
            ByteArrayOutputStream outputStream = PdfGenerator.generarPDFDinamico(listaObjetos, "Reporte de Compras");
            MailSender.sendEmail(txtEmail.getText(), "PDF COMPRAS", mensaje, "REPORTE DE COMPRAS", outputStream);
            JOptionPane.showMessageDialog(this, "Se envio el pdf al correo: " + txtEmail.getText() + " correctamente");
            limpiaCabecera();
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        Empleado empl;
        SelEmpleado dialog=new SelEmpleado(new javax.swing.JFrame(),true);
        dialog.setVisible(true);
        empl=dialog.getEmpleado(); //recibe la información del cliente al que se le hizoc clic

        this.txtIdEmpleado.setText(String.valueOf(empl.getId_empleado()));
        this.txtEmpleado.setText(empl.getApellido());
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoActionPerformed

    private void limpiaDetalle(){
        this.txtIdMed.setText("");
        this.txtNomMed.setText("");
        this.txtDescMed.setText("");
        this.txtPrecioUnit.setText("");
        this.txtCantidad.setText("");
        this.txtIdEmpleado.setText("");
        this.txtIdProv.setText("");
        
    } 
    
    private void limpiaAgregar(){
        this.txtIdMed.setText("");
        this.txtNomMed.setText("");
        this.txtDescMed.setText("");
        this.txtPrecioUnit.setText("");
        this.txtCantidad.setText("");
        
    } 
    
    private void limpiaCabecera(){
        this.txtIdProveedor.setText("");
        this.txtProveedor.setText("");
        this.txtContacto.setText("");
    }
    
    private void limpiaPrimeraHoja(){
        this.txtProvCod.setText("");
        llenaTblCabCompra(false,"");
        this.txtCabCod.setText("");
        llenaTblDetCompra(false,"");
    }
  
    /*
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCompras().setVisible(true);
            }
        });
    }
    */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarDetalle;
    private javax.swing.JButton btnBorrarVenta;
    private javax.swing.JButton btnBuscarClie;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarEmpleado2;
    private javax.swing.JButton btnBuscarMed;
    private javax.swing.JButton btnBuscarMed2;
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
    private javax.swing.JTable tblCabCompra;
    private javax.swing.JTable tblDetCompra;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCabCod;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidad2;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtDescMed;
    private javax.swing.JTextField txtDetCod;
    private javax.swing.JTextField txtDetCod1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtEmpleado2;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdMed;
    private javax.swing.JTextField txtIdProv;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtMed2;
    private javax.swing.JTextField txtNomMed;
    private javax.swing.JTextField txtPrecioUnit;
    private javax.swing.JTextField txtPrecioUnit2;
    private javax.swing.JTextField txtProv2;
    private javax.swing.JTextField txtProvCod;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables
}
