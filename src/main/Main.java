package main;

import models.Bibleapi;
import tasks.AddingInList;
import tasks.ExecuteQuery;
import tasks.GeneratingFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner read = new Scanner(System.in);
        String search1 = "";
        //String search2 = "";
        //String menu = """
        //LANGUAGE - NAME - IDENTIFIER
        //English	- King James Version - kjv
        // Portuguese - João Ferreira de Almeida - almeida
        // """;
        ExecuteQuery executeQuery = new ExecuteQuery();
        Bibleapi newText = null;

        AddingInList addingText = new AddingInList();


        while (!search1.equalsIgnoreCase("leave")){
            //System.out.println(menu);
            System.out.println("Type the book of Bible, chapter and verse, like this example: John 3:16, or type leave to finish aplication: ");

            search1 = read.nextLine();

            if (search1.equalsIgnoreCase("leave")){
                break;
            }

            // System.out.println("Now type a translation of Bible, typing the translation id, according to menu above: ");
            //search2 = read.nextLine();

            try {
                newText = executeQuery.searchText(search1);


                addingText.saveText(newText);
                System.out.println(newText);

                //json = json.replace("[", "(");

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please verify if the parameter of search is correct");
            }

        }

        GeneratingFile generator = new GeneratingFile();
        System.out.println(addingText);
        generator.saveJson(addingText);

    }
}