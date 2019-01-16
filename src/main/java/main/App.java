package main;




public class App 
{
    public static void main( String[] args )
    {
        String firstWord = "the";
        String referenceWords = "Mary had a little lamb, little lamb, little lamb "+
        "Mary had a little lamb " +
        "Whose fleece was white as snow. " +
        
        "And everywhere that Mary went " +
        "Mary went, Mary went, " +
        "Everywhere that Mary went " +
        "The lamb was sure to go. " +
        
        "He followed her to school one day, school one day, school one day " +
        "He followed her to school one day " +
        "Which was against the rules. " +
        
        "It made the children laugh and play, " +
        "laugh and play, laugh and play, " +
        "It made the children laugh and play, " +
        "To see a lamb at school. " +
        
        "And so the teacher turned it out, " +
        "turned it out, turned it out, "+
        "And so the teacher turned it out, " +
        "But still it lingered near, " +
        "He waited patiently about, " +
        "ly about, ly about, " +
        "He waited patiently about, " +
        "Till Mary did appear. ";
        Double numToGenerate = 5.0;
        WordPredictor wordPredictor = new WordPredictor(firstWord, referenceWords, numToGenerate);
        wordPredictor.populatePossibleNextWordObject();
        System.out.println( wordPredictor.toString() );
    }
}
