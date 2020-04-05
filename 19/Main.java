package com.company;

import java.io.*;

public class Main {

 	/*
	* Всякий раз, когда Гоша просит Лизу потусоваться, она занята домашним заданием.
	* Гоша хочет помочь ей закончить это быстрее. Можете ли вы помочь Гоше понять домашнее
	* задание Лизы, чтобы она могла погулять с ним?
	* Рассмотрим массив различных целых чисел. Можно менять местами любые два элемента массива
	* любое количество раз. Массив "красив", если сумма разностей двух соседних элементов минимальна.
	* sum(|qrr[i] - arr[i - 1]|) -> min
	* Определите минимальное количество перестановок, которые должны быть выполнены
	* для того, чтобы сделать массив "красивым".
	*
	* 1 <= n <= 10e5
	* 1 <= qrr[i] <= 2*10e9
	*
	* Пример: 4
	*         2 5 3 1
	* Ответ: 2
	*        1 <=> 2, 2 <=> 5
	*
	* Пример: 3
	*         2 3 1
	* Ответ: 1
	*	 1 <=> 2
	*/

    public static void main(String[] args) throws IOException {
        System.out.println("Main thread started...");
        int n = 6;

        int[] arr = new int[n];

        String[] arrItems = {"2","8","7","4","1","6"};

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        Thread t = new Thread(() ->{
            System.out.println("second thread started...");
            Solution solution = new Solution();
            solution.setArr(arr);
            solution.calc();
            int result = solution.getResult();

            System.out.println (result);
            System.out.println("second thread closed");
        }){{start();}};

        try{
            t.join();
        }
        catch(InterruptedException e){
            System.out.println("second thread has been interrupted");
        }
        System.out.println("Main thread closed");
    }
}