/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;


import java.util.List;

public interface ICrudDao<T> {
    void create(T o) throws Exception;
    void update(T o) throws Exception;
    void delete(T o) throws Exception;
    T find(Object o) throws Exception;
    List<T> readAll() throws Exception;
}