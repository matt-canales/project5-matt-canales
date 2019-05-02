Project 5 Documentation
======================


Problem Solving Approach
------------------------

In this project, we were tasked with implementing a functional GUI for our Mesonet comparison project. 

Our goals for the functions available to the user included:

**Listing all stations that are a specified Hamming distance from a selected station**

**Counting the number of stations at each Hamming distance from our selected station**

**Adding a text string to the list of stations**

We were also given a free section, which I took advantage of by creating a display area to **show an up to date station list.**

I ran into a few challenges on this project, most notable was an issue I had with duplicate entries and inflated station tallies.

This was happening because I did not properly re-initialize each variable when a new station was entered.


Method Analysis
------------------------
*in Driver.java*

**main(String[] args)**

The main method. A new *HammDistFrame* is called and stored as *hammDist*.

The default close operation is set, the frame is packed, and the visibility is set to true.

*in HammDistFrame.java*

**HammDistFrame()**

This default constructor requires no arguments.

Several text fields, labels, buttons, text areas, and a slider are created and added to the window layout.

Our HammingDist type variable is initialized to a new HammingDist object.

A call is made to calcAllLocationDist() on our HammingDist object. 

**actionPerformed(ActionEvent e)**

This method listens for triggered action listeners, and performs the actions for the respective action listener.

The source of the action event is checked to determine which button was pressed.

If the source is *calcDist*, the *location1* local var of our HammingDist local object is set to the selected station ID. A call is then made to *calcAllLocationDist()* to prepare the values for the distance counts, which are then used to set the output field values.

If the source of the event is *addStation*, the *addLocation()* function in our HammingDist class is called with the current value of *addStationText* being passed in.

If the source is *showStations*, the *distOutput* text area is cleared, and the state of the *distSlider* is checked. The stations that match this specified distance are appended to the text area one by one in a for loop.


**stateChanged(ChangeEvent e)**

The source of the ChangeEvent is checked.

If it is the slider, the text box *sliderState* is set to the value of the slider.

**read()**

A new BufferedReader is created, with a new FileReader argument pointing to "Mesonet.txt".

Each line of the input is stored in a String[] array using a for loop.


*in HammingDist.java:*

**HammingDist(String loc1):**

This constructor accepts a String type argument.
This argument is stored in local variables for later access. 

The constructor makes a call to the *read()* method within a try-catch, which reads and stores the relevant info to a local ArrayList. 

**read():**

This method handles the reading of the specified file line by line. 
 

Next, a for loop walks through each line, adding them to our String ArrayList, locationList.

**calcHammingDist(String loc1, String loc2):**

This method accepts 2 String type arguments. 

Next, a for loop walks through each character of both Strings, and increments the numberDifferent counter each time there is a mismatched character.

Finally, the counter value is returned.

**calcAllLocationDist():**

This method calculates the distance between the *location1* String and all of the 119 locations in our *locationList*.

A for loop walks through and calls the *calcHammingDist()* method, passing it location 1, and each location on the list. 

The counter is incremented, and separate lists are kept of each HammingDist.

