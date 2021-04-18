/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import   javax.servlet.http.HttpSession;
import   javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 *
 * @author Kidtim
 */
@ManagedBean(name="DiceRollerC")
@SessionScoped
public class DiceRollerC implements Serializable{
    int atkNumber;
    int defNumber;
    int atkSkull;
    int defSkull;
    int atkShield;
    int defShield;
    int atkBlank;
    int defBlank;
    int dice1;
    int dice2;
    int inflict;
    int counterStrike;
    String Compare;
    //String atkRolls[];
    //String defRolls[];
    String atkResponse;
    String defResponse;
    String atkSkullNum;
    String defSkullNum;
    String atkShieldNum;
    String defShieldNum;
    String atkBlankNum;
    String defBlankNum;

    public int getAtkNumber() {
        return atkNumber;
    }

    public void setAtkNumber(int atkNumber) {
        this.atkNumber = atkNumber;
    }

    public int getDefNumber() {
        return defNumber;
    }

    public void setDefNumber(int defNumber) {
        this.defNumber = defNumber;
    }
    
    
        public DiceRollerC() {
        
    }

    public String getAtkResponse() {
        Random rng1 = new Random();
        atkSkull = 0;
        atkShield = 0;
        atkBlank = 0;
        dice1 = 0;
        for (int i=0; i < atkNumber;i++)
        {    
        
        dice1 = (rng1.nextInt(6) + 1);
        if (dice1 >=1 && dice1 <=3) { atkSkull = atkSkull + 1; System.out.println("atkSkull on roll " + i + " num=" + dice1);}
        if (dice1 >=4 && dice1 <=5) { atkShield = atkShield + 1; System.out.println("atkShield on roll " + i+ " num=" + dice1);}
        if (dice1==6) { atkBlank = atkBlank + 1; System.out.println("atkBlank on roll " + i+ " num=" + dice1);}
        
        }
        atkSkullNum = Integer.toString(atkSkull);
        atkShieldNum = Integer.toString(atkShield);
        atkBlankNum = Integer.toString(atkBlank);
        
        return '\n' + "Attacker rolled " + atkNumber + " Dice!" + '\n' + '\n';
    }

    public String getDefResponse() {
        
        Random rng2 = new Random();
        defSkull = 0;
        defShield = 0;
        defBlank = 0;
        
        
        for (int i=0; i < defNumber;i++)
        {   
            dice2 = 0;
        dice2 = (rng2.nextInt(6) + 1);
         if (dice2 <= 3 && dice2 >=1) { defSkull = defSkull + 1; System.out.println("defSkull on roll " + i + " num=" + dice2);}
        if (dice2 <= 5 && dice2 >=4) { defShield = defShield + 1; System.out.println("defShield on roll " + i+ " num=" + dice2);}
        if (dice2==6) { defBlank = defBlank + 1; System.out.println("defBlank on roll " + i+ " num=" + dice2);}
        
        defSkullNum = Integer.toString(defSkull);
        defShieldNum = Integer.toString(defShield);
        defBlankNum = Integer.toString(defBlank);
        }
        return '\n' +  "Defender rolled " + defNumber + " Dice!" + '\n' + '\n';
    }

    public String getCompare() {
        if (atkSkull > defShield)
        {
            System.out.println("compareskull = " + atkSkull);
            System.out.println("compareshield = " + defShield);
            inflict = atkSkull - defShield;
            return '\n' + "Attacker Wins! They inflict " + inflict + " wounds.";
        }
        else if(defShield >= atkSkull)
        {
            System.out.println("compareskull = " + atkSkull);
            System.out.println("compareshield = " + defShield);
            counterStrike = defShield - atkSkull;
            return '\n' + "Defender Wins! " + counterStrike + " extra shields were rolled.";
        }
        else return "error";
        
    }

    
    public String getAtkSkullNum() {
        return "Attacker Rolled " + atkSkullNum + " Skulls!" + '\n' ;
    }

    public String getDefSkullNum() {
        return "Defender rolled " + defSkullNum + "Skulls!" + '\n';
    }

    public String getAtkShieldNum() {
        return "Attacker Rolled " + atkShieldNum + "Shields!" + '\n' ;
    }

    public String getDefShieldNum() {
        return "Defender rolled " + defShieldNum + "Shields!" + '\n';
    }

    public String getAtkBlankNum() {
        return "Attacker Rolled " + atkBlankNum + "Blanks!" + '\n';
    }

    public String getDefBlankNum() {
        return "Defender rolled " + defBlankNum + "Blanks!" + '\n';
    }

    
        
        
    
}
