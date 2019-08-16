package fr.fireowls.fireband.tests;

import java.math.BigInteger;

import javax.sound.midi.Instrument;

import fr.fireowls.fireband.instruments.Instruments;
import fr.fireowls.fireband.instruments.Piano;
import fr.fireowls.fireband.util.BigValue;
import fr.fireowls.fireband.util.Competence;
import fr.fireowls.fireband.util.Constant;

public class InstrumentsTest {

    public static void main(String[] args){
        Instruments piano = new Piano();
        System.out.println(piano.toString());
        testProgress(piano);

    }

    public static void testAllLevelAndTier(Instruments instru){
        for(int i = 0 ; i < Constant.MAX_LEVEL*2; i++){
            instru.setTier(i+1);
            instru.getCompetence().setLevel(i+1);
            System.out.println(instru.toString());
            System.out.println("Tier price : "+instru.getPrice().toString());
        }
    }

    public static void testProgress(Instruments instru){
        BigValue bigV = new BigValue(Constant.EXP_CHAR);
        bigV.setValue(1000000000);
        instru.getCompetence().setProgress(bigV);
        System.out.println(instru.toString());
    }
}
