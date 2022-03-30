package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        Calculator calculator = new Calculator(nums);
        System.out.println(nums + " = " + calculator.calculate());

    }

    public static class Calculator {
        String[] space;
        int indexspace;

        public Calculator(String nums) {
            this.space = nums.split(" ");
            this.indexspace = 0;
        }

        public double calculate() {
            double first = calculate2();
            while (indexspace < space.length) {
                String operator = space[indexspace];
                if (!operator.equals("+") && !operator.equals("-")) {
                    System.out.println("Некорректный ввод! ");
                    return 0;
                } else {
                    indexspace++;
                }
                double second = calculate2();
                if (operator.equals("+")) {
                    first += second;
                } else {
                    first -= second;
                }
            }
            return first;
        }

        public double calculate2() {
            double first = calculate3();
            while (indexspace < space.length) {
                String operator = space[indexspace];
                if (!operator.equals("*") && !operator.equals("/")) {
                    break;
                } else {
                    indexspace++;
                }
                double second = calculate3();
                if (operator.equals("*")) {
                    first *= second;
                } else {
                    first /= second;
                }
            }
            return first;
        }

        public double calculate3() {

            double first = Double.parseDouble(space[indexspace++]);
            while (indexspace < space.length) {
                String operator = space[indexspace];
                if (!operator.equals("%") && !operator.equals("^")){
                    break;
                }else {
                    indexspace++;
                }
                double second = Double.parseDouble(space[indexspace++]);
                if (operator.equals("%")) {
                    first %= second;
                } else {
                    first = Math.pow(first,second);
                }
            }
            return first;
        }

    }
}
