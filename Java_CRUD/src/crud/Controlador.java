package crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jalej
 */
public class Controlador implements ActionListener, MouseListener{
    
    Vista v;
    Clientes p;
    daoClientes dao;
    
    public static void main(String[] args){
        Controlador c = new Controlador();
    }
    
    public Controlador(){
        v = new Vista();
        
        dao = new daoClientes();
        
        // BUTTONS ACTIONS
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.btnPDF.addActionListener(this);
        v.addMouseListener(this);
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
            refrescarTabla();
            limpiarCampos();
            
        }
        if(e.getSource()==v.btnEliminar){
            //DELETE CLIENT LOGIC
        }
        if(e.getSource()==v.btnGuardar){
            //SAVE CLIENT LOGIC
        }
        if(e.getSource()==v.btnLimpiar){
            //GENERATE PDF CLIENT
        }
        if(e.getSource()==v.btnPDF){
        
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==v.tblDatos){
            //CLICK TABLE LOGIC
        }
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
