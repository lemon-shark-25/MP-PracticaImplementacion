/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author dezqu
 */
public class AdministradorDeGuardado {
    private static AdministradorDeGuardado instancia;
    
    private AdministradorDeGuardado(){
    }
    
    public static AdministradorDeGuardado getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorDeGuardado();
        }
        return instancia;
    }
    
    public void saveState(String state) {
    }

    public void loadState() {
        
    }
}
