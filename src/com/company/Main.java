package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Finder finder = new Finder();

        while (!finder.end){
            finder.startDialog();
        }
    }
}
