/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reto.reto;

import java.util.List;

/**
 *
 * @author DAM103
 */
public interface Repositorio<T> {
    public List<T> consultar();
    public boolean guardar(T t);
    public T porId( int id);
    public boolean eliminar( int id);
    
}
