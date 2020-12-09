package bsu;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

            List<Casino> casinos = new ArrayList<>();
            try (Scanner scannerCasinos = new Scanner(new File("casinos.txt"))) {
                while (scannerCasinos.hasNextLine()) {
                    String line = scannerCasinos.nextLine();
                    String[] casino = line.split(",");
                    casinos.add(new Casino(casino));
                }
                int number;
                Query request = new Query(casinos);
                Scanner scanner = new Scanner(System.in);
                boolean start = true;
                while (start) {
                    menu();
                    number = scanner.nextInt();
                    scanner.nextLine();
                    switch (number) {
                        case 1:
                            request.casinoTopRateValue();
                            break;
                        case 2:
                            System.out.println("Enter the minimum value rate");
                            int rateValue = scanner.nextInt();
                            scanner.nextLine();
                            request.TopRateValue(rateValue);
                            break;
                        case 3:
                            System.out.println("Enter the name of casino");
                            String name = scanner.nextLine();
                            request.searchName(name);
                            break;
                        case 4:
                            System.out.println("Enter the name of the city");
                            String category = scanner.nextLine();
                            System.out.println("City: " + category + ". Rate value: " + request.rateValueOfTheCity(category));
                            break;
                        case 0:
                            start = false;
                            break;
                    }
                }
            } catch (FileNotFoundException | ParseException e) {
                e.printStackTrace();
            }
        }

        public static void menu() {
            System.out.println("Selected category");
            System.out.println("1.All the casinos and their rate value");
            System.out.println("2.Casinos by number of rate value greater than a given number");
            System.out.println("3.Find a casino by name");
            System.out.println("4.City and the number of their rate value");
            System.out.println("0. Exit");
        }
    }

