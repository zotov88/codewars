package kyu_3.battleship_field_validator;

import java.util.*;

public class Kata {

    public static void main(String[] args) {
        int[][] battleField = {
                {1, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(fieldValidator(battleField));
    }

    public static boolean fieldValidator(int[][] field) {
        BattleFieldValidator validator = new BattleFieldValidator(field);
        return validator.isValidate();
    }

    static class BattleFieldValidator {

        private final int[][] field;
        private final Map<Integer, Integer> shipMap = new HashMap<>();
        private int lastShipDeck;


        public BattleFieldValidator(int[][] field) {
            this.field = field;
        }

        public boolean isValidate() {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (isHorizontalShip(i, j)) {
                        if (scanShipHorizontal(i, j) && checkBorderHorizontalShip(i, j)) {
                            fillHorizontalShipByZero(i, j);
                        } else {
                            return false;
                        }
                    }
                    if (isVerticalShip(i, j)) {
                        if (scanShipVertical(i, j) && checkBorderVerticalShip(i, j)) {
                            fillVerticalShipByZero(i, j);
                        } else {
                            return false;
                        }
                    }
                    if (isOneDeckShip(i, j)) {
                        if (checkBorderOneDeckShip(i, j)) {
                            field[i][j] = 0;
                        } else {
                            return false;
                        }
                    }
                    putToShipMap();
                    lastShipDeck = 0;
                }
            }

            System.out.println(shipMap);
            return isValidateCountOfShip();
        }

        private boolean isOneDeckShip(int i, int j) {
            return field[i][j] == 1;
        }

        private boolean isVerticalShip(int i, int j) {
            return field[i][j] == 1 && i + 1 < field.length && field[i + 1][j] == 1;
        }

        private boolean isHorizontalShip(int i, int j) {
            return field[i][j] == 1 && j + 1 < field[i].length && field[i][j + 1] == 1;
        }

        private boolean checkBorderVerticalShip(int i, int j) {
            int upVertical = i == 0 ? i : i - 1;
            int downVertical = i + lastShipDeck - 1;
            downVertical = downVertical == field.length - 1 ? downVertical : downVertical + 1;
            int leftHorizontal = j == 0 ? j : j - 1;
            int rightHorizontal = j == field[i].length - 1 ? j : j + 1;

            return getSum(upVertical, downVertical, leftHorizontal, rightHorizontal) <= lastShipDeck;
        }

        private boolean checkBorderHorizontalShip(int i, int j) {
            int upVertical = i == 0 ? i : i - 1;
            int downVertical = i == field.length - 1 ? i : i + 1;
            int leftHorizontal = j == 0 ? j : j - 1;
            int rightHorizontal = j + lastShipDeck - 1;
            rightHorizontal = rightHorizontal == field[i].length - 1 ? rightHorizontal : rightHorizontal + 1;

            return getSum(upVertical, downVertical, leftHorizontal, rightHorizontal) <= lastShipDeck;
        }

        private boolean checkBorderOneDeckShip(int i, int j) {
            lastShipDeck = 1;
            int upVertical = i == 0 ? i : i - 1;
            int downVertical = i == field.length - 1 ? i : i + 1;
            int leftHorizontal = j == 0 ? j : j - 1;
            int rightHorizontal = j == field[i].length - 1 ? j : j + 1;

            return getSum(upVertical, downVertical, leftHorizontal, rightHorizontal) <= lastShipDeck;
        }

        private int getSum(int upVertical, int downVertical, int leftHorizontal, int rightHorizontal) {
            int sum = 0;
            for (int k = upVertical; k <= downVertical; k++) {
                for (int m = leftHorizontal; m <= rightHorizontal; m++) {
                    sum += field[k][m];
                }
            }
            return sum;
        }

        private void fillVerticalShipByZero(int i, int j) {
            for (int k = 0; k < i + lastShipDeck; k++) {
                field[k][j] = 0;
            }
        }

        private void fillHorizontalShipByZero(int i, int j) {
            for (int k = j; k < j + lastShipDeck; k++) {
                field[i][k] = 0;
            }
        }

        private boolean scanShipVertical(int i, int j) {
            int deck = 1;
            while (i + 1 < field.length && field[++i][j] == 1) {
                deck++;
            }
            if (deck < 5) {
                lastShipDeck = deck;
                return true;
            }
            return false;
        }

        private boolean scanShipHorizontal(int i, int j) {
            int deck = 1;
            while (j + 1 < field[i].length && field[i][++j] == 1) {
                deck++;
            }
            if (deck < 5) {
                lastShipDeck = deck;
                return true;
            }
            return false;
        }

        private void putToShipMap() {
            if (!shipMap.containsKey(lastShipDeck)) {
                shipMap.put(lastShipDeck, 1);
            } else {
                shipMap.put(lastShipDeck, shipMap.get(lastShipDeck) + 1);
            }
        }

        public boolean isValidateCountOfShip() {
            List<Boolean> booleans = new ArrayList<>();
            booleans.add(shipMap.containsKey(1) && shipMap.get(1) == 4);
            booleans.add(shipMap.containsKey(2) && shipMap.get(2) == 3);
            booleans.add(shipMap.containsKey(3) && shipMap.get(3) == 2);
            booleans.add(shipMap.containsKey(4) && shipMap.get(4) == 1);

            return !booleans.contains(false);
        }

        private void print() {
            for (int[] ints : field) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }
}
