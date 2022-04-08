package com.shelfproject;

public class ShelfSort {

    private ShelfSort() {
    }

    public static void sort(int[] arr, int index) {
        int[] lengthCounter = new int[15];
        int[] tempdup = new int[index];
        int dupCounter = 0;
        int insertionSort = 0;
        int[][] dimensionalArray = new int[11][index];
        dimensionalArray[1][0] = -1;
        tempdup[0] = 2147483590;

        for (int i = 0; i < arr.length; i++) {
            String c = "" + arr[i];

            if (c.length() <= 2) {
                lengthCounter[1] = lengthCounter[1] + 1;
            } else {
                lengthCounter[c.length()] = lengthCounter[c.length()] + 1;
            }

            if (arr[i] == dimensionalArray[1][arr[i]]) {
                dupCounter++;
                insertionSort = dupCounter;

                while (true) {
                    if (insertionSort != 0 && arr[i] < tempdup[insertionSort - 1]) {
                        tempdup[insertionSort] = tempdup[insertionSort - 1];
                        insertionSort--;
                    } else {
                        tempdup[insertionSort] = arr[i];
                        break;
                    }
                }
            } else {
                if (c.length() <= 2) {
                    dimensionalArray[1][arr[i]] = arr[i];
                } else {
                    int x = Character.getNumericValue(c.charAt(0) - 1);
                    String y = "" + x + c.substring(1);

                    if (arr[i] == dimensionalArray[c.length()][Integer.parseInt(y)]) {
                        dupCounter++;
                        insertionSort = dupCounter;

                        while (true) {
                            if (insertionSort != 0 && arr[i] < tempdup[insertionSort - 1]) {
                                tempdup[insertionSort] = tempdup[insertionSort - 1];
                                insertionSort--;
                            } else {
                                tempdup[insertionSort] = arr[i];
                                break;
                            }
                        }
                    } else {
                        dimensionalArray[c.length()][Integer.parseInt(y)] = arr[i];
                    }
                }
            }
        }

        int[] duplicated = new int[dupCounter];
        if (dupCounter >= 1) {
            System.arraycopy(tempdup, 0, duplicated, 0, dupCounter);
        }

        merge(dimensionalArray, arr, lengthCounter, duplicated);
    }

    private static void merge(int[][] arrr, int[] arr, int[] lenArray, int[] dup) {
        int index = 0;
        int hitorgap = 0;
        int indexof = 1;
        int dupIndex = 0;
        int lengthCounter = 0;
        boolean dupflag = dup.length > 0;

        while (index < arr.length) {
            if (lengthCounter >= lenArray[indexof]) {
                indexof = indexof + 1;
                lengthCounter = 0;
                hitorgap = 0;
            } else if ((indexof > 1 && arrr[indexof][hitorgap] == 0)
                    || arrr[indexof][hitorgap] == 0 && hitorgap > 0
                    || arrr[indexof][hitorgap] == -1) {
                hitorgap++;
            } else {
                if (indexof <= 2) {
                    lengthCounter++;
                    arr[index] = arrr[1][hitorgap];
                    index++;
                    hitorgap++;
                } else {
                    lengthCounter++;
                    arr[index] = arrr[indexof][hitorgap];
                    index++;
                    hitorgap++;
                }

                if (dupflag && dup[dupIndex] == arr[index - 1]) {
                    while (dup[dupIndex] == arr[index - 1]) {
                        arr[index] = arr[index - 1];
                        index++;
                        lengthCounter++;
                        if (dupIndex != dup.length - 1) {
                            dupIndex++;
                        } else {
                            dupflag = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}
