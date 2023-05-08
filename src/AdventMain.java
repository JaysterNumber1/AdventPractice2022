import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventMain {


    private void Day1() throws FileNotFoundException {

        File file = new File("Day1.txt");
        Scanner reader = new Scanner(file);
        String data = null;


        int calories = 0;
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            if (!data.equals("")) {
                calories += Integer.parseInt(data.toString());

            } else {


                if (max1 < calories) {
                    max3 = max2;
                    max2 = max1;
                    max1 = calories;

                } else if (max2 < calories) {
                    max3 = max2;
                    max2 = calories;
                } else if (max3 < calories) {
                    max3 = calories;
                }
                calories = 0;
            }

        }


        System.out.println(max1 + " + " + max2 + "+ " + max3 + " = " + (max1 + max2 + max3));


    }

    private void Day2() throws FileNotFoundException {
        File file = new File("Day2.txt");
        Scanner reader = new Scanner(file);
        String data = null;

        String oMove = null;
        String pMove = null;

        int score = 0;

        while (reader.hasNextLine()) {
            data = reader.nextLine();
            oMove = data.substring(0, 1);
            pMove = data.substring(2, 3);

            //region Part A)
            /*
            if(pMove.equals("X")){
                score+=1;
                if(oMove.equals("A")){
                    score+=3;
                } else if(oMove.equals("B")){

                } else{
                    score+=6;
                }
            }
            else if(pMove.equals("Y")){
                score+=2;
                if(oMove.equals("A")){
                    score+=6;
                } else if(oMove.equals("B")){
                    score+=3;

                } else{
                }
            } else{
                score+=3;
                if(oMove.equals("A")){

                } else if(oMove.equals("B")){
                    score+=6;

                } else{
                    score+=3;
                }
            }

             */
            //endregion

            if (pMove.equals("Y")) {
                score += 3;
                if (oMove.equals("A")) {
                    score += 1;
                } else if (oMove.equals("B")) {
                    score += 2;
                } else {
                    score += 3;
                }
            } else if (pMove.equals("X")) {

                if (oMove.equals("A")) {
                    score += 3;
                } else if (oMove.equals("B")) {
                    score += 1;
                } else {
                    score += 2;
                }
            } else {
                score += 6;
                if (oMove.equals("A")) {
                    score += 2;
                } else if (oMove.equals("B")) {
                    score += 3;
                } else {
                    score += 1;
                }
            }

        }
        System.out.println(score);
    }

    private void Day3() throws FileNotFoundException {
        File file = new File("Day3.txt");
        Scanner reader = new Scanner(file);
        String data = null;

        String part1;
        String part2;
        String part3;

        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int sum = 0;
        while (reader.hasNextLine()) {

            //region Part A
            /*
            data = reader.nextLine();
            for (int i = 0; i < data.length()/2; i++) {
                for (int j = data.length()/2; j < data.length(); j++) {
                    if(data.charAt(i)==data.charAt(j)){
                        System.out.println(data.charAt(i));
                        sum+=alpha.indexOf(data.charAt(j))+1;
                        i = data.length();
                        j = data.length();
                    }


                }

            }

             */
            //endregion

            part1 = reader.nextLine();
            part2 = reader.nextLine();
            part3 = reader.nextLine();
            for (int i = 0; i < part1.length(); i++) {
                for (int j = 0; j < part2.length(); j++) {
                    for (int k = 0; k < part3.length(); k++) {
                        if (part1.charAt(i) == part2.charAt(j) && part1.charAt(i) == part3.charAt(k)) {
                            System.out.println(part1.charAt(i));
                            sum += alpha.indexOf(part2.charAt(j)) + 1;
                            i = part1.length();
                            j = part2.length();
                            k = part3.length();
                        }
                    }
                }

            }


        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AdventMain().Day3();
    }
}
