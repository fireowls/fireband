package fr.fireowls.fireband.util;

/**
 * @author MrKeesLer
 * @version 1.0
 * Classe qui gere la progression d'une comptence
 */
public class Competence {

    private int level;
    private BigValue progress;
    private BigValue expToLevelUp;

    /**
     * Constructeur pour creer une competence avec des valeur specifiées
     * @param level est le niveau de la competence
     * @param progess est la progression de la competence
     */
    public Competence(int level,BigValue progess){
        this.level = level;
        this.progress = progess;
        this.expToLevelUp = new BigValue("");
        this.expToLevelUp.setValue((100*10^this.level)/10);
    }

    /**
     * Constructeur pour creer une nouvelle competence
     */
    public Competence(){
        this(1,new BigValue(" "));
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
        this.level = level;
    }

    /**
     * Permet de changer la progression
     * @param progress est la nouvelle progression
     */
    public void setProgress(BigValue progress) {
        if(progress.equals(this.expToLevelUp)){
            progress.subtract(this.expToLevelUp);
            this.level++;
            this.expToLevelUp.setValue((100*10^this.level)/10);
            this.setProgress(progress);
        }else {
            this.progress = progress;
        }
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
    }

    /**
     * Permet de verifier si le joueur a assez d'experience pour monter de niveau
     */
    public void checkProgress(){
        if(this.progress.equals(this.expToLevelUp)){
            this.level++;
            this.expToLevelUp.setValue((100*10^this.level)/10);
            this.expToLevelUp.setValue(0);
        }
    }
}
