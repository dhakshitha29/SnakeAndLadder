package player;

import java.util.Scanner;

public class Player {
    private String pname;
    private String email;
    private String contactno;
    private int age;
    public void setPlayerDetails(String pname,String email,String contactno,int age){
        this.pname=pname;
        this.email=email;
        this.contactno=contactno;
        this.age=age;
    } 
    public void setPlayerName(String pname){
        this.pname=pname;
    }  
    // public void setEmail(String email){
    //     this.email=email;
    // }
    // public void setPhnno(String contactno){
    //     this.contactno=contactno;
    // }
    // public void setAge(int age){
    //     this.age=age;
    // }

    public String getPlayerName(){
        return this.pname;
    }
    public void getPlayerDetails(){
        System.out.println("Player Name :"+this.pname);
        System.out.println("Player emailId :"+this.email);
        System.out.println("Player Contact Number :"+this.contactno);
        System.out.println("Player Age :"+this.age);
    }

    public void setPlayerInputDetails(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Hey Player:)!\nEnter your details");
        System.out.print("Name :");
        String name=sc.next();
        System.out.print("emailID :");
        String email=sc.next();
        System.out.print("Contact No :");
        String contactno=sc.next();
        System.out.print("Age :");
        int age=sc.nextInt();

        this.setPlayerDetails(name, email, contactno, age);
    }
}
