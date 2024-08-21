public class WordMatch {
    private String secret;
    public WordMatch(String secret){
        this.secret = secret;
    }

    public int scoreGuess(String guess){
        if (guess.isEmpty()){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess.length() > this.secret.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int len = guess.length();
        int countMatches = 0;
        for (int i=0; i<this.secret.length() - len + 1; i++){
            String segment = this.secret.substring(i, i+len);
            if (segment.equals(guess)) countMatches++;
        }
        return countMatches * len * len;
    }

    public String findBetterGuess(String guess1, String guess2){
        int score1 = this.scoreGuess(guess1);
        int score2 = this.scoreGuess(guess2);
        if (score1 >= score2) return guess1;
        else return guess2;
    }



}
