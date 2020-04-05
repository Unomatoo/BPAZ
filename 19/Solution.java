package com.company;

public class Solution {

    private int[] arr;
    private int[] arrCopy;
    private int ascendingResult = 0;
    private int descendingResult = 0;

    private int result = 0;

    public Solution() {}

    public void calc() {
        //считаем по возрастанию
        for (int min = 0; min < arr.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            if (min != least) {
                int tmp = arr[min];
                arr[min] = arr[least];
                arr[least] = tmp;
                ascendingResult++;
            }
        }

        //считаем по убыванию
        for (int min = arrCopy.length - 1; min > 0; min--) {
            int least = min;
            for (int j = min - 1; j >= 0; j--) {
                if (arrCopy[j] < arrCopy[least]) {
                    least = j;
                }
            }
            if (min != least) {
                int tmp = arrCopy[min];
                arrCopy[min] = arrCopy[least];
                arrCopy[least] = tmp;
                descendingResult++;
            }
        }

        if (descendingResult < ascendingResult){
            setResult(descendingResult);
        } else {
            setResult(ascendingResult);
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
        arrCopy = arr.clone();
    }
}
