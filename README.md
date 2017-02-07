# AutoCompleteTest
The repository contains the test project for Autocomplete assignment

The Repository mainly contains 1 project file and another is an HTML file which acts as a client to consume the REST service exposed by the project.

Guidelines to setup and test: 

1) Import the RestTest project into STS and run it as a spring boot project. This will expose the REST service on localhost and the service endpoint can now be tested with below given URL 

http://localhost:8080/autoFill?name=input

This will return a list of string in a JSON format which will match the input as prefix.

2) Once the REST service is up. Launch the RestClient.html file into google chrome browser.
3) Type any prefix suppose "ab" in the text field. It is going to create a list of matching words in an unordered list just below the input field.

Open Items: 

1) The assignment was to make an autocomplete which means that user should be able to click the search results and it should fill the input field just by that click. This part could not be implemented.

2) The current implementation is donw with vanilla ajax. This should have been implemented with Jquery or angular JS kind of JS framework. 
