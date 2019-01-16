package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;

public class WordPredictor{

    String firstWord;
    String referenceWords;
    Double numToGenerate;
    ArrayList<NextWords> possibleNextWordObjects;

    public WordPredictor(String firstWord, String referenceWords, Double numToGenerate){
        this.firstWord=firstWord;
        this.referenceWords = referenceWords;
        this.numToGenerate=numToGenerate;
        this.possibleNextWordObjects = new ArrayList<>();
    }

    @Override
    public String toString(){
        Collections.sort(possibleNextWordObjects);
        StringBuilder stb = new StringBuilder();
        Formatter formatter = new Formatter(stb);
        for (NextWords str : possibleNextWordObjects) {
            stb.append(str.getNextWord());
            stb.append(" ");
            formatter.format("%.3f", str.getTimesOccured()/(double)getNumberOfPossibleNextWords());
            stb.append(";");
            stb.append(" ");
        }
        stb.trimToSize();
        return stb.toString();
    }

    public void populatePossibleNextWordObject(){
        String[] words = formattedWordArray();
        for (int i = 0; i <= words.length-numToGenerate ; i++) {
            String possibleNextWords = getPossibleNextWords(words, i);
            if(words[i].equals(firstWord)){
                addPossibleWords(possibleNextWords);
            }
        }
    }

    public void addPossibleWords(String possibleNextWord){
        if(getNumberOfPossibleNextWords()>0){
            incrementTimesStringOccured(possibleNextWord);
        } else {
            possibleNextWordObjects.add(new NextWords(possibleNextWord));
        }
    }

    public void incrementTimesStringOccured(String possibleNextWord){
        boolean isIncremented = false;
        for (NextWords next : possibleNextWordObjects) {
            if(next.getNextWord().equals(possibleNextWord)){
                next.incrementTimesOccured();
                isIncremented=true;
            }
        }
        if(isIncremented==false){
            possibleNextWordObjects.add(new NextWords(possibleNextWord));
        }
    }

    public String getPossibleNextWords(String[] words, int index) {
        String possibleNextWords = "";
        for (int i = 0; i < numToGenerate; i++) {
            if(possibleNextWords != ""){
                possibleNextWords+= " ";
            }
            possibleNextWords+=words[i+index];
        }
        return possibleNextWords;
    }

    public String[] formattedWordArray(){
        referenceWords = referenceWords.replaceAll("[^a-zA-Z ]", "");
        referenceWords = referenceWords.toLowerCase();
        return referenceWords.split(" ");
    }

    public int getNumberOfPossibleNextWords(){
        int numberOfPossibleNextWords = 0;
        for (int i = 0; i < possibleNextWordObjects.size() ; i++) {
            numberOfPossibleNextWords+= getTimesOccurredAtIndex(i);
        }
        return numberOfPossibleNextWords;
    }

    public int getTimesOccurredAtIndex(int index){
        NextWords nextWords = possibleNextWordObjects.get(index);
        return nextWords.getTimesOccured();
    }

}