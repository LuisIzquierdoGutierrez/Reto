/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

import java.util.List;

/**
 *
 * @author DAM103
 */
public class Transporte {
   private int idTransporte;
   private List<Tipo_transporte> tipo;

    public Transporte(int idTransporte, List<Tipo_transporte> tipo) {
        this.idTransporte = idTransporte;
        this.tipo = tipo;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public List<Tipo_transporte> getTipo() {
        return tipo;
    }

    public void setTipo(List<Tipo_transporte> tipo) {
        this.tipo = tipo;
    }

   
   
}
