import java.util.*;
import java.lang.*;

public class Main
{
    public interface Inter
    {
        public String getName();
        public String getAddr();
        public void display();
    }

    public static class User
    {
        protected String name;
        protected String category;
        protected String address;
        protected int reward;
    }

    public static class Company
    {
        protected float compbalance;
        protected float delcharges;

        public Company()
        {
            this.compbalance = 0;
            this.delcharges = 0;
        }

        public void display()
        {
            System.out.println("Total Company balance - INR " + compbalance + "/-");
            System.out.println("Total Delivery Charges Collected - INR " + delcharges + "/-");
        }
    }

    public static class Restaurant extends User implements Inter
    {
        protected int numorders;
        public ArrayList<String[]> menu = new ArrayList<>();
        protected float discount;
        
        public Restaurant(String name,String category,String address)
        {
            this.name = name;
            this.category = category;
            this.address = address;
            this.numorders = 0;
            this.reward = 0;
            this.discount = 0;
        }

        public String getName()
        {
            return name;
        }
        public String getAddr()
        {
            return address;
        }
        public int getNumOrders()
        {
            return numorders;
        }

        public void display()
        {
            System.out.println(name + " (" + category + ") | Address: " + address + " | Total orders: " + numorders);
        }
    }

    public static class Customer extends User implements Inter
    {
        protected float balance;
        public ArrayList<String[]> cart = new ArrayList<>();
        public ArrayList<String> history = new ArrayList<>();

        public Customer(String name,String category,String address)
        {
            this.name = name;
            this.category = category;
            this.address = address;
            this.balance = 1000;
            this.reward = 0;
        }
        
        public String getName()
        {
            return name;
        }
        public String getAddr()
        {
            return address;
        }
        public float getBalance()
        {
            return balance;
        }

        public void display()
        {
            System.out.println(name + " (" + category + ") | Address: " + address + " | Balance: " + balance + "/-");
        }
    }

    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        Restaurant resarray[] = new Restaurant[5];
        Customer cusarray[] = new Customer[5];
        Company company = new Company();

        resarray[0] = new Restaurant("Shah","Authentic","Delhi 6");
        resarray[1] = new Restaurant("Ravi's","normal","New Delhi");
        resarray[2] = new Restaurant("The Chinese","Authentic","Gurgaon");
        resarray[3] = new Restaurant("Wang's","Fast Food","Noida");
        resarray[4] = new Restaurant("Paradise","normal","Hauz Khas");

        cusarray[0] = new Customer("Ram","Elite","123, New Delhi");
        cusarray[1] = new Customer("Sam","Elite","2541, Sector 2, Noida");
        cusarray[2] = new Customer("Tim","Special","977, Sector-44, Gurgaon");
        cusarray[3] = new Customer("Kim","normal","4th street, Noida");
        cusarray[4] = new Customer("Jim","normal","A block, Hauz Khas");
        
        int op = 0;
        do
        {
            System.out.println("Welcome to Zotato:");
            System.out.println("    1) Enter as Restaurant Owner");
            System.out.println("    2) Enter as Customer");
            System.out.println("    3) Check User Details");
            System.out.println("    4) Company Account Details");
            System.out.println("    5) Exit");
            op = inp.nextInt();

            switch(op)
            {
                case 1:
                    int op1 = 0;
                    System.out.println("Choose Restaurant");
                    System.out.println("    1) Shah (Authentic)");
                    System.out.println("    2) Ravi's");
                    System.out.println("    3) The Chinese (Authentic)");
                    System.out.println("    4) Wang's (Fast Food)");
                    System.out.println("    5) Paradise");
                    op1 = inp.nextInt();

                    int op3 = 0;
                    do {
                        System.out.println("Welcome " + resarray[op1-1].getName());
                        System.out.println("    1) Add item");
                        System.out.println("    2) Edit item");
                        System.out.println("    3) Print Rewards");
                        System.out.println("    4) Discount on bill value");
                        System.out.println("    5) Exit");
                        op3 = inp.nextInt();

                        switch(op3)
                        {
                            case 1:
                                String n = inp.nextLine();
                                System.out.println("Enter food item details");
                                System.out.println("Food name:");
                                n = inp.nextLine();
                                System.out.println("item price:");
                                String p = inp.nextLine();
                                System.out.println("item quantity:");
                                String q = inp.nextLine();
                                System.out.println("item category:");
                                String c = inp.nextLine();
                                System.out.println("Offer:");
                                String o = inp.nextLine();

                                int index = resarray[op1-1].menu.size() + 1;
                                String toput[] = {Integer.toString(index),n,p,q,o,c};
                                resarray[op1-1].menu.add(toput);
                                System.out.println(index+" "+n+" "+p+" "+q+" "+o+"% off "+c);
                                break;
                            case 2:
                                int op4 = 0;
                                System.out.println("Choose item by code");
                                for(int j=0;j<resarray[op1-1].menu.size();j++)
                                {
                                    String b[] = resarray[op1-1].menu.get(j);
                                    System.out.println((j+1)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                }
                                op4 = inp.nextInt();

                                int op5 = 0;
                                System.out.println("Choose an attribute to edit");
                                System.out.println("    1) Name");
                                System.out.println("    2) Price");
                                System.out.println("    3) Quantity");
                                System.out.println("    4) Category");
                                System.out.println("    5) Offer");
                                op5 = inp.nextInt();

                                switch(op5)
                                {
                                    case 1:
                                        n = inp.nextLine();
                                        System.out.println("Enter the new name - ");
                                        String changeS = inp.nextLine();
                                        resarray[op1-1].menu.get(op4-1)[1] = changeS;
                                        String b[] = resarray[op1-1].menu.get(op4-1);
                                        System.out.println((op4)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                        break;
                                    case 2:
                                        System.out.println("Enter the new price - ");
                                        float changeF = inp.nextFloat();
                                        resarray[op1-1].menu.get(op4-1)[2] = Float.toString(changeF);
                                        b = resarray[op1-1].menu.get(op4-1);
                                        System.out.println((op4)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                        break;
                                    case 3:
                                        System.out.println("Enter the new quantity - ");
                                        int changeI = inp.nextInt();
                                        resarray[op1-1].menu.get(op4-1)[3] = Integer.toString(changeI);
                                        b = resarray[op1-1].menu.get(op4-1);
                                        System.out.println((op4)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                        break;
                                    case 4:
                                        n = inp.nextLine();
                                        System.out.println("Enter the new category - ");
                                        changeS = inp.nextLine();
                                        resarray[op1-1].menu.get(op4-1)[5] = changeS;
                                        b = resarray[op1-1].menu.get(op4-1);
                                        System.out.println((op4)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                        break;
                                    case 5:
                                        System.out.println("Enter the new offer - ");
                                        changeF = inp.nextFloat();
                                        resarray[op1-1].menu.get(op4-1)[4] = Float.toString(changeF);
                                        b = resarray[op1-1].menu.get(op4-1);
                                        System.out.println((op4)+" "+resarray[op1-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                        break;
                                }
                                break;
                            case 3:
                                System.out.println("Reward Points: " + resarray[op1-1].reward);
                                break;
                            case 4:
                                System.out.println("Offer on bill value - ");
                                resarray[op1-1].discount = inp.nextFloat();
                                break;
                            case 5:
                                break;
                        }

                    }while(op3!=5);
                    break;
                case 2:
                    op1 = 0;
                    System.out.println("    1) Ram (Elite)");
                    System.out.println("    2) Sam (Elite)");
                    System.out.println("    3) Tim (Special)");
                    System.out.println("    4) Kim");
                    System.out.println("    5) Jim");
                    op1 = inp.nextInt();

                    op3 = 0;
                    do {
                        System.out.println("Welcome " + cusarray[op1-1].getName());
                        System.out.println("Customer Menu");
                        System.out.println("    1) Select Restaurant");
                        System.out.println("    2) checkout cart");
                        System.out.println("    3) Reward won");
                        System.out.println("    4) print the recent orders");
                        System.out.println("    5) Exit");
                        op3 = inp.nextInt();

                        switch(op3)
                        {
                            case 1:
                                int op4 = 0;
                                System.out.println("Choose Restaurant");
                                System.out.println("    1) Shah (Authentic)");
                                System.out.println("    2) Ravi's");
                                System.out.println("    3) The Chinese (Authentic)");
                                System.out.println("    4) Wang's (Fast Food)");
                                System.out.println("    5) Paradise");
                                op4 = inp.nextInt();

                                int op5 = 0;
                                System.out.println("Choose item by code");
                                for(int j=0;j<resarray[op4-1].menu.size();j++)
                                {
                                    String b[] = resarray[op4-1].menu.get(j);
                                    System.out.println((j+1)+" "+resarray[op4-1].name+" - "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+"% off "+b[5]);
                                }
                                op5 = inp.nextInt();

                                System.out.println("Enter item quantity - ");
                                int quan = inp.nextInt();
                                int index = cusarray[op1-1].cart.size() + 1;
                                String n = resarray[op4-1].menu.get(op5-1)[1];
                                String p = resarray[op4-1].menu.get(op5-1)[2];
                                String q = Integer.toString(quan);
                                String o = resarray[op4-1].menu.get(op5-1)[4];
                                String c = resarray[op4-1].menu.get(op5-1)[5];
                                String toput[] = {Integer.toString(index),resarray[op4-1].name,n,p,q,o,c,Integer.toString(op4-1),Integer.toString(op5-1)};
                                cusarray[op1-1].cart.add(toput);
                                System.out.println("Items added to cart");
                                break;
                            case 2:
                                System.out.println("Items in cart - ");
                                float sum = 0;
                                int qauntotal = 0;
                                for(int k=0;k<cusarray[op1-1].cart.size();k++)
                                {
                                    String b[] = cusarray[op1-1].cart.get(k);
                                    System.out.println((k+1)+" "+b[1]+" - "+b[2]+" - "+b[3]+" - "+b[4]+" - "+b[5]+"% off ");
                                    cusarray[op1-1].history.add("Bought item: "+b[2]+", quantity: "+b[4]+" from "+b[1]);
                                    float indivamount = Float.parseFloat(b[3]);
                                    int qqq = Integer.parseInt(b[4]);
                                    float disc = 1 - (Float.parseFloat(b[5])/100);
                                    sum += indivamount*qqq*disc;
                                    qauntotal += qqq;

                                    int originalq = Integer.parseInt(resarray[Integer.parseInt(b[7])].menu.get(Integer.parseInt(b[8]))[3]);
                                    int subq = Integer.parseInt(cusarray[op1-1].cart.get(k)[4]);
                                    resarray[Integer.parseInt(b[7])].menu.get(Integer.parseInt(b[8]))[3] = Integer.toString(originalq-subq);
                                }

                                float disc2 = 0;
                                int storey = -1;
                                String cat = "";
                                for(int y=0;y<resarray.length;y++)
                                {
                                    if(resarray[y].name.equals(cusarray[op1-1].cart.get(0)[1]))
                                    {
                                        disc2 = (1 - (resarray[y].discount/100));
                                        cat = resarray[y].category;
                                        storey = y;
                                    }
                                }
                                sum = sum*disc2;

                                if(cat.equals("Authentic") && sum>100)
                                {
                                    sum -= 50;
                                }

                                company.compbalance += 0.01*sum;

                                int delamount = 0;
                                if(cusarray[op1-1].category.equals("Elite"))
                                {
                                    delamount = 0;
                                }
                                if(cusarray[op1-1].category.equals("Special"))
                                {
                                    delamount = 20;
                                }
                                if(cusarray[op1-1].category.equals("normal"))
                                {
                                    delamount = 40;
                                }

                                company.delcharges += delamount;
                                float amount = sum + delamount;

                                if(cusarray[op1-1].category.equals("Elite"))
                                {
                                    if(amount>200)
                                    {
                                        amount -= 50;
                                    }
                                }
                                if(cusarray[op1-1].category.equals("Special"))
                                {
                                    if(amount>200)
                                    {
                                        amount -= 25;
                                    }
                                }

                                int rew = 0;
                                if(cat.equals("Authentic"))
                                {
                                    rew += 25*((int)amount/200);
                                }
                                if(cat.equals("Fast Food"))
                                {
                                    rew += 10*((int)amount/150);
                                }
                                if(cat.equals("normal"))
                                {
                                    rew += 5*((int)amount/100);
                                }

                                cusarray[op1-1].reward += rew;
                                cusarray[op1-1].balance += rew;
                                resarray[storey].reward += rew;

                                System.out.println("Delivery charge - INR "+delamount+"/-");
                                System.out.println("Total order value - INR "+amount+"/-");

                                System.out.println("    1) Proceed to checkout");
                                int misc = inp.nextInt();

                                cusarray[op1-1].history.add("Total price: INR "+amount);
                                cusarray[op1-1].history.add("Delivery Charges: INR "+delamount);

                                for(int k=cusarray[op1-1].cart.size()-1;k>=0;k--)
                                {
                                    cusarray[op1-1].cart.remove(k);
                                }

                                resarray[storey].numorders += 1;
                                cusarray[op1-1].balance -= amount;
                                System.out.println(qauntotal+" items successfully bought for INR "+amount+"/-");
                                break;
                            case 3:
                                System.out.println("Reward Points won: " + cusarray[op1-1].reward);
                                break;
                            case 4:
                                for(int l=0;l<cusarray[op1-1].history.size();l++)
                                {
                                    String b = cusarray[op1-1].history.get(l);
                                    System.out.println(b);
                                }
                                break;
                            case 5:
                                break;
                        }

                    }while(op3!=5);
                    break;
                case 3:
                    op1 = 0;
                    System.out.println("    1) Customer List");
                    System.out.println("    2) Restaurant List");
                    op1 = inp.nextInt();

                    switch(op1)
                    {
                        case 1:
                            op3 = 0;
                            System.out.println("    1. Ram");
                            System.out.println("    2. Sam");
                            System.out.println("    3. Tim");
                            System.out.println("    4. Kim");
                            System.out.println("    5. Jim");
                            op3 = inp.nextInt();
                            cusarray[op3-1].display();
                            break;
                        case 2:
                            op3 = 0;
                            System.out.println("    1. Shah");
                            System.out.println("    2. Ravi's");
                            System.out.println("    3. The Chinese");
                            System.out.println("    4. Wang's");
                            System.out.println("    5. Paradise");
                            op3 = inp.nextInt();
                            resarray[op3-1].display();
                            break;
                    }
                    break;
                case 4:
                    company.display();
                    break;
                case 5:
                    break;
            }

        }while(op!=5);
    }
}