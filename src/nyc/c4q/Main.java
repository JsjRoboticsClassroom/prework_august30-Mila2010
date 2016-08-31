package nyc.c4q;

public class Main {

    public static void main(String[] args) {

        boolean yes=true;
        while (yes){
            Hangman hangman = new Hangman();
        while (hangman.getMisses() < 5){
            hangman.printCurrentWord();
            hangman.promptPlayer("Enter a letter: ");
            hangman.readLetter();
            hangman.checkLetter();
            if(hangman.guessedSuccessfully()){
                break;
            }
            System.out.println(Drawing.get(hangman.getMisses()));
            System.out.println("Misses -> " +hangman.getMisses());
        }
        if(hangman.guessedSuccessfully()){
            System.out.println("Success");
        } else {
            System.out.println("The answer was " + hangman.getSecretWord());
        }
            yes = hangman.askToPlay();
    }

    }
}
