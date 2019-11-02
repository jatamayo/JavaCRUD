package crud;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jalej
 */
public class Controlador implements ActionListener, MouseListener{
    
    Vista v;
    
    Clientes p,p1;
    Compra com, com1;
    Facturacion fac, fac1;
    Inventario inv, inv1;
    Proveedor prov, prov1;
    
    daoClientes dao;
    daoCompra daoCom;
    daoFacturacion daoFac;
    daoInventario daoInv;
    daoProveedor daoProv;
    
    int id = 0;
    
    ArrayList<Clientes> lista = null;
    ArrayList<Compra> lista2 = null;
    ArrayList<Proveedor> lista3 = null;
    ArrayList<Inventario> lista4 = null;
    ArrayList<Facturacion> lista5 = null;
    
    
    
    public static void main(String[] args){
        Controlador c = new Controlador();
    }
    
    public Controlador(){
        v = new Vista();
        
        dao = new daoClientes();
        p1 = new Clientes();        
        daoCom = new daoCompra();
        com1 = new Compra();        
        daoFac = new daoFacturacion();
        fac1=new Facturacion();        
        daoInv = new daoInventario();
        inv1=new Inventario();
        daoProv = new daoProveedor();
        prov1=new Proveedor();
        
        
        // BUTTONS ACTIONS
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.btnPDF.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        
        
        refrescarTabla();
        
        // BUTTONS COMPRAS
        v.btnAgregar_compra.addActionListener(this);
        v.btnEliminar_compra.addActionListener(this);
        v.btnGuardar_compra.addActionListener(this);
        v.btnLimpiar_compra.addActionListener(this);
        v.btnPDF_compra.addActionListener(this);
        v.tblDatosCompra.addMouseListener(this);
        refrescarTabla();
        
        // BUTTONS FACTURACION
        v.btnGenerar_factura.addActionListener(this);
        refrescarTabla();

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //ADD NEW CLIENT BUTTON
        if(e.getSource()==v.btnAgregar){
            p = new Clientes();
            p.setNombre_cliente(v.txtNombre_cliente.getText());
            p.setDireccion_cliente(v.txtDireccion_cliente.getText());
            p.setTelefono_cliente(Integer.parseInt(v.txtTelefono_cliente.getText()));
            p.setEstado_cliente(v.cboEstado_cliente.getSelectedItem().toString());
            p.setSaldo_cliente(Integer.parseInt(v.txtSaldo_cliente.getText()));
            if(!dao.create(p)){
                JOptionPane.showMessageDialog(this.v,"ERROR al insertar cliente");
            }
            limpiarCampos();
        }
        //ADD NEW COMPRA BUTTON
        if(e.getSource()==v.btnAgregar_compra){
            com = new Compra();
            com.setNombre_articulo(v.txtNombre_articulo.getText());
            com.setId_proveedor(Integer.parseInt(v.cboNombre_proveedor.getSelectedItem().toString()));
            com.setCantidad_articulo(Integer.parseInt(v.txtCantidad_articulo.getText()));
            com.setPrecio_articulo(Integer.parseInt(v.txtPrecio_articulo.getText()));
            if(!daoCom.create(com)){
                JOptionPane.showMessageDialog(this.v,"ERROR al insertar compra");
            }
            inv = new Inventario();
            daoInv.getIdCompra();
            if(!daoInv.create(inv)){
                JOptionPane.showMessageDialog(this.v,"ERROR al insertar Inventario");
            }
            limpiarCampos();
        }
        
        //ADD NEW FACTURACION BUTTON
        if(e.getSource()==v.btnGenerar_factura){
            System.out.println("GENERAR FACTURA");
            fac = new Facturacion();
            fac.setId_cliente(Integer.parseInt(v.txtId_cliente.getText()));
            fac.setId_compra(Integer.parseInt(v.txtId_compra.getText()));
            if(!daoFac.create(fac)){
                JOptionPane.showMessageDialog(this.v,"ERROR al insertar factura");
            }
            limpiarCampos();
        }
        
        
        
        // DELETE CLIENT
        if(e.getSource()==v.btnEliminar){
            int x = JOptionPane.showConfirmDialog(this.v, "ESTA SEGURO DE ELIMINAR REGISTRO");
            System.out.println(x + "  " + id);
            if(x == 0 && id > 0){
                if(!dao.delete(id)){
                    JOptionPane.showMessageDialog(this.v,"NO elimino registro");
                }
            }
        }
        // DELETE COMPRA
        if(e.getSource()==v.btnEliminar_compra){
            int x = JOptionPane.showConfirmDialog(this.v, "ESTA SEGURO DE ELIMINAR REGISTRO");
            System.out.println(x + "  " + id);
            if(x == 0 && id > 0){
                if(!daoCom.delete(id)){
                    JOptionPane.showMessageDialog(this.v,"NO elimino registro");
                }
            }
        }
        
        
        
        //SAVE CLIENT
        if(e.getSource()==v.btnGuardar){
            //SAVE CLIENT LOGIC
            p1.setNombre_cliente(v.txtNombre_cliente.getText());
            p1.setDireccion_cliente(v.txtDireccion_cliente.getText());
            p1.setTelefono_cliente(Integer.parseInt(v.txtTelefono_cliente.getText()));
            p1.setEstado_cliente(v.cboEstado_cliente.getSelectedItem().toString());
            p1.setSaldo_cliente(Integer.parseInt(v.txtSaldo_cliente.getText()));
            if(!dao.update(p1)){
                JOptionPane.showMessageDialog(this.v, "Nose actualizo registo");
            }
        }
        //SAVE COMPRA
        if(e.getSource()==v.btnGuardar_compra){
            //SAVE CLIENT LOGIC
            com.setNombre_articulo(v.txtNombre_articulo.getText());
            com.setId_proveedor(Integer.parseInt(v.cboNombre_proveedor.getSelectedItem().toString()));
            com.setCantidad_articulo(Integer.parseInt(v.txtCantidad_articulo.getText()));
            com.setPrecio_articulo(Integer.parseInt(v.txtPrecio_articulo.getText()));
            if(!daoCom.update(com)){
                JOptionPane.showMessageDialog(this.v, "Nose actualizo registo");
            }
        }
        
        
        //GENERATE PDF CLIENT
        if(e.getSource()==v.btnLimpiar){
            limpiarCampos();
        }
        //GENERATE PDF COMPRA
        if(e.getSource()==v.btnLimpiar){
            limpiarCampos();
        }
        

        
        if(e.getSource()==v.btnPDF){
            //GENERATE PDF
            try {
                FileOutputStream archivo;
                File file = new  File("D:\\users\\jalej\\Escritorio\\GitHub\\JavaCRUD\\Java_CRUD\\src\\pdf\\reporteExamenFinal.pdf");
                archivo = new FileOutputStream(file);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();
                Image img = Image.getInstance("D:\\users\\jalej\\Escritorio\\GitHub\\JavaCRUD\\Java_CRUD\\src\\img\\umg.png");
                img.setAlignment(Element.ALIGN_CENTER);
                img.scaleToFit(100, 100);
                doc.add(img);
                Paragraph p = new Paragraph(10);
                Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
                p.add(Chunk.NEWLINE);
                p.add(Chunk.NEWLINE);
                p.add("EXAMEN FINAL ALGORITOS");
                p.add(Chunk.NEWLINE);
                p.add(Chunk.NEWLINE);
                p.add(Chunk.NEWLINE);             
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);
                //DATA TABLE
                PdfPTable tabla = new PdfPTable(6);
                tabla.setWidthPercentage(100);
                PdfPCell c1 = new PdfPCell(new Phrase("ID Cliente", negrita));
                PdfPCell c2 = new PdfPCell(new Phrase("Nombre Cliente", negrita));
                PdfPCell c3 = new PdfPCell(new Phrase("Dirección Cliente", negrita));
                PdfPCell c4 = new PdfPCell(new Phrase("Telefono Cliente", negrita));
                PdfPCell c5 = new PdfPCell(new Phrase("Estado Cliente", negrita));
                PdfPCell c6 = new PdfPCell(new Phrase("Saldo Cliente", negrita));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                c4.setHorizontalAlignment(Element.ALIGN_CENTER);
                c5.setHorizontalAlignment(Element.ALIGN_CENTER);
                c6.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c6.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(c1);
                tabla.addCell(c2);
                tabla.addCell(c3);
                tabla.addCell(c4);
                tabla.addCell(c5);
                tabla.addCell(c6);
                //ADD REGISTERS
                for(Clientes cli: lista){
                    tabla.addCell(""+cli.getId_cliente());
                    tabla.addCell(cli.getNombre_cliente());
                    tabla.addCell(cli.getDireccion_cliente());
                    tabla.addCell(""+cli.getTelefono_cliente());
                    tabla.addCell(cli.getEstado_cliente());
                    tabla.addCell(""+cli.getSaldo_cliente());
                }
                Paragraph p1 = new Paragraph(10);
                p1.add(Chunk.NEWLINE);
                p1.add("NUMERO DE REGISTROS: "+lista.size());
                p1.add(Chunk.NEWLINE);
                p1.add(Chunk.NEWLINE);
                p1.add(Chunk.NEWLINE);             
                p1.setAlignment(Element.ALIGN_LEFT);
                
                doc.add(tabla);
                doc.add(p1);
                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this.v, "Error al crear Archivo");
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(this.v, "Error al generar PDF");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.v, "Error Generate PDF");
            }
        
        }
        
        
        
        refrescarTabla();
    }


    public void refrescarTabla(){
        //REFRESH CLIENTES
        while(v.model.getRowCount()>0){
            v.model.removeRow(0);
        }
        lista = dao.read();
        for(Clientes c: lista){
            Object item[] = new Object[6];
            item[0] = c.getId_cliente();
            item[1] = c.getNombre_cliente();
            item[2] = c.getDireccion_cliente();
            item[3] = c.getTelefono_cliente();
            item[4] = c.getEstado_cliente();
            item[5] = c.getSaldo_cliente();
            v.model.addRow(item);
        }
        v.tblDatos.setModel(v.model);
        //REFRESH COMPRAS
        while(v.model2.getRowCount()>0){
            v.model2.removeRow(0);
        }
        lista2 = daoCom.read();
        for(Compra com: lista2){
            Object item[] = new Object[5];
            item[0] = com.getId_compra();
            item[1] = com.getId_proveedor();
            item[2] = com.getNombre_articulo();
            item[3] = com.getCantidad_articulo();
            item[4] = com.getPrecio_articulo();
            v.model2.addRow(item);
        }
        v.tblDatosCompra.setModel(v.model2);
        //REFRESH PROVEEDOR
        while(v.model3.getRowCount()>0){
            v.model3.removeRow(0);
        }
        lista3 = daoProv.read();
        for(Proveedor prov: lista3){
            Object item[] = new Object[4];
            item[0] = prov.getId_proveedor();
            item[1] = prov.getNombre_proveedor();
            item[2] = prov.getDireccion_proveedor();
            item[3] = prov.getTelefono_proveedor();
            v.model3.addRow(item);
        }
        v.tblDatosProveedor.setModel(v.model3);
        //REFRESH INVENTARIO
        while(v.model4.getRowCount()>0){
            v.model4.removeRow(0);
        }
        lista4 = daoInv.read();
        for(Inventario inv: lista4){
            Object item[] = new Object[2];
            item[0] = inv.getId_inventario();
            item[1] = inv.getId_compra();
            v.model4.addRow(item);
        }
        v.tblDatosInventario.setModel(v.model4);
    }
    

    
    
    
    public void limpiarCampos(){
        v.txtNombre_cliente.setText("");
        v.txtDireccion_cliente.setText("");
        v.txtTelefono_cliente.setText("");
        v.txtSaldo_cliente.setText("");
        v.cboEstado_cliente.setSelectedIndex(0);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== v.tblDatos){
            int fila = v.tblDatos.getSelectedRow();
            id = Integer.parseInt(v.tblDatos.getValueAt(fila, 0).toString());
            System.out.println("ID:"+id);
            p1 = dao.read(id);
            
            v.lblId_cliente.setText("" + p1.getId_cliente());
            v.txtNombre_cliente.setText(p1.getNombre_cliente());
            v.txtDireccion_cliente.setText(p1.getDireccion_cliente());
            //v.txtTelefono_cliente.setInt(p1.getTelefono_cliente());
            v.cboEstado_cliente.setSelectedItem(p1.getEstado_cliente());
            //v.txtSaldo_cliente.setText(Integer.parseInt(p1.getSaldo_cliente()));
            //v.txtSaldo_cliente.getComponent(p1.getSaldo_cliente());
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
