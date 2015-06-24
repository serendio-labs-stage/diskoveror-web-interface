# Diskoveror Web Interface

The Web interface consists of REST api's and an User Interface to utilize the Text-analytics and ML modules developed at Serendio.

### The User Interface

The engine at the backend is tied with a simple user-friendly front end.

![Diskoveror Web Interface](/Analyze.jpg "Web Interface")


### RestAPI

The RestAPI on being called (by passing the input text to it) with a GET request returns a structured JSON. This JSON contains the following fields:

* Entities 
* Topics
* Sentiment

The Entitie list is also checked for coreferences which ithe engine resolves internally.

