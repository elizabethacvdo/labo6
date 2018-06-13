/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LN710Q
 */
public class Consulta extends JFrame{
    
    public JLabel lblCodigo,lblMarca,lblStock,lblExistencia;
    
    public JTextField codigo,descripcion,stock;
    public JComboBox marca;
    
    ButtonGroup existencia=new ButtonGroup();
    public JRadioButton no;
    public JRadioButton si; 
    public JTable resultados;
    public JPanel table;
    public JButton buscar,eliminar,insertar,limpiar,actualizar;
    
    private static final int ANCHOC=130,ALTOC=30; 
    DefaultTableM
}