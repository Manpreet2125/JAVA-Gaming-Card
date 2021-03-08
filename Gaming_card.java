
package gaming;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class Gaming {
    
      public static int bal=500,count=0;
      public static int updated;
      public static void playGame() throws InterruptedException
      {
            String[] games={"G1","G2","G3","G4","G5","G6","G7","G8","G9","G10"};
            Random rand=new Random();
            Date day=new Date();     
            System.out.print("Welcome To Smash Gaming Zone\n");
            TimeUnit.SECONDS.sleep(3);
            System.out.print("Please Swipe-In your card\n");
            TimeUnit.SECONDS.sleep(3);
            System.out.print("Loading Please wait.....\n");  
            TimeUnit.SECONDS.sleep(3);
            System.out.print("Your current amount in card is  : " + bal+ "\n");
            if( bal!=0 && bal>10)
                  count++;
            for(int i=1;i<=games.length;i++)
            {  
                int game_no=rand.nextInt(9);
                System.out.print("game no is : " + games[game_no]+"\n");
                System.out.print("****Enjoy your time at Smash****\n");  
                System.out.print("Playing.....");  
                TimeUnit.SECONDS.sleep(5);
                int d=day.getDay();
                if(d<=4&&d>=1)
                {
                    bal=bal-10;
                    count=0;
                    System.out.print("Your Balance is : "+bal+"\n");
                    break;
                }
                else
                {
                    bal=bal-20;
                    count=0;
                    System.out.print("Your Balance is : "+bal+"\n");
                    break;
                }
                
            }
      }
      public static void askRefill()
      {
          System.out.print("Do you want to add on some mooney in your card?  if YES Press Y/y else N/n:\n");
          Scanner ask=new Scanner(System.in);
          String answer=ask.nextLine();
          try {
            if(answer.isEmpty() || (!answer.equalsIgnoreCase("y")&& !answer.equalsIgnoreCase("n")))
                throw new ArithmeticException("input is not valid");
            if(answer.equalsIgnoreCase("y"))
                {
                    System.out.print("How much do you want to add:\n");
                   int amt=ask.nextInt();
                   updated=bal+amt;
                   System.out.print("Your new amount is:"+ updated+"\n");
                }
             else
                 System.out.print("Amount remains same\n");
          }
          catch(Exception e)
          {
              System.out.print("errror occurred beacause "+ e.getMessage()+ "\n");

          }
      }
      
      public static void tryAgain() throws InterruptedException{
           System.out.print("Do you want to exit a game?  if YES Press Y/y or else if you want to play swipe-out the card and swipe-in again \n");
            Scanner ask=new Scanner(System.in);
            String exit=ask.nextLine();
             try {
              if(exit.isEmpty() || (!exit.equalsIgnoreCase("y")))
                throw new ArithmeticException("input is not valid");
             
             if (exit.equalsIgnoreCase("y"))
                if(bal>0)
                   System.out.print("Thanks for coming ");
                else 
                {
                   System.out.print("Cant Exit You balnace is low");
                   askRefill();
                }
             }
           catch(Exception e)
          {
              System.out.print("errror occurred beacause "+ e.getMessage()+ "\n");

          }
      }
             public static void main(String[] args) throws InterruptedException
    {      
              
        playGame();
        askRefill();
        tryAgain();

             

    }
    
}
