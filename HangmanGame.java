
/**
 * Contains the methods for Hangman.
 *
 * @Carolyn
 * @version (a version number or a date)
 */
public class HangmanGame
{
    String secretWord; //the word being guessed
    String gameStatus; //what the player has guessed
    String triedLetters; //what the player has tried
    /** The constructor for the HangmanGame class
     * @param secretWord The word being guessed by the player 
     */
    public HangmanGame(String secretWord) //stores the secret word 
    {
        this.secretWord = secretWord.toLowerCase();
        this.gameStatus = "";
        this.triedLetters = "";
        for(int i = 0; i <= secretWord.length() - 1; i++)
        {
           if(Character.isLetter(secretWord.charAt(i)))
           {
            gameStatus += "-";
           }
           else
           {
               gameStatus += secretWord.charAt(i);
           }
        }
    }
    /** returns the letters the player has tried
     * @return triedLetters the letters the player has tried
     */
    public String getTried() //returns all the letters you have tried
    {
        return triedLetters;
    }
    /** returns what the player has guessed
     * @return gameStatus the string that the player has guessed
     */
    public String getGuessed() //returns the status of your game string 
    {
        return gameStatus;
    }
    /** Method that checks if the letter is in the string, not in the string, or was already guessed 
     * the character is made lowercase for consistency
     * The if statement checks if the letter has been guessed
     * The else if statement checks if the letter is in the secret word, then runs through the word and replaces the dash with a letter
     * The else statment returns that the letter is not in the string
     */
    public int tryLetter(char a)
    {
        a = Character.toLowerCase(a);
        if(triedLetters.indexOf(a) >= 0)
        {
            return 0;
        }
        else if(secretWord.indexOf(a) >= 0)
        {
           for(int i = gameStatus.length() - 1; i >= 0; i--)
           {
             if(secretWord.charAt(i) == a)
             {
               gameStatus = gameStatus.substring(0, i) + a + gameStatus.substring(i + 1, gameStatus.length());
             }
            }
           triedLetters += a;
           return 1;
        }
        else
        {
            triedLetters += a;
            return -1;
        }
    }
}
