import java.io.*;
class date
{
    String date,name;
    int d1,m1,y1,d=0,c,w;
    void input()throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter date in dd/mm/yyyy format");
        date=in.readLine();
        c=d1=Integer.parseInt(date.substring(0,2));
        m1=Integer.parseInt(date.substring(2,4));
        y1=Integer.parseInt(date.substring(4));
        System.out.println("Enter day on 1st January of the corresponding year");
        name=in.readLine();
       if(name.equals("sunday"))
       w=0;
       else if(name.equals("monday"))
       w=1;
       else if(name.equals("tuesday"))
       w=2;
       else if(name.equals("wednesday"))
       w=3;
       else if(name.equals("thursday"))
       w=4;
       else if(name.equals("friday"))
       w=5;
       else if(name.equals("saturday"))
       w=6;
       else
       {
           System.out.println("Invalid input\nTry again");
           System.exit(0);
       }
    }
    void calculatedate()
    {
        int i;
        if(m1==2)
        {
            d1=d1+31;
        }
        else
        {
        for(i=1;i<=m1;i++)
        {
            if(i==1)
            d1=d1-1;
            else if(i==3||i==5||i==7||i==8||i==10||i==12)
             d=d+31;
             else if(i==2)
             {
                 if(y1%4==0)
                 d=29;
                 else
                 d=28;
             }
             else
             d=d+30;
        }
        }
        d1=d1+d;
    }
    void day()
    {
        int j,rem;String store;
        String arr[]={"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        j=d1+w;
        rem=j%7;
        if(m1==4||m1==9||m1==11)
        {
            if(rem+1==7)
            store=arr[0];
            else
            store=arr[rem];
        }
        else if(m1==6)
        {
            rem=rem%7;
            store=arr[rem+1];
        }
        else if(m1==2)
        {
            if(rem==0)
            {store=arr[0];}
            else
            {store=arr[rem-1];}
        }
        else
        store=arr[rem];
        System.out.println("Day on "+c+"/"+m1+"/"+y1+" is ="+store);
    }
    public static void main()throws IOException
    {
        date ob=new date();
        ob.input();
        ob.calculatedate();
        ob.day();
        }
    }