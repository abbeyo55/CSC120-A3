//all imports needed (scanner, list, arrays, arraylist, random)
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

class Conversation {
  public static void main(String[] arguments) {
    System.out.println("Hello!!! I am really excited to talk today!"); //greeting at the beginning
    System.out.println("How many times would you like to talk?"); //asks questions for user response 
    Scanner inputManyRounds = new Scanner(System.in); //user input
    int numRounds = inputManyRounds.nextInt();

    String[] scriptArray = new String[2 * numRounds + 2]; // set size of Array, how many lines

    scriptArray[0] = "What are you thinking about?";
    System.out.println("What are you thinking about?"); //begins first question to ask 


    Scanner inputLoop = new Scanner(System.in);  

    // canned responses if words are not used for replacement 
    List<String> cannedResponses = Arrays.asList("Hmm...", "Mmmm...", "Tell me something else instead","Tell me about yourself", "That is really interesting", "I am enjoying this conversation", "I am confused tell me more");
    int c = 1; // so that the questions and responses don't write over each other

    for (int n = 0; n < numRounds; n++){
      /*
       * define list that will store new words for output
       * take user input and then
       * convert user input into list 
       */
       List<String> outList=new ArrayList<String>();

       String whatThinks = inputLoop.nextLine();
       scriptArray[c] = whatThinks; // add the input to transcript
       c += 1; // doesn't overlap of what we wrote about previously 
 
       String[] think = whatThinks.split(" ");
       List<String> newSentence = Arrays.asList(think);
  
    // creates replacement words is nothing special is used "I, you, me. etc"

    if (!newSentence.contains("I") && !newSentence.contains("am") && !newSentence.contains("are") && !newSentence.contains("you") && !newSentence.contains("my") && !newSentence.contains("your") && !newSentence.contains("me")){ // if not containing any of the mirror words...
      String response = cannedResponses.get(new Random().nextInt(cannedResponses.size())); //choose a canned response randomly 
      System.out.println(response); //print a canned response randomly 
      scriptArray[c] = response;
      c = c + 1;

    }else{ //replacement words, taking into account capitalization
  
      for (int i = 0; i < newSentence.size(); i++){

        if(newSentence.get(i).equals("I")){
          outList.add("you"); 
        }
        else if(newSentence.get(i).equals("am")){    
          outList.add("are");
        }
        else if(newSentence.get(i).equals("Am")){    
          outList.add("Are");
        }
        else if(newSentence.get(i).equals("are")){    
          outList.add("am");
        }
        else if(newSentence.get(i).equals("Are")){    
          outList.add("Am");
        }
        else if(newSentence.get(i).equals("you")){    
          outList.add("I");
        }
        else if(newSentence.get(i).equals("You")){    
          outList.add("I");
        }
        else if(newSentence.get(i).equals("my")){    
          outList.add("your");
        }
        else if(newSentence.get(i).equals("My")){    
          outList.add("Your");
        }
        else if(newSentence.get(i).equals("your")){    
          outList.add("my");
        }
        else if(newSentence.get(i).equals("Your")){    
          outList.add("My");
        }
        else if(newSentence.get(i).equals("me")){    
          outList.add("you");
        }
        else if(newSentence.get(i).equals("Me")){    
          outList.add("You");
        }
        else if(!newSentence.get(i).equals("your") || !newSentence.get(i).equals("me") || !newSentence.get(i).equals("my")|| !newSentence.get(i).equals("you")|| !newSentence.get(i).equals("are")|| !newSentence.get(i).equals("am")|| !newSentence.get(i).equals("I")){ 
        outList.add(newSentence.get(i));}

      } // close the loop for replacement words 

      String joined = String.join(" ", outList); // join list back into string, joins together everything
      String response = (joined + "?"); //adds question mark to what was asked, repeats back question with changing mirrored words 
      System.out.println(response); // print mirror question or response without mirror statements
      scriptArray[c] = response;
      c += 1;

    } // close else statement
  } //close rounds for loop

  String end = "It was great talking to you!! Goodbye!"; //end conversation 
  System.out.println(end);
  scriptArray[c] = end;
  
  System.out.println("Transcript:"); //prints transcript, final product all put together 
  
  for(int i=0 ; i<scriptArray.length ; i++) //print array from what was created above
  System.out.println(scriptArray[i]);    

    inputManyRounds.close();
    inputLoop.close();
    
  } //closes public void argument
  } //closes class / EVERYTHING (this can now be called in the "main" channel)



/*
// coding for replacement statements mirroring a set of words in a compressed way from Office Hours, wasn't sure how to add this in to code
    String[] toMirror = {"I", "me", "you", "am", "my", "your"};
    String[] replacememts = {"you", "you", "I", "are", "your", "my"}; // in line to replace one another
    String[] words = sentence.split(" ");
    for (int i=0; i<words.length; i++) {
      String r = " "; //I believe with code this would have to turn all "r"s to "c" given coding for Sentences
      for (int j=0; j<toMirror.length; j++){ //need to use both "i" and "j" so that they don't overlap one another when coding to cause an error
        if (words[i].equals(toMirror[j])){
          r = replacememts[j];
        }
      }
      if (r.equals(" ")){
        r = words[i];
      }
      newSentence += " " + r; //adds with the += while keeping same sentence
    }
   System.out.println(newSentence); //replaces sentence with the correct wording (just once)

 */



 /*
  * Sources:
  https://www.geeksforgeeks.org/java-program-to-replace-multiple-characters-in-a-string/ 
  https://www.w3schools.com/java/java_user_input.asp
  https://stackoverflow.com/questions/20275572/how-to-use-or-in-java
  https://www.w3schools.com/java/java_for_loop.asp
  https://www.geeksforgeeks.org/list-contains-method-in-java-with-examples/
  https://softhints.com/java-split-string-into-list-examples/
  https://stackoverflow.com/questions/29441908/list-cannot-be-resolved-to-a-type
  https://www.geeksforgeeks.org/arrays-in-java/
  TA Hours, Jordan Crouser 
  */