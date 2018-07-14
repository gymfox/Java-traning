package com.gymfox.bcwc5.gun;

public class GunMain {
    public static void main(String[] args) throws OutOfRoundsException, GunIsNotReadyException {
        Gun beretta = new Gun("Beretta", 5);

        System.out.println(beretta);

        System.out.println("Reloaded...");
        beretta.reload();
        System.out.println("Preparing...");
        beretta.prepare();

        System.out.println(beretta);

        for ( int i = 0; i < 6; i++ ) {
            beretta.shoot();
        }

    }
}
