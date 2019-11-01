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
    daoClientes dao;
    int id = 0;
    
    public static void main(String[] args){
        Controlador c = new Controlador();
    }
    
    public Controlador(){
        v = new Vista();
        
        dao = new daoClientes();
        p1=new Clientes();
        
        // BUTTONS ACTIONS
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.btnPDF.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        refrescarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==v.btnAgregar){
            //ADD NEW CLIENT LOGIC
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
        if(e.getSource()==v.btnEliminar){
            //DELETE CLIENT LOGIC
            int x = JOptionPane.showConfirmDialog(this.v, "ESTA SEGURO DE ELIMINAR REGISTRO");
            System.out.println(x + "  " + id);
            if(x == 0 && id > 0){
                if(!dao.delete(id)){
                    JOptionPane.showMessageDialog(this.v,"NO elimino registro");
                }
            }
        }
        
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
        if(e.getSource()==v.btnLimpiar){
            //GENERATE PDF CLIENT
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
                
                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        refrescarTabla();
    }


    public void refrescarTabla(){
        while(v.model.getRowCount()>0){
            v.model.removeRow(0);
        }
        ArrayList<Clientes> lista = dao.read();
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
