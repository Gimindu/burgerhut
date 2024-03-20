import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
public class FoodiesFaveFoodCenter_array {
    /**
     * display coustomers in queue and cashiers
     * @param array store coustomers postion(queue)
     */

    static void queue(String[][] array) {
        System.out.println("*****************");
        System.out.println("*   Cashiers    *");
        System.out.println("*****************");



        for (int col = 0; col < 5; col++) {
            System.out.print("\t");
            for (int row = 0; row < array.length; row++) {

                // Check if the row index is within the bounds of the current column
                if (col < array[row].length) {
                    System.out.print( array[row][col] + "\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }


    /**
     * show empty spaces in queue
     * @param array store coustomers postion(queue)
     */
    static void emptyQueue(String[][] array) {
        System.out.println("****************");
        System.out.println("*   Cashiers   *");
        System.out.println("****************");


        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < array.length; row++) {

                //Check if the row index is within the bounds of the current column
                if (col < array[row].length&& array[row][col].equals("X")) {
                    System.out.print(array[row][col] + "\t");
                } else {
                    System.out.print(" \t");
                }
            }
            System.out.println();
        }
    }





    /**
     * add coustomers to queue
     * @param array store coustomers postion(queue)
     * @param customerName store coustomers name
     */
    static void addCustomer(String[][] array, String[][] customerName) {
        Scanner input = new Scanner(System.in);
        //check its below 10
        if(burgerCount[0]<=10 && burgerCount[0]!=0){
            System.out.print("stock is getting empty please add burgers\n");

        }
        //check the burger count is 0
        if(burgerCount[0]!=0) {
            int cashierNum = 0;
            System.out.print("\nCashier 1 - Type number 1\nCashier 2 - Type number 2\nCashier 3 - Type number 3\nWhere do you want to add the customer: ");
            //validation check
            try {
                cashierNum = input.nextInt();
            } catch (Exception e) {
                System.out.println("\n");
            }


            // Check if the cashier is within the bounds
            if (cashierNum >= 1 && cashierNum <= 3) {
                System.out.print("Enter the name: ");
                String name = input.next();
                int index = cashierNum - 1;
                boolean added = false;
                for (int i = 0; i < array[index].length; i++) {
                    if (array[index][i].equals("X")) {
                        array[index][i] = "O";
                        customerName[index][i] = name;
                        System.out.println(customerName[index][i] + " added to the queue");
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    System.out.println("Customer queue for Cashier " + cashierNum + " is full.");
                }
            } else {
                System.out.println("Invalid number or non-intiger value");
            }

        } else {
            System.out.println("cant add customers please add burgers to stock");

        }
    }





    /**
     * remove customer from sepsific location
     * @param array store coustomers postion(queue)
     * @param customerName store coustomers name
     */
    static void removeCustomer(String[][] array, String[][] customerName){
        Scanner input = new Scanner(System.in);
        //ask the user cashier number
        int cashierNumb=0;

        System.out.print("\n cashier1-Type number 1\n cashier2-Type number 2\n cashier3-Type number 3\nwhere need to remove the  customer:-");
        try{
            cashierNumb = input.nextInt();
        }catch (Exception e){
            System.out.println("\n");
        }

        if (cashierNumb >= 1 && cashierNumb <= 3) {
            cashierNumb -= 1;
            //ask the user position in the queue
            int customerPosition=0;
            System.out.print("\nEnter the customer position:-");
            try{
                customerPosition = input.nextInt();
            }catch (Exception e){
                System.out.println("\n");
            }

            //check the customer postion between cashier length

            if (customerPosition >=1 && customerPosition <= array[cashierNumb].length) {
                customerPosition -= 1;

                String removeName = customerName[cashierNumb][customerPosition];
                if (array[cashierNumb][customerPosition].equals("O")) {

                    //filling the empty space
                    for (int j = customerPosition; j < array[cashierNumb].length; j++) {
                        if (j < (array[cashierNumb].length - 1)) {
                            array[cashierNumb][j] = array[cashierNumb][j + 1];
                            customerName[cashierNumb][j] = customerName[cashierNumb][j + 1];

                        } else {
                            array[cashierNumb][j] = "X";
                            customerName[cashierNumb][j] = "";
                        }
                        // display queue
                    }
                    queue(array);
                    System.out.println(removeName+" remove from the queue");


                }else {
                    System.out.println("It’s an empty position");
                }
            }else{
                System.out.println("Invalid number or non-integer value");
            }


        }else {
            System.out.println("Invalid number or non-integer value");
        }




    }


    /**
     * Remove a served customer
     * @param array store coustomers postion(queue)
     * @param customerName store coustomers name
     * @param burgerCount remove burger
     */
    static void removeServedCustomer(String[][] array, String[][] customerName,int[]burgerCount){

        Scanner input = new Scanner(System.in);
        if(burgerCount[0]>=5) {
            //ask the user cashier number
            int cashierNumb = 0;
            System.out.print("\n cashier1-Type number 1\n cashier2-Type number 2\n cashier3-Type number 3\nwhere need to remove the  customer:-");
            try {
                cashierNumb = input.nextInt();
            } catch (Exception e) {
                System.out.println("\n");
            }
            String removeName = "";
            if (cashierNumb >= 1 && cashierNumb <= 3) {
                cashierNumb -= 1;
                removeName = customerName[cashierNumb][0];

                if (array[cashierNumb][0].equals("O")) {


                    for (int j = 0; j < array[cashierNumb].length; j++) {
                        if (j < (array[cashierNumb].length - 1)) {
                            array[cashierNumb][j] = array[cashierNumb][j + 1];

                            customerName[cashierNumb][j] = customerName[cashierNumb][j + 1];

                        } else {
                            array[cashierNumb][j] = "X";
                            customerName[cashierNumb][j] = "";
                        }

                    }

                    //remove burger value
                    burgerCount[0] -= 5;

                    queue(array);
                    System.out.println(removeName + " remove from the queue");


                } else {
                    System.out.println("It’s an empty position");
                }
            } else {
                System.out.println("Invalid number or non-integer value");
            }
        }else{
            System.out.println("please add burgers to remove customer");

        }

    }


    /**
     * sort the name alphabetical order
     * @param customerName store coustomers name
     */
    static void nameSort(String[][] customerName) {
        String[] oneArray = new String[10];
        int k = 0;

        // Combine all customer names into one array
        for (int i = 0; i < customerName.length; i++) {
            for (int j = 0; j < customerName[i].length; j++, k++) {
                if (customerName[i][j] != null && !customerName[i][j].isEmpty()) {
                    oneArray[k] = customerName[i][j];
                }
            }
        }

        // Count the number of non-null elements
        int nonNull = 0;
        for (String element : oneArray) {
            if (element != null) {
                nonNull++;
            }
        }

        // Create a new array without spaces
        String[] withoutSpaceArray = new String[nonNull];

        // Assign elements to the new array
        int x = 0;
        for (String element : oneArray) {
            if (element != null) {
                withoutSpaceArray[x] = element;
                x++;
            }
        }

        // Bubble Sort with custom string comparison
        for (int i = 0; i < nonNull - 1; i++) {
            for (int j = 0; j < nonNull - i - 1; j++) {
                if (compareStrings(withoutSpaceArray[j], withoutSpaceArray[j + 1]) > 0) {
                    // Swap withoutSpaceArray[j] and withoutSpaceArray[j+1]
                    String temp = withoutSpaceArray[j];
                    withoutSpaceArray[j] = withoutSpaceArray[j + 1];
                    withoutSpaceArray[j + 1] = temp;
                }
            }
        }

        // Print the sorted customer names
        System.out.println("Customers in A-Z:");
        for (String name : withoutSpaceArray) {
            System.out.print(name + " ");
        }
    }

    // Custom string comparison method
    static int compareStrings(String item_one, String item_two) {
        int minLength = Math.min(item_one.length(), item_two.length());

        for (int i = 0; i < minLength; i++) {
            char firstItem = Character.toLowerCase(item_one.charAt(i));
            char secondItem = Character.toLowerCase(item_two.charAt(i));

            if (firstItem != secondItem) {
                return firstItem - secondItem;
            }
        }

        return item_one.length() - item_two.length();
    }


    /**
     * save data to text file
     * @param burgerCount reaming burger count
     * @param array store coustomers postion(queue)
     * @param customerName store coustomers name
     */
    static void storeData(int[]burgerCount,String[][] array, String[][] customerName) {
        try {
            FileWriter myWriter = new FileWriter("storeData.txt");
            myWriter.write(burgerCount[0]+"\n");
            for(int i=0;i<3;i++){
                for(int j=0;j< array[i].length;j++){
                    myWriter.write((array[i][j])+",");
                }
                myWriter.write(("\n"));

            }
            for(int i=0;i<3;i++){
                for(int j=0;j< customerName[i].length;j++){
                    myWriter.write((customerName[i][j])+",");
                }
                myWriter.write(("\n"));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    /**
     * load data from text file
     * @param burgerCount reaming burger count
     * @param array store coustomers postion(queue)
     * @param customerName store coustomers name
     */
    static void loadData(int[]burgerCount,String[][] array, String[][] customerName) {
        try {
            File loadData = new File("storeData.txt");
            Scanner line = new Scanner(loadData);
            int lineNumber = 1;

            while (line.hasNext()) {
                String data = line.nextLine();

                switch (lineNumber) {
                    //load 1st line in text file(burger count)
                    case 1:
                        burgerCount[0] = Integer.parseInt(data);
                        break;
                    //load 2nd line in text file(array)

                    case 2:
                        String[] newArray1 = data.split(",");
                        for (int i = 0; i < newArray1.length; i++) {
                            array[0][i] = newArray1[i].trim();
                        }
                        break;
                    //load 3rd line in text file(array)
                    case 3:
                        String[]  newArray2 = data.split(",");
                        for (int i = 0; i <  newArray2.length; i++) {
                            array[1][i] =  newArray2[i].trim();
                        }
                        break;
                    //load 4th line in text file(array)
                    case 4:
                        String[] newArray3 = data.split(",");
                        for (int i = 0; i < newArray3.length; i++) {
                            array[2][i] = newArray3[i].trim();
                        }
                        break;
                    //load 5th line in text file(customerName)
                    case 5:
                        String[] newArray4 = data.split(",");
                        for (int i = 0; i < newArray4.length; i++) {
                            customerName[0][i] = newArray4[i].trim();
                        }
                        break;
                    //load 6th line in text file(customerName)
                    case 6:
                        String[] newArray5 = data.split(",");
                        for (int i = 0; i < newArray5.length; i++) {
                            customerName[1][i] = newArray5[i].trim();
                        }
                        break;
                    //load 7th line in text file(customerName)
                    case 7:
                        String[] newArray6 = data.split(",");
                        for (int i = 0; i < newArray6.length; i++) {
                            customerName[2][i] = newArray6[i].trim();
                        }
                        System.out.println("Successfully load the file.");
                        break;

                    default:
                        break;
                }
                //add 1 to line number
                lineNumber++;
            }

            line.close();
            //print error
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }




    /**
     * burger count
     */
    static int[] burgerCount={2};


    /**
     * add burgers
     * @param burgerCount reaming burger count
     */
    static void burger(int [] burgerCount) {
        Scanner input = new Scanner(System.in);
        //print available burger
        System.out.println("available Burgers:- " + burgerCount[0]);
        // add burger
        int add_burger=0;
        System.out.print("Enter how many burgers do you want to add: ");
        //ere
        try{
            add_burger = input.nextInt();
        }catch (Exception e){
            System.out.println("non-intiger value");
        }

        //maximum burger count
        if (burgerCount[0]+add_burger<51){
            burgerCount[0] += add_burger;
            System.out.println(add_burger + " Burgers Added");
            System.out.println("available Burgers:- " + burgerCount[0]);
        }else {
            System.out.print("Try again, maximum stock is 50 \navailable Burgers:- " + burgerCount[0]);
        }

    }





    public static void main(String[] args) {
        //customers
        String[][] array= {{"X", "X"},{ "X", "X", "X"},{"X", "X", "X", "X", "X"}};
        //customers name
        String[][] customerName= {{"", ""},{ "", "", ""},{"", "", "", "", ""}};
        Scanner input = new Scanner(System.in);

        //console menu
        do{
            System.out.println("\n");
            System.out.println("\n          MENU            ");
            System.out.println("100 or VEQ: View all  Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue. (From a specific location).");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine).");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data from file");
            System.out.println("108 or STK: View Remaining burgers Stock.");
            System.out.println("109 or AFS: Add burgers to Stock.");
            System.out.println("999 or EXT: Exit the Program.\n");

            //Take the Menu input
            System.out.print("Enter menu option:- ");
            String consoleInput = input.next().toUpperCase();


            switch (consoleInput) {
                case "100":
                case "VFQ":
                    queue(array);
                    break;
                case "101":
                case "VEQ":
                    emptyQueue(array);

                    break;
                case "102":
                case "ACQ":
                    addCustomer(array,customerName);
                    break;
                case "103":
                case "RCQ":
                    removeCustomer(array,customerName);
                    break;
                case "104":
                case "PCQ":
                    removeServedCustomer(array,customerName,burgerCount);
                    break;
                case "105":
                case "VCS":
                    nameSort(customerName);
                    break;
                case "106":
                case "SPD":
                    storeData(burgerCount,array,customerName);
                    break;
                case "107":
                case "LPD":
                    loadData(burgerCount,array,customerName);
                    break;
                case "108":
                case "STK":
                    System.out.println("available Burgers:- " + burgerCount[0]);
                    break;
                case "109":
                case "AFS":
                    burger(burgerCount);
                    break;
                case "999":
                case "EXT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("incorrect input");
                    break;
            }
        }
        while(true);
    }
}