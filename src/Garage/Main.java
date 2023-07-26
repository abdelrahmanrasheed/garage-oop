package Garage;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList();
    private static ArrayList<Vehicle> vehicles = new ArrayList();
    private static ArrayList<Fees> fees = new ArrayList();
    public static void main(String[] args) {

        int user_option;
        do {
            System.out.println(
                    "\n1. Register customer\n" +
                            "2. Register a vehicle.\n" +
                            "3. Choose Membership.\n" +
                            "4. Display Customer Details.\n" +
                            "5. Display Vehicle Details.\n" +
                            "6. Display all Customers.\n" +
                            "7. Display all Vehicles.\n" +
                            "8. Display all fees recorded\n" +
                            "9. Quit.\n" +
                            "########################################## \n" +
                            "Please enter a number for the required operation: ");
            user_option = scan.nextInt();
            if (user_option == 9)
            {
                System.out.println("See You Later.");
            }
            else if (user_option == 1)
            {
                addCustomer();
            }
            else if (user_option == 2)
            {
                registervehicle();
            }
            else if (user_option == 3)
            {
                payfees();
            }
            else if (user_option == 4)
            {
                customerdetails();
            }
            else if (user_option == 5)
            {
                vehicledetails();
            }
            else if (user_option == 6)
            {
                displaycustomers();
            }
            else if (user_option == 7)
            {
                displayvehicles();
            }
            else if(user_option == 8)
            {
                displaysales();
            }
        } while (user_option != 9);

    }
    public static void addCustomer()
    {
        if (customers.size() > 30)
        {
            System.out.println("Maximum Garage spots have been filled cannot add more.");
            return;
        }
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        for (Customer customer : customers) {
            if (customer.getGarageid() == id) {
                System.out.println("This user already exists\n");
                addCustomer();
            }
        }
        scan.nextLine();
        System.out.println("Enter Name: ");
        String name = scan.nextLine();
        System.out.println("Enter Phone Number: ");
        String phone = scan.nextLine();
        System.out.println("Enter Address: ");
        String address = scan.nextLine();
        customers.add(new Customer(id, name, phone,address));
        System.out.println("Member has been added Successfully!");

    }

    public static void registervehicle()
    {
        if (customers.size() > 30)
        {
            System.out.println("Maximum Garage spots have been filled cannot add more.");
            return;
        }
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Vehicle Manufacturer: ");
        String manf = scan.nextLine();
        System.out.println("Enter Vehicle Model: ");
        String model = scan.nextLine();
        System.out.println("Vehicle Added Successfully!");
        vehicles.add(new Vehicle(id, manf, model));
    }

    public static void payfees()
    {
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        for (Customer customer : customers)
        {
            if (customer.getGarageid() == id)
            {
                System.out.println("Hello," +customer.getName());
            }
            else
            {
                System.out.println("User Doesn't exist");
                return;
            }
        }
        System.out.println("Which membership would you like ? (1. Gold, 2.Silver, 3.Bronze)");
        int mem = scan.nextInt();
        if (mem == 1)
        {
            System.out.println("Your fees will be 200$");
            System.out.println("Would you like to pay now ? 1.Yes , 0.No");
            boolean answer = scan.hasNextShort();
            if (answer == true)
            {
                System.out.println("Success!");
                fees.add(new Fees(id, 200));
                return;
            }
            else
            {
                System.out.println("See You another time!");
                return;
            }
        }
        if (mem == 2)
        {
            System.out.println("Your fees will be 100$");
            System.out.println("Would you like to pay now ? 1.Yes , 0.No");
            boolean answer = scan.hasNextShort();
            if (answer == true)
            {
                System.out.println("Success!");
                fees.add(new Fees(id, 100));
                return;
            }
            else
            {
                System.out.println("See You another time!");
                return;
            }
        }
        if (mem == 3)
        {
            System.out.println("Your fees will be 70$");
            System.out.println("Would you like to pay now ? 1.Yes , 0.No");
            boolean answer = scan.hasNextShort();
            if (answer == true)
            {
                System.out.println("Success!");
                fees.add(new Fees(id, 70));
                return;
            }
            else
            {
                System.out.println("See You another time!");
                return;
            }
        }
        else
        {
            System.out.println("Sorry, you entered a wrong number. Try again");
            payfees();
        }

    }

    public static void customerdetails()
    {
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        for (Customer customer : customers)
        {
            if (customer.getGarageid() == id)
            {
                System.out.println(customer.toString());
            }
        }
    }
    public static void vehicledetails()
    {
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getGarageid() == id)
            {
                System.out.println(vehicle.toString());
            }
        }
    }
    public static void displaysales()
    {
        if (fees.size() < 1)
        {
            System.out.println("No Fees have been recorded please use function 3 to add Membership for users");
            return;
        }
        for (Fees fees :fees)
        {
            System.out.println("User: "+ fees.getGarageid()+" Has Paid:"+fees.getFees());
        }
    }
    public static void displaycustomers()
    {
        for (Customer customer : customers)
        {
            System.out.println(customer.toString());
        }
    }
    public static void displayvehicles()
    {
        System.out.println("Enter Your Garage ID: ");
        int id = scan.nextInt();
        for (Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle.toString());
        }
    }
}
