import java.util.*;
public class Runner
{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String[] months = {"January", "Febuary", "March", "April", "May", "June", "Jully", "August", "September", "October", "November", "December"};
        double monthlyMoney=0;
        int month = 0;
        double savings=0;
        boolean loop = true;
        boolean nobuy = true;
        String description;
        double cost=0;
        Queue<Item> list = new LinkedList<Item>();
        System.out.println("How much money is set aside each month? ");
        monthlyMoney = Double. parseDouble(scan.nextLine());
        while(loop){
            if(month>11){
                month=0;
            }
            System.out.println(months[month] + " -- Savings: $" + savings);
            while(list.peek() != null && savings >= list.peek().getCost()){
                System.out.println("Purchased " + list.peek());
                savings = savings - list.remove().getCost();
                System.out.println(months[month] + " -- Savings: $" + savings);
            }
            System.out.println("Enter an item description, N to move to the next month or Q to quit.");
            description = scan.nextLine();
            if(description.equals("Q") || description.equals("q")){
                loop = false;
            }
            else if(description.equals("N") || description.equals("n")){
                month++;
                savings+=monthlyMoney;
            }
            else{
                System.out.println("Enter a cost ");
                cost = Double.parseDouble(scan.nextLine());
                Item temp = new Item(description, cost);
                list.add(temp);
            }
        }
    }
}
