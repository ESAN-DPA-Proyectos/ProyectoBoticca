
package UI;


import BEAN.Rol;
import DAO.RolDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelRol extends javax.swing.JDialog {
    RolDAO rolDao;
    DefaultTableModel dtm;
    Rol rol;

    public SelRol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        rol=new Rol();
        rolDao=new RolDAO();
        dtm=(DefaultTableModel)this.tblSelRol.getModel();
        llenaTblSelRol("");
    }
    
    private void llenaTblSelRol(String cad){
        Vector<Rol> listaRol;
        listaRol=rolDao.listaRol(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaRol.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaRol.get(i).getId_rol());
            vec.addElement(listaRol.get(i).getDescripcion());
            vec.addElement(listaRol.get(i).getRequisito());
            vec.addElement(listaRol.get(i).getAniosexp());
            vec.addElement(listaRol.get(i).getSueldo());
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
        tblSelRol = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR ROL");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Rol", "Descripcion", "Requisito", "Años de exp", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelRol);

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
                        .addGap(292, 292, 292)
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
            llenaTblSelRol("");
        }else{
            llenaTblSelRol(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelRolMouseClicked
        int idx;
        idx=this.tblSelRol.getSelectedRow();
        rol.setId_rol(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        rol.setDescripcion(dtm.getValueAt(idx, 1).toString());
        rol.setRequisito(dtm.getValueAt(idx, 2).toString());
        rol.setAniosexp(Integer.parseInt(dtm.getValueAt(idx, 3).toString()));
        rol.setSueldo(Float.parseFloat(dtm.getValueAt(idx, 4).toString()));
        this.dispose();
    }//GEN-LAST:event_tblSelRolMouseClicked

    public Rol getRol(){
        return rol;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelRol dialog = new SelRol(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelRol;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
