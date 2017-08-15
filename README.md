# SentimentAnalyzer

Opinion read from a text file:
0 - No Opinion
1 - Positive Opinion
2 - Negative Opinion

I coded this project is Java. Initially, data that is returned by Web service (REST API) is provided in XML format. Ideally XML parsing library like JDOM would be used for parsing XML, but the goal of this project was different. It was testing to see if I can do something on my own without using any external libraries or APIs. Keeping the end goal in mind, I was able to parse the XML file using String manipulation. I created a book object from response returned by www.goodreads.com. I parsed for six elements that would make up one book in goodreads database: title, author, publication year, average rating, total rating counts, and image url.
