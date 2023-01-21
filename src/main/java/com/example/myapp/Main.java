package com.example.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество доходов в день за месяц через пробел:");
            String[] receipts = reader.readLine().split("\\s+");
            System.out.println("Введите количество расходов в день за месяц через пробел:");
            String[] expenses = reader.readLine().split("\\s+");

            List<Double> receiptsDouble = new ArrayList<>();
            List<Double> expensesDouble = new ArrayList<>();

            Arrays.stream(receipts).forEach(s -> receiptsDouble.add(Double.parseDouble(s)));
            Arrays.stream(expenses).forEach(s -> expensesDouble.add(Double.parseDouble(s)));

            Double sumReceipts = 0.0;
            for (Double value : receiptsDouble) {
                sumReceipts += value;
            }

            Double sumExpenses = 0.0;
            for (Double value : expensesDouble) {
                sumExpenses += value;
            }

            System.out.println("Ваши доходы за месяц составили:\t" + sumReceipts);
            System.out.println("Ваши расходы за месяц составили:\t" + sumExpenses);
            System.out.println("Чистая прибыль составила:\t" + (sumReceipts - sumExpenses));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
