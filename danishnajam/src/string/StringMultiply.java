Comment added
 
ICF Interview Prep Group
STREAM
STUDENTS
ABOUT
ICF Interview Prep Group

Danish Najam

Iqbal Zaveri
Select theme
Upload photo
Due Saturday
8:00 AM – String Homework 1
VIEW ALL
TOPICS
Arrays & Misc
Dynamic Programming
Graphs
In-Class Problems
LinkedListsStacksAndQueues
Multithreading
Object Modelling
Recursion
Scalable System Design
Schedule
Sorting
Strings
Trees
ADD TOPIC
STREAM
Show deleted items


Post by Shahzad Mughal
Shahzad Mughal
Created 10:41 PM10:41 PM

Shortest path in binary maze

coding_practice/ShortestPathInBinaryMaze.java at master � shahzadmughal8410/coding_practice � GitHub
https://github.com/shahzadmughal8410/coding_practice/blob/master/algo/src/main/java/sm/coding/algo/practice/icf/test/randomtest/graph/ShortestPathInBinaryMaze.java

Shahzad Mughal10:41 PM
It looks difficult to open from submitted assignments, sharing a direct link.

Add class comment…

Announcement: "String Multiple Solution"
Danish Najam
Created 10:34 PM10:34 PM

String Multiple Solution

StringMultiply.java
Java

Shahzad Mughal10:42 PM
github link would be better, phone is unable to open it

Add class comment…

Announcement: "Shortest Path In Maze Solution"
Danish Najam
Created 10:28 PM10:28 PM

Graphs
Shortest Path In Maze Solution

ShortestPathInMaze.java
Java
4 class comments

Iqbal Zaveri10:32 PM
Who is the author of this code?

Shahzad Mughal10:34 PM
Supposed to be @Danish bhai

Iqbal Zaveri10:36 PM
@Danish bhai
At least I am not able to open on my iphone. May be a github link would be better 

Danish Najam11:12 PM
https://github.com/icftips/datastructandalgo/blob/master/danishnajam/src/graph/ShortestPathInMaze.java

Add class comment…

Question: "Find distance between two nodes of a Binary Tree"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Find distance between two nodes of a Binary Tree
Find distance between two nodes of a Binary Tree
Find the distance between two keys in a binary tree, no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.
1
DONE
14
NOT DONE

Add class comment…

Question: "Shortest path in a Binary Maze"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Shortest path in a Binary Maze
Shortest path in a Binary Maze
Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

Expected time complexity is O(MN).

For example –

Input:
mat[ROW][COL] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
{1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
{1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
{0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
{1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
{1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
{1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
{1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
Source = {0, 0};
Destination = {3, 4};

Output:
Shortest Path is 11
2
DONE
13
NOT DONE

Add class comment…

Question: "Multiply strings"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Multiply strings
0
DONE
15
NOT DONE

Add class comment…

Question: "String compression"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
String compression
0
DONE
15
NOT DONE

Add class comment…

Question: "Minimum window substring"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Minimum window substring
0
DONE
15
NOT DONE

Add class comment…

Question: "Largest common prefix"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Largest common prefix
0
DONE
15
NOT DONE

Add class comment…

Question: "Implement Trie"
Iqbal Zaveri
Created Jan 20Jan 20

In-Class Problems
Implement Trie
0
DONE
15
NOT DONE

Add class comment…

package string;

public class StringMultiply {

    public static String multiply(String first, String second) {
        first  = reverse(first);
        second = reverse(second);

        int result[] = new int[first.length() + second.length()];

        int  intAtFirst, intAtSecond;
        //multiply each digit and do a summation at the corresponding index
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                intAtFirst  = Character.getNumericValue(first.charAt(i));
                intAtSecond = Character.getNumericValue(second.charAt(j));
                // record the results at the index location offset by i's current index in summation manner
                result[i+j] = result[i+j] + intAtFirst * intAtSecond;
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < result.length; i++) {
            int mod = result[i]%10;
            int carry = result[i]/10;
            if(i+1 < result.length){
                result[i+1] = result[i+1] + carry;
            }
            sb.insert(0, mod);
        }

        //remove all front 0's if any
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","25"));
    }
}
