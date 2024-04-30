/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.reto;

/**
 *
 * @author DAM103
 */
public class Transporte {
   private int idTransporte;
   private String tipoTransporte;
   private double importe;
   private String comentario;

    public Transporte(int idTransporte,String tipoTransporte, double importe, String comentario) {
        this.idTransporte=idTransporte;
        this.tipoTransporte = tipoTransporte;
        this.importe= importe;
        this.comentario=comentario;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

   
   
}
