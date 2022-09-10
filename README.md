## Woodpecker-IELTS-English-Word-Desktop-Software
#### 1. Overall Introduction
The software we developed is an **English vocabulary memory desktop software**. The main users are students who want to learn English to improve their IELTS scores. This software provides a variety of functions to help users recite IELTS words, strengthen their memory of vocabulary, and test users' learning results; allow users to make learning plans and give learning feedback.

It is available for the users to search for translation and explanation of words and phrases. It can also strengthen users’ memories of vocabulary by several functions such as **self-testing, vocabulary push, and adding unfamiliar words to the notebook**. Furthermore, the software is designed to motivate users to learn new words by its **clock-in** function.

Our software provides users with **two different testing methods**: word spelling detection and pronunciation recognition. First of all, an interesting game can test the user's word memorization. The user will complete the spelling of multiple words according to the game prompts. In addition, the user can also read the pronunciation of a given word, then let the software recognize and give a corresponding score.

In terms of memorizing words, the software will **automatically** select suitable words according to the target IELTS score set by the user, so as to avoid words that are too difficult or too simple to affect the user's mood of memorizing words. The user is also allowed to set the number of words to learn each day, and then this software can **record the user's learning situation** and give **feedback**, promoting the user's **self-reflection** and **English ability improvement**.

Equally important is that our software is presented in a beautiful, user-friendly form, in order for users to enjoy a good experience. 

<div align=center><img src="https://github.com/WangHewei16/Woodpecker-IELTS-English-Word-Desktop-Software/blob/main/images/software%20poster.png" width="990"/></div>

#### 2. Technologies

`Platform:` desktop <br>
`Programming language:`
* Front end: Java Swing
* Back end: Java, MySQL, AliCloud


`Others:`
* Youdao-Zhiyun API 
* org.apache.http related JAR: httpcomponents-client-5.0.3/4.5.13/4.2.5 
* json JAR: json-20090211.jar
* Microsoft API 
* iFLYTEK Voice Evaluation API


#### 3. Functions
* Implemented an APP that helps users memorize IELTS words, with a progress bar, word memorization, check-in, dictionary lookup, word push, word test, vocabulary book, and pronunciation correction. 
* Completed the UI design of the login interface and the main interface so that the word push can go forward and backward, connect to the Microsoft API, and get a detailed explanation of each pushed word, including translation, synonyms, and example sentences. 
* Designed the user plan function so that users can freely set the number of daily plan words, word difficulty, and self-test number, and set up push to record the length of time the user stays on the word, the time of the last word learning, and the error rate in the test. 
* Developed an algorithm to use the recorded data to figure out the words most likely to be forgotten by the user, connected the app to the pronunciation engine, and accurately read each word when pushing and rewriting the iFLYTEK Voice Evaluation API. 
* Provided users with a test user’s pronunciation and gave a score for the word’s pronunciation, the score for each syllable, and the relevant information of each syllable phoneme to design the application’s word query function and vocabulary function. 

<div align=center><img src="https://github.com/WangHewei16/Woodpecker-IELTS-English-Word-Desktop-Software/blob/main/images/function%20diagram.png" width="600"/></div>

#### 4. Development Scrum 
The figure below demonstrates the project plan before we develop the software. There are five scrum in our project and each scrum includes two or three user story.
<div align=center><img src="https://github.com/WangHewei16/Woodpecker-IELTS-English-Word-Desktop-Software/blob/main/images/develop%20scrum.png" width="550"/></div>
