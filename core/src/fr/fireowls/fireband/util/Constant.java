package fr.fireowls.fireband.util;


import java.math.BigInteger;

public class Constant {
    public static String divition[] = {"", "k", "M", "B", "T"};

    public static BigValue[] getTierPrice(){
        BigValue tierPrice[] = {new BigValue(""), new BigValue(""), new BigValue(""), new BigValue(""), new BigValue(""), new BigValue("")};
        for(int i = 1; i < tierPrice.length+1; i++){
            tierPrice[i].setValue(100*10^i);
        }
        return tierPrice;
    }
}
