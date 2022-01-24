package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonGenerator {

    public static void main(String[] args) {
        String totalInput = "";
	    ArrayList<String> people = new ArrayList<String>();
        Scanner input = new Scanner(System.in);



        while(!totalInput.toString().equalsIgnoreCase("n")) {
            totalInput = SafeInput.getNonZeroLenString(input, "Give the persons information in the format: " +
                    "ID, FirstName, LastName, Title, YOB. Give 'N' to cancel");

            people.add(totalInput);
        }

        people.remove(people.size() - 1);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try {

            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String person : people) {
                writer.write(person, 0, person.length());

                writer.newLine();
            }

            writer.close();
            System.out.println("File has been written");


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
