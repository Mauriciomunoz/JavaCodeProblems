package EasyProblems;


import java.util.ArrayList;
import java.util.List;

/**
 * Mock Interview with Ivan
 *
 * Write a class
 * Add words (String) to class
 * Will predict possible similar words
 * Always low case
 * No special chars
 * two methods one to add and one to get
 * No nums
 *
 *
 *
 */
public class PredectibleWords {

    public static void main(String[] args) {

        WordsDictionary wd = new WordsDictionary();
        wd.addWord("perro");
        wd.addWord("pescado");
        wd.addWord("persona");
        List<String> predictions = wd.getWords("p");
        wd.addWord("personas");
        List<String> predictions2 = wd.getWords("pe");
        List<String> predictions3 = wd.getWords("pes");
        wd.addWord("gato");
        wd.addWord("gas");
        List<String> predictions4 = wd.getWords("g");
        List<String> predictions5 = wd.getWords("t");


        System.out.println("DONE");
    }

}

class WordsDictionary{
    //No initialization in mock interview. Fixed
    TrieNode root = new TrieNode();

    public void addWord(String str){
        int i = 1;
        TrieNode word = new TrieNode();

        if(root.getChild(str.charAt(0)) != null){
            word = root.getChild(str.charAt(0));
            i = 1;
        }else{
            word.c = str.charAt(0);
            root.nodes.add(word);
        }

        while(i < str.length()){
            Character c = str.charAt(i);
            if(word.getChild(c) == null){
                TrieNode nextChar = new TrieNode();
                nextChar.c = c;
                word.nodes.add(nextChar);
                word = nextChar;
            }else{
                word = word.getChild(c);
            }
            i++;
        }

        //Added ending of word in the Trie
        TrieNode endChar = new TrieNode();
        endChar.c = '\0';
        word.nodes.add(endChar);
    }

    public List<String> getWords(String str){
        List<String> predictions = new ArrayList<>();
        int i = 0;
        TrieNode aux = root;

        while(i < str.length()){
            Character c = str.charAt(i);
            if(aux.getChild(str.charAt(i)) != null ){
                aux = aux.getChild(str.charAt(i));
            }else{
                return predictions;
            }
            i++;
        }

        helper(aux, str.substring(0,str.length() - 1), predictions);

        return predictions;
    }

    public void helper(TrieNode node, String aux, List<String> listWords){
        if(node.c == '\0'){
            listWords.add(aux);
        }
        aux = aux + node.c;

        for(int i = 0; i < node.nodes.size(); i++){
            helper(node.nodes.get(i), aux, listWords);
        }

    }
}

//Fix creation of class. I was using public name instead class name
class TrieNode{
        Character c;
        List<TrieNode> nodes = new ArrayList<>();
        public TrieNode(){};

        //Added method to search node in list
        public TrieNode getChild(Character c){
            TrieNode charNode;

            for(int i = 0; i < this.nodes.size(); i++){
                charNode = this.nodes.get(i);
                if(charNode.c == c){
                    return charNode;
                }
            }

            return null;
        }
}
