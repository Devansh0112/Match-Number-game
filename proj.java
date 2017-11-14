
import java.util.*;
import java.io.*;

class project {

   static int score;

    void setscore() throws IOException {
        FileWriter file = new FileWriter("score.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.write(String.valueOf(score));
            bufferedWriter.close();
        }

    

    void playgame() throws IOException {

        int i = 0;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("The rules of the game are as follows - \n1.You choose a number between 1 to 10\n2.If it matches the number on the screen you get 50 points\n3. Else no points");
        System.out.println("Let's start! \n\n");

        project p = new project();
        while (i < 10) {
            System.out.println("Enter your number : ");
            int n = sc.nextInt();
            int b = r.nextInt(10) + 1;

            System.out.println("The number on the screen is " + b);
            if (n == b) {
                score = score + 50;
                System.out.println("Great!");
            }

            i = i + 1;

        }
        System.out.println("Your score is : " + score);
        p.checkscore();

    }

    void checkscore() throws FileNotFoundException, IOException {
        FileReader f = new FileReader("score.txt");
        BufferedReader b = new BufferedReader(f);
        String l;
        project p = new project();

        l = b.readLine();
        int x = Integer.parseInt(l);

        if (score > x) {
            p.setscore();
        }
        
        
        b.close();

    }

    void highscore() throws FileNotFoundException, IOException {

        FileReader f = new FileReader("score.txt");

        BufferedReader b = new BufferedReader(f);
            String l;

            l = b.readLine();
            System.out.println(l + " is the highest score till now!");
            b.close();
        
    }
    
    void clearh() throws FileNotFoundException, IOException{
        FileWriter n = new FileWriter("score.txt");
        BufferedWriter b = new BufferedWriter(n);
        int a = 0;
        b.write(String.valueOf(a));
        b.close();
        
        
    }

    public static void main(String args[]) throws IOException {

        System.out.println("Welcome to the Match-Number Game");
        System.out.println("Select from option below\n\n");
        project p = new project();
        System.out.println("1. Play Game\n2.High Score\n3.Clear Highscore\n4.Exit\n\n");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        while (true) {

            switch (op) {
                case 1:
                    score = 0;
                    p.playgame();
                    break;

                case 2:
                    p.highscore();
                    break;

		case 3 : p.clearh();
			break;

                case 4:
                    System.exit(30);

                default:
                    System.out.println("Please chose a valid option");

            }

            System.out.println("Select from option below\n\n");
            System.out.println("1. Play Game\n2.High Score\n3.Clear Highscore\n4.Exit\n\n");
            op = sc.nextInt();

        }
    }
}
