/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;
import java.util.Iterator;
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

            //values accede a la columa derecha de la lista, 
            //el iterador no puede iterar respecto a una lista de más
            //de una columna.
        Iterator<Strength> it = c.getStrength().values().iterator();
        while (it.hasNext()) {
            // dmg+=((Strength) it.next()).getValue();
            dmg+=it.next().getValue();
        }
        Iterator<Weakness> it1 = c.getWeakness().values().iterator();
        while (it1.hasNext()) {
            // dmg+=((Strength) it.next()).getValue();
            dmg-=it1.next().getValue();
        }
        
        return dmg;
    }
	}
	

