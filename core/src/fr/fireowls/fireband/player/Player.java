package fr.fireowls.fireband.player;

import java.io.Serializable;
import java.util.ArrayList;

import fr.fireowls.fireband.exceptions.InstrumentNotFoundException;
import fr.fireowls.fireband.interfaces.Achetable;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.instruments.Instruments;

/**
 * Classe pour creer un joueur
 * @author TheTeKsa
 *
 */
public class Player implements Serializable {
	/**
	 * Le nom du joueur
	 */
	private String name;
	/**
	 * L argent du joueur
	 */
	private BigValue money;
	/**
	 * Les instruments possede par le joueur
	 */
	private ArrayList<Instruments> instruments;
	/**
	 * Indice de l instrument en cours d utilisation
	 */
	private int idxCurrentInstrument;
	
	/**
	 * Constructeur d un joueur deje existant
	 * @param money argent du joueur
	 * @param instruments la liste des instruments du joueur
	 */
	public Player(String name, BigValue money, ArrayList<Instruments> instruments) {
		this.name = name;
		this.money = money;
		this.instruments = instruments;
		this.idxCurrentInstrument = 0;
	}
	
	/**
	 * Constructeur d un nouveau joueur
	 */
	public Player(String name) {
		this(name, new BigValue("$"), new ArrayList<Instruments>());
	}
	
	/**
	 * Ajouter un instrument a la liste
	 * @param i l instrument a ajouter
	 * @return true si reussite ou false si echec de l ajout
	 */
	public boolean addInstrument(Instruments i) {
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
	 * Permet de changer l instrument en cours d utilisation
	 * @param i Nouvel instrument
	 * @return true ou false selon la reussite ou non de la fonction
	 */
	public boolean switchInstrument(Instruments i) {
		if (this.instruments.contains(i)) {
			this.idxCurrentInstrument = this.instruments.indexOf(i);
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
	 * Fonction pour acheter instruments ou musiciens
	 * @param item l item a acheter
	 * @return true si le joueur a assez d argent ou false le cas contraire
	 */
	public boolean buy(Achetable item) {
		if (this.money.compareTo(item.getPrice()) >= 0) {
			this.money.subtract(item.getPrice());
			return true;
		}
		return false;
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

	/**
	 * Recuperer l instrument en cours d utilisation
	 * @return l instrument en cours d utilisation
	 * @throws InstrumentNotFoundException
	 */
	public Instruments getCurrentInstrument() throws InstrumentNotFoundException {
		if (this.instruments.isEmpty()) {
			throw new InstrumentNotFoundException();
		}
		return this.instruments.get(this.idxCurrentInstrument);
	}

}
