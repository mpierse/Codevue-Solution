package main;


public class NextWords implements Comparable<NextWords>{
    private String nextWords;
    private Integer timeOccured;

    public NextWords(String nextWords){
        this.nextWords=nextWords;
        this.timeOccured = 1;
    }

    public Integer getTimesOccured(){
        return timeOccured;
    }

    public String getNextWord(){
        return nextWords;
    }

    public void incrementTimesOccured(){
        timeOccured++;
    }

	@Override
	public int compareTo(NextWords nextWords) {
        if(this.getTimesOccured() > nextWords.getTimesOccured())
        return -1;
        else if(this.getTimesOccured()<nextWords.getTimesOccured())
        return 1;
        else
        return 0;
	}

}
