package nyc.c4q;

import java.util.Scanner;


public class Hangman {
    private final SecretWord mSecretWord;
    private char mLastGuess;
    private int mMisses = 0;

    public Hangman(){
        mSecretWord = new SecretWord();
    }


    public int getMisses(){
        return mMisses;
    }

    public void readLetter() {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        mLastGuess = Character.toUpperCase(input);
    }

    public void promptPlayer(String string) {
        System.out.println(string);
    }

    public boolean checkLetter() {
        if (mSecretWord.isLetter(mLastGuess)) {
            // If letter is in word do something
            mSecretWord.set(mLastGuess);
            return true;
        } else {
            mMisses++;
            return false;
        }
    }

    public static boolean askToPlay(){

        System.out.println("Do you want to play again?");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();
        boolean answer =!userAnswer.toLowerCase().equalsIgnoreCase("yes") && !userAnswer.toLowerCase().equalsIgnoreCase("y") && !userAnswer.toLowerCase().equalsIgnoreCase("no") && !userAnswer.toLowerCase().equalsIgnoreCase("n");
        while(answer){
            System.out.println("Ops....I am afraid I don't understand your answer. Please type yes or no");
            userAnswer = scanner.next();
            answer =!userAnswer.toLowerCase().equalsIgnoreCase("yes") && !userAnswer.toLowerCase().equalsIgnoreCase("y") && !userAnswer.toLowerCase().equalsIgnoreCase("no") && !userAnswer.toLowerCase().equalsIgnoreCase("n");
        }

        if(userAnswer.equalsIgnoreCase("yes")||userAnswer.equalsIgnoreCase("y")){
       return true; }else {return  false;}
    }


        public void printCurrentWord(){
        System.out.println(mSecretWord);
    }

    public String getSecretWord() {
        return mSecretWord.reveal();
    }

    public boolean guessedSuccessfully() {
        return mSecretWord.isGuessed();
    }
}