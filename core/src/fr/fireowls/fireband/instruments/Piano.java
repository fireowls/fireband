package fr.fireowls.fireband.instruments;

import fr.fireowls.fireband.util.BigValue;
/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere le piano
 */
public class Piano extends Instruments {
	
	/**
	 * Constructeur pour creer un piano avec certaine valeur
	 * @param tier est le tier du piano
	 * @param level est le niveau du piano
	 * @param progress est la progression du piano
	 */
	public Piano(int tier, int level, BigValue progress) {
		super(tier, level, progress);
	}
	
	/**
	 * Constructeur a utilise pour creer un piano basique
	 */
	public Piano() {
		this(1,1,new BigValue('m'));
	}

	/**
	 * Event aleatoire qui defini si il y a de la casse ( 5% de chance que ca arrive)
	 * @return true si les cordes ont cassees, false sinon
	 */
	boolean hasBrock() {
		return false;
	}

	/**
	 * Verifie si le piano peut etre utiliser
	 * @return false si il y a de la casse, true sinon
	 */
	boolean canBeUse() {
		return true;
	}
}
