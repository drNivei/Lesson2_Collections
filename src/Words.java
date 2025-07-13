import java.util.ArrayList;
import java.util.List;

public class Words {
    List<String> words = new ArrayList<>();

    Words(){
    }

    public void addWord(String newWord){
        this.words.add(newWord);
    }

    public String find_Most_Common_Word() {
        String most_common_word = "ERROR";
        int max_counter = 0;
        int word_counter = 0;
        for (String verified : words) {
            for (String compared : words) {
                if (verified.equals(compared)) {
                    word_counter++;
                }
            }
            if (word_counter > max_counter) {
                max_counter = word_counter;
                most_common_word = verified;
            }
            word_counter=0;
        }
        return most_common_word;
    }

}
