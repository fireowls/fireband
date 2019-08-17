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
        piano.setTier(5);
        System.out.println(piano.toString());
        testAllLevelAndTier(piano);
        System.out.println("-----------------------------------------");
        testProgress(piano);
        BigValue big[] = Constant.getMusicienPrice();
        for(int i = 0; i < big.length; i++){
            System.out.println("tier "+i+" "+big[i].toString());
        }
    }

    public static void testAllLevelAndTier(Instruments instru){
        System.out.println("TESTING TIER AND LEVEL VALUES");
        for(int i = 0 ; i < Constant.MAX_LEVEL*2; i++){
            instru.setTier(i+1);
            instru.getCompetence().setLevel(i+1);
            System.out.println(instru.toString());
            System.out.println("Tier price : "+instru.getPrice(instru.getTier()).toString());
        }
    }

    public static void testProgress(Instruments instru){
        System.out.println("TESTING PROGRESS");
        instru.getCompetence().setLevel(1);
        BigValue bigV = new BigValue(Constant.EXP_CHAR);
        bigV.setValue(1000000000);
        instru.getCompetence().setProgress(bigV);
        System.out.println(instru.toString());
    }



}
