package fr.fireowls.fireband.util;


import java.math.BigInteger;

public class Constant {
    public static String divition[] = {"", "k", "M", "B", "T"};
    public static final int MAX_TIER = 5;
    public static final int MAX_LEVEL = 10;

    public static BigValue[] getTierPrice(){
        final BigValue TIER_PRICE[] = new BigValue[Constant.MAX_TIER+1];
        TIER_PRICE[0] = new BigValue("$");
        for(int i = 1; i < TIER_PRICE.length; i++){
            //System.out.println(i);
            TIER_PRICE[i] = new BigValue("$");
            TIER_PRICE[i].setValue((int)(100*Math.pow(10,i)));
            //System.out.println(TIER_PRICE[i]);
        }
        return TIER_PRICE;
    }

    // Potentiel fail ici si on peut ajouter des levels
    public static BigValue[] getExpToLvlUp(){
        final BigValue EXP_AMOUNT[] = new BigValue[Constant.MAX_LEVEL+1];
        EXP_AMOUNT[0] = new BigValue("♫");
        for(int i = 1; i < EXP_AMOUNT.length; i++){
            //System.out.println(i);
            EXP_AMOUNT[i] = new BigValue("♫");
            EXP_AMOUNT[i].setValue((long)(100*Math.pow(10,i))/10);
            //System.out.println(EXP_AMOUNT[i]);
        }
        return EXP_AMOUNT;
    }
}
