#  Meltwater Technical Exercise
Used postgresql, springframework.boot,  "@angular/cli": "~13.3.5", "@angular/compiler-cli": "~13.3.0"
Backend   private server = 'http://localhost:8080'; (Typical java spring app build run) 
Frontend 'http://localhost:4200' (angular app npm install npm start.. etc) 
Add the .txt files in the git repo to ("user.home") + "/Downloads/uploads/" for quicker start up and full access to features 


The purpose of this assignment is to get a feel for how you approach technical and programming problems. There is no ‘right’ or ‘wrong’ answer. Think about the problem and do the best you can, and be prepared to talk about the process you followed and any questions or problems you encountered.
Assignment Part 1
You work for the CIA. You are given a software engineering assignment related to processing classified documents.
You are given a task to build a program that can be demoed to process classified documents (text format) and remove censored text.
Definition:
The program will remove given keywords and phrases from document text and insert XXXX at the locations where the text was removed.
Input parameters:
1. String of keywords and phrases: a string of censored keywords and phrases separated by spaces or commas. Phrases will be enclosed in single or double-quotes. Some examples:
Hello world “Boston Red Sox”, ‘Pepperoni Pizza’, ‘Cheese Pizza’, beer
2. Document text – the original document text that needs the provided keywords and phrases removed (masked out).
Returns:
Document text with indicated keywords and phrases removed and replaced with XXXX.
Please design and build this program in a way it can be demoed using a language of your choice (Our stack is mostly JS). Be prepared to discuss the design issues and trade-offs you considered.
Assignment Part 2
As an extension, you’ve been asked to store the documents and make them searchable by the keywords that were redacted from them. Be prepared to discuss how you’d design this system. How would you store the data? How would you make it searchable? How would you expose it to external consumers? Don’t worry about implementing anything for this section.
   
