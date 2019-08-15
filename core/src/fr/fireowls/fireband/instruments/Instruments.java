package fr.fireowls.fireband.instruments;

import java.util.Random;

import fr.fireowls.fireband.util.Competence;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere les bases des instruments
 */
public abstract class Instruments {
	/**
	 * Tier de l'instrument
	 */
	protected int instrument_Tier;

	protected Competence instrument_Level;
	
	protected static Random rand = new Random();
	
	/**
	 * Construteur pour reprendre une progession
	 * @param tier est le tier de l'instrument
	 * @param level est le niveau de l'instrument
	 */
	public Instruments(int tier, Competence level) {
		this.instrument_Tier = tier;
		this.instrument_Level = level;
	}
	
	/**
	 * Constructeur pour initialiser pour la premiere fois un instrument
	 */
	public Instruments() {
		this(1,new Competence());
	}
	
	/**
	 * Verifie si l'instrument a assez d'experience pour passer au niveau superieur
	 */
	public void checkProgess() {
		this.instrument_Level.checkProgress();
	}
	
	/**
	 * Met a jour la progression de l'instrument
	 * @param instru l'instrument qui progresse
	 */
	public static void updateProgess(Instruments instru) {
		instru.instrument_Level.updateProgress(instru.instrument_Tier);
	}
	
	/**
	 * 
	 * @return le tier de l'instrument
	 */
	public int getTier() {
		return this.instrument_Tier;
	}
	
	/**
	 * Permet de changer le tier de l'instrument
	 * @param tier est le nouveau tier
	 */
	public void setTier(int tier) {
		this.instrument_Tier = tier;
	}
	
	/**
	 * 
	 * @return le niveau de l'instrument
	 */
	public Competence getLevel() {
		return this.instrument_Level;
	}
	
	/**
	 * Permet de changer le niveau de l'instrument
	 * @param level est le nouveau niveau
	 */
	public void setLevel(Competence level) {
		this.instrument_Level = level;
	}

	/**
	 * Methode affichage de l'instrument
	 * @return le type d'instrument, son tier, son niveau et sa progression
	 */
	public String toString(){
		return this.getClass().getSimpleName()+" [tier "+this.instrument_Tier+"; level "+this.instrument_Level+"; progres "+this.instrument_Level.getProgress()+"/"+this.instrument_Level.getExpToLevelUp()+"]";
	}

	abstract boolean hasBrock();
	abstract boolean canBeUse();
}
