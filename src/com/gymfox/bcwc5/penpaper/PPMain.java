package com.gymfox.bcwc5.penpaper;

import java.util.Scanner;

public class PPMain {
    public static void main(String[] args) throws
            OutOfSpaceException, OutOfInkException {
        Paper paper = new Paper();
        Pen parker = new Pen();
        String text;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the text: ");
        text = in.nextLine();
        parker.refill();
        parker.write(paper, text);
        paper.show();
    }
}
