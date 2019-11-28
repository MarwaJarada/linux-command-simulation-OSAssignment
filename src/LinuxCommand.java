import java.util.*;
import java.io.*;

/**
 * @author Marwa N. Jarada
 * This code is a simulate to some linux commands
 * NOTE: you have to right all the file path
 */

public class LinuxCommand {
    public static void grep(String requiredWord,String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                if (line.trim().contains(requiredWord)) {
                    for (String word : words) {
                        System.out.print(word + " ");
                    }
                    System.out.println("");
                }
            }
        }catch (Exception e){
            System.out.println("command not found");
        }

    }
    public static void grep(String extendCommand,String requiredWord, String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int counter = 1;

            switch (extendCommand) {
                case "-v":
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] words = line.split("\\W+");
                        if (line.trim().contains(requiredWord)) {
                            continue;
                        } else {
                            for (String word : words) {
                                System.out.print(word + " ");
                            }
                            System.out.println("");
                        }
                    }
                    break;
                case "-n":
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] words = line.split("\\W+");
                        if (line.trim().contains(requiredWord)) {
                            System.out.print(counter + ".");
                            for (String word : words) {
                                System.out.print(word + " ");
                            }
                            System.out.println("");
                        }
                        counter++;
                    }
                    break;
                case "-c":
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] words = line.split("\\W+");
                        if (line.trim().contains(requiredWord)) {
                            counter++;
                        }
                    }
                    System.out.println(counter);
                    break;

                case "-i":
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] words = line.toLowerCase().split("\\W+");
                        if (line.trim().contains(requiredWord)) {
                            continue;
                        } else {
                            for (String word : words) {
                                System.out.print(word + " ");
                            }
                            System.out.println("");
                        }
                    }
                    break;

            }
        }catch (Exception e){
            System.out.println("command not found");

        }
        }
    public static void wc(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int numOfLines = 0; // Because it start with 0 line;
            int numOfWords = 0;
            int numOfChars = 0;
            while ((line = bufferedReader.readLine()) != null) {
                numOfLines++;
                String[] words = line.toLowerCase().split(" ");
                numOfWords += words.length;
                //numOfChars+=line.length();
                numOfChars += line.chars().count();
            }

            System.out.println(numOfLines + " " + numOfWords + " " + numOfChars + "    " + file.getName());
        }
        catch (Exception e){
            System.out.println("command not found\n");
        }
    }
    public static void wc(String extendCommand, String fileName) throws IOException {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            int numOfLines = 0; // Because it start with 0 line;
            int numOfWords = 0;
            int numOfChars = 0;
            switch (extendCommand) {
                case "-w":
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] words = line.split(" ");
                        numOfWords += words.length;
                    }
                    System.out.println(numOfWords + "  " + file.getName());
                    break;

                case "-l":
                    while ((line = bufferedReader.readLine()) != null) {
                        numOfLines++;
                    }
                    System.out.println(numOfLines + "  " + file.getName());
                    break;

                case "-c":
                    while ((line = bufferedReader.readLine()) != null) {
                        numOfChars += line.length();
                    }
                    System.out.println(numOfChars + "  " + file.getName());
                    break;

            }
        }catch (Exception e){
            System.out.println("command not found\n");
        }


    }
    public static void ls(String fileName){
        try {
            File file = new File(fileName);
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    System.out.println(f.getName());
                }
            } else
                System.out.println(file.getName());

        }catch (Exception e){
            System.out.println("command not found\n");
        }
    }
    public static void date(){
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        System.out.println(date);

    }
    public static void cal(int year){
        try {
            int Y = year;    // year
            int startDayOfMonth = 5;
            int spaces = 2;

            // months[i] = name of month i
            String[] months = {
                    "",                               // leave empty so that we start with months[1] = "January"
                    "January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"
            };

            // days[i] = number of days in month i
            int[] days = {
                    0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };

            for (int M = 1; M <= 12; M++) {

                // check for leap year
                if ((((Y % 4 == 0) && (Y % 100 != 0)) || (Y % 400 == 0)) && M == 2)
                    days[M] = 29;


                // print calendar header
                // Display the month and year
                System.out.println("          " + months[M] + " " + Y);

                // Display the lines
                System.out.println("_____________________________________");
                System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");

                // spaces required
                spaces = (days[M - 1] + spaces) % 7;

                // print the calendar
                for (int i = 0; i < spaces; i++)
                    System.out.print("     ");
                for (int i = 1; i <= days[M]; i++) {
                    System.out.printf(" %3d ", i);
                    if (((i + spaces) % 7 == 0) || (i == days[M])) System.out.println();
                }

                System.out.println();
            }
        }catch (Exception e){
            System.out.println("command not found\n");
        }
    }
    public static void cal(int month,int year){
        try {
            int Y = year;    // year
            int startDayOfMonth = 5;
            int spaces = 2;

            // months[i] = name of month i
            String[] months = {
                    "",                               // leave empty so that we start with months[1] = "January"
                    "January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"
            };

            // days[i] = number of days in month i
            int[] days = {
                    0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
            };


            // check for leap year
            if ((((Y % 4 == 0) && (Y % 100 != 0)) || (Y % 400 == 0)) && month == 2)
                days[month] = 29;


            // print calendar header
            // Display the month and year
            System.out.println("          " + months[month] + " " + Y);

            // Display the lines
            System.out.println("_____________________________________");
            System.out.println("   Sun  Mon Tue   Wed Thu   Fri  Sat");

            // spaces required
            spaces = (days[month - 1] + spaces) % 7;

            // print the calendar
            for (int i = 0; i < spaces; i++)
                System.out.print("     ");
            for (int i = 1; i <= days[month]; i++) {
                System.out.printf(" %3d ", i);
                if (((i + spaces) % 7 == 0) || (i == days[month])) System.out.println();
            }

            System.out.println();
        }catch (Exception e){
            System.out.println("command not found\n");
        }

    }
    public static void display() throws Exception {
        try {
            System.out.println("Enter a command line:");
            Scanner s = new Scanner(System.in);
            String command = s.nextLine();
            ArrayList<String> commandList = new ArrayList<String>();
            commandList.addAll(Arrays.asList(command.split(" ")));
            if (commandList.size() <= 4) {
                switch (commandList.get(0)) {
                    case "grep":
                        if (commandList.size() == 3) {
                            grep(commandList.get(1), commandList.get(2));
                        } else if (commandList.size() == 4) {
                            grep(commandList.get(1), commandList.get(2), commandList.get(3));
                        } else throw new Exception();
                        break;
                    case "wc":
                        if (commandList.size() == 2) {
                            wc(commandList.get(1));
                        } else if (commandList.size() == 3) {
                            wc(commandList.get(1), commandList.get(2));
                        } else throw new Exception();
                        break;
                    case "ls":
                        if (commandList.size() == 2) {
                            ls(commandList.get(1));
                        } else throw new Exception();
                        break;
                    case "date":
                        LinuxCommand.date();
                        break;
                    case "cal":
                        if (commandList.size() == 2) {
                            cal(Integer.parseInt(commandList.get(1)));
                        } else if (commandList.size() == 3) {
                            cal(Integer.parseInt(commandList.get(1)), Integer.parseInt(commandList.get(1)));
                        } else throw new Exception();
                        break;
                }
            } else {
                System.out.println("\t Something went wrong - spill the command right! -");
            }
        }catch (Exception e){
            System.out.println("command not found");
        }


    }
    public static void main(String[] args) throws Exception {
        while (true){
            display();
        }

    }
}
