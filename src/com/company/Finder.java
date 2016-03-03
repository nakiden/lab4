package com.company;

import java.util.Enumeration;
import java.util.Scanner;
import java.io.File;

public class Finder {

    public String cd = "C:/";
    public boolean end = false;

    public void startDialog(){
        System.out.println();
        System.out.print(this.cd);
        String row[] = getCommandFromLine(readLine());
        String text = null;
        String cmd = row[0];
        try {
            text = row[1];
        } catch (Exception ex){

            //if (!cmd.equals("ls"))
            //System.out.print("Couldn't find a message after command");
        }


        commandHandler(cmd, text);
    }

    private String[] getCommandFromLine(String line){
        String [] array = line.split(" ");
        return array;
    }


    public String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private void commandHandler(String cmd, String text){

        Command request = Command.getType(cmd);

        switch(request) {
            case CD:
                changeDirectory(text);
                break;
            case LS:
                showFilesList();
                break;
            case EXIT:
                closeFinder();
                break;
            case HELP:
                showFullCommandsList();
                break;
            default:
                handleErrorMessage();
                break;
        }
    }

    private void changeDirectory(String text){

        if (text != null) System.out.println(text);
    }

    private void showFilesList(){
        File folder = new File(this.cd);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

    private void closeFinder(){
        this.end = true;
    }

    private void showFullCommandsList(){

        for (Command cmd : Command.values()) {
            System.out.print(cmd + ", ");
        }

        System.out.print(" to be continued");
    }

    private void handleErrorMessage(){
        System.out.println("Wrong command, use help to show the full list of commands");
    }

    public enum Command {
        CD("cd"),
        LS("ls"),
        EXIT("exit"),
        HELP("help"),
        ERROR("error");

        private String typeValue;

        private Command(String type) {
            typeValue = type;
        }

        static public Command getType(String pType) {

            for (Command type: Command.values()) {
                if (type.getTypeValue().equals(pType)) {
                    return type;
                }
            }
            return ERROR;
        }

        public String getTypeValue() {
            return typeValue;
        }

    }
}

