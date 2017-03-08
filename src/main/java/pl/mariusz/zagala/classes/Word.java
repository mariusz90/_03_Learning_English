package pl.mariusz.zagala.classes;


import pl.mariusz.zagala.datebase.Datebase;

import java.io.*;
import java.util.Scanner;

/**
 * Created by MariuszZ on 2017-03-07.
 */
public class Word {

    private String wordPl;

    private String wordEn;
    private int pairWord;
    private int okWord;

    public String getWordPl() {
        return wordPl;
    }

    public void setWordPl(String wordPl) {
        boolean godWord = true;
        for(int i=0;i<wordPl.length();i++)
        {
            if(Character.isLetter(wordPl.charAt(i)) == false) {
                godWord = false;
                break;
            }
        }
        if(godWord==false) {
            this.wordPl ="";
            System.out.println("Zły napis");
        }
        else {
            String word = wordPl.toUpperCase();
            this.wordPl = word;
        }
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
    boolean godWord = true;
      for(int i=0;i<wordEn.length();i++)
      {
          if(Character.isLetter(wordEn.charAt(i)) == false) {

             godWord = false;
              System.out.println(godWord);
             break;
          }

      }
      if(godWord==false) {
          this.wordEn ="";
          System.out.println("Zły napis");
      }
      else {
          String word = wordEn.toUpperCase();
          this.wordEn = word;
      }
    }

    public int getPairWord() {
        return pairWord;
    }

    public void setPairWord(int pairWord) {
        this.pairWord = pairWord;
    }

    public int getOkWord() {
        return okWord;
    }

    public void setOkWord(int okWord) {
        this.okWord = okWord;
    }
    public Word() {


    }

    @Override
    public String toString() {
        return "Word{" +
                "wordPl='" + wordPl + '\'' +
                ", wordEn='" + wordEn + '\'' +
                ", pairWord=" + pairWord +
                ", okWord=" + okWord +
                '}';
    }

    public Word(String wordPl, String wordEn) {
        this.wordPl = wordPl;
        this.wordEn = wordEn;
    }

    public Word(String fileName)
    {
        FileReader fr = null;
        String linia = "";

        // OTWIERANIE PLIKU:
        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try {
            while((linia = bfr.readLine()) != null){
               String [] words = linia.split(";");
                System.out.println(words[0]);
                System.out.println(words[1]);
               setWordPl(words[0]);
               setWordEn(words[1]);

               Datebase.insertWords(getWordPl(), getWordEn());
             //   System.out.print(getWordPl()+" "+getWordEn());
            }
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }


}
