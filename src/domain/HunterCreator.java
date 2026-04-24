/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Hugo Martínez González
 */
public class HunterCreator implements CharacterCreator {

    @Override
    public Character create() {
        return new Hunter();
    }
    
    
}
