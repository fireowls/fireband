package fr.fireowls.fireband.util;

import java.io.Serializable;

/**
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la progression d'une comptence
 */
public class Competence implements Serializable {

    private int level;
    private BigValue progress;
    private BigValue expToLevelUp;
    private BigValue expValues[] = Constant.getExpToLvlUp();

    /**
     * Constructeur pour creer une competence avec des valeur specifiées
     * @param level est le niveau de la competence
     * @param progess est la progression de la competence
     */
    public Competence(int level,BigValue progess){
        this.level = level;
        this.progress = progess;
        this.expToLevelUp = expValues[this.level];
    }

    /**
     * Constructeur pour creer une nouvelle competence
     */
    public Competence(){
        this(1,new BigValue(Constant.EXP_CHAR));
    }

    /**
     *
     * @return le niveau de la competence
     */
    public int getLevel(){ return this.level; }

    /**
     *
     * @return la progression de la competence
     */
    public BigValue getProgress() { return this.progress; }

    /**
     *
     * @return l'experience necessaire pour monter de niveau
     */
    public BigValue getExpToLevelUp() { return this.expToLevelUp; }

    /**
     * Permet de changer le niveau
     * @param level est le nouveau niveau
     */
    public void setLevel(int level) {
        if(level > Constant.MAX_LEVEL){
            this.level = Constant.MAX_LEVEL;
        }else {
            this.level = level;
        }
        this.expToLevelUp = this.expValues[this.level];
    }

    /**
     * Permet de changer la progression
     * @param progress est la nouvelle progression
     */
    public void setProgress(BigValue progress) {
        this.progress = progress;
        this.checkProgress();
    }

    /**
     * Permet de changer la valeur necessaire pour monter de niveau
     * @param expToLevelUp
     */
    public void setExpToLevelUp(BigValue expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
    }

    /**
     * Permet d'augement la progression
     * @param tier est le tier de la competence
     */
    public void updateProgress(int tier){
        this.progress.add(this.level*tier);
        this.checkProgress();
    }

    /**
     * Permet de verifier si le joueur a assez d'experience pour monter de niveau
     */
    public void checkProgress(){
        while(this.progress.getValue().compareTo(this.expToLevelUp.getValue()) >= 0){
            if(this.level < Constant.MAX_LEVEL) {
                this.level++;
                this.progress.subtract(this.expToLevelUp);
                this.expToLevelUp = this.expValues[this.level];
            }
        }
    }
}
