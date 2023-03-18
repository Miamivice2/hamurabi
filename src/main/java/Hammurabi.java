package hammurabi;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    int people = 100;
    int bushelsOfGrain =2800;
    int acresOfLand = 1000;
    int landValue = 19;
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
    }

    //other methods go here
    int askHowManyAcresToBuy(int price, int bushels){
        while (true) {
            System.out.print("How many acres do you want?");
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }

    }



    int askHowManyAcresToSell(int acresOwned){
        while (true) {
            System.out.print("How many acres do you want to sell?");
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }


    }

    int askHowMuchGrainToFeedPeople(int bushels){
        while (true) {
            System.out.print("How many acres do you want?");
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }

    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        while (true) {
            System.out.print("How many acres do you want to plant?");
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }

    }

    int plagueDeaths(int population){
        return 0;
    }
    int starvationDeaths(int population, int bushelsFedToPeople){
        return 0;
     }
     boolean uprising(int population, int howManyPeopleStarved){
        return true;
      }
      int immigrants(int population, int acresOwned, int grainInStorage){
        return 0;
      }
      int harvest(int acres, int bushelsUsedAsSeed){
        return 0;
      }
      int grainEatenByRats(int bushels){
        return 0;
      }
      int newCostOfLand(){
        return 0;
      }



























}


