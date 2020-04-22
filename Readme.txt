Object oriented programmin task no.1
Eden Harel - ID:205518178
Dorel Saig - ID:308065176

Election System:
built from 8 classes.
all of the data is hard-coded in Program class, that includes:
1. round1 - roundmanager object that will include all program data.
2. array of 2 voting stations.
3. array of 3 parties.
4. array of 10 citizens.

menu with hard coded additions:
1.military voting station
2.military aged citizen - will be added to said military voting station.
(if changed to a non military aged citizen he will be added to a random voting station list of voters)
3.left wing party.
4.party candidate - will be added to the 2nd party "Meretz"

menu option 5-7 will print data on screen - get methods return StringBuffer

menu option 8 - voting process:
The voting process is random by design.
the method works by randomising a boolean value to determine if a citizen votes or not (asks if wants to vote)
if true, a random number between 0 and the number of all added parties will be generated, and according to that number the citizen will cast his vote.
menu option 9 - displays current round results.
menu option 10 - exit program.


General notes:
full arrays (of all types) will double in size in order to add an object to a full array.
ArrayList,Instances were not used as instructed, the program will be more readable and efficiant using these options.
