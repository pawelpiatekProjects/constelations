import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SuperClass s1 = new SuperClass();

        File f = new File("./super.obj");
        //Sprawdzanie czy plik istnieje. Jeśli plik istnieje to program wchodzi do pętli do while
        // w której wykonywany jest cały porgram do momentu gdy użytkownik nie wybierze opcji
        // 10, która jest jednoznaczna z zakończeniem działania programu
        //Jeśli plik nie istnieje to program tworzy taki plik i kończy swoje działanie. Żeby móc
        // korzystać z tego pliku trzeba wtedy ponownie uruchomić program
        if (f.exists()) {
            Scanner scan = new Scanner(System.in);

            int choice;
            s1.readFromObj("super");
            do {

                System.out.println("------MENU------");
                System.out.println("1. Wyswietl wszystkie gwiazdy");
                System.out.println("2. Wyswietl wszystkie gwiazdy w danej konstelacji");
                System.out.println("3. Dodaj gwiazde");
                System.out.println("4. Usun gwiazde");
                System.out.println("5. Wyswietl wszystkie gwiazdy w podanej odlegosci od Ziemi");
                System.out.println("6. Wyswietl wszystkie gwiazdy o podanej temperaturze");
                System.out.println("7. Wyswietl wszystkie gwiazdy o podanym rozmiarze");
                System.out.println("8. Wyswietl wszystkie gwiazdy na podanej polkuli");
                System.out.println("9. Wyswietl potencjalne supernowe");
                System.out.println("10. Zakończ program");
                System.out.print("Wybierz opcje: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1: {
                        s1.print();
                        break;
                    }
                    case 2: {
                        Scanner stringScan = new Scanner(System.in);

                        System.out.println("Podaj konstelacje: ");
                        String constelationName = stringScan.nextLine();
                        s1.findStarsInConstelation(constelationName);
                        break;
                    }
                    case 3: {
                        Scanner stringScan = new Scanner(System.in);

                        System.out.print("Podaj nazwe: ");
                        String name = stringScan.nextLine();
                        System.out.print("Podaj deklinacje: ");
                        double declination = scan.nextDouble();
                        System.out.print("Podaj rektasencje: ");
                        double rectasention = scan.nextDouble();
                        System.out.print("Podaj obserwowana wielkosc: ");
                        double observedSize = scan.nextDouble();
                        System.out.print("Podaj odleglosc w latach swietlnych: ");
                        double distance = scan.nextDouble();
                        System.out.print("Podaj konstelacje: ");
                        String constelation = stringScan.nextLine();
                        String catalogName = s1.getGreek(constelation);
                        catalogName += constelation;
                        System.out.print("Podaj polkule: ");
                        String hemisphere = stringScan.nextLine();
                        System.out.print("Podajtemperature: ");
                        double temperature = scan.nextDouble();
                        System.out.print("Podaj mase: ");
                        double mass = scan.nextDouble();

                        Star temp = new Star(name, catalogName, declination, rectasention, observedSize, distance, constelation,
                                hemisphere, temperature, mass);

                        s1.addToList(temp);
                        break;
                    }
                    case 4: {
                        Scanner stringScan = new Scanner(System.in);
                        System.out.print("Podaj nazwe gwiazdy: ");
                        String name = stringScan.nextLine();
                        s1.RemoveStar(name);
                        break;
                    }
                    case 5: {
                        Scanner doubleScan = new Scanner(System.in);
                        System.out.print("Podaj odleglosc od Ziemi: ");
                        double distance = doubleScan.nextDouble();
                        s1.findByDistance(distance);
                        break;
                    }
                    case 6: {
                        Scanner doubleScan = new Scanner(System.in);
                        System.out.print("Podaj dol przedzialu temperatury: ");
                        double temperature1 = doubleScan.nextDouble();
                        System.out.print("Podaj gore przedzialu temperatury: ");
                        double temperature2 = doubleScan.nextDouble();
                        s1.findByTemperature(temperature1,temperature2);
                        break;
                    }
                    case 7: {
                        Scanner doubleScan = new Scanner(System.in);
                        System.out.print("Podaj dolny przedzial rozmairu gwiazdy: ");
                        double size1 = doubleScan.nextDouble();
                        System.out.print("Podaj gorny przedzial rozmairu gwiazdy: ");
                        double size2 = doubleScan.nextDouble();
                        s1.findBySize(size1,size2);
                        break;
                    }
                    case 8: {
                        Scanner stringScan = new Scanner(System.in);
                        System.out.print("Podaj polkule: ");
                        String hemisphere = stringScan.nextLine();
                        s1.findByHemiSphere(hemisphere);
                        break;
                    }
                    case 9: {
                        s1.findSupernova();
                        break;
                    }
                }
            } while (choice != 10);




        }else{
            ArrayList<Star>temp = new ArrayList<Star>();
            temp.add(new Star());
           s1.saveArrToObject(temp,"super");
        }
        s1.saveArrToObject(s1.stars, "super");
        s1.stars.clear();
    }


}

