#### Load Balancing

1. If server not responding, LB will stop sending request to the server
Client -> LB -> [S1, S2, S3]
2. By balancing load across multiple servers, LB reduces individual server load thus improving availability and resposiveness.
3. Client -> LB -> Web Server -> LB -> Application Server -> LB -> Database Server

##### Benefits of load balancing
1. Users experience fast uninterrupted service
2. Less downtime and high throughput.
3. Make it easier to handle incoming request.
4. Smart load balancer: Predict trend in traffic and determine traffic bottlenecks

##### Load Balancing Algorithms
Health Checks: LB should forward request only to active backend servers. 
Removed from the pool if health check failed.

1. Least connection: Directs requests with least connections
2. Least response time: Directs to lowest average response time and fewest active connections
3. Least bandwidth: Serving least amount of traffic measured in MBPS
4. Round robin: To next server in round robin way
5. Weighted round robin: Handle servers with different processing capabilities
6. IP hash: Hash calculated to redirect to client


##### Redundant load balancer
1. One LB monitors others LB. In case of failure, other LB takes over.