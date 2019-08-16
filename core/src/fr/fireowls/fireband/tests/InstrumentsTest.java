package fr.fireowls.fireband.tests;

import java.math.BigInteger;

import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

public class InstrumentsTest {

    public static void main(String[] args){
        Instruments piano = new Piano();

        for(int i = 0 ; i < Constant.MAX_LEVEL; i++){
            piano.setTier(i+1);
            piano.getCompetence().setLevel(i+1);
            System.out.println(piano.toString());
            System.out.println("Tier price : "+piano.getPrice().toString());
        }
    }

}
