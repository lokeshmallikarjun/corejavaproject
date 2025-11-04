package com.edubridge;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        // Create Configuration and build SessionFactory
        Configuration con = new Configuration();
        con.configure("Hibernate.cfg.xml"); //Make sure file name matches exactly (case-sensitive)
        SessionFactory factory = con.buildSessionFactory();

        //  Open a Hibernate session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        //  Create Scanner to take user input
      
        Scanner sc = new Scanner(System.in);

        //  Create Student object and set values
        Student student = new Student();

       System.out.print("Enter Student Name: ");
        student.setStudentName(sc.nextLine());

        System.out.print("Enter Student Address: ");
        student.setStudentAddress(sc.nextLine());

        System.out.print("Enter Student Contact Number: ");
        student.setStudentContact(sc.nextLine());

        System.out.print("Enter Student Grade: ");
        student.setStudentGrade(sc.nextLine());

        //Save object into DB
        session.save(student);
        tx.commit();

        System.out.println("\n Student record inserted successfully!");
        System.out.println(student); // print student details

        // Step 6: Close resources
        session.close();
        factory.close();
        sc.close();
    }
}
