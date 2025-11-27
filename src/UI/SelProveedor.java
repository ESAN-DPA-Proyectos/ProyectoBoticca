
package UI;
import BEAN.Proveedor;
import DAO.ProveedorDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelProveedor extends javax.swing.JDialog {
    ProveedorDAO provDao;
    DefaultTableModel dtm;
    Proveedor prov;

    public SelProveedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prov=new Proveedor();
        provDao=new ProveedorDAO();
        dtm=(DefaultTableModel)this.tblSelProv.getModel();
        llenaTblSelProv("");
    }
    
    private void llenaTblSelProv(String cad){
        Vector<Proveedor> listProveedores;
        listProveedores=provDao.listarProveedores(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listProveedores.size();i++){
            Vector vec=new Vector();
            vec.addElement(listProveedores.get(i).getId_proveedor());
            vec.addElement(listProveedores.get(i).getNombre());
            vec.addElement(listProveedores.get(i).getNombreContacto());
            vec.addElement(listProveedores.get(i).getDireccion());
            vec.addElement(listProveedores.get(i).getCiudad());
            vec.addElement(listProveedores.get(i).getTelefono());
            vec.addElement(listProveedores.get(i).getEstado());
            dtm.addRow(vec);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSelProv = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR PROVEEDOR");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Proveedor", "Nombre", "Contacto", "Direccion", "Ciudad", "Telefono", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelProvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelProv);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(txtBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblSelProv("");
        }else{
            llenaTblSelProv(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelProvMouseClicked
        int idx;
        idx=this.tblSelProv.getSelectedRow();
        prov.setId_proveedor(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        prov.setNombre(dtm.getValueAt(idx, 1).toString());
        prov.setNombreContacto(dtm.getValueAt(idx, 2).toString());
        prov.setDireccion(dtm.getValueAt(idx, 3).toString());
        prov.setCiudad(dtm.getValueAt(idx, 4).toString());
        prov.setTelefono(dtm.getValueAt(idx, 5).toString());
        prov.setEstado(Integer.parseInt(dtm.getValueAt(idx, 6).toString()));
        this.dispose();
    }//GEN-LAST:event_tblSelProvMouseClicked

    public Proveedor getProveedor(){
        return prov;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelProveedor dialog = new SelProveedor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSelProv;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
