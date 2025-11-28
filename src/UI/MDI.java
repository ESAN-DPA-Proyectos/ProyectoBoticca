
package UI;

import BEAN.Usuario;

public class MDI extends javax.swing.JFrame {

    // Usuario que inició sesión en el sistema
    private Usuario usuarioActual;

    /**
     * Creates new form MDI
     * Constructor principal que recibe al usuario logueado
     */
    public MDI(Usuario u) {
        initComponents();
        this.setLocationRelativeTo(null);   // centrar ventana
        //this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH); // opcional: abrir maximizado
        
        this.usuarioActual = u;
        actualizarTitulo();

        // Opcional: mostrar el usuario en el título
        if (u != null) {
            this.setTitle("SISTEMA BOTICCA - Usuario: " + u.getNombreCompleto());
        }
    }

    // Constructor sin parámetros (solo para pruebas puntuales)
    public MDI() {
        this(null);
    }
    
    private void actualizarTitulo() {
    if (usuarioActual == null) {
        // Título por defecto si no hay usuario
        setTitle("BDBOTICCA");
        return;
    }

    // Ajusta estos getters a lo que tenga tu BEAN Usuario
    String usuario = usuarioActual.getUsuario();          // ej. "admin"
    String nombre  = usuarioActual.getNombreCompleto();   // ej. "Juan Pérez"

    StringBuilder sb = new StringBuilder("BDBOTICCA - Usuario: ");

    if (usuario != null && !usuario.isEmpty()) {
        sb.append(usuario);
    } else {
        sb.append("?");
    }

    if (nombre != null && !nombre.isEmpty()) {
        sb.append(" (").append(nombre).append(")");
    }

    setTitle(sb.toString());
}


        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMantenimiento = new javax.swing.JMenu();
        sMnuInstitucion = new javax.swing.JMenuItem();
        sMnuProveedor = new javax.swing.JMenuItem();
        sMnuArea = new javax.swing.JMenuItem();
        sMnuCliente = new javax.swing.JMenuItem();
        sMnuEmpleado = new javax.swing.JMenuItem();
        sMnuEmpresa = new javax.swing.JMenuItem();
        sMnuCategoria = new javax.swing.JMenuItem();
        sMnuMed = new javax.swing.JMenuItem();
        sMnuUbigeo = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        sMnuRol = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        sbMnuVentas = new javax.swing.JMenuItem();
        sMnuCompras = new javax.swing.JMenuItem();
        sMnuContrato = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem7.setText("jMenuItem7");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        mnuMantenimiento.setText("MANTENIMIENTO");
        mnuMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantenimientoActionPerformed(evt);
            }
        });

        sMnuInstitucion.setText("Institucion");
        sMnuInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuInstitucionActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuInstitucion);

        sMnuProveedor.setText("Proveedor");
        sMnuProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuProveedorActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuProveedor);

        sMnuArea.setText("Área");
        sMnuArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuAreaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuArea);

        sMnuCliente.setText("Cliente");
        sMnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuClienteActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuCliente);

        sMnuEmpleado.setText("Empleado");
        sMnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuEmpleadoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuEmpleado);

        sMnuEmpresa.setText("Empresa");
        sMnuEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuEmpresaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuEmpresa);

        sMnuCategoria.setText("Categoria");
        sMnuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuCategoriaActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuCategoria);

        sMnuMed.setText("Medicamentos");
        sMnuMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuMedActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuMed);

        sMnuUbigeo.setText("Ubigeo");
        sMnuUbigeo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuUbigeoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuUbigeo);

        jMenuItem6.setText("Sede");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(jMenuItem6);

        sMnuRol.setText("Rol");
        sMnuRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuRolActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(sMnuRol);
        mnuMantenimiento.add(jSeparator2);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(jMenuItem2);
        mnuMantenimiento.add(jSeparator1);

        jMenuBar1.add(mnuMantenimiento);

        jMenu1.setText("TRANSACCIONES");

        sbMnuVentas.setText("Ventas");
        sbMnuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbMnuVentasActionPerformed(evt);
            }
        });
        jMenu1.add(sbMnuVentas);

        sMnuCompras.setText("Compras");
        sMnuCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuComprasActionPerformed(evt);
            }
        });
        jMenu1.add(sMnuCompras);

        sMnuContrato.setText("Contratos");
        sMnuContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sMnuContratoActionPerformed(evt);
            }
        });
        jMenu1.add(sMnuContrato);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantenimientoActionPerformed
        
    }//GEN-LAST:event_mnuMantenimientoActionPerformed

    private void sMnuInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuInstitucionActionPerformed
        FrmInstAcademica frmProd;
        frmProd=new FrmInstAcademica();
        
        this.escritorio.add(frmProd);
        frmProd.setVisible(true);
        
    }//GEN-LAST:event_sMnuInstitucionActionPerformed

    private void sMnuProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuProveedorActionPerformed
        FrmProveedor frmProv;
        frmProv=new FrmProveedor();
        
        this.escritorio.add(frmProv);
        frmProv.setVisible(true);
    }//GEN-LAST:event_sMnuProveedorActionPerformed

    private void sMnuAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuAreaActionPerformed
        FrmArea frmArea;
        frmArea=new FrmArea();
        
        this.escritorio.add(frmArea);
        frmArea.setVisible(true);
    }//GEN-LAST:event_sMnuAreaActionPerformed

    private void sMnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuClienteActionPerformed
        FrmCliente frmClien;
        frmClien=new FrmCliente();
        
        this.escritorio.add(frmClien);
        frmClien.setVisible(true);
    }//GEN-LAST:event_sMnuClienteActionPerformed

    private void sMnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuEmpleadoActionPerformed
        FrmEmpleado frmEmpl;
        frmEmpl=new FrmEmpleado();
        
        this.escritorio.add(frmEmpl);
        frmEmpl.setVisible(true);
    }//GEN-LAST:event_sMnuEmpleadoActionPerformed

    private void sMnuEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuEmpresaActionPerformed
        FrmEmpresa frmEmpr;
        frmEmpr=new FrmEmpresa();
        
        this.escritorio.add(frmEmpr);
        frmEmpr.setVisible(true);
    }//GEN-LAST:event_sMnuEmpresaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void sMnuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuCategoriaActionPerformed
        FrmCategoria frmCat;
        frmCat=new FrmCategoria();
        
        this.escritorio.add(frmCat);
        frmCat.setVisible(true);
    }//GEN-LAST:event_sMnuCategoriaActionPerformed

    private void sMnuMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuMedActionPerformed
        FrmMedicamento frmMed;
        frmMed=new FrmMedicamento();
        
        this.escritorio.add(frmMed);
        frmMed.setVisible(true);
    }//GEN-LAST:event_sMnuMedActionPerformed

    private void sMnuUbigeoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuUbigeoActionPerformed
        FrmUbigeo frmUbi;
        frmUbi=new FrmUbigeo();
        
        this.escritorio.add(frmUbi);
        frmUbi.setVisible(true);
    }//GEN-LAST:event_sMnuUbigeoActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        FrmSede frmSede;
        frmSede=new FrmSede();
        
        this.escritorio.add(frmSede);
        frmSede.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void sbMnuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbMnuVentasActionPerformed
        FrmVentas frmVent = new FrmVentas();
        escritorio.add(frmVent);
        frmVent.setVisible(true);
        try {
            frmVent.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
        
        }
    }//GEN-LAST:event_sbMnuVentasActionPerformed

    private void sMnuComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuComprasActionPerformed
        FrmCompras frmComp;
        frmComp = new FrmCompras();
        frmComp.setVisible(true);
        this.escritorio.add(frmComp);
    }//GEN-LAST:event_sMnuComprasActionPerformed

    private void sMnuRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuRolActionPerformed
        // TODO add your handling code here:
        FrmRol frm = new FrmRol();
        this.escritorio.add(frm);
        frm.setVisible(true);    
    }//GEN-LAST:event_sMnuRolActionPerformed

    private void sMnuContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sMnuContratoActionPerformed
        FrmContrato frmCont;
        frmCont = new FrmContrato();
        frmCont.setVisible(true);
        this.escritorio.add(frmCont);
    }//GEN-LAST:event_sMnuContratoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI().setVisible(true);
            }
        });
    /*}*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenuItem sMnuArea;
    private javax.swing.JMenuItem sMnuCategoria;
    private javax.swing.JMenuItem sMnuCliente;
    private javax.swing.JMenuItem sMnuCompras;
    private javax.swing.JMenuItem sMnuContrato;
    private javax.swing.JMenuItem sMnuEmpleado;
    private javax.swing.JMenuItem sMnuEmpresa;
    private javax.swing.JMenuItem sMnuInstitucion;
    private javax.swing.JMenuItem sMnuMed;
    private javax.swing.JMenuItem sMnuProveedor;
    private javax.swing.JMenuItem sMnuRol;
    private javax.swing.JMenuItem sMnuUbigeo;
    private javax.swing.JMenuItem sbMnuVentas;
    // End of variables declaration//GEN-END:variables
}
