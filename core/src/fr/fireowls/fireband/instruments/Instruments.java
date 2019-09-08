package fr.fireowls.fireband.instruments;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;
import java.util.Random;

import fr.fireowls.fireband.interfaces.Achetable;
import fr.fireowls.fireband.player.Player;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

/**
 * 
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere les bases des instruments
 */
public abstract class Instruments implements Serializable, Achetable {
	/**
	 * Tier de l'instrument
	 */
	protected int instrument_Tier;

    /**
     * Competence de l'instrument ( niveau, progression et experience pour monter de niveau )
     */
	protected Competence instrument_Level;

    /**
     * Permet de generer des nombres aléatoire
     */
	protected static Random rand = new Random();

    /**
     * Tableau stockant les cout des differents tier
     */
	protected BigValue tierPrice[] = Constant.getTierPrice();

	/**
	 * Image de l'instrument
	 */
	protected Texture img;
	/**
	 * Construteur pour reprendre une progession
	 * @param tier est le tier de l'instrument
	 * @param level est le niveau de l'instrument
	 */
	public Instruments(int tier, Competence level) {
		this.instrument_Tier = tier;
		this.instrument_Level = level;
		this.img = new Texture("badlogic.jpg");
	}
	
	/**
	 * Constructeur pour initialiser pour la premiere fois un instrument
	 */
	public Instruments() {
		this(0,new Competence());
	}
	
	/**
	 * Verifie si l'instrument a assez d'experience pour passer au niveau superieur
	 */
	public void checkProgess() {
		this.instrument_Level.checkProgress();
	}
	
	/**
	 * Met a jour la progression de l'instrument
	 */
	public void updateProgess() {
		this.instrument_Level.updateProgress(this.instrument_Tier);
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
		if(tier > Constant.MAX_TIER){
			this.instrument_Tier = Constant.MAX_TIER;
		}else {
			this.instrument_Tier = tier;
		}
	}
	
	/**
	 * 
	 * @return le niveau de l'instrument
	 */
	public Competence getCompetence() {
		return this.instrument_Level;
	}
	
	/**
	 * Permet de changer le niveau de l'instrument
	 * @param level est le nouveau niveau
	 */
	public void setCompetene(Competence level) {
		this.instrument_Level = level;
	}

	/**
	 * Methode affichage de l'instrument
	 * @return le type d'instrument, son tier, son niveau et sa progression
	 */
	public String toString(){
		return this.getClass().getSimpleName()+" [tier "+this.instrument_Tier+"; level "+this.instrument_Level.getLevel()+"; progres "+this.instrument_Level.getProgress()+"/"+this.instrument_Level.getExpToLevelUp()+"("+this.instrument_Level.getPourcentage()+")]";
	}

    /**
     * Permet d'augementer le tier de l'instrument si le joueur peut l'acheter
	 * @param tier tier que l'on veut acheter
     * @param player est le joueur qui va acheter le tier superieur
     * @return true si le joueur acheter le tier, false sinon
     */
	public boolean upgradeTier(Player player,int tier){
		if(this.instrument_Tier < tier){
			if(player.buy(this, tier)){
				this.instrument_Tier = tier;
				return true;
			}
		}
		return false;
	}

    /**
     * @return le pourcentage de progression dans le niveau de l'instrument
     */
	public String getPourcentage(){
	    return this.instrument_Level.getPourcentage();
    }

    public Texture getImg(){return this.img;}

	abstract boolean hasBrock();
	abstract boolean canBeUse();
}
