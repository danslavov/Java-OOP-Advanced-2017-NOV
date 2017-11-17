package _02_InterfacesAndAbstraction.Exercises.P04_Telephony;

public class Smartphone implements CallOtherPhones, BrowseInTheWorldWideWeb {

    @Override
    public void browseSite(String site) {
        for (char ch : site.toCharArray()) {
            if (Character.isDigit(ch)) {
                System.out.println("Invalid URL!");
                return;
            }
        }
        System.out.printf("Browsing: %s!%n", site);
    }

    @Override
    public void callNumber(String phoneNumber) {
        for (char ch : phoneNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                System.out.println("Invalid number!");
                return;
            }
        }
        System.out.println("Calling... " + phoneNumber);
    }
}
