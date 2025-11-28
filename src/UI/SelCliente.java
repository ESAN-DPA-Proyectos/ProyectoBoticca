
package UI;
import BEAN.Cliente;
import DAO.ClienteDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelCliente extends javax.swing.JDialog {
    ClienteDAO clieDao;
    DefaultTableModel dtm;
    Cliente clie;

    public SelCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clie=new Cliente();
        clieDao=new ClienteDAO();
        dtm=(DefaultTableModel)this.tblSelClie.getModel();
        llenaTblSelClien("");
    }
    
    private void llenaTblSelClien(String cad){
        Vector<Cliente> listaClien;
        listaClien=clieDao.listaClientes(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaClien.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaClien.get(i).getId_cliente());
            vec.addElement(listaClien.get(i).getNombre());
            vec.addElement(listaClien.get(i).getApellido());
            vec.addElement(listaClien.get(i).getDireccion());
            vec.addElement(listaClien.get(i).getTelefono());
            vec.addElement(listaClien.get(i).getDni());
            //vec.addElement(listaClien.get(i).getGenero());
            //vec.addElement(listaClien.get(i).getEstcivil());
            vec.addElement(listaClien.get(i).getEstado());
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
        tblSelClie = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR CLIENTE");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelClie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Nombre", "Apellido", "Direccion", "Telefono", "DNI", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelClie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelClieMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelClie);

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
            llenaTblSelClien("");
        }else{
            llenaTblSelClien(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelClieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelClieMouseClicked
        int idx;
        idx=this.tblSelClie.getSelectedRow();
        clie.setId_cliente(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        clie.setNombre(dtm.getValueAt(idx, 1).toString());
        clie.setApellido(dtm.getValueAt(idx, 2).toString());
        clie.setDireccion(dtm.getValueAt(idx, 3).toString());
        clie.setTelefono(dtm.getValueAt(idx, 4).toString());
        clie.setDni(dtm.getValueAt(idx, 5).toString());
        //clie.setGenero(Integer.parseInt(dtm.getValueAt(idx, 6).toString()));
        //clie.setEstcivil(Integer.parseInt(dtm.getValueAt(idx, 7).toString()));
        clie.setEstado(Integer.parseInt(dtm.getValueAt(idx, 6).toString()));
        this.dispose();
    }//GEN-LAST:event_tblSelClieMouseClicked

    public Cliente getCliente(){
        return clie;
    }

    /*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelCliente dialog = new SelCliente(new javax.swing.JFrame(), true);
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
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSelClie;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
