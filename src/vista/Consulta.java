/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dao.FiltroDao;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Filtro;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    
    public JLabel lblCodigo,lblMarca,lblStock,lblExistencia,lblexistencia2;
    
    public JTextField codigo,descripcion,stock;//cajas de entrada de texto
    public JComboBox marca;     //menu  de marcas
    
    ButtonGroup existencia=new ButtonGroup();
    ButtonGroup existencia2=new ButtonGroup();//cuadritos de existencia
    public JRadioButton no;
    public JRadioButton si; 
    public JRadioButton generico;
    public JRadioButton original;
    
    public JTable resultados;//tabla
    
    public JPanel table;//contenedor
    
    public JButton buscar,eliminar,insertar,limpiar,actualizar;
    
    private static final int ANCHOC=130,ALTOC=30; 
    
    DefaultTableModel tm;   //tabla 
    
    public Consulta(){
        super("inventario");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        agregarLabels();
        formulario();
        llenarTabla();
        Container container =getContentPane();
        container.add(lblCodigo);
        container.add(lblMarca);
        container.add(lblStock);
        container.add(lblExistencia);
        container.add(lblexistencia2);
        container.add(codigo);
        container.add(marca);
        container.add(stock);
        container.add(si);
        container.add(no);
        container.add(generico);
        container.add(original);
        container.add(buscar);
        container.add(insertar);
        container.add(actualizar);
        container.add(eliminar);
        container.add(limpiar);
        container.add(table);
        setSize(650,650);
        eventos();
        FiltroDao f =new  FiltroDao();
        f.nueva();
    }
    
    public final void agregarLabels(){//labels
        lblCodigo = new JLabel("codigo");
        lblMarca = new JLabel("marca");
        lblStock = new JLabel ("stock");
        lblExistencia = new JLabel("stoc en tienda");
        lblexistencia2 = new JLabel("denominacion");
        lblCodigo.setBounds(10,10, ANCHOC, ALTOC);
        lblMarca.setBounds(10,60, ANCHOC, ALTOC);
        lblStock.setBounds(10,100, ANCHOC, ALTOC);
        lblExistencia.setBounds(10,140, ANCHOC, ALTOC);
        lblexistencia2.setBounds(310,140,ANCHOC,ALTOC);
    }
    
    public final void formulario(){
        codigo =new JTextField();//cajas de texto
        marca =new JComboBox();
        stock = new JTextField();
        si=new JRadioButton("si",true);//botones de opcion
        no = new JRadioButton("no");
        original=new JRadioButton("original",true);//botones de opcion
        generico = new JRadioButton("generico");
        
        resultados=new JTable();//tabla
        
        buscar = new JButton ("buscar");
        insertar = new JButton("insertar");
        eliminar = new JButton("eliminar");
        actualizar = new JButton("actualizar");
        limpiar =new JButton ("limpiar");
        
        table =new JPanel();//lugar donde se almacena algo
        
        marca.addItem("FRAM");
        marca.addItem("wix");
        marca.addItem("Luber Finer");
        marca.addItem("osk");
        
        existencia=new ButtonGroup();
        
        existencia.add(si);
        existencia.add(no);
        existencia2=new ButtonGroup();
        
        existencia2.add(original);
        existencia2.add(generico);
        
        codigo.setBounds(140,10,ANCHOC,ALTOC);
        marca.setBounds(140,60,ANCHOC,ALTOC);
        stock.setBounds(140,100,ANCHOC,ALTOC);
        si.setBounds(140,140,50,ALTOC);
        no.setBounds(210,140,50,ALTOC);
        original.setBounds(405,140,100,ALTOC);
        generico.setBounds(500,140,110,ALTOC);
        
        
        buscar.setBounds(300,10,ANCHOC,ALTOC);
        insertar.setBounds(10,210,ANCHOC,ALTOC);
        actualizar.setBounds(150,210,ANCHOC,ALTOC);
        eliminar.setBounds(300,210,ANCHOC,ALTOC);
        limpiar.setBounds(450,210,ANCHOC,ALTOC);
        resultados=new JTable();
        
        table.setBounds(30, 250,500, 300);
        table.add(new JScrollPane(resultados));
    }
    
    //----------------------------------------------------------------------------------
    
    public void llenarTabla(){
        tm = new DefaultTableModel(){

    public Class<?> getColumnClass(int column){
            switch(column){
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return Boolean.class;
                default:
                    return Boolean.class;
                    
            }
        }
        };
        tm.addColumn("codigo");
        tm.addColumn("marca");
        tm.addColumn("stock");
        tm.addColumn("stock en sucursal");
        tm.addColumn("original");
        
        FiltroDao fd = new FiltroDao();
        ArrayList<Filtro> filtros=fd.readAll();
        
        for(Filtro f1:filtros){
            tm.addRow(new Object[]{
                f1.getCodigo(),f1.getMarca(),f1.getStock(),f1.getExistencia(),f1.isTipo()});
        }
        resultados.setModel(tm);
    }
    
    public void eventos(){
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            FiltroDao fd = new FiltroDao();
            Filtro f = new Filtro(codigo.getText(),marca.getSelectedItem().toString(),Integer.parseInt(stock.getText()),true,true);
            
            if(no.isSelected()){
                f.setExistencia(false);
            }
            if(generico.isSelected()){
                f.setTipo(false);
            }
            if(fd.create(f)){
                JOptionPane.showMessageDialog(null, "filtro registrado con exito");
                limpiarCampos();
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null,"ocurrio un problema al momento de llenar el filtro");
            }
            
            
            }
        });
      actualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                FiltroDao fd =new FiltroDao();
                Filtro f = new Filtro (codigo.getText(),marca.getSelectedItem().toString(),
                Integer.parseInt(stock.getText()),true,true);
                if(no.isSelected()){
                    f.setExistencia(false);
                }
                if(generico.isSelected()){
                f.setTipo(false);
            }
                if(fd.update(f)){
                    JOptionPane.showMessageDialog(null, "filtro modificado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                   JOptionPane.showMessageDialog(null,"ocurrio un problema al momento de modificar el filtro"); 
                }
            }
          
      });
        
      eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                FiltroDao fd=new FiltroDao();
                if(fd.delete(codigo.getText())){
                    JOptionPane.showMessageDialog(null,"filtro eliminado con exito");
                    limpiarCampos();
                    llenarTabla();
                }else{
                    JOptionPane.showMessageDialog(null,"ocurrio un problema al momento de eliminar el filtro");
                }
            }
          
      });
    
      buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                FiltroDao fd=new FiltroDao();
                Filtro  f = fd.read(codigo.getText());
                if(f==null){
                    JOptionPane.showMessageDialog(null,"el filtro no se ha encontrado");
                   
                }else{
                    codigo.setText(f.getCodigo());
                    marca.setSelectedItem(f.getMarca());
                    stock.setText(Integer.toString(f.getStock()));
                    if(f.getExistencia()){
                    si.setSelected(true);
                }else{
                        no.setSelected(false);
                    }
                    if(f.isTipo()){
                    original.setSelected(true);
                }else{
                        generico.setSelected(false);
                    }
                }
            }
          
      });
      
      
      limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarCampos();
            }
          
      });
    }
    
   public void limpiarCampos(){
       codigo.setText("");
       marca.setSelectedItem("FRAM");
       stock.setText("");
   }
    
   public static void main(String[] args){
       java.awt.EventQueue.invokeLater(new Runnable() {
           @Override
           public void run() {
               new Consulta().setVisible(true);           }
       });{
       
   }
   }
   
}