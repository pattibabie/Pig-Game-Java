Patricia Bailey
Final Project - CMPT201

Files turned in:
	Die.java
	PigGame.java
	PigPlayer.java
	UserPigPlayer.java
	SimpleHoldPlayer.java
	Simulations.java
	READmeFinalProjectBailey.txt

Also, I ran PigGameGUI/PigGameProgram.java and it worked perfectly. It was really 
cool to see my program run graphically!
	

This was a fun and challenging project. I have not completed it yet. I got the 
game to run, and I'm currently working on "Win in Four Turns." I completed 
the Die, PigGame, PigPlayer, UserPigPlayer, SimpleHoldPlayer, and Simulations 
classes.

During this project, I learned that most of the time, what I need is much simpler
than I make it out to be. I overthink everything. When I finally figure out the 
code, it always seems like it should have been obvious.

This project also drove home the importance of psuedocode. I've started writing 
things out more beforehand, instead of aimlessly typing code. Not only pseudocode,
but comments, too! Commenting different parts of the code itself, makes it so I 
can go back and actually understand what is going on in it.

I'm also getting a lot better with loops and if-else statements. They are life-
savers, and they're fun to write. 

This project also gave me good practice with inheritance. It helps a lot to put 
it all together yourself. 

The best part about writing Pig were the moments of realization and success,
especially when I would figure it out without having to send out an email for help. 
The puzzle of it all was awesome. Simple game. Hard as hell to write. Best final
ever. 

*I commented out questions that I will answer as I finish those parts of the project.

//Describe your strategy in detail (for StrategicPlayer). You should explain your 
//reasoning, how you modified your strategy, and how well the strategy performed 
//after your modifications.
	I am currently working on this strategy. I will answer this
	when I am done.

//Describe how you implemented the other two strategies (FourTurnsPlayer and 
//WatchOpponentPlayer). What tweaks did you make to improve the WatchOpponentPlayer 
//strategy? 
	I am currently working on these strategies. I will answer this
	when I am done.

What are your answers to the three questions:

How much of an advantage does the first player have?
	I ran 4 million simulations, and the first player averaged 53.5% wins.
	Since it's a race to 100 points, the first player is already at an 
	advantage, because they are the first to accrue points, and therefore they
	have a headstart. It seems that that simple fact affords the first player 
	a 3.5% advantage over the second player.

What is the best hold value to use for the SimpleHoldPlayer?
	In the simulations I did for SimpleHoldPlayer using bestHoldValue, I noticed
	that numbers between 18-25 had particularly good chances of success 
	especially if the opponent has a hold value of 10 or 15. If the opponent has
	the default hold value of 20, the numbers are much closer. The best hold
        values of the player when the opponent has a hold value of 20, were 18, 19,
	and 22-25. I don't think I can say just yet what the "best" hold value is 
	for SimpleHoldPlayer, but it's most likely within these ranges.

//Which was the best strategy: SimpleHoldPlayer, WatchOpponentPlayer, 
//FourTurnsPlayer or StrategicPlayer? 
//Provide percentages of how they perform against the other strategies. 
	I am currently working on these strategies. I will answer this
	when I am done.