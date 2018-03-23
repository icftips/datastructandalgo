package com.icftips.practice.string;


public class TextJustification {

    public static void main(String[] args) {
        String [] input = new String[]{"aaa","bb","cc","ddddd"};
        int col = 6;
//        String[] input = new String[]{"tushar", "roy", "likes", "to", "code"};
//        int col = 10;
        System.out.println(textJustificationCost(input, col) );
    }

    private static String textJustificationCost(String[] input, int cols) {

        int[][] dp = new int[input.length][input.length];
        /*
        initializing dp matrix
        */
        for (int i = 0; i < input.length; i++) {
            int sofar = -1;
            int j = i;
            for (; j < input.length; j++) {
                if (sofar + 1 + input[j].length() <= cols) {
                    sofar += 1 + input[j].length();
                    dp[i][j] = (int) Math.pow((sofar - cols), 2);
                } else {
                    break;
                }

            }
            while (j < input.length) {
                dp[i][j++] = Integer.MAX_VALUE;
            }
        }

        /*
        finding cost of each word placement
        */
        int cost[] = new int[input.length];
        int word[] = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            cost[i] = dp[i][input.length - 1];
            word[i] = input.length;
            for (int j = input.length - 1; j > i; j--) {
                if (dp[i][j-1] == Integer.MAX_VALUE) {
                    continue;
                }
//                System.out.println("["+i+" : "+j+"]"+cost[i]+" > "+cost[j]+" + "+dp[i][j - 1]);
                if (cost[i] > cost[j] + dp[i][j - 1]) {
                    cost[i] = cost[j] + dp[i][j - 1];
                    word[i] = j;
                }
            }
        }
        
        /*
         Building final justified text
         */
        StringBuilder st = new StringBuilder();
        int i=0,j=word[i];        
        
        while(j<input.length){
            j=word[i];
            for(int k=i;k<j;k++){
                st.append(input[k]).append(" ");
            }
            st.append("\n");
            i=j;
        }
        return st.toString();
    }

}
