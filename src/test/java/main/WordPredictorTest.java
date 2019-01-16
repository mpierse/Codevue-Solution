package main;

import org.junit.Assert;
import org.junit.Test;

public class WordPredictorTest {

    String firstWord = "the";
    String referenceWords = "the happy dog";

    WordPredictor wordPredictor = new WordPredictor(firstWord, referenceWords, 2.0);

    @Test
    public void formattedWordArrayTest(){
        String[] expected = new String[]{"the", "happy", "dog"};
        String[] actual = wordPredictor.formattedWordArray();
        for (int i=0; i<expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void getPossibleWordsTest1(){
        String[] words = new String[]{"the", "happy", "dog"};
        String expected = "the happy";
        String actual = wordPredictor.getPossibleNextWords(words, 0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPossibleWordsTest1(){
        wordPredictor.addPossibleWords("the happy");
        int expected = 1;
        int actual = wordPredictor.getNumberOfPossibleNextWords();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPossibleWordsTest2(){
        wordPredictor.addPossibleWords("the happy");
        wordPredictor.addPossibleWords("the fluffy");
        int expected = 2;
        int actual = wordPredictor.getNumberOfPossibleNextWords();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addPossibleWordsTest3(){
        wordPredictor.addPossibleWords("the happy");
        wordPredictor.addPossibleWords("the happy");
        wordPredictor.addPossibleWords("the happy");
        wordPredictor.addPossibleWords("the happy");
        int expected = 4;
        int actual = wordPredictor.getTimesOccurredAtIndex(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void populatePossibleWords(){
        
    }

}
