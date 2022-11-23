package task13;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Recommendations {
    private Map<Integer, String> films;
    private List<Set<Integer>> preferencesBase;
    private Set<Integer> user;

    public Recommendations(Map<Integer, String> films, List<Set<Integer>> preferencesBase, Set<Integer> user) {
        this.films = films;
        this.preferencesBase = preferencesBase;
        this.user = user;
    }

    public String getRecommendation(){
        for(int i=0; i<preferencesBase.size(); i++){
            Set<Integer> pref = Collections.singleton(preferencesBase.indexOf(i));
            if(intersection(pref)){
                for(Integer number: pref){
                    if(!user.contains(number)) return films.get(number);
                }
            }
        }
        return "nothing";
    }

    private boolean intersection(Set<Integer> preference){
        int k=0;
        for(Integer number: preference){
            if(user.contains(number)) k++;
        }
        return k >= user.size() / 2;
    }
}
