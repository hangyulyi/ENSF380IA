# ENSF380 Individual Assignment

## Requirements to run the program:
All files should be in the correct file structure if not modified but in the case they are, files should be in the following structure:
```
├── edu/ucalgary/oop
│   ├── All .java files should be in the package including test files
│   └── GenderOptions.txt
├── lib
│   ├── hamcrest-core-1.3.jar
│   └── junit-4.13.2.jar
├── project.sql
└── remaining files
```

In order to compile files, navigate to the main folder where you have the files structured as shown above and then run the command:
```zsh
javac -cp ".:lib/*:." edu/ucalgary/oop/*.java
```

Now, to run the program, run the command:
```zsh
java -cp ".:lib/*:." edu.ucalgary.oop.DisasterVictimGUI
```

This should bring up a GUI giving you the option to add/edit DisasterVictim and go to Relief Services.

### Things to note when using the GUI:
- As of right now, in order to edit a Disaster Victim's information, you need to go into the Edit panel, click the desired victim on the list shown on the left of the screen, back, and then enter the edit screen again.
- Relief Services have not been implemented and are not able to be used.