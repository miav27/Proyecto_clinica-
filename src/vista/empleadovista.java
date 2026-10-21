package vista;

import Controladores.ControladorEmpleado;
import Entidades.Empleado;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class empleadovista extends javax.swing.JFrame {
    
    private Controladores.ControladorEmpleado obj = new  ControladorEmpleado();
    private Empleado emp;
    private DefaultTableModel model;

    public empleadovista() {
        initComponents();
        model = (DefaultTableModel) tblempleado.getModel();
        
        // REQUISITO: Cargar empleados al abrir
        listarEmpleados(); 
        
        // REQUISITO EXTRA: Añadir listener a la tabla para cargar datos al hacer clic
        /*tblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadoMouseClicked(evt);
            }
        });*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btninsertar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblempleado = new javax.swing.JTable();

        setTitle("MANTENIMIENTO DE EMPLEADO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Email");

        jLabel5.setText("Usuario");

        jLabel6.setText("Password");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imagen1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(txtApellido)
                            .addComponent(txtEmail)
                            .addComponent(txtUsuario))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        btninsertar.setText("Insertar");
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        tblempleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "APELLIDOS", "EMAIL", "Usuario", "Contraseña"
            }
        ));
        jScrollPane1.setViewportView(tblempleado);
        if (tblempleado.getColumnModel().getColumnCount() > 0) {
            tblempleado.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblempleado.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblempleado.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblempleado.getColumnModel().getColumn(3).setPreferredWidth(160);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btninsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninsertar)
                    .addComponent(btnlimpiar)
                    .addComponent(btnactualizar)
                    .addComponent(btneliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("empleadovet");
        jPanel1.getAccessibleContext().setAccessibleDescription("vet");

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarCajas();
        listarEmpleados();
 }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        procesar(1);
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        procesar(2);
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        procesar(3);
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblempleado;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    //instanciar objeto de la clase Empleadocontroller

// --- MÉTODOS DE LÓGICA DE VISTA ---

    private void procesar(int opcion) {
        try {
            switch (opcion) {
                case 1: // INSERTAR
                    if (validarCampos()) {
                        leerDatos();
                        obj.registrarEmpleado(emp);
                        JOptionPane.showMessageDialog(this, "Empleado registrado con éxito");
                        listarEmpleados();
                        limpiarCajas();
                    }
                    break;
                    
                case 2: // ACTUALIZAR
                    if (tblempleado.getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla para actualizar");
                        return;
                    }
                    if (validarCampos()) {
                        leerDatos();
                        // Obtener el ID del empleado seleccionado
                        int filaSeleccionada = tblempleado.getSelectedRow();
                        String id = model.getValueAt(filaSeleccionada, 0).toString();
                        obj.actualizarEmpleado(emp);
                        JOptionPane.showMessageDialog(this, "Empleado actualizado con éxito");
                        listarEmpleados();
                        limpiarCajas();
                    }
                    break;
                    
                case 3: // ELIMINAR
                    if (tblempleado.getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla para eliminar");
                        return;
                    }
                    int confirmacion = JOptionPane.showConfirmDialog(this, 
                        "¿Está seguro de eliminar este empleado?", 
                        "Confirmar eliminación", 
                        JOptionPane.YES_NO_OPTION);
                    
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        int filaSeleccionada = tblempleado.getSelectedRow();
                        String id = model.getValueAt(filaSeleccionada, 0).toString();
                        Empleado empleadoEliminar = obj.buscarEmpleadoPorId(id);
                        if (empleadoEliminar != null) {
                            obj.eliminarEmpleado(empleadoEliminar);
                            JOptionPane.showMessageDialog(this, "Empleado eliminado con éxito");
                            listarEmpleados();
                            limpiarCajas();
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void leerDatos() {
        emp = new Empleado();
        emp.setNombres(txtNombre.getText());
        emp.setApellidos(txtApellido.getText());
        emp.setEmail(txtEmail.getText());
        emp.setUsername(txtUsuario.getText());
        emp.setPassword(new String(txtPassword.getPassword()));
        // El teléfono no está en tu interfaz, si lo necesitas agrégalo
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty() ||
            txtApellido.getText().trim().isEmpty() ||
            txtEmail.getText().trim().isEmpty() ||
            txtUsuario.getText().trim().isEmpty() ||
            txtPassword.getPassword().length == 0) {
            
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return false;
        }
        return true;
    }

    private void listarEmpleados() {
        limpiarTabla();
        try {
            List<Empleado> lista = obj.listarTodosEmpleados();
            if (lista != null) {
                for (Empleado e : lista) {
                    Object[] fila = {
                        e.getidempleado(),
                        e.getNombres(),     // NOMBRE
                        e.getApellidos(),   // APELLIDOS
                        e.getEmail(),       // EMAIL
                        e.getUsername(),
                        e.getPassword()
                            
                    };
                    model.addRow(fila);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar empleados: " + e.getMessage());
        }
    }

    private void limpiarCajas() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        tblempleado.clearSelection();
    }

    private void limpiarTabla() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    // Agrega este método para cargar datos al hacer clic en la tabla
    private void tblempleadoMouseClicked(java.awt.event.MouseEvent evt) {                                      
        int fila = tblempleado.getSelectedRow();
        if (fila >= 0) {
            try {
                // Obtener datos de la fila seleccionada
                String idempleado = model.getValueAt(fila,1).toString();
                String nombre = model.getValueAt(fila, 1).toString();
                String apellido = model.getValueAt(fila, 2).toString();
                String email = model.getValueAt(fila, 3).toString();
                String usuario = model.getValueAt(fila, 4).toString();
                String password = model.getValueAt(fila, 5).toString();
                // Cargar en los campos de texto
                txtNombre.setText(nombre);
                txtApellido.setText(apellido);
                txtEmail.setText(email);
                txtUsuario.setText(usuario);
                txtPassword.setText(password);
                
                // Buscar el empleado completo para obtener usuario y password
                String id = model.getValueAt(fila, 0).toString();
                Empleado empleado = obj.buscarEmpleadoPorId(id);
                if (empleado != null) {
                    txtUsuario.setText(empleado.getUsername());
                    txtPassword.setText(empleado.getPassword());
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar empleado: " + e.getMessage());
            }
        }
    }

        /**
         * Evento al hacer clic en una fila de la tabla.
         */
        
        /*
        private void tblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {                                      
            int fila = tblEmpleado.getSelectedRow();
                if (fila > -1) {
                    String id = model.getValueAt(fila, 0).toString();
                    txtIdEmpleado.setText(id); // Pone el ID en la caja
                    buscarYMostrarEmpleado(id); // Llama al método de búsqueda
                }
        }
        */
        
    }
    


