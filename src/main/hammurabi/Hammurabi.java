package hammurabi;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

void playGame() {
        int year = 1;
        int population = 100;
        int bushels = 2800;
        int land = 1000;
        int landValue = 19;
        int immigrants = 0;
        int starved = 0;
        int plague = 0;
        int bushelsEaten = 0;
        int harvest = 2800;


        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office.\n" +
        "Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. \n" +
        "Watch out for rat infestiations and the plague! Grain is the general currency, measured in bushels. \n" +
        "The following will help you in your decisions:\n" +
        "\n" +
        "Each person needs at least 20 bushels of grain per year to survive\n" +
        "Each person can farm at most 10 acres of land\n" +
        "It takes 2 bushels of grain to farm an acre of land\n" +
        "The market price for land fluctuates yearly\n" +
        "Rule wisely and you will be showered with appreciation at the end of your term.\n" +
        "Rule poorly and you will be kicked out of office!\n"+
        "\n" +
        "Press any key to proceed");

        while (true) {
        scan.nextLine();
        break;
        }

        for(year = 1; year <= 10; year++) {
        System.out.println(printSummary(year,plague, starved,immigrants,population,harvest,bushelsEaten,land,landValue));
        int bought = askHowManyAcresToBuy(landValue, bushels);
        land += bought;
        bushels -= bought * landValue;

        if(bought == 0){
        int sold = askHowManyAcresToSell(land);
        land -= sold;
        bushels += sold * landValue;
        }

        int feed = askHowMuchGrainToFeedPeople(bushels);
        bushels -= feed;

        int plant = askHowManyAcresToPlant(land, population, bushels);
        bushels -= plant * 2;

        plague = plagueDeaths(population);
        population -= plague;

        starved = starvationDeaths(population, feed);
        population -= starved;

        if(uprising(population, starved)){
        System.out.println("Listen,the population is starving, you cant handle the thrown!!!!");
        break;
        }
        if(starved == 0) {
        immigrants = immigrants(population, land, bushels);
        population += immigrants;
        }

        harvest = harvest(plant);
        bushels += harvest;

        bushelsEaten = grainEatenByRats(bushels);
        bushels -= bushelsEaten;

        landValue = newCostOfLand();

         }

        }
        String printSummary(int year, int plague, int starved, int immigrants, int population, int bushels, int bushelsEaten, int land, int landValue){
        String newRulerOfTheLand = "";
        newRulerOfTheLand += "Who is our new ruler!\n";
        newRulerOfTheLand += "You are in year" + year + " of your ten year rule. \n";
        newRulerOfTheLand += "Old ruler days" + plague + "Death\n";
        newRulerOfTheLand += "Old ruler days" + starved + "Starvation\n";
        newRulerOfTheLand += "Old ruler days" + immigrants + "Please enter\n";
        newRulerOfTheLand += "Current population" + population + "\n";
        newRulerOfTheLand += "Current harvest" + bushels + " bushels. \n";
        newRulerOfTheLand += "Rats destroyed" + bushelsEaten + " bushels, leaving" + bushels + " bushels in storage. \n";
        newRulerOfTheLand += "New rulers acres" + land + " acres of land. \n";
        newRulerOfTheLand += "Current cost of land" + landValue + " number of bushels/acre.\n";

        return newRulerOfTheLand;
        }

        public int askHowManyAcresToBuy ( int price, int bushels){
            int acres = getNumber("How much acres are you trying to buy?");
            if (acres * price > bushels) {
                System.out.print("Out of your price range, sorry!.");
                acres = 0;
            } else if (bushels > price * acres && acres > 0) {
                System.out.println("\n" +
                        "you have purchased " + acres + " acres of land");
            } else {
                System.out.println("Nothing was brought");
                acres = 0;
            }
            //figure out a mathod to buy acres
            return acres;
        }


        public int askHowManyAcresToSell ( int acresOwned){
            int acres = getNumber("Are you selling acres? if so how many??\n");
            if (acresOwned > acres && acresOwned >= 0) {
                System.out.println("You have sold " + acres + " acres of land\n");

            } else if (acresOwned < acres) {
                System.out.println("YOU CANT SELL LAND YOU DO NOT OWN\n");
                acres = 0;
            } else {
                System.out.println("Nothing was brought");

            }//figure out a if statement(s) on how to sell acres?
            return acres;
        }
            //figure out a way to feed bushels to the people wothout starving them
        public int askHowMuchGrainToFeedPeople ( int bushels){
            int feed = getNumber("Everyone is starving, how much grain do we need to take care of them?\n");
            if (bushels >= feed && feed > 0) {
                System.out.println("Everyone has ate" + feed + " many of bushels\n");
            } else if (feed > bushels) {
                System.out.println("You have taken care of everyone, they are full of bushels\n");
                feed = bushels;
            } else {
                System.out.println("THE PEOPLE DID NOT EAT, THEY ARE STARVING:'(\n");
                feed = 0;
            }
            return feed;
        }
            // figure out a method on hpw to plant acres ??
        public int askHowManyAcresToPlant ( int acresOwned, int population, int bushels){
            int plant = 0;
            while (true) {
                plant = getNumber("How much will we plant?\n");
                if (plant > acresOwned) {
                    System.out.println("Need more land\n");
                }
                if (plant > population * 10) {
                    System.out.println("We need more people!!\n");
                }
                if (plant > bushels * 2) {
                    System.out.println("Will need more bushels\n");
                }
                if (plant < 0) {
                    System.out.println("YOU HAVE NOTHING TO PLANT!!");
                }
                if (plant <= population * 10 && plant <= acresOwned && plant <= bushels * 2 && plant >= 0) {
                    System.out.println("planted" + plant + "Harvest!\n");
                    return plant;
                }
            }

        }
                // make ints public under here and figure out the type of statement and what it will return
        public int plagueDeaths ( int population){
            int Deaths = 0;
            rand.nextInt(20);
            if (3 > rand.nextInt(20)) {
                Deaths = (int) (population * 0.5);
            }
            return Deaths;
        }

        public int starvationDeaths ( int population, int bushelsFedToPeople){
            int starve = 0;
            int survivors = bushelsFedToPeople / 20;
            if (population > bushelsFedToPeople / 20) {
                starve = population - survivors;
            }
            return starve;
        }

        public boolean uprising ( int population, int howManyPeopleStarved){
            if (howManyPeopleStarved > (int) (population * .45)) {
                return true;
            }
            return false;
        }


        public int immigrants ( int population, int acresOwned, int grainInStorage){
            int immigrants = (int) ((double) (20 * acresOwned + grainInStorage) / (100 * population) + 1);
            return immigrants;
        }

        public int harvest ( int acres){
            int harvest = acres * (rand.nextInt(6) + 1);
            return harvest;
        }

        public int grainEatenByRats ( int bushels){
            int bushelsEaten = 0;
            if (2 > rand.nextInt(5)) {
                bushelsEaten = (int) ((double) bushels * (rand.nextInt(2) + 1) / 10 + 0.5);
            }
            return bushelsEaten;
        }

        public int newCostOfLand () {
            int landValue = rand.nextInt(7) + 17;
            return landValue;
        }

        public int getNumber (String message){
            while (true) {
                System.out.print(message);
                try {
                    return scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\"" + scan.next() + "\" isn't a number!\n");
                }
            }
        }
    }




