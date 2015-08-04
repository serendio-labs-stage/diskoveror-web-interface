# Diskoveror Web Interface

The Web interface consists of REST api's and an User Interface to utilize the Text-analytics and ML modules developed at Serendio.

### The User Interface

The engine at the backend is tied with a simple user-friendly front end.

![Diskoveror Web Interface](/diskoveror.jpg "Web Interface")
![Diskoveror Web Interface](/diskoverorimg.jpg "Web Interface")

### RestAPI

A HTTP based Rest API is supported in this package. It has the capability to extract the below data from any input text that is passed to it:

 * Basic Entities like Person,Organization etc.
 * Life Science based entities like Protein, Genes etc.
 * Topic Identification of given text.
 * Sentiment extraction of given text.

#### Syntax

The components of a given text could be extracted by setting the below parameters and giving a post request to the 
API :

>        analysis  - Extracts specific text analyics data from input text. (Mandatory)

##### Values compatible

>        All (Gives an output with all of the features resolved by the engine)                  
>        Entities (Output consists of only entities resolved from the input text)        
>        LSEntities (Returns Life Science entities)
>        Sentiment (Gives the overall sentiment of the input text)
>        Topics (Returns the categories to which the input belongs to)

##### Example Usage:

>        analysis=All
>        analysis=Entities,Sentiment
>        analysis=Sentiment

##### Entities (optional)

Specifies the entities that are required to be extracted from the input text. Default is all entities.
Values compatible

>        Person
>        Organization
>        Location
>        Currency
>        Date
>        Time
>        Percent

##### Example:

>        entities=Person
>        entities=Person,Organization

##### inputtext (Mandatory)

The input to the diskoveror text analytics modules.

##### Example:

>        inputtext=”This sentence is given for example. Bill Gates is a co-founder of Microsoft”

The RestAPI on being called (by passing the input text to it) with a GET request returns a structure


### Starting the web-interface application
#### Installing Playframework
[Follow the tutorial on the official website](https://www.playframework.com/documentation/2.4.x/Installing)
#### Starting the web-application from play
![Starting web-app](/rsz_play1.png "Web Interface")

### Example RestAPI request

>        curl -GET --data-urlencode "analysis=All" --data-urlencode "inputtext=$value" http://5.9.115.14:9000/api


