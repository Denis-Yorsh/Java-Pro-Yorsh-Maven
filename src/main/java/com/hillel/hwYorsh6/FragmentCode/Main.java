package com.hillel.hwYorsh6.FragmentCode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class Ball {
    }

    private static class Board {
        private List balls;


        public Board() {
            // when creating an object in the constructor, it was not declared a reference this.balls
            this.balls = new ArrayList<>(List.of(new Ball(), new Ball(), new Ball()));
        }

        public int count() {
            return balls.size();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.count());
    }
}