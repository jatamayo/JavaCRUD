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
    JLabel  lblId_cliente, lblNombre_cliente, lblDireccion_cliente, lblTelefono_cliente, lblEstado_cliente, lblSaldo_cliente,
            lblId_proveedor, lblNombre_proveedor, lblDireccion_proveedor, lblTelefono_proveedor,
            lblId_factura,
            lblId_compra, lblNombre_articulo, lblCantidad_articulo,lblPrecio_articulo,
            lblId_inventario;
    
    JTextField txtNombre_cliente, txtDireccion_cliente, txtTelefono_cliente, txtSaldo_cliente,
               txtNombre_proveedor, txtDireccion_proveedor, txtTelefono_proveedor,
               txtId_proveedor, txtNombre_articulo, txtCantidad_articulo, txtPrecio_articulo,
               txtId_factura, txtId_cliente, txtId_compra;
    
    JComboBox cboEstado_cliente, cboNombre_proveedor;
    
    JScrollPane scroll;
    
    DefaultTableModel model, model2, model3, model4, model5;
    
    JTable tblDatos,tblDatosCompra, tblDatosProveedor, tblDatosInventario, tblDatos_facturacion;
    
    JButton btnAgregar, btnEliminar, btnGuardar, btnLimpiar, btnPDF,
            btnAgregar_compra, btnEliminar_compra, btnGuardar_compra, btnLimpiar_compra, btnPDF_compra,
            btnGenerar_factura;
    
    
    public Vista(){
        this.setTitle("PROYECTO FINAL");
        this.setSize(1900, 800);
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
        
        // LABELS - COMPRAS
        lblId_compra = new JLabel("ID Compra");
        this.getContentPane().add(lblId_compra,new AbsoluteConstraints(770,10,100,20));        
        lblNombre_articulo = new JLabel("Nombre Articulo");
        this.getContentPane().add(lblNombre_articulo,new AbsoluteConstraints(770,40,100,20));        
        lblCantidad_articulo = new JLabel("Cantidad Articulo");
        this.getContentPane().add(lblCantidad_articulo,new AbsoluteConstraints(770,70,100,20));        
        lblPrecio_articulo = new JLabel("Precio Articulo");
        this.getContentPane().add(lblPrecio_articulo,new AbsoluteConstraints(770,100,100,20));
        lblNombre_proveedor = new JLabel("ID Proveedor");
        this.getContentPane().add(lblNombre_proveedor,new AbsoluteConstraints(770,130,100,20));
        
         // LABELS - FACTURACION    
        lblId_factura = new JLabel("GENERAR FACTURA DE COMRPA");
        this.getContentPane().add(lblId_factura,new AbsoluteConstraints(1550,450,300,20));        
        lblId_cliente = new JLabel("ID Cliente");
        this.getContentPane().add(lblId_cliente,new AbsoluteConstraints(1500,480,100,20));        
        lblId_compra = new JLabel("ID Compra");
        this.getContentPane().add(lblId_compra,new AbsoluteConstraints(1500,510,100,20));        
        
        
        
        //TEXT FIELDS
        txtNombre_cliente = new JTextField();
        this.getContentPane().add(txtNombre_cliente,new AbsoluteConstraints(120,40, 100, 20));
        txtDireccion_cliente = new JTextField();
        this.getContentPane().add(txtDireccion_cliente,new AbsoluteConstraints(120,70, 100, 20));
        txtTelefono_cliente = new JTextField();
        this.getContentPane().add(txtTelefono_cliente,new AbsoluteConstraints(120,100, 100, 20));
        txtSaldo_cliente = new JTextField();
        this.getContentPane().add(txtSaldo_cliente,new AbsoluteConstraints(120,130, 100, 20));
        
        //TEXT FIELDS - COMPRAS
        txtNombre_articulo = new JTextField();
        this.getContentPane().add(txtNombre_articulo,new AbsoluteConstraints(920,40, 100, 20));
        txtCantidad_articulo = new JTextField();
        this.getContentPane().add(txtCantidad_articulo,new AbsoluteConstraints(920,70, 100, 20));
        txtPrecio_articulo = new JTextField();
        this.getContentPane().add(txtPrecio_articulo,new AbsoluteConstraints(920,100, 100, 20));
        
        
        //TEXT FIELDS - FACTURACION
        txtId_cliente = new JTextField();
        this.getContentPane().add(txtId_cliente,new AbsoluteConstraints(1580,480, 150, 20));
        txtId_compra = new JTextField();
        this.getContentPane().add(txtId_compra,new AbsoluteConstraints(1580,510, 150, 20));
       
        
        //COMBO BOX
        Object items[]=new Object[2];
        items[0]="Solvente";
        items[1]="Moroso";
        cboEstado_cliente = new JComboBox(items);
        this.getContentPane().add(cboEstado_cliente,new AbsoluteConstraints(120,160,100,20));
        
        //COMBO PROVEEDORES
        Object proveedores[]=new Object[5];
        proveedores[0]="1";
        proveedores[1]="2";
        proveedores[2]="3";
        proveedores[3]="4";
        proveedores[4]="5";
        cboNombre_proveedor = new JComboBox(proveedores);
        this.getContentPane().add(cboNombre_proveedor,new AbsoluteConstraints(920,130,100,20));
        
        
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
        
        //BUTTONS - COMPRAS
        btnAgregar_compra=new JButton("Agregar");
        this.getContentPane().add(btnAgregar_compra,new AbsoluteConstraints(1040,10,100,20));
        btnEliminar_compra=new JButton("Eliminar");
        this.getContentPane().add(btnEliminar_compra,new AbsoluteConstraints(1040,40,100,20));
        btnGuardar_compra=new JButton("Guardar");
        this.getContentPane().add(btnGuardar_compra,new AbsoluteConstraints(1040,70,100,20));
        btnLimpiar_compra=new JButton("Editar");
        this.getContentPane().add(btnLimpiar_compra,new AbsoluteConstraints(1040,100,100,20));
        btnPDF_compra=new JButton("PDF");
        this.getContentPane().add(btnPDF_compra,new AbsoluteConstraints(1040,130,100,20));
        
        //BUTTONS - COMPRAS
        btnGenerar_factura=new JButton("GENERAR FACTURA");
        this.getContentPane().add(btnGenerar_factura,new AbsoluteConstraints(1580,540,150,20));
        
        
        
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
        this.getContentPane().add(scroll,new AbsoluteConstraints(10,200,700,300));
        this.setVisible(true);
        
        // TABLE - COMPRA
        tblDatosCompra = new JTable();
        scroll = new JScrollPane(); 
        model2 = new DefaultTableModel();
        model2.addColumn("ID Compra");
        model2.addColumn("ID Proveedor");
        model2.addColumn("Nombre Articulo");
        model2.addColumn("Cantidad Articulo");
        model2.addColumn("Precio Articulo");
        tblDatosCompra.setModel(model2);
        scroll.setViewportView(tblDatosCompra);
        this.getContentPane().add(scroll,new AbsoluteConstraints(770,200,700,300));
        this.setVisible(true);
        
         // TABLE - PROVEEDOR
        tblDatosProveedor = new JTable();
        scroll = new JScrollPane(); 
        model3 = new DefaultTableModel();
        model3.addColumn("ID Proveedor");
        model3.addColumn("Nombre Proveedor");
        model3.addColumn("Direccion Proveedor");
        model3.addColumn("Telefono Proveedor");
        tblDatosProveedor.setModel(model3);
        scroll.setViewportView(tblDatosProveedor);
        this.getContentPane().add(scroll,new AbsoluteConstraints(10,550,700,300));
        this.setVisible(true);
        
         // TABLE - INVENTARIO
        tblDatosInventario = new JTable();
        scroll = new JScrollPane(); 
        model4 = new DefaultTableModel();
        model4.addColumn("ID Inventario");
        model4.addColumn("ID Compra");
        tblDatosInventario.setModel(model4);
        scroll.setViewportView(tblDatosInventario);
        this.getContentPane().add(scroll,new AbsoluteConstraints(770,550,700,300));
        this.setVisible(true);
        
    }
    
}
