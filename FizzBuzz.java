import java.util.Scanner;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class FizzBuzz{  
    public static void main(String args[]){
        //Commenting the direct scenario
        // String[] inparr = {"3", "Mumin", "8", "23", "71","%6$#", "1", "15", "5", "9"};
        // for(int i = 0; i<inparr.length; i++)
        //     System.out.println(checkFizzBuzz(inparr[i]));
        
        //getting input and expected output from a table in a website
        WebDriver wd = new ChromeDriver();
        wd.get("https://mytablewebsite.com");         
        List<webelement> input = wd.findElements(By.xpath("//td[first()]"));
        List<webelement> expected_op = wd.findElements(By.xpath("//td[last()]"));
        Iterator iterinp = input.iterator();
        Iterator iterop = expected_op.iterator();
        while (iterinp.hasNext()) {
            if(!checkFizzBuzz(iterinp.next()).equals(iterop.next())){
                System.out.println("Test Case Failed");
                break;
            }
            System.out.println("Test Case Passed");
        }
        wd.close();
    }  
    static String checkFizzBuzz(String num){
        int n = 0;
        try{
            n = Integer.parseInt(num);
        }
        catch(Exception e){
            return("Invalid");
        }
        
        if (n%3==0 && n%5==0)
            return("FizzBuzz");  
        else if (n%3==0)    
            return("Fizz");   
        else if (n%5==0) 
            return("Buzz");     
        else      
            return("Divided " + num + " by 3\nDivided " + num + " by 5 ");  
        }   
}