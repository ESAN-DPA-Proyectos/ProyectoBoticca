
package UI;

import BEAN.Empleado;
import DAO.EmpleadoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelEmpleado extends javax.swing.JDialog {
    EmpleadoDAO emplDao;
    DefaultTableModel dtm;
    Empleado empl;

    public SelEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        empl=new Empleado();
        emplDao=new EmpleadoDAO();
        dtm=(DefaultTableModel)this.tblSelEmpl.getModel();
        llenaTblSelEmpl("");
    }
    
    private void llenaTblSelEmpl(String cad){
        Vector<Empleado> listaEmpl;
        listaEmpl=emplDao.listaEmpleados(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaEmpl.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaEmpl.get(i).getId_empleado());
            vec.addElement(listaEmpl.get(i).getNombre());
            vec.addElement(listaEmpl.get(i).getApellido());
            vec.addElement(listaEmpl.get(i).getCargo());
            vec.addElement(listaEmpl.get(i).getTelefono());
            vec.addElement(listaEmpl.get(i).getEstado());
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
        tblSelEmpl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR EMPLEADO");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelEmpl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Empleado", "Nombre", "Apellido", "Cargo", "Telefono", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelEmpl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelEmplMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelEmpl);

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
                        .addGap(271, 271, 271)
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
            llenaTblSelEmpl("");
        }else{
            llenaTblSelEmpl(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelEmplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelEmplMouseClicked
        int idx;
        idx=this.tblSelEmpl.getSelectedRow();
        empl.setId_empleado(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        empl.setNombre(dtm.getValueAt(idx, 1).toString());
        empl.setApellido(dtm.getValueAt(idx, 2).toString());
        empl.setCargo(dtm.getValueAt(idx, 3).toString());
        empl.setTelefono(dtm.getValueAt(idx, 4).toString());
        empl.setEstado(Integer.parseInt(dtm.getValueAt(idx, 5).toString()));
        this.dispose();
    }//GEN-LAST:event_tblSelEmplMouseClicked

    public Empleado getEmpleado(){
        return empl;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelEmpleado dialog = new SelEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelEmpl;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
