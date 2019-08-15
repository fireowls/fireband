package fr.fireowls.fireband.instruments;

import fr.fireowls.fireband.util.BigValue;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la basse
 */
public class Basse extends Instruments{
	
	private boolean brokenString;
	
	/**
	 * Constructeur pour creer une basse avec certaine valeur
	 * @param tier est le tier de la basse
	 * @param level est le niveau de la basse
	 * @param progress est la progression de la basse
	 */
	public Basse(int tier, int level, BigValue progress) {
		super(tier,level,progress);
		this.brokenString = false;
	}
	/**
	 * Constructeur a utilise pour cr�er une basse
	 */
	public Basse() {
		this(1,1,new BigValue('m'));
	}
	
	/**
	 * Event aleatoire qui defini si les cordes casses ( 5% de chance que ca arrive)
	 * @return true si les cordes ont cassees, false sinon
	 */
	public boolean hasBrock() {
		if(Instruments.rand.nextInt(100) > 94) {
			this.brokenString = true;
		}
		return this.brokenString;
	}
	
	/**
	 * Verifie si la basse peut etre utiliser
	 * @return false si les cordes sont cassees, true sinon
	 */
	public boolean canBeUse() {
		if(this.brokenString) {
			return false;
		}
		return true;
	}
}
