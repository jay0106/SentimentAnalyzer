import java.util.Arrays;
/*
Sentiment Analysis: discovering opinions expressed in online reviews.
language pattern used in this program:
{feature} was {opinion} e.g. food was delicious
{opinion} {feature} e.g. fantastic service
0 - no opinion
1 - positive opinion
2 - negative opinion
*/
public class SentimentAnalyzerTester {
    public static void main(String[] args) {
        //process and detect the review
        try{
            int[] featureOpinions = SentimentAnalyzer.detectProsAndCons(Review.REVIEW_LIST.get(0),
                    Review.FEATURE_SET, Review.POS_OPINION_WORDS, Review.NEG_OPINION_WORDS);
            System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Review not Available");
        }
    }
}

