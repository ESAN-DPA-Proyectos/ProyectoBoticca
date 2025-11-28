
package UI;


import BEAN.Ubigeo;
import DAO.UbigeoDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelUbigeo extends javax.swing.JDialog {
    UbigeoDAO ubiDao;
    DefaultTableModel dtm;
    Ubigeo ubi;
    
    public SelUbigeo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ubi=new Ubigeo();
        ubiDao=new UbigeoDAO();
        dtm=(DefaultTableModel)this.tblSelUbigeo.getModel();
        llenaTblSelUbigeo("");
    }
    
    private void llenaTblSelUbigeo(String cad){
        Vector<Ubigeo> listUbigeo;
        listUbigeo=ubiDao.listarUbigeo(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listUbigeo.size();i++){
            Vector vec=new Vector();
            vec.addElement(listUbigeo.get(i).getId_ubigeo());
            vec.addElement(listUbigeo.get(i).getRegion());
            vec.addElement(listUbigeo.get(i).getDepartamento());
            vec.addElement(listUbigeo.get(i).getProvincia());
            vec.addElement(listUbigeo.get(i).getDistrito());
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
        tblSelUbigeo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR UBIGEO");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelUbigeo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Ubigeo", "Region", "Departamento", "Provincia", "Distrito"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelUbigeo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelUbigeoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelUbigeo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if(this.txtBuscar.getText().isEmpty()){
            llenaTblSelUbigeo("");
        }else{
            llenaTblSelUbigeo(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelUbigeoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelUbigeoMouseClicked
        int idx;
        idx=this.tblSelUbigeo.getSelectedRow();
        ubi.setId_ubigeo(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        ubi.setRegion(dtm.getValueAt(idx, 1).toString());
        ubi.setDepartamento(dtm.getValueAt(idx, 2).toString());
        ubi.setProvincia(dtm.getValueAt(idx, 3).toString());
        ubi.setDistrito(dtm.getValueAt(idx, 4).toString());
        this.dispose();
    }//GEN-LAST:event_tblSelUbigeoMouseClicked
    
    public Ubigeo getUbigeo(){ //con esto se puede llamar a los valores que retorna la tabla
        return ubi;
    }

    /*
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelUbigeo dialog = new SelUbigeo(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelUbigeo;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
