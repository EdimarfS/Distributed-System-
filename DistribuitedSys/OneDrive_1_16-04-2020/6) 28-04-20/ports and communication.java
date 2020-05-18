import java.net.*;
//import javax.net.*;

//a logical port "represents" a service
//a service is hosted on a "host" machine and made available (reachable) through a port

/*
  In a multi-client setting, several clients try to reach the same service
  by sending requests to the same port. Separate sockets (so, connections)
  are then created for each of those clients.
*/

/*
  - The server program continuously executes on a host machine, listening on a
    specific port for client requests;
  - A client sends a request to the service (which is exposed on the aforementioned port);
  - The server creates a socket to handle the communication with the client;
  - A stream is then associated to the sockets lying at both ends (server/client);
  - At the end of the communication process, the two sockets must be closed (this closes
    the connections and the associated streams).
*/