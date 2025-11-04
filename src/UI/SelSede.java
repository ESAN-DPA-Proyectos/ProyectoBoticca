
package UI;


import BEAN.Sede;
import DAO.SedeDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelSede extends javax.swing.JDialog {
    SedeDAO sedeDao;
    DefaultTableModel dtm;
    Sede sede;

    public SelSede(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sede=new Sede();
        sedeDao=new SedeDAO();
        dtm=(DefaultTableModel)this.tblSelSede.getModel();
        llenaTblSelSede("");
    }
    
    private void llenaTblSelSede(String cad){
        Vector<Sede> listaEmpl;
        listaEmpl=sedeDao.listaSede(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaEmpl.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaEmpl.get(i).getId_sede());
            vec.addElement(listaEmpl.get(i).getNombre());
            vec.addElement(listaEmpl.get(i).getDireccion());
            vec.addElement(listaEmpl.get(i).getTelefono());
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
        tblSelSede = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR SEDE");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelSede.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Sede", "Nombre", "Direccoin", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelSedeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelSede);

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
            llenaTblSelSede("");
        }else{
            llenaTblSelSede(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelSedeMouseClicked
        int idx;
        idx=this.tblSelSede.getSelectedRow();
        sede.setId_sede(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        sede.setNombre(dtm.getValueAt(idx, 1).toString());
        sede.setDireccion(dtm.getValueAt(idx, 2).toString());
        sede.setTelefono(dtm.getValueAt(idx, 3).toString());
        this.dispose();
    }//GEN-LAST:event_tblSelSedeMouseClicked

    public Sede getSede(){
        return sede;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelSede dialog = new SelSede(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelSede;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
