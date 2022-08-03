package KWSModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Segment {
    private ArrayList<String> corpusList = new ArrayList<String>();
    private ArrayList<String> clusteredWords = new ArrayList<String>();

    private ArrayList<StringWithRange> FMMResult = new ArrayList<StringWithRange>();
    private ArrayList<StringWithRange> FMMUnmatched = new ArrayList<StringWithRange>();
    private ArrayList<StringWithRange> BMMResult = new ArrayList<StringWithRange>();
    private ArrayList<StringWithRange> BMMUnmatched = new ArrayList<StringWithRange>();


    private String input;

    private File corpusFile = new File("src/KWSModel/corpus_list.txt");
    private Scanner corpus = new Scanner(corpusFile);


//Core Private Methods

    private void clearDelimiters(){
        StringBuilder newInput = new StringBuilder();
        for(int i = 0; i!=input.length(); i++){
            if(!((input.charAt(i) == '\u17d4') || (input.charAt(i) == '\u17d5') || (input.charAt(i) == ' ') || (input.charAt(i) == '\u200b' || (input.charAt(i) == '\n' || (input.charAt(i) == '\t'))))){
                //Filter khmer characters only (ranging from unicode 1780 to 17F9):
                if(input.charAt(i) >= '\u1780' && input.charAt(i) <= '\u17D3'){
                    newInput.append(input.charAt(i));
                }//Khmer char only filter
            }//Delimiters filters
        }//Push everything except delimiters
        input = new String(newInput);
    }

    private void doClustering(){
        StringBuilder temp = new StringBuilder(input);
             //Since the loop only append new cluster if there's a consonant after last consonant it meets in the last iterations, we need to append an extra word to push the last cluster.
        temp.append("\u17a1");//
        String tempInput = temp.toString();
        temp = new StringBuilder();
        temp.append(tempInput.charAt(0));

        for(int i = 1 ;i!=tempInput.length(); i++){

            //If it's a consonant or an independent vowel
            if (((tempInput.charAt(i) >= '\u1780') && (tempInput.charAt(i) <= '\u17a2')) ||
                    ((tempInput.charAt(i) >= '\u17a6') && (tempInput.charAt(i) <= '\u17b3')))
            {
                if(tempInput.charAt(i-1) != '\u17d2'){  //if it's not the " ្ "
                    clusteredWords.add(new String(temp));
                    temp = new StringBuilder("");
                }
            }
            temp.append(tempInput.charAt(i));

        }//Start push the clusters.
    }

    private void doFMM(){
        StringBuilder inputCluster = new StringBuilder();

        int matchedStartPoint = 0;
        int matchedEndPoint = 0;
        int unmatchedClustersNumber = 0; //For counting how many clusters have it got unmatched. Usually, if 10 clusters are passed and there's still no match word from corpus list
                                        //We'll skip the current appended cluster and start by using the +1 current cluster.
        boolean corpusListScanHasMatch = false; //For indicating whether if the corpusList scanning loop has at least 1 match.
        boolean addedClusterHasMatch = false;   //For indicating whether if the new added cluster has at least 1 match from the corpusList scanning or not.

        StringBuilder wordResult ;



        while(true) {

            for (int i = matchedStartPoint; i != clusteredWords.size(); i++) {
                inputCluster.append(clusteredWords.get(i));

                for (int j = 0; j != corpusList.size(); j++) {
                    if (inputCluster.toString().equals(corpusList.get(j))) {
                        matchedEndPoint = i;
                        corpusListScanHasMatch = true;
                    }
                }//For::Loop Compare the entire corpus list with the current appendable string (input). (1 iteration of this = matching the entire corpus list with a cluster)

                if(corpusListScanHasMatch) {
                    unmatchedClustersNumber = 0;
                    corpusListScanHasMatch = false;
                    addedClusterHasMatch = true;
                }
                else {
                    unmatchedClustersNumber ++;
                    if(unmatchedClustersNumber >= 10){
                        unmatchedClustersNumber = 0;
                        break;
                    }
                }

            }//For::Loop Adding each cluster ( 1 iteration of this = matching 1 word from left)

            if(!addedClusterHasMatch){
                FMMUnmatched.add( new StringWithRange( clusteredWords.get(matchedEndPoint),matchedStartPoint,matchedEndPoint ));

            }
            else {


                //Add the result;
                wordResult = new StringBuilder();
                for (int i = matchedStartPoint; i <= matchedEndPoint; i++) {
                    wordResult.append(clusteredWords.get(i));
                }
                FMMResult.add(new StringWithRange( wordResult.toString(), matchedStartPoint, matchedEndPoint));

            }




            matchedEndPoint++;
            matchedStartPoint = matchedEndPoint;

            if(matchedStartPoint >= clusteredWords.size() - 1){
                break;
            }//Exit condition is when the endPoint exceeds the clusterWords boundary.


            //Reset some variables to it's default value.
            inputCluster = new StringBuilder();
            corpusListScanHasMatch = false;
            addedClusterHasMatch = false;
            matchedEndPoint = matchedStartPoint;
            unmatchedClustersNumber = 0;



        }//While::The whole process (Breaks if there's a matching for every words)


    }




    private void doBMM(){
        StringBuilder inputCluster = new StringBuilder();

        int matchedStartPoint = clusteredWords.size() -1;
        int matchedEndPoint = clusteredWords.size() - 1;
        int unmatchedClustersNumber = 0; //For counting how many clusters have it got unmatched. Usually, if 10 clusters are passed and there's still no match word from corpus list
        //We'll skip the current appended cluster and start by using the +1 current cluster.
        boolean corpusListScanHasMatch = false; //For indicating whether if the corpusList scanning loop has at least 1 match.
        boolean addedClusterHasMatch = false;   //For indicating whether if the new added cluster has at least 1 match from the corpusList scanning or not.

        StringBuilder wordResult ;



        while(true) {

            for (int i = matchedEndPoint; i >= 0; i--) {
                inputCluster.insert(0,clusteredWords.get(i));

                for (int j = 0; j != corpusList.size(); j++) {
                    if (inputCluster.toString().equals(corpusList.get(j))) {
                        matchedStartPoint = i;
                        corpusListScanHasMatch = true;
                    }
                }//For::Loop Compare the entire corpus list with the current appendable string (input). (1 iteration of this = matching the entire corpus list with a cluster)

                if(corpusListScanHasMatch) {
                    unmatchedClustersNumber = 0;
                    corpusListScanHasMatch = false;
                    addedClusterHasMatch = true;
                }
                else {
                    unmatchedClustersNumber ++;
                    if(unmatchedClustersNumber >= 10){
                        unmatchedClustersNumber = 0;
                        break;
                    }
                }

            }//For::Loop Adding each cluster ( 1 iteration of this = matching 1 word from left)

            if(!addedClusterHasMatch){
                BMMUnmatched.add( new StringWithRange( clusteredWords.get(matchedEndPoint),matchedStartPoint,matchedEndPoint ));

            }
            else {

                //Add the result;
                wordResult = new StringBuilder();
                for (int i = matchedStartPoint; i <= matchedEndPoint; i++) {
                    wordResult.append(clusteredWords.get(i));
                }
                BMMResult.add(new StringWithRange( wordResult.toString(), matchedStartPoint, matchedEndPoint));

            }




            matchedStartPoint--;
            matchedEndPoint = matchedStartPoint;

            if(matchedStartPoint < 0 ){
                break;
            }//Exit condition is when the endPoint exceeds the clusterWords boundary.


            //Reset some variables to it's default value.
            inputCluster = new StringBuilder();
            corpusListScanHasMatch = false;
            addedClusterHasMatch = false;
            matchedEndPoint = matchedStartPoint;
            unmatchedClustersNumber = 0;



        }//While::The whole process (Breaks if there's a matching for every words)


    }


    private ArrayList<ArrayList<String>> doBiMM(){
        ArrayList<ArrayList<String>> returner = new ArrayList<ArrayList<String>>();
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> unmatched = new ArrayList<String>();

        boolean isAnUnmatchedWord = true;
        ArrayList<StringWithRange> resultFromP1 = new ArrayList<StringWithRange>();

        //Pre-Procedures: Add all matched words to the
        for(int i = 0; i != FMMResult.size() ; i++){
            result.add(FMMResult.get(i).getValue());
        }

        //Procedure 0: If the FMM doesn't have any unmatched word, this means that the FMMResult is the final result.
        if(FMMUnmatched.size() == 0){
//        if(true){   //Debug
            returner.add(result);
            returner.add(unmatched);
            return returner;
        }


        //Procedure 1:  Find the part that has the problem that caused unmatched. Find the unmatched words from FMM and compare them with the BMMResult list to see whether if any FMMUnmatched contains in the word from BMMResult
        for(int i = 0 ; i != FMMUnmatched.size(); i++){
            for(int j = BMMResult.size() - 1; j >= 0; j--) {
                if (FMMUnmatched.get(i).getStartPoint() >= BMMResult.get(j).getStartPoint() &&
                        FMMUnmatched.get(i).getEndPoint() <= BMMResult.get(j).getEndPoint() ){
                    //Insert
                    resultFromP1.add(BMMResult.get(j));
                    isAnUnmatchedWord = false;
                    break;

                }//If the FMMUnmatched contains in the range of one of any BMMResult.
            }//For::Loop FMMUnmatched@i with the entire BMMResult.
            if(isAnUnmatchedWord){
                unmatched.add(FMMUnmatched.get(i).getValue());
            }
            isAnUnmatchedWord = true;

        }//For::Loop FMMUnmatched.get(i->FMMUnmatched.Size())

        //Procedure 2 start replacing the unmatched word that has the start point of
        for(int i = 0 ; i != resultFromP1.size(); i++){
            for(int j = 0 ; j != FMMResult.size(); j++){
                if(hasCollision( FMMResult.get(j), resultFromP1.get(i) ) ){
                    //Add the word that was split.
                    result.add( redefineString(FMMResult.get(j), resultFromP1.get(i).getStartPoint()).getValue());
                    //Add the word that is the more correctly implemented.
                    result.add( resultFromP1.get(i).getValue());
                    break;
                }//If the FMMResult has cluster number collied with resultFromP1 (if FMMResult@j is in range with resultFromP1)
                else{
                    result.add( FMMResult.get(j).getValue());
                }//Else if not collied

            }//For::Loop resultFromP1@i with the entire FMMResult.
        }//For::Loop resultFromP1.get(i->resultFromP1.Size())

        returner.add(result);
        returner.add(unmatched);

        return returner;
    }








    //Aux Private Function:

    private boolean hasCollision(StringWithRange a, StringWithRange b){
        if(a.getEndPoint() >= b.getStartPoint())
            return true;
        else return false;
    }

    //redefineString: split the string till the new endPoint
    private StringWithRange redefineString(StringWithRange value, int newEndPoint ){
        int nClusters = newEndPoint - value.getStartPoint();

        String tempInput = value.getValue();
        StringBuilder result = new StringBuilder();
        int stringEndpointIndex = 0;
        int clusterCounter = 1;

        for(int i = 1 ;i!=tempInput.length(); i++){

            //If it's a consonant or an independent vowel
            if (((tempInput.charAt(i) >= '\u1780') && (tempInput.charAt(i) <= '\u17a2')) ||
                    ((tempInput.charAt(i) >= '\u17a6') && (tempInput.charAt(i) <= '\u17b3')))
            {
                if(tempInput.charAt(i-1) != '\u17d2'){  //if it's not the " ្ "
                    clusterCounter++;
                    if(clusterCounter >=nClusters){
                        stringEndpointIndex = i;
                        break;
                    }//if clusterCounter >= newEndpoint
                }// if it's not sub consonant
            }//if it's a consonant or an independent vowel.
        }//For::Loop Start push the clusters.


        for(int i = 0; i <= stringEndpointIndex; i++ ){
            result.append(tempInput.charAt(i));
        }


        return new StringWithRange(result.toString(),value.getStartPoint(),nClusters);
    }






//Public methods & constructor

    public Segment() throws FileNotFoundException {
        while (corpus.hasNext()){
            corpusList.add(corpus.next());
        }

    }//Constructor


    public ArrayList<String> doSegmentation(String target){
        ArrayList<ArrayList<String>> biMMResult = new ArrayList<ArrayList<String>>();
        ArrayList<String> segmentedWords = new ArrayList<String>();


        input = target;

        clearDelimiters();  //WORKS
        doClustering();     //WORKS
        doFMM();        //WORKS
        doBMM();        //WORKS


        biMMResult = doBiMM();  //Doesn't work;

        //Push the results to the segmentedWords (Push the matched first then the unmatched with the following delimiter "_Unmatched_"
        for(int i = 0; i != biMMResult.get(0).size() ; i++){
            segmentedWords.add( biMMResult.get(0).get(i));
        }//Push Matched words

        //add the delimiter
//        segmentedWords.add("_Delimiter_");

//        for(int i = 0; i != biMMResult.get(1).size() ; i++){
//            segmentedWords.add( biMMResult.get(1).get(i));
//        }//Push unmatched words


        return segmentedWords;
    }



    public void DEBUG_PrintClusteredWords(){
        System.out.println("DEBUG: Clustered Words   =");
        for(int i = 0; i!=clusteredWords.size(); i++){
          System.out.println(clusteredWords.get(i) + "/");
        }

    }
    public void DEBUG_PrintInput(){
        System.out.println("DEBUG:  Inputs   =" + input);

    }
    public void DEBUG_PrintInputAsCharArr(){
        System.out.println("DEBUG Inputs as char[] = ");
        for(int i = 0; i != input.length() ; i++){
            System.out.println(input.charAt(i));
        }
    }

    public void DEBUG_PrintFMMResult(){
        System.out.println("DEBUG FMM Results = ");
        for(int i = 0; i != FMMResult.size(); i++){
            System.out.println(FMMResult.get(i).getValue() + "|" + FMMResult.get(i).getStartPoint()+ "|" + FMMResult.get(i).getEndPoint());
        }
        System.out.println("DEBUG FMM Unmatch = ");
        for(int i = 0; i != FMMUnmatched.size(); i++){
            System.out.println(FMMUnmatched.get(i).getValue() + "|" + FMMUnmatched.get(i).getStartPoint()+ "|" + FMMUnmatched.get(i).getEndPoint());
        }


    }
    public void DEBUG_PrintBMMResult(){
        System.out.println("DEBUG BMM Results = ");
        for(int i = 0; i != BMMResult.size(); i++){
            System.out.println(BMMResult.get(i).getValue() + "|" + BMMResult.get(i).getStartPoint()+ "|" + BMMResult.get(i).getEndPoint());
        }
        System.out.println("DEBUG BMM Unmatch = ");
        for(int i = 0; i != BMMUnmatched.size(); i++){
            System.out.println(BMMUnmatched.get(i).getValue() + "|" + BMMUnmatched.get(i).getStartPoint()+ "|" + BMMUnmatched.get(i).getEndPoint());
        }


    }
}




