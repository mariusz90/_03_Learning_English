package pl.mariusz.zagala.classes;


import java.io.File;

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

    public Word(String fileName)
    {

    }
}
