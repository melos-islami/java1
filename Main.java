import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("PIN-i i ri (4 shifra): ");
        String pin = input.nextLine().trim();

        if (pin.length() == 4) {

            if (pin.matches("[0-9]{4}")) {

                int numri = Integer.parseInt(pin);

                if (pin.equals("1234") ||
                    pin.equals("0000") ||
                    pin.equals("1111") ||
                    pin.equals("1212") ||
                    pin.equals("2580") ||
                    pin.equals("4321")) {

                    System.out.println(
                        "I dobët: ky PIN provohet i pari."
                    );

                } else {

                    System.out.println(
                        "Kujdes: disa sisteme e heqin 0-n në fillim."
                    );

                    int pike = 0;

                    if (numri < 1950 || numri > 2026) {
                        pike++;
                    }

                    if (pin.charAt(0) != pin.charAt(1)) {
                        pike++;
                    }

                    if (pin.charAt(2) != pin.charAt(3)) {
                        pike++;
                    }

                    var niveli = switch (pike) {
                        case 3 -> "I fortë";
                        case 2 -> "Mesatar";
                        default -> "I dobët";
                    };

                    double perqindja = (pike / 3.0) * 100;

                    System.out.printf(
                        "%s: %.2f %%\n",
                        niveli, perqindja
                    );

                    String rezultati = (pike == 3)
                        ? "PIN-i pranohet."
                        : "Zgjidhni PIN tjetër.";

                    System.out.println(rezultati);
                }

            } else {
                System.out.println(
                    "Gabim: PIN-i duhet të ketë vetëm shifra!"
                );
            }

        } else {
            System.out.println(
                "Gabim: PIN-i duhet të ketë saktësisht 4 shifra!"
            );
        }

        input.close();
    }
}
