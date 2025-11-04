
package UI;



import BEAN.Area;
import DAO.AreaDAO;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class SelArea extends javax.swing.JDialog {
    AreaDAO areaDao;
    DefaultTableModel dtm;
    Area area;

    public SelArea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        area=new Area();
        areaDao=new AreaDAO();
        dtm=(DefaultTableModel)this.tblSelArea.getModel();
        llenaTblSelArea("");
    }
    
    private void llenaTblSelArea(String cad){
        Vector<Area> listaArea;
        listaArea=areaDao.listaArea(cad);
        dtm.setRowCount(0);
        for(int i=0; i<listaArea.size();i++){
            Vector vec=new Vector();
            vec.addElement(listaArea.get(i).getId_area());
            vec.addElement(listaArea.get(i).getDescripcion());
            vec.addElement(listaArea.get(i).getSubArea());
            vec.addElement(listaArea.get(i).getCentCosto());
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
        tblSelArea = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SELECCIONAR AREA");

        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblSelArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Area", "Descripcion", "Sub area", "Cen Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSelArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSelAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSelArea);

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
            llenaTblSelArea("");
        }else{
            llenaTblSelArea(this.txtBuscar.getText());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblSelAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSelAreaMouseClicked
        int idx;
        idx=this.tblSelArea.getSelectedRow();
        area.setId_area(Integer.parseInt(dtm.getValueAt(idx, 0).toString()));
        area.setDescripcion(dtm.getValueAt(idx, 1).toString());
        area.setSubArea(dtm.getValueAt(idx, 2).toString());
        area.setCentCosto(Integer.parseInt(dtm.getValueAt(idx, 3).toString()));
        this.dispose();
    }//GEN-LAST:event_tblSelAreaMouseClicked

    public Area getArea(){
        return area;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelArea dialog = new SelArea(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblSelArea;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
