import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
class Player{
    String name="";
    String country="";
    int age=0;
    double height=0.0;
    String club="";
    String position="";
    int number =0;
    double salary=0.0;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }


    public double getHeight() {
        return height;
    }

    public String getClub() {
        return club;
    }


    public String getPosition() {
        return position;
    }


    public int getNumber() {
        return number;
    }

    public double getSalary() {
        return salary;
    }


    Player(String name, String country, int age, double height, String
           club, String position, int number, double salary)
    {
        this.name=name;
        this.country=country;
        this.age=age;
        this.height=height;
        this.club=club;
        this.position=position;
        this.number=number;
        this.salary=salary;
    }
    Player()
    {

    }
}
public class Football {
    ArrayList<Player>playerinfo=new ArrayList<>();
    Player p=new Player();
    ArrayList<String>clubplayer=new ArrayList<>();
    Set<String>st;
   /// HashMap<String,Integer>clubwiseplayer=new HashMap<>();
    Football()
    {

    }
    public void CreateDatabase() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("F:\\BUET-LEVEL-TERM\\Java(19 batch)\\Java Term Project (Part 1)\\players.txt"));
        String str;
        // ArrayList<Player>playerinfo=new ArrayList<>();
        String name;
        String country;
        int age;
        double height;
        String club;
        String position;
        int number;
        double salary;
        String [] token;
        while ((str = in.readLine()) != null) {
            token=str.split(",");
            name=token[0];
            country=token[1];
            age=Integer.parseInt(token[2]);
            height=Double.parseDouble(token[3]);
            club=token[4];
            position=token[5];
            number=Integer.parseInt(token[6]);
            salary=Double.parseDouble(token[7]);
            Player player=new Player(name,country,age,height,club,position,number,salary);
            playerinfo.add(player);
        }
      //  ArrayList<String>clubplayer=new ArrayList<>();
        for (int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);
            clubplayer.add(p.getClub());
        }
        st=new HashSet<String>(clubplayer);
       /* for(String s:st)
        {
            System.out.println(s+" : "+Collections.frequency(clubplayer,s));
        }*/
    }
    public int clubwiseplayer(String c)
    {
        return Collections.frequency(clubplayer,c);
    }
    public void ClubWisePlayerCount()
    {
        for(String s:st)
        {
            System.out.print(s+":"+Collections.frequency(clubplayer,s));
            System.out.println();
        }
        SearchPlayers();
    }
    public void AllInfo()
    {
        System.out.print("Name : "+p.getName()+" "+"Country : "+p.getCountry()
                +" "+"Age : "+" "+p.getAge()+" "+"Height:  "+p.getHeight()+" "+
                "Club : "+p.getClub()+" "+"Position: "+p.getPosition()+
                " "+"Number : "+p.getNumber()+" "+"Salary : "+p.getSalary());
        System.out.println();
    }
    public void AllinfofromList()
    {
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);
            System.out.print(" "+p.getName()+" "+p.getCountry()+" "+p.getAge()+" "+
                    " "+p.getHeight()+" "+p.getClub()+" "+p.getPosition()+" "+
                    p.getNumber()+" "+p.getSalary());
            System.out.println();
        }
    }
    public void MainMenu()
    {
        System.out.println("Main Menu ");
        System.out.println("(1) Search Players\n(2) Search Clubs\n" +
                "(3) Add Player\n(4) Exit System");
        Scanner s=new Scanner(System.in);
        int op=s.nextInt();
        if(op==1)
        {
            SearchPlayers();
        }
        if(op==2)
        {
            SearchClubs();
        }
        if (op==3)
        {
            AddPlayer();
        }
        if(op==4)
        {
            System.exit(0);
        }
        else {
            System.out.println("Wrong !!!");
            MainMenu();
        }

    }
    public void SearchPlayers()
    {
        System.out.println("Player Searching Options");
        System.out.println("(1) By Player Name\n(2) By Club and Country\n" +
                "(3) By Position\n(4) By Salary Range\n(5) Country-wise Player count\n" +
                "(6) Back to Main Menu\n(7) Club-Wise Player-Count");
        Scanner s=new Scanner(System.in);
        int op=s.nextInt();
        if(op==1)
        {
            ByPlayerName();
        }
        if(op==2)
        {
            ByClubCountry();
        }
        if(op==3)
        {
            ByPosition();
        }
        if(op==4)
        {
            BySalary();
        }
        if(op==5)
        {
            CountryWiseCount();
        }
        if(op==6)
        {
            MainMenu();
        }
        if(op==7)
        {
            ClubWisePlayerCount();
        }
        else {
            System.out.println("Wrong!!");
            SearchPlayers();
        }
    }
    public void AddPlayer()
    {

        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        System.out.print("Enter Player Name : ");
        String name=scanner.nextLine();
        System.out.print("Enter Country Name : ");
        String country=scanner.nextLine();
        System.out.print("Enter Player's Age  : ");
        int age=scanner.nextInt();
        System.out.print("Enter Player's Height : ");
        double height=scanner.nextDouble();
        System.out.print("Enter Club Name : ");
        String club=scanner1.nextLine();
        System.out.print("Enter Player's Position Name : ");
        String position=scanner1.nextLine();
        System.out.print("Enter Player's  Number : ");
        int number=scanner1.nextInt();
        System.out.print("Enter Player's Weekly Salary : ");
        double salary=scanner1.nextDouble();
        if(clubwiseplayer(club)<=7)
        {
             Player p=new Player(name,country,age,height,club,position,number,salary);
             playerinfo.add(p);
             clubplayer.add(club);
             st.add(club);
            try {
                //String data = " Tutorials Point is a best website in the world";
                File f1 = new File("F:\\BUET-LEVEL-TERM\\Java(19 batch)\\Java Term Project (Part 1)\\players.txt");
                if(!f1.exists()) {
                    f1.createNewFile();
                }

                FileWriter fileWritter = new FileWriter(f1.getName(),true);
                BufferedWriter bw = new BufferedWriter(fileWritter);
                bw.write('\n');
                bw.write(p.getName()+","+p.getCountry()+","+p.getAge()+","+
                        p.getHeight()+","+p.getClub()+","+p.getPosition()+","
                        +p.getNumber()+","+p.getSalary());
                bw.close();
                // System.out.println("Done");
            } catch(IOException e){
                e.printStackTrace();
            }
             AllinfofromList();
             MainMenu();
        }
       else {
            System.out.println(club+" "+"has "+Collections.frequency(clubplayer,club)+
                    " "+"players which is maximum. ");
            MainMenu();
        }
    }
    public void SearchClubs()
    {
        System.out.println("Club Searching Options");
        System.out.println("(1) Player with maximum Salary of a Club\n" +
                "(2) Player with Maximum Age of a Club\n" +
                "(3) Player with maximum Height of a Club\n" +
                "(4) Total Yearly Salary of a Club\n" +
                "(5) Back to Main Menu");
        Scanner s=new Scanner(System.in);
        int op=s.nextInt();
        if(op==1)
        {
            maxsalaryclub();
        }
        if(op==2)
        {
            maxageclub();
        }
        if(op==3)
        {
            //ByPosition();
            maxheightclub();
        }
        if(op==4)
        {
           TotalSalary();
        }
        if(op==5)
        {
            MainMenu();
        }
        else {
            System.out.println("Wrong!!");
            SearchClubs();
        }
    }
    public void ByPlayerName()
    {
        Scanner scanner=new Scanner(System.in);
        int flag=0;
        System.out.println("Enter Player Name : ");
        String player=scanner.nextLine();
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);
            if(p.getName().equalsIgnoreCase(player)) {
                flag=1;
                break;
            }

        }
        if(flag==0)
        {
            System.out.println("No Such Player With This Name ");
            SearchPlayers();
        }
        else {
            AllInfo();
            SearchPlayers();
        }
    }
    public void ByClubCountry()
    {
         Scanner s=new Scanner(System.in);
         System.out.print("Enter country : ");
         String cn=s.nextLine();
        System.out.print("Enter Club : ");
         String cl=s.nextLine();

        String cntry="";
        int flag=0;
        for(int i=0;i<playerinfo.size();i++) {
            p = playerinfo.get(i);
            cntry=p.getCountry();
            if(cntry.equalsIgnoreCase(cn) && p.getClub().equalsIgnoreCase(cl))
            {
                System.out.println(p.getName()+" "+p.getCountry()+" "+p.getClub());
                flag=1;
            }
            else if(cntry.equalsIgnoreCase(cn) && cl.equalsIgnoreCase("ANY"))
            {
                System.out.println(p.getName()+" "+p.getClub()+" "+p.getCountry());

                flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("No Such Player With this country and Club");
        }
        SearchPlayers();
    }
    public void ByPosition()
    {
        Scanner scanner=new Scanner(System.in);
        String pos=scanner.nextLine();
        int flag=0;
        for(int i=0;i<playerinfo.size();i++)
        {

            p=playerinfo.get(i);
            if(p.getPosition().equalsIgnoreCase(pos))
            {
                flag=1;
                AllInfo();
            }
        }
        SearchPlayers();

    }
    public void BySalary()
    {
        Scanner scanner=new Scanner(System.in);
        int min,max;
        int flag=0;
        System.out.println("Enter minimum Range ");
        min=scanner.nextInt();
        System.out.println("Enter Maximum Range ");
        max=scanner.nextInt();
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);

            if(p.getSalary()>=min && p.getSalary()<=max)
            {
               // System.out.println(p.getName()+" "+p.getSalary());
                flag=1;
                AllInfo();

            }
        }
        if(flag==0)
        {
            System.out.println("No Salary in this Range !!");
        }
        SearchPlayers();
    }
    public void CountryWiseCount()
    {
        ArrayList<String>country=new ArrayList<>();
        for (int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);
            country.add(p.getCountry());
        }
        Set<String>st=new HashSet<String>(country);
        for(String s:st)
        {
            System.out.println(s+" : "+Collections.frequency(country,s));
        }
        SearchPlayers();
    }
    public void maxsalaryclub()
    {
        Scanner scanner=new Scanner(System.in);
        String club=scanner.nextLine();
        double maxsalary=-1;
        int flag=0;
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);

            if(p.getClub().equalsIgnoreCase(club))
            {
                maxsalary=(p.getSalary()>maxsalary)?p.getSalary():maxsalary;
                p=playerinfo.get(i);
                flag=1;
            }
        }
        if(flag==1)
        {
            for(int i=0;i<playerinfo.size();i++)
            {
                p=playerinfo.get(i);
                if(p.getClub().equalsIgnoreCase(club) && p.getSalary()==maxsalary)
                {
                    AllInfo();
                }
            }
            SearchClubs();
        }
        else {
            System.out.println("No such club found!!");
            SearchClubs();
        }
    }
    public void maxageclub()
    {
        Scanner scanner=new Scanner(System.in);
        String club=scanner.nextLine();
        int maxage=-1;
        int flag=0;
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);

            if(p.getClub().equalsIgnoreCase(club))
            {
                maxage=(p.getAge()>maxage)?p.getAge():maxage;
                flag=1;
            }
        }
        if(flag==1)
        {
            for(int i=0;i<playerinfo.size();i++)
            {
                p=playerinfo.get(i);
                if(p.getClub().equalsIgnoreCase(club) && p.getAge()==maxage)
                {
                    AllInfo();
                }
            }
            SearchClubs();
        }
        else {
            System.out.println("No Such Club with this Name");
            SearchClubs();
        }
    }
    public void maxheightclub()
    {
        Scanner scanner=new Scanner(System.in);
        String club=scanner.nextLine();
        double maxheight=-1;
        int flag=0;
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);
            if(p.getClub().equalsIgnoreCase(club))
            {
                maxheight=(p.getHeight()>maxheight)?p.getHeight():maxheight;
                flag=1;
            }
        }
        if(flag==1)
        {
            for(int i=0;i<playerinfo.size();i++)
            {
                p=playerinfo.get(i);
                if(p.getClub().equalsIgnoreCase(club) && p.getHeight()==maxheight)
                {
                    AllInfo();
                }
            }
            SearchClubs();
        }
        else {
            System.out.println("No Such Club with this name");
            SearchClubs();
        }
    }
    public void TotalSalary()
    {
        Scanner scanner=new Scanner(System.in);
        String club=scanner.nextLine();
        double totalsalary=0.0;
        int flag=0;
        for(int i=0;i<playerinfo.size();i++)
        {
            p=playerinfo.get(i);

            if(p.getClub().equalsIgnoreCase(club))
            {
                totalsalary+=p.getSalary();
                flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("No such Club Found !!");
            SearchClubs();
        }
        else {
            System.out.println("Total Yearly Salary of " + club + " is " + totalsalary * 52.0);
            SearchClubs();
        }
    }
    public static void main(String[] args) throws IOException {


        Football f=new Football();
        f.CreateDatabase();
        f.MainMenu();
    }
}
