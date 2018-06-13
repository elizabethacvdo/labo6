/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import interfaz.metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Logger;
import modelo.Filtro;


/**
 *
 * @author LN710Q
 */
public class FiltroDao implements metodos <Filtro>{
    
    private static final String SQL_INSERT="INSERT INTO filtros_aceite (codfiltro,marca,stock,existencia)VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE filtros_aceite SET marca=?,stock=?,existencia=? WHERE codFiltro=?";
    private static final String SQL_DELETE="DELETE FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQL_READ ="SELECT * FROM filtros_aceite WHERE codFiltro=?";
    private static final String SQLREADALL = "SELECT * FROM filtroS_aceite";
    
    private static final Connection con = Connection.conectar();
    
    
    @Overridee
    public boolean create(Filtro g) {
        PreparedStatement ps;
        
        try{
            //ps = con.GetCnx().
        }
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps = con.
        }
        
    }

    @Override
    public boolean update(Filtro c) {
    }

    @Override
    public Filtro read(Object key) {
    }

    @Override
    public ArrayList<Filtro> readAll() {
    }
    
    
    
    
    
    
}
