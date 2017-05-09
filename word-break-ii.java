/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Java
@Datetime: 17-03-18 20:00
*/

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> result = new ArrayList<String>();
    public ArrayList<String> sentence = new ArrayList<>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        if (wordDict.isEmpty()) {
            return result;
        }
        if (checkChar(s, wordDict)) {
            return result;
        }
        Helper(s, wordDict);
        return result;
    }
    private void Helper(String s, Set<String> wordDict) {
        //System.out.println(sentenceToString(sentence));
        if (s.equals("")) {
            String str = sentenceToString(sentence);
            result.add(str);
            sentence.remove(sentence.size() - 1);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                sentence.add(s.substring(0,i));
                Helper(s.substring(i,s.length()), wordDict);
            }
        }
        if (sentence.size() != 0) {
            sentence.remove(sentence.size() - 1);
        }
        return;
    }
    private String sentenceToString(ArrayList<String> strArray) {
        String str = "";
        for (String word : strArray) {
            str = str + " " + word;
        }
        return str.substring(1);
    }
    private boolean checkChar(String s, Set<String> wordDict) {
        Set<Character> charDict = new HashSet<>();
        for (String word : wordDict.toArray(new String[wordDict.size()])) {
            for (int i = 0; i < word.length(); i++) {
                if (!charDict.contains(word.charAt(i))) {
                    charDict.add(word.charAt(i));
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!charDict.contains(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}