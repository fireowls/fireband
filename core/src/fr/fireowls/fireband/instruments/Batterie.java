package fr.fireowls.fireband.instruments;

import fr.fireowls.fireband.util.BigValue;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la batterie
 */
public class Batterie extends Instruments{
	
	private boolean brockenCymbal;
	/**
	 * Constructeur pour cr�er une batterie avec des parametres specifier
	 * @param tier est le tier de la batterie
	 * @param level est le niveau de la batterie
	 * @param progress est le progres de la batterie
	 */
	public Batterie(int tier, int level, BigValue progress) {
		super(tier,level,progress);
		this.brockenCymbal = false;
	}
	
	/**
	 * Constructeur pour creer une batterie basique
	 */
	public Batterie() {
		this(1,1,new BigValue('m'));
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
}
