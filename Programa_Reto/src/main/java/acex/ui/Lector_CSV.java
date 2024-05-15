/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acex.ui;

import acex.database.*;
import acex.enums.Tipo_Etapa;
import acex.enums.Tipo_Perfil;
import acex.objects.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author DAM126
 */
public class Lector_CSV {

    private static BufferedReader reader = null;
    private static String line = " ";
    private static DAO_Profesor dao_profesor = new DAO_Profesor();
    private static DAO_Departamento dao_departamento = new DAO_Departamento();
    private static DAO_Cursos dao_curso = new DAO_Cursos();
    private static DAO_Grupo dao_grupo= new DAO_Grupo();
    
    private static int index = 1;

    public static void Leer_CSV_Profesores(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] linea = line.split(",");
                Profesor p = new Profesor(0, linea[2], linea[1], linea[0], linea[3], "password", Tipo_Perfil.PROFESOR, true, Integer.parseInt(linea[4]));
                dao_profesor.save(p);
                index++;
            }
        } catch (Exception e) {
            System.out.println("esto es un error pero no sabemos por que asi que ignoralo");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {

            }
        }
    }

    public static void Leer_CSV_Departamentos(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] linea = line.split(",");
                Departamento d = new Departamento(Integer.parseInt(linea[0]), 0, linea[1], linea[2]);
                dao_departamento.save(d);
                index++;
            }
        } catch (Exception e) {
            System.out.println("esto es un error pero no sabemos por que asi que ignoralo");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {

            }
        }
    }
     public static void Leer_CSV_Cursos(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] linea = line.split(",");
               Cursos curso = new Cursos(Integer.parseInt(linea[0]),linea[1],Tipo_Etapa.valueOf(linea[3].toUpperCase()), true,linea[2]);
                dao_curso.save(curso);
                index++;
            }
        } catch (Exception e) {
            System.out.println("esto es un error pero no sabemos por que asi que ignoralo");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {

            }
        }
    } public static void Leer_CSV_Grupos(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] linea = line.split(",");
               Grupo grupo = new Grupo(Integer.parseInt(linea[0]),linea[1],true,"",Integer.parseInt(linea[2]));
                dao_grupo.save(grupo);
                index++;
            }
        } catch (Exception e) {
            System.out.println("esto es un error pero no sabemos por que asi que ignoralo");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {

            }
        }
    }

}
