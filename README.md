# Network Project
ITCS 3166 Project Description
----------------------------

This is a Group Project. Locate your Group Members on Canvas.*

1. Prepare 30 PowerPoint slides on the subject of IP (Internet Protocol) (Chapter 5)

2. Find a youtube video (or another video) on the subject of IP (Internet Protocol). Save the video link in a text file.

3. Implement IP router function, which does the following:
- takes as an input: 
	- a 32 bit IP address
	- a routing table: a list of IP address - subnet mask - Interface (NIC card) pairs
- does a binary AND of the subnet mask with the input IP address to extract the network part of the address
- compares the network part of the address with each address in its routing table
- if it matches with one of them , it routes the packet to the matching Interface
- if it matches none of them , it routes the packet to the Default Router (Gateway)

4. Use the data (IP addresses and routing table) from Exercise 33 Chapter 5  for your program.

Hint: the IP addresses first need to be converted to binary in order to extract and compare the network part . see sample IP address conversion here:
https://webpages.uncc.edu/aatzache/ITCS3166/ExerciseD.doc

5. Create a Graphical User Interface - showing which packet gets routed to which Interface at any given time. Use Java programming language for this project.

6. To turn in: upload the PowerPoint file, the video link file, and the implementation source code files to Canvas | click on Group Project.  One group member ONLY should upload the project.

* Note:
This is a Group Project . On Canvas locate your Group Members , and obtain their e-mails . This project requires that every student checks his/her UNCC e-mail account, and communicates with his / her group-mates . Contact your group-mates as soon as possible . Be sure to talk to them , meet with them , e-mail , telephone , Facebook or use any other means of communication you like . You may meet in person or online via Skype , GoogleHangout or another means . If a student is reported by his / her group-mates as non-responsive or not participating in the group activities , the student will receive a grade of   0   for this project .
