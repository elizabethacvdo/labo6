/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public interface metodos <Generic>{
    public boolean create(Generic g);
    public boolean delete (Object key);
    public boolean update(Generic c);
    public  void nueva();
    
    
    public Generic read(Object key);
    public ArrayList<Generic> readAll();
    
    
}
