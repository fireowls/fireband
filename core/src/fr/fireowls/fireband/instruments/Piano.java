package fr.fireowls.fireband.instruments;

import java.io.Serializable;

import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere le piano
 */
public class Piano extends Instruments implements Serializable {

	private boolean brokenPiano;
	/**
	 * Constructeur pour creer un piano avec certaine valeur
	 * @param tier est le tier du piano
	 * @param level est le niveau du piano
	 */
	public Piano(int tier, Competence level) {
		super(tier, level);
		this.brokenPiano = false;
	}
	
	/**
	 * Constructeur a utilise pour creer un piano basique
	 */
	public Piano() {
		this(0,new Competence());
	}

	/**
	 * Event aleatoire qui defini si il y a de la casse ( 5% de chance que ca arrive)
	 * @return true si les cordes ont cassees, false sinon
	 */
	boolean hasBrock() {
		if(Instruments.rand.nextInt(100) > 94) {
			this.brokenPiano = true;
		}
		return this.brokenPiano;
	}

	/**
	 * Verifie si le piano peut etre utiliser
	 * @return false si il y a de la casse, true sinon
	 */
	boolean canBeUse() {
		if(this.brokenPiano){
			return false;
		}
		return true;
	}

	/**
	 * @param tier est le tier dont on veut connaitre le prix
	 * @return le prix du tier passé en parametre
	 */
	public BigValue getPrice(int tier){
		return this.tierPrice[tier];
	}
}
