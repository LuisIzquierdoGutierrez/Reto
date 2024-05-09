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
   private Tipo_transporte transporte;
   private Solicitudes_ACEX actividad;

    public Transporte(int idTransporte, Tipo_transporte transporte) {
        this.idTransporte = idTransporte;
        this.transporte = transporte;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Tipo_transporte getTipo() {
        return transporte;
    }

    public void setTipo(Tipo_transporte transporte) {
        this.transporte = transporte;
    }

   
   
}
