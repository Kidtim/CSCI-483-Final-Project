
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
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
/**
 *
 * @author Tim
 */
@ManagedBean(name="DiceRollerB")
@SessionScoped
public class DiceRollerB implements Serializable{
    int HSUserNumber;
    int HSSkull;
    int HSShield;
    int HSBlank;
    int Dice;
    String Rolls[];
    String Response;


    public int getHSUserNumber() {
        return HSUserNumber;
    }

    public void setHSUserNumber(int HSUserNumber) {
        this.HSUserNumber = HSUserNumber;
    }
    
    
    
    
    public DiceRollerB() {
        
    }
    
    
    String HSSkullNum;
    String HSShieldNum;
    String HSBlankNum;

    public String getResponse() {
        Random randomGR = new Random();
        HSSkull = 0;
        HSShield = 0;
        HSBlank = 0;
        for (int i = 0; i < HSUserNumber; i++)
        {
                Dice = 0;
                Dice = (randomGR.nextInt(6) + 1);
                if (Dice == 1) {HSSkull = HSSkull + 1;}
                if (Dice == 2) {HSSkull = HSSkull + 1;}
                if (Dice == 3) {HSSkull = HSSkull + 1;}
                if (Dice == 4) {HSShield = HSShield + 1;}
                if (Dice == 5) {HSShield = HSShield + 1;}
                if (Dice == 6) {HSBlank = HSBlank + 1;}
                
        }
        
        HSSkullNum = Integer.toString(HSSkull);
        HSShieldNum = Integer.toString(HSShield);
        HSBlankNum = Integer.toString(HSBlank);
    
        return "You Rolled " + HSUserNumber + " Dice!" + '\n' + '\n';
    }

    
    
    
    public String getHSSkullNum() {
        
        return "You rolled " + HSSkullNum + " Skulls!";
    }

    public String getHSShieldNum() {
        return "\n" + "You rolled " + HSShieldNum + " Shields!";
    }

    public String getHSBlankNum() {
        return "\n" + "You rolled " + HSBlankNum + " Blanks!";
    }
    
    
}
