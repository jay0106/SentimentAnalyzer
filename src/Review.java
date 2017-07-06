//This class holds the review that needs to be processed

import java.util.ArrayList;

public class Review {
    public static final ArrayList<String> REVIEW_LIST = getReview();
    public static final String[][] FEATURE_SET = {
            { "ambiance", "ambience", "atmosphere", "decor" },
            { "dessert", "ice cream", "desert" },
            { "food" },
            { "soup" },
            { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
    public static final String[] POS_OPINION_WORDS = {"good", "fantastic", "friendly", "great",
            "excellent", "amazing", "awesome","delicious" };
    public static final String[] NEG_OPINION_WORDS = {"slow", "bad", "horrible", "awful",
            "unprofessional", "poor" };

    private Review(){} //can't extend & instantiate this class

    private static ArrayList<String> getReview(){
        return InputReview.read("review.txt"); //all the reviews
    }
}
