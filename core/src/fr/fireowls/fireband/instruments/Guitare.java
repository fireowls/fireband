package fr.fireowls.fireband.instruments;
import java.io.Serializable;

import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;


/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la guitare
 */
public class Guitare extends Instruments implements Serializable {

	private boolean brokenString;
	
	/**
	 * Constructeur pour creer une guiatre avec certaine valeur
	 * @param tier est le tier de la guitare
	 * @param level est le niveau de la guitare
	 */
	public Guitare(int tier, Competence level) {
		super(tier,level);
		this.brokenString = false;
	}

	/**
	 * Constructeur a utilise pour creer une guitare basique
	 */
	public Guitare() {
		this(0,new Competence());
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
	 * Verifie si la guitare peut etre utiliser
	 * @return false si les cordes sont cassees, true sinon
	 */
	public boolean canBeUse() {
		if(this.brokenString) {
			return false;
		}
		return true;
	}


	public BigValue getPrice() {
		return this.tierPrice[this.instrument_Tier];
	}
}
