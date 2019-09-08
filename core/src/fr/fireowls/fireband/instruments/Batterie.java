package fr.fireowls.fireband.instruments;

import java.io.Serializable;

import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la batterie
 */
public class Batterie extends Instruments implements Serializable {
	
	private boolean brockenCymbal;
	/**
	 * Constructeur pour cr�er une batterie avec des parametres specifier
	 * @param tier est le tier de la batterie
	 * @param level est le niveau de la batterie
	 */
	public Batterie(int tier,Competence level) {
		super(tier,level);
		this.brockenCymbal = false;
	}
	
	/**
	 * Constructeur pour creer une batterie basique
	 */
	public Batterie() {
		this(1,new Competence());
	}

	/**
	 * Event aleatoire qui defini si les cymbales casses( 5% de chance que ca arrive)
	 * @return true si les cordes ont cassees, false sinon
	 */
	boolean hasBrock() {
		if(Instruments.rand.nextInt(100) > 94) {
			this.brockenCymbal = true;
		}
		return this.brockenCymbal;
	}

	/**
	 * Verifie si la batterie peut etre utiliser
	 * @return false si les cordes sont cassees, true sinon
	 */
	boolean canBeUse() {
		if(this.brockenCymbal) return false;
		return true;
	}

	/**
	 * @param tier est le tier dont on veut connaitre le prix
	 * @return le prix du tier passé en parametre
	 */
	public BigValue getPrice(int tier) {
		return this.tierPrice[tier];
	}
}
