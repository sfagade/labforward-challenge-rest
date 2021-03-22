**Project Name:** com.app.labforward <br/>
**JDK Version:** 11

**Description:** This project serves a RESTful API endpoint for determining the frequency of a word in a notebook. 
It works with based on the rule that a word is considered similar to another only if the Levenshtein distance is not 
more that one.

**Specs:** <p>This project is a Spring-boot project and does not make use of any special libraries other that the required 
library for Spring REST API and validation framework. The application is configured to run on port 8182 and exposes a 
single Rest post endpoint.</p>
<p>I would say I spent about 5 hours on the project as a whole, it's a bit hard to say accurately because I did not do 
everything in one sitting (I had to juggle doing this with other responsibilities over the weekend). I'd say most of my 
time was spent on the web interface, majorly because I'm not as experienced with React as I am with Java, so I spent 
some time debugging why I was getting a strange behaviour on the UI and also doing the little css on the interface.</p>

**Further Improvements:**
<p>I suspect that this solution might not scale very well if say we have to perform a search within a very large 
notebook. Given the right motivation I would spend some time working on providing a better scaling capabilities for the 
solution. I suspect there might be some other nuances that one may have to consider and test as well.</p>
<p>Another area I might want to revisit is improving the lookandfeel on the web interface. My suspicion now is that the 
current implementation might not work well across different device screen types </p>

**Build Instructions:**
    To build the application you can run any of these commands from the root 
    folder of the application
    <ul>
        <li>
            *mvn clean install*. 
            This will first delete all generated files from previous successful run 
            commands and then run all the tests in the application again and generate 
            an executable jar file in the target folder of the application.
        </li>
        <li>
            *mvn clean install -Dmaven.test.skip=true*. 
            This does the same has the previous command with the only difference being 
            that this does not run any of the tests.
        </li>
    </ul>

**Run Instructions:**
There are three ways to run the application the first two requires that you have
successfully completed a build process:
    <ul>
        <li>java -jar target/com.app.labforward.challenge-0.0.1-SNAPSHOT.jar</li>
    </ul>

**Testing:**
By default application is reachable via http://localhost:8182/api/notebooks [POST]
<br />
Sample Payload
    
``` 
    {
        "notebookWord": "Word word wor Word ord",
        "searchWord": "word"
    }
    
