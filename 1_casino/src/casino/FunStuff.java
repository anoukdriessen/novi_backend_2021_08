package casino;
public class FunStuff {
    public static void main(String[] args) {
        System.out.println("Welkom bij de Fun Stuff");
        FunStuff fs = new FunStuff();

        try {
            fs.countdown(3);
        } catch (InterruptedException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    /**
     * Methode om een countdown weer te geven
     * @param from vanaf welk getal de countdown moet worden aangemaakt
     */
    public void countdown(int from) throws InterruptedException {
        for (int i = 0; i < from; i++) {
            int count = from - i;
            System.out.println(count + "..");
            // wacht 1 seconden
            Thread.sleep(1000);
        }
        System.out.println("GO!");
    }
}
