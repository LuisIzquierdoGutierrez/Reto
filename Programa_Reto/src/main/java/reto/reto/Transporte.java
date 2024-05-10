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
   private double importe;

    public Transporte(int idTransporte, int transporte, int actividad, double importe) {
        this.idTransporte = idTransporte;
        this.transporte = new Tipo_transporteDAO().porId(transporte);
        this.actividad = new Solicitudes_ACEX_DAO().porId(actividad) ;
        this.importe = importe;
    }

   
   
    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Tipo_transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Tipo_transporte transporte) {
        this.transporte = transporte;
    }

    public Solicitudes_ACEX getActividad() {
        return actividad;
    }

    public void setActividad(Solicitudes_ACEX actividad) {
        this.actividad = actividad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }


   

   
   
}
