# urlshortener

An example copied from Clojure Programming Book.

A Simple (in memory) url shortener service

## Usage

Execute on project's root:

    $ lein run


## Examples

After you have the server running try:

Save an url:

    % curl -i -X POST 'http://localhost:8080/?url=http://clojurebook.com' HTTP/1.1 201 Created
    Date: Sun, 18 Dec 2011 20:58:09 GMT
    Location: 1
    Content-Length: 58 Server: Jetty(6.1.25)

Try to set an already taken short url:

    % curl -i -X PUT 'http://localhost:8080/1?url=http://apple.com' HTTP/1.1 409 Conflict
    Date: Sun, 18 Dec 2011 20:58:40 GMT
    Content-Length: 28
    Server: Jetty(6.1.25)
    Short URL 1 is already taken

List short urls:

    % curl http://localhost:8080/list/
    1

An unexistent URL:

    % curl -i http://localhost:8080/some/other/url HTTP/1.1 404 Not Found
    Date: Sun, 18 Dec 2011 21:21:53 GMT Content-Length: 28
    Server: Jetty(6.1.25)
    Sorry, there's nothing here.

Access a short url:

    curl -i http://localhost:8080/1
    HTTP/1.1 302 Found
    Date: Fri, 03 Jul 2015 17:42:06 GMT
    Location: http://clojurebook.com
    Content-Length: 0
    Server: Jetty(9.2.10.v20150310)

## License

Copyright © 2015 Mariano Cortesi

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
