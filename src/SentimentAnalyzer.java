public class SentimentAnalyzer {

    private SentimentAnalyzer(){}//can't extend & instantiate this class

    public static int[] detectProsAndCons(String review, String[][] featureSet, String[]
            posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output
        int tmp = -1;
        String reviewLowered = review.toLowerCase();

        for(String[] featureList : featureSet){
            tmp++;
            for(String feature : featureList){
                if(reviewLowered.contains(feature)){
                    featureOpinions[tmp] = getOpinionOnFeature(reviewLowered, feature, posOpinionWords, negOpinionWords);
                    break;
                }
            }
        }
        return featureOpinions;
    }

    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int result = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if(result != 1 && result != -1){
            result = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        //System.out.println("Result is: " + result);
        return result;
    }

    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        String final_temp = "";

        //positive review
        if (review.contains(pattern)){
            String temp = review.substring(review.indexOf(pattern));
            String[] temp2 = temp.split(" ");
            final_temp = "";
            for(int i = 0; i < temp2.length; i++){
                if(i == 0 || i == 1 || i == 2){
                    final_temp += temp2[i] + " ";
                }
            }
            //this the string with {feature} was {opinion}
            for(String pos : posOpinionWords){
                if(final_temp.contains(pos)){
                    opinion = 1;
                }
            }
        }

        //negative opinion
        if(opinion != 1) {
            for (String neg : negOpinionWords) {
                if(final_temp.contains(neg)){
                    opinion = -1;
                }
            }
        }
        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        String[] sentences = review.split("\\.");
        int opinion = 0;
        String final_string = "";

        outerLoop: for(String sentence : sentences){
            sentence = sentence.trim();
            for(String pos : posOpinionWords){
                if(sentence.contains(pos)){
                    String temp = sentence.substring(sentence.indexOf(pos));
                    String[] temp2 = temp.split(" ");
                    for(int i = 0; i <= 1; i++){
                        final_string += temp2[i] + " ";
                    }
                    if(final_string.contains(pos) && final_string.contains(feature)){
                        opinion = 1;
                    }
                    break outerLoop;
                }
            }
        }

        //negative
        final_string = "";
        if(opinion != 1){
            outerLoop: for(String sentence : sentences){
                sentence = sentence.trim();
                for(String neg : negOpinionWords){
                    if(sentence.contains(neg)){
                        String temp = sentence.substring(sentence.indexOf(neg));
                        String[] temp2 = temp.split(" ");
                        for(int i = 0; i <= 1; i++){
                            final_string += temp2[i] + " ";
                        }
                        if(final_string.contains(neg) && final_string.contains(feature)){
                            opinion = -1;
                        }

                        break outerLoop;
                    }
                }
            }
        }
        return opinion;
    }
}
