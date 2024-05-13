/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package acex.database;

import java.util.List;

/**
 * Esta interfaz define los métodos básicos para un repositorio genérico.
 * @author Adrian
 * @param <T> el tipo de objeto que se almacenará en el repositorio
 * 
 */
public interface Patron_DAO<T> {
     /**
     * Consulta todos los objetos almacenados en el repositorio.
     * 
     * @return una lista de objetos del tipo T almacenados en el repositorio
     */
    public List<T> consultar();
    /**
     * Guarda un objeto en el repositorio.
     * 
     * @param t el objeto a save en el repositorio
     * @return true si el objeto se guarda correctamente, false en caso contrario
     */
    public boolean save(T t);
     /**
     * Obtiene un objeto del repositorio por su identificador.
     * 
     * @param id el identificador del objeto a obtener
     * @return el objeto del tipo T con el identificador especificado, o null si no se encuentra en el repositorio
     */
    public T porId( int id);
   
    /**
     * Elimina un objeto del repositorio por su identificador.
     * 
     * @param id el identificador del objeto a eliminar
     * @return true si el objeto se elimina correctamente, false en caso contrario
     */
    public boolean eliminar( int id);
    
}
