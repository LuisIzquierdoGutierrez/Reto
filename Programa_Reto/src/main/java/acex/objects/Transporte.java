/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.objects;

import acex.database.DAO_Tipo_transporte;
import acex.database.DAO_Solicitudes_ACEX;
import java.util.List;

/**
 * Esta clase representa un objeto de transporte.
 * Contiene información sobre el transporte, la actividad asociada y el importe.
 * @author Adrian, Luis
 */
public class Transporte {
   private int idTransporte;
   private Tipo_Transporte transporte;
   private Solicitudes_ACEX actividad;
   private double importe;
   
   /**
     * Constructor de la clase Transporte.
     * @param idTransporte El ID del transporte.
     * @param transporte El tipo de transporte.
     * @param actividad La actividad asociada.
     * @param importe El importe del transporte.
     */

    public Transporte(int idTransporte, int transporte, int actividad, double importe) {
        this.idTransporte = idTransporte;
        this.transporte = new DAO_Tipo_transporte().porId(transporte);
        this.actividad = new DAO_Solicitudes_ACEX().porId(actividad) ;
        this.importe = importe;
    }

   
   
    /**
     * Obtiene el ID del transporte.
     * @return El ID del transporte.
     */
    public int getIdTransporte() {
        return idTransporte;
    }

    /**
     * Establece el ID del transporte.
     * @param idTransporte El ID del transporte.
     */
    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    /**
     * Obtiene el tipo de transporte.
     * @return El tipo de transporte.
     */
    public Tipo_Transporte getTransporte() {
        return transporte;
    }

    /**
     * Establece el tipo de transporte.
     * @param transporte El tipo de transporte.
     */
    public void setTransporte(Tipo_Transporte transporte) {
        this.transporte = transporte;
    }

    /**
     * Obtiene la actividad asociada.
     * @return La actividad asociada.
     */
    public Solicitudes_ACEX getActividad() {
        return actividad;
    }

    /**
     * Establece la actividad asociada.
     * @param actividad La actividad asociada.
     */
    public void setActividad(Solicitudes_ACEX actividad) {
        this.actividad = actividad;
    }

    /**
     * Obtiene el importe del transporte.
     * @return El importe del transporte.
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del transporte.
     * @param importe El importe del transporte.
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
   
   
}
