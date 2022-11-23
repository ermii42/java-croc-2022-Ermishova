package task13;

import java.util.*;

public class Recommendations {
    private final Map<Integer, String> films;
    private final List<Set<Integer>> preferencesBase;
    private final Set<Integer> user;

    public Recommendations(Map<Integer, String> films, List<Set<Integer>> preferencesBase, Set<Integer> user) {
        this.films = films;
        this.preferencesBase = preferencesBase;
        this.user = user;
    }

    public String getRecommendation() {
        for (int i = 0; i < preferencesBase.size(); i++) {
            Set<Integer> pref = Collections.singleton(preferencesBase.indexOf(i));
            if (intersection(pref)) {
                for (Integer number : pref) {
                    if (!user.contains(number)) return films.get(number);
                }
            }
        }
        return "nothing";
    }

    private boolean intersection(Set<Integer> preference) {
        int k = 0;
        for (Integer number : preference) {
            if (user.contains(number)) k++;
        }
        return k >= user.size() / 2;
    }
}
