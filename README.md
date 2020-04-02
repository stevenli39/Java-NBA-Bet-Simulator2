# Personal Project

## **Sports Gambling Simulator**

Project Overview:
- This application can be used as a sports gambling simulator, focusing on NBA basketball games. 
Users of this application can practice wagering on actual games and see their winnings or losses depending on 
how they chose to bet. 
- Those who seek a practice platform to test their wages in a risk free environment will find this application helpful. 
- As an avid basketball fan and an individual who likes to go against the odds, this project provides the ability
challenge myself by challenging conventional projects while bringing a passion project to life. 

## **User Story**

- As a user, I want to add all wagers into a list of historical wagers. 
- As a user, I want to see the results of my wagers and the game stats.
- As a user, I want to be able to see the amount of earnings or losses depending on my wager.
- As a user, I want to see the possible match pairings that are available for wager. 
- As a user, I want to save my balance to file.
- As a user, I want to optionally load my balance file. 

## **Instructions for Grader** 
How to generate the first two required events: 
- You can generate the first required event by first clicking on the "Account" button. This will bring you to a scene 
where you can enter an positive integer amount into the text box and then click on the "Add Amount" button. This will
add the specified amount into the account, open a confirmation box and bring you back to the main menu. 
- You can generate the second required event by again "Account" button. Again, you enter an positive integer amount and 
then click on the "Withdrawal" button, this will subtract the amount as long as your balance is larger than the
specified amount, open a confirmation box and bring you back to the main menu.
- In the Account scene, there is a label that displays your current account balance, this balance is updated after every
"Add Amount" or "Withdrawal" button click. 
- You can locate the audio and visual components simply by starting the application. The visual component is located 
on the main screen. In addition, please turn on your volume to hear the audio component of the program, it will be 
activated once you start the application. 
- You can save the state of my application by clicking on the "Quit and Save" button on the mainscreen or 
by exiting the application via the "x" on the tab itself. Essentially no matter, how you close the application, 
the information will automatically save. 
- You can reload the state of my application simply by starting up the application again. There is no button 
 that loads the data in the actual application as Professor Felix Grund said that having the state of the application
 upon start is sufficient. Piazza post @1017. 
 
 ## **Phase 4: Task 2** 
 - I have chosen to test and design a robust class. I have implemented this in the Account class. addBalance and 
 subtractBalance methods now both throw a NegativeAmount exception whenever a negative Integer is entered as a 
 parameter. This was done because you can not subtract or add a negative dollar amount. Associated tests have been
 added to the AccountTest class.
  
 ## **Phase 4: Task 3** 
 - First cohesion issue: In my UI class, many methods or functionality are not directly related to the UI. For example, 
 I took the saving and loading behaviour from main and directly copied and pasted it onto the UI. It should have been 
 refactored out into its own separate classes as it has no relationship with the UI. I have commented out the methods in
 the UI which I have refactored out and the new classes I added are Saver and Initializer. In addition, I noticed that 
 the code in the ProgramSound class and the PositiveIntegerChecker which was originally in my UI could be refactored as 
 the UI should be focused solely on the functionality and display of the application. I have also placed comments above 
 the commented out methods to provide further detail in the UI class. 
 
 - Second cohesion issue: There is repetition between the code, in the saving of methods that were previously in the UI. 
 -Solution to the Saver repetition: Originally I had one method each for Saving the accounts and pastwagers, but I 
 noticed that the only two points of variance between the two methods were the files that they saved to and the Saveable 
 classes that it was writing. I refactored the common behaviour into one method and created parameters for the 
 Saveable class that it was writing and the data file that it was writing the data to. This would have become tedious
 and repetitive issue if I needed to save more classes in the future. 
