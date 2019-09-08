package fr.fireowls.fireband.instruments;

import java.io.Serializable;

import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la basse
 */
public class Basse extends Instruments implements Serializable {
	
	private boolean brokenString;
	
	/**
	 * Constructeur pour creer une basse avec certaine valeur
	 * @param tier est le tier de la basse
	 * @param level est le niveau de la basse
	 */
	public Basse(int tier, Competence level) {
		super(tier,level);
		this.brokenString = false;
	}
	/**
	 * Constructeur a utilise pour creer une basse
	 */
	public Basse() {
		super();
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

    /**
     * @param tier est le tier dont on veut savoir le prix
     * @return le cout du tier
     */
	public BigValue getPrice(int tier) {
		return this.tierPrice[tier];
	}
}
