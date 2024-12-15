import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Profanityfilter2 {
    
    private String badwords;
    private String sentence;
    private ArrayList<String> finalsentence;
    private ArrayList<String> finalbadwords;
    private ArrayList<String> finalfinal;
    private ArrayList<String> checkDots = new ArrayList<>(); 


    public void scScanner() {
        Scanner input = new Scanner(System.in);
        finalbadwords = new ArrayList<>();
        finalfinal = new ArrayList<>();
        this.badwords = input.nextLine();

        String [] splitbadwords = this.badwords.split(" ");
        for (String badword : splitbadwords){
            this.finalbadwords.add(badword.toLowerCase());
        }
        ArrayList<String> listofSentences = new ArrayList<>();
        finalsentence = new ArrayList<>();
        while (input.hasNextLine()) { 
            this.sentence = input.nextLine();
            listofSentences.add(this.sentence); 
        }
        String [] splitsentences;
        for (String s : listofSentences){
            splitsentences = s.split(" ");
            for (int i = 0; i < splitsentences.length; i++){
                this.finalsentence.add(splitsentences[i]);
            }
        }
        for (String word : this.finalbadwords){
            String y = "";
            for (int i = 0, j = 0; i < word.length(); i++){
                if (j == 0){
                    y = y + "*";
                }
                else if(j == 1){
                    y += "&";
                }
                else if(j == 2){
                    y += "#";
                }
                else if(j == 3){
                    y += "$";
                }
                else{
                    y += "%";
                    j = -1;
                }
                j++;
            }
            this.finalfinal.add(y);
        }
        input.close();
        }
        
    
    public void checkforDots(String palabra, int index){
        if (palabra.contains(",")){
            finalsentence.set(index, palabra.replace(",", ""));
            checkDots.add(",");
        }
        else if(palabra.contains(".")){
            finalsentence.set(index, palabra.replace(".", ""));
            checkDots.add(".");
        }
        else if(palabra.contains("!")){
            finalsentence.set(index, palabra.replace("!", ""));
            checkDots.add("!");
        }
        else if(palabra.contains("?")){
            finalsentence.set(index, palabra.replace("?", ""));
            checkDots.add("?");
        }
        else{
            checkDots.add("");
        }
    }
    
    public void filteredSentence() {
        scScanner();

        for (int i = 0; i < this.finalsentence.size(); i++){
            checkforDots(this.finalsentence.get(i), i);
            for (int j = 0; j < this.finalbadwords.size(); j++) {
                if (this.finalsentence.get(i).toLowerCase().equals(this.finalbadwords.get(j).toLowerCase())){
                    finalsentence.set(i, this.finalfinal.get(j));
                }
             }
        }
        String x = "";
        for (int i = 0; i < finalsentence.size(); i++){
            x += finalsentence.get(i) + checkDots.get(i) + " ";
        }
        System.out.println(x);
        finalsentence.clear();
        checkDots.clear();
    }
}
  

    
    
