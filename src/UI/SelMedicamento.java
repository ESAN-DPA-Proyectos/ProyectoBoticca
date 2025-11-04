
package UI;

import BEAN.Medicamento;
import DAO.MedicamentoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelMedicamento extends javax.swing.JDialog {
    MedicamentoDAO medDao;
    DefaultTableModel dtm;
    Medicamento med;

    public SelMedicamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        med=new Medicamento();
        medDao=new MedicamentoDAO();
        dtm=(DefaultTableModel)this.tblSelMed.getModel();
        llenaTblSelMed("");
    }
    
    private void llenaTblSelMed(String cad){
        Vector<Medicamento> listaMed;
        listaMed=medDao.listaMedicamentos(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaMed.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaMed.get(i).getId_medicamento());
            vec.addElement(listaMed.get(i).getNombre());
            vec.addElement(listaMed.get(i).getDescripcion());
            vec.addElement(listaMed.get(i).getPrecio());
            vec.addElement(listaMed.get(i).getStock());
            vec.addElement(listaMed.get(i).getFecha_vencimiento());
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
        tblSelMed = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR MEDICAMENTO");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelMed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Medicamento", "Nombre", "Descripcion", "Precio", "Stock", "Fecha Vencimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelMed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelMedMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelMed);

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
                        .addGap(250, 250, 250)
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
            llenaTblSelMed("");
        }else{
            llenaTblSelMed(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelMedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelMedMouseClicked
        int idx;
        idx=this.tblSelMed.getSelectedRow();
        med.setId_medicamento(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        med.setNombre(dtm.getValueAt(idx, 1).toString());
        med.setDescripcion(dtm.getValueAt(idx, 2).toString());
        med.setPrecio(Float.parseFloat(dtm.getValueAt(idx, 3).toString()));
        med.setStock(Integer.parseInt(dtm.getValueAt(idx, 4).toString()));
        med.setFecha_vencimiento(dtm.getValueAt(idx, 5).toString());
        this.dispose();
    }//GEN-LAST:event_tblSelMedMouseClicked

    public Medicamento getMedicamento(){
        return med;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelMedicamento dialog = new SelMedicamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelMed;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
