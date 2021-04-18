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
import java.util.Arrays;

/**
 *
 * @author Kidtim
 */
@ManagedBean(name="DiceRollerD")
@SessionScoped
public class DiceRollerD implements Serializable{
    int diceType;
    int diceNum;
    int dice;
    int modifierSingle;
    int modifierTotal;
    int currentRoll;
    int Sum = 0;
    int rolls[] = new int[9];
    String response;
    public int getDiceType() {
        return diceType;
    }

    public void setDiceType(int diceType) {
        this.diceType = diceType;
    }

    public int getDiceNum() {
        
        return diceNum;
        
    }
    
    public void setDiceNum(int diceNum) {
        this.diceNum = diceNum;
    
    }

    public int getModifierSingle() {
        return modifierSingle;
    }

    public int getModifierTotal() {
        return modifierTotal;
    }

    public void setModifierSingle(int modifierSingle) {
        this.modifierSingle = modifierSingle;
    }

    public void setModifierTotal(int modifierTotal) {
        this.modifierTotal = modifierTotal;
    }
    
    

    public String getResponse() {
        Random RNGesus = new Random();
        Sum = 0;
        for (int i=0; i<diceNum; i++)
        {
            dice = 0;
            dice = (RNGesus.nextInt(diceType) + 1);
            currentRoll = dice + modifierSingle;
            rolls[i] = currentRoll;   
        }
        for (int u=0; u<diceNum; u++)
        {
            Sum = rolls[u] + Sum;
        }
        Sum = Sum + modifierTotal;
        return "You rolled " + diceNum + "d" + diceType + "." + '\n' + "You added " + modifierSingle + " to each roll" 
                + '\n' + "You added " + modifierTotal + " to the total roll." + '\n'
                + "Your results are: " + Arrays.toString(rolls) + " +" + modifierTotal + '\n' + "Summed together is: " + Sum;
    }
    
    

    
    
    
    
}
