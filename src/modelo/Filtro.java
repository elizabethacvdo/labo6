/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String codigo;
    private String marca;
    private int stock;
    private boolean existencia;
    private boolean tipo;

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public Filtro(int id, String codigo, String marca, int stock, boolean existencia, boolean tipo) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
        this.tipo = tipo;
    }
    

    public Filtro(int id, String codigo, String marca, int stock, boolean existencia) {
        this.id = id;
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public Filtro(String codigo, String marca, int stock, boolean existencia, boolean tipo) {
        this.codigo = codigo;
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }

    public Filtro(String marca, int stock, boolean existencia, boolean tipo) {
        this.marca = marca;
        this.stock = stock;
        this.existencia = existencia;
    }
    

    public Filtro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
            
    
}
