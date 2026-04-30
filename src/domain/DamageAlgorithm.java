/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 * Algoritmo de daño. Implementa el patrón
 *
 * @author Ignacio Jerónimo Martín i.jeronimo.2024@alumnos.urjc.es
 */
public class DamageAlgorithm implements Algorithm{

	@Override
	public int execute(GameCharacter c) {

        int dmg = c.getPower()+c.getAbility().getAttackValue()+
        c.getPrincipalWeaponOne().getAttackModifier()
        +c.getPrincipalWeaponTwo().getAttackModifier();

            if (c instanceof Hunter) {

                dmg+=((Hunter) c).getAttitude();

            } else if (c instanceof Lycanthrope) {
                
                if (((Lycanthrope) c).getRage()< ((Lycanthrope) c).getAbility().getRageValue())

                dmg-=c.getAbility().getAttackValue();

            } else if (c instanceof Vampire) {

                if (((Vampire) c).getBloodPoints()>=5){ 

                dmg+=2;
                ((Vampire) c).setBloodPoints(((Vampire) c).getBloodPoints()-5);

                }
            }
        return dmg;
    }
	}
	

