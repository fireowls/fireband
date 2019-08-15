package fr.fireowls.fireband.player;

import java.util.ArrayList;

import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.instruments.Instruments;

/**
 * Classe pour creer un joueur
 * @author TheTeKsa
 *
 */
public class Player {

	private String name;
	private BigValue money;
	private ArrayList<Instruments> instruments;
	
	/**
	 * Constructeur d un joueur deje existant
	 * @param money argent du joueur
	 * @param instruments la liste des instruments du joueur
	 */
	public Player(String name, BigValue money, ArrayList<Instruments> instruments) {
		this.name = name;
		this.money = money;
		this.instruments = instruments;
	}
	
	/**
	 * Constructeur d un nouveau joueur
	 */
	public Player(String name) {
		this(name, new BigValue('$'), new ArrayList<Instruments>());
	}
	
	/**
	 * Ajouter un instrument a la liste
	 * @param i l instrument a ajouter
	 * @return true si reussite ou false si echec de l ajout
	 */
	public boolean addInstrument(Instruments i) {          //COMMENTAIRE A RETIRER : je crois pas que t'est besoin de check si il le contient car je suis pratiquement sûr que l'ArrayList le fait lui meme pareil pour le remove
		if (!this.instruments.contains(i)) {
			this.instruments.add(i);
			return true;
		}
		return false;
	}
	
	/**
	 * Supprimer un instrument de la liste
	 * @param i l instrument a retirer
	 * @return true si reussite ou false si echec de la suppression
	 */
	public boolean removeInstrument(Instruments i) {
		if (this.instruments.contains(i)) {
			this.instruments.remove(i);
			return true;
		}
		return false;
	}

	/**
	 * Ajouter de l argent au joueur
	 * @param money le montant a ajouter
	 */
	public void addMoney(int money) {
		this.money.add(money);
	}

	/**
	 * Retirer de l argent au joueur
	 * @param money le montant a retirer
	 */
	public void substractMoney(int money) {
		this.money.subtract(money);
	}

	/**
	 * Recuperer le nom du joueur
	 * @return le nom du joueur
	 */
	public String getName() {
		return name;
	}

	/**
	 * Recuperer l argent du joueur
	 * @return l argent du joueur
	 */
	public BigValue getMoney() {
		return money;
	}

	/**
	 * Recuperer les instruments du joueur
	 * @return les instruments du joueur
	 */
	public ArrayList<Instruments> getInstruments() {
		return instruments;
	}
	
}
