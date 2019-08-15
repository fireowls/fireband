package fr.fireowls.fireband.instruments;

import java.util.Random;

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
	/**
	 * Niveau de l'instrument
	 */
	protected int instrument_Level;
	/**
	 * Progession sur l'instrument
	 */
	protected long instrument_progess;
	/**
	 * Experience necaissaire pour levelup
	 */
	protected long progessToLevelup;
	
	protected static Random rand = new Random();
	
	/**
	 * Construteur pour reprendre une progession
	 * @param tier est le tier de l'instrument
	 * @param level est le niveau de l'instrument
	 * @param progess est la progression sur cet instrument
	 */
	public Instruments(int tier, int level, long progess) {
		this.instrument_Tier = tier;
		this.instrument_Level = level;
		this.instrument_progess = progess;
		this.progessToLevelup = (100 * (10^this.instrument_Level)) / 10;
	}
	
	/**
	 * Constructeur pour initialiser pour la premiere fois un instrument
	 */
	public Instruments() {
		this(1,1,0);
	}
	
	/**
	 * Verifie si l'instrument a assez d'experience pour passer au niveau superieur
	 */
	public void checkProgess() {
		if(this.instrument_progess == this.progessToLevelup) {
			this.instrument_Level++;
			this.instrument_progess = 0;
			this.progessToLevelup = (100 * (10^this.instrument_Level)) / 10;
		}
	}
	
	/**
	 * Met a jour la progression de l'instrument
	 * @param instru l'instrument qui progresse
	 */
	public static void updateProgess(Instruments instru) {
		instru.instrument_progess += instru.instrument_Level * instru.instrument_Tier;
		instru.checkProgess();
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
	public int getLevel() {
		return this.instrument_Level;
	}
	
	/**
	 * Permet de changer le niveau de l'instrument
	 * @param level est le nouveau niveau
	 */
	public void setLevel(int level) {
		this.instrument_Level = level;
		this.progessToLevelup = ( 100 * 10^this.instrument_Level ) / 10;
	}
	
	/**
	 * 
	 * @return la progression de l'instrument
	 */
	public long getProgess() {
		return this.instrument_progess;
	}
	
	
	/**
	 * Permet de changer la progression de l'instrument
	 * @param val est la nouvelle progression de l'instrument
	 */
	public void setProgess(long val) {
		this.instrument_progess = val;
		this.checkProgess();
	}
	
	/**
	 * 
	 * @return l'experience necaissaire pour passer au niveau superieur
	 */
	public long getExpToLevelup() {
		return this.progessToLevelup;
	}
	
	/**
	 * Permet de changer l'experience requis pour levelup
	 * @param val est la nouvelle valeur d'experience requis
	 */
	public void setExpToLevelup(long val) {
		this.progessToLevelup = val;
	}
	
	abstract boolean hasBrock();
	abstract boolean canBeUse();
}
