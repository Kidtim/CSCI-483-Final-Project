
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
 * @author Tim
 */
@ManagedBean(name="DiceRollerA")
@SessionScoped
public class DiceRollerA implements Serializable {
    int userNumber;   //Initialize a large amount of variables and arrays
    int DiceSix1;
    int DiceSix2;
    int DiceSix3;
    int DiceSix4;
    int DSixLowest = 6;
    int DSixTotal[] = {0, 0, 0, 0, 0, 0};
    int FirstRoll[] = {0, 0, 0, 0};
    int SecondRoll[] = {0, 0, 0, 0};
    int ThirdRoll[] = {0, 0, 0, 0};
    int FourthRoll[] = {0, 0, 0, 0};
    int FifthRoll[] = {0, 0, 0, 0};
    int SixthRoll[] = {0, 0, 0, 0};
    
    String Response;
    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    

    public DiceRollerA() {
          
    }
    public String getResponse() {
        for (int i = 0; i<userNumber; i++)
            {
                Random randomGR = new Random();  //random numbers
                DiceSix1 =(randomGR.nextInt(6) + 1);
                DiceSix2 =(randomGR.nextInt(6) + 1);
                DiceSix3 =(randomGR.nextInt(6) + 1);
                DiceSix4 =(randomGR.nextInt(6) + 1);
                
                int DSix[] = {DiceSix1, DiceSix2, DiceSix3, DiceSix4};
                
                
                    for (int u = 0; u<4; u++)
                        {
                            if (DSixLowest > DSix[u]) //Compare a roll to 6. Is it lower? if so, replace DSixLowest. Then compare it to the next number.
                                {                       //Repeat until we have the lowest rolled number
                                    DSixLowest = DSix[u];
                                }
                        }
                DSixTotal[i] = (DiceSix1 + DiceSix2 + DiceSix3 + DiceSix4)-DSixLowest; //Roll 4d6 (four six sided dice) and drop the lowest roll.
                switch (i) //sets the rolls into an array
                {
                    case 0: FirstRoll[0] = DiceSix1; FirstRoll[1] = DiceSix2; FirstRoll[2] = DiceSix3; FirstRoll[3] = DiceSix4; break;
                    case 1: SecondRoll[0] = DiceSix1; SecondRoll[1] = DiceSix2; SecondRoll[2] = DiceSix3; SecondRoll[3] = DiceSix4; break;
                    case 2: ThirdRoll[0] = DiceSix1; ThirdRoll[1] = DiceSix2; ThirdRoll[2] = DiceSix3; ThirdRoll[3] = DiceSix4; break;
                    case 3: FourthRoll[0] = DiceSix1; FourthRoll[1] = DiceSix2; FourthRoll[2] = DiceSix3; FourthRoll[3] = DiceSix4; break;
                    case 4: FifthRoll[0] = DiceSix1; FifthRoll[1] = DiceSix2; FifthRoll[2] = DiceSix3; FifthRoll[3] = DiceSix4; break;
                    case 5: SixthRoll[0] = DiceSix1; SixthRoll[1] = DiceSix2; SixthRoll[2] = DiceSix3; SixthRoll[3] = DiceSix4; break;
                }
            } 
            switch (userNumber) //Outputs the desired number of rolls, and what the rolls were
            {
                    case 1: return "Your stat is: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll);
                    
                    case 2: return "Your stats are: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll) + '\n' + "second: " + Arrays.toString(SecondRoll);
                    
                    case 3: return "Your stats are: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll) + '\n' + "second: " + Arrays.toString(SecondRoll)
                                                        + '\n' + "third: " + Arrays.toString(ThirdRoll);
                    case 4: return "Your stats are: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll) + '\n' + "second: " + Arrays.toString(SecondRoll)
                                                        + '\n' + "third: " + Arrays.toString(ThirdRoll) + '\n' + "fourth: " + Arrays.toString(FourthRoll) ;
                    case 5: return "Your stats are: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll) + '\n' + "second: " + Arrays.toString(SecondRoll)
                                                        + '\n' + "third: " + Arrays.toString(ThirdRoll) + '\n' + "fourth: " + Arrays.toString(FourthRoll) 
                                                           + '\n' + "fifth: " + Arrays.toString(FifthRoll);
                    case 6: return "Your stats are: " + '\n' + Arrays.toString(DSixTotal) + '\n' + "first: " + Arrays.toString(FirstRoll) + '\n' + "second: " + Arrays.toString(SecondRoll)
                                                        + '\n' + "third: " + Arrays.toString(ThirdRoll) + '\n' + "fourth: " + Arrays.toString(FourthRoll)
                                                           + '\n' + "fifth: " + Arrays.toString(FifthRoll) + '\n' + "Sixth: " + Arrays.toString(SixthRoll);
                    default: return "Sorry! Invalid input!" + '\n' + "Please input a valid number from 1 to 6.";
            }
        
    }
}