package crud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;
/**
 *
 * @author jalej
 */
public class Vista extends JFrame{
    
    // FIELDS
    JLabel lblId_cliente, lblNombre_cliente, lblDireccion_cliente, lblTelefono_cliente, lblEstado_cliente, lblSaldo_cliente;
    JTextField txtNombre_cliente, txtDireccion_cliente, txtTelefono_cliente, txtSaldo_cliente;
    JComboBox cboEstado_cliente;
    
    JScrollPane scroll;
    DefaultTableModel model;
    JTable tblDatos;
    JButton btnAgregar, btnEliminar, btnGuardar, btnLimpiar, btnPDF;
    
    
    public Vista(){
        this.setTitle("PROYECTO FINAL");
        this.setSize(1600, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new AbsoluteLayout());
        
        // LABELS
        lblId_cliente = new JLabel("ID Cliente");
        this.getContentPane().add(lblId_cliente,new AbsoluteConstraints(10,10,100,20));
        lblNombre_cliente = new JLabel("Nombre Cliente");
        this.getContentPane().add(lblNombre_cliente,new AbsoluteConstraints(10,40,100,20));
        lblDireccion_cliente = new JLabel("Direccion Cliente");
        this.getContentPane().add(lblDireccion_cliente,new AbsoluteConstraints(10,70,100,20));
        lblTelefono_cliente = new JLabel("Telefono Cliente");
        this.getContentPane().add(lblTelefono_cliente,new AbsoluteConstraints(10,100,100,20));
        lblSaldo_cliente = new JLabel("Saldo Cliente");
        this.getContentPane().add(lblSaldo_cliente,new AbsoluteConstraints(10,130,100,20));
        lblEstado_cliente = new JLabel("Estado Cliente");
        this.getContentPane().add(lblEstado_cliente,new AbsoluteConstraints(10,160,100,20));
        
        //TEXT FIELDS
        txtNombre_cliente = new JTextField();
        this.getContentPane().add(txtNombre_cliente,new AbsoluteConstraints(120,40, 100, 20));
        txtDireccion_cliente = new JTextField();
        this.getContentPane().add(txtDireccion_cliente,new AbsoluteConstraints(120,70, 100, 20));
        txtTelefono_cliente = new JTextField();
        this.getContentPane().add(txtTelefono_cliente,new AbsoluteConstraints(120,100, 100, 20));
        txtSaldo_cliente = new JTextField();
        this.getContentPane().add(txtSaldo_cliente,new AbsoluteConstraints(120,130, 100, 20));
        
        //COMBO BOX
        Object items[]=new Object[2];
        items[0]="Solvente";
        items[1]="Moroso";
        cboEstado_cliente = new JComboBox(items);
        this.getContentPane().add(cboEstado_cliente,new AbsoluteConstraints(120,160,100,20));
        
        //BUTTONS
        btnAgregar=new JButton("Agregar");
        this.getContentPane().add(btnAgregar,new AbsoluteConstraints(240,10,100,20));
        btnEliminar=new JButton("Eliminar");
        this.getContentPane().add(btnEliminar,new AbsoluteConstraints(240,40,100,20));
        btnGuardar=new JButton("Guardar");
        this.getContentPane().add(btnGuardar,new AbsoluteConstraints(240,70,100,20));
        btnLimpiar=new JButton("Editar");
        this.getContentPane().add(btnLimpiar,new AbsoluteConstraints(240,100,100,20));
        btnPDF=new JButton("PDF");
        this.getContentPane().add(btnPDF,new AbsoluteConstraints(240,130,100,20));
        
        // TABLE
        tblDatos = new JTable();
        scroll = new JScrollPane(); 
        model = new DefaultTableModel();
        model.addColumn("ID Cliente");
        model.addColumn("Nombre Cliente");
        model.addColumn("Direccion Cliente");
        model.addColumn("Telefono Cliente");
        model.addColumn("Saldo Cliente");
        model.addColumn("Estado Cliente");
        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll,new AbsoluteConstraints(10,200,500,300));
        this.setVisible(true);
        
    }
    
}
