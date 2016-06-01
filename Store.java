import java.util.*;
import java.io.*;

public class Store {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to my fancy store!");
  
    ArrayList<String[]> store = read();
    print(store);  

    int total = 0;
    int choice = 8;
    while (choice != 10) {
      System.out.println("What would you like to purchase?");
      printNames(store);
      System.out.println("");
      System.out.println("Or, press 9 for a return or 10 to exit: "); 
      choice = scan.nextInt();
    
      if (choice == 0 || choice == 1 || choice == 2 || choice == 3 || choice == 4) {
        total += Integer.parseInt(store.get(choice)[1]);
      }

    }

    System.out.println("Your total is: " + total);

  }

    public static ArrayList<String[]> read() {
      ArrayList<String[]> in = new ArrayList<String[]>();
      String fileName = "reg.txt";
      String line = null;
      try {
              FileReader fileReader = 
                  new FileReader(fileName);

              BufferedReader bufferedReader = 
                  new BufferedReader(fileReader);

              while((line = bufferedReader.readLine()) != null) {
             	  in.add(line.split(",", 2));
              }   

              bufferedReader.close();
      return in;         
      }
      catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");                
      }
      catch(IOException ex) {
        System.out.println("Error reading file '" + fileName + "'");  
      }
      return null;                
    }
    public static void print(ArrayList<String[]> in){
      for (String[] i : in) {
        System.out.println(i[0] + " are $" + i[1]);
      }   
    }
    public static void printNames(ArrayList<String[]> in){
      for (int i = 0; i < in.size(); i++) {
        System.out.println(" " + i + "	"  + in.get(i)[0]);
      }   
    }
}
