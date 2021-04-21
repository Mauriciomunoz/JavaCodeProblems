package CCI_Moderate;

import java.util.HashSet;

/**
 *
 * CCI: 16.2
 *
 * Design a method to find frequency of occurrences of any given word in a book.
 * What if we are running this algorithm multiple times?
 *
 * Hints: #489 536
 */


public class WordFrequencies_16_2 {

    public static void main(String[] args) {

        String book = "Vikings is a historical drama television series created and" +
                " written by Michael Hirst for the History channel. Filmed in Ireland, " +
                "it premiered on March 3, 2013, in Canada. The series concluded on " +
                "December 30, 2020, when the second half of the sixth season was released" +
                " in its entirety on Prime Video in Ireland, ahead of its broadcast " +
                "on History in Canada from January 1 to March 3, 2021. A sequel series, " +
                "titled Vikings: Valhalla, is in development for Netflix. " +
                "Vikings is inspired by the sagas of Viking Ragnar Lothbrok," +
                " one of the best-known legendary Norse heroes and notorious as " +
                "the scourge of England and France. The show portrays Ragnar as a " +
                "farmer who rises to fame by raiding England and eventually becomes a " +
                "Scandinavian king, with the support of his family and fellow warriors. " +
                "In the later seasons, the series follows the fortunes of his sons and " +
                "their adventures in England, Scandinavia, Kievan Rus', " +
                "the Mediterranean and North America.";

        String word = "Vikingssw";

        int result = frequency(book, word);
        System.out.println(result);

    }

    static int frequency(String book, String word){
        int result = 0;

        HashSet<String> dictionary = new HashSet<>();

        book = book.replace(".", "");
        book = book.replace(",", "");
        book = book.replace(":", "");
        book = book.replace(";", "");
        book = book.replace("'", "");
        //Check for () [] {} "" ''

        //Add it all to a hastable helps to avoid iteration in case the word is not in the text
        String[] words = book.split(" "); //O(N)
        for(String str : words){
            dictionary.add(str);
        }

        if(dictionary.contains(word)) {
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])) {
                    result++;
                }
            }
        }

        return result;
    }


}
