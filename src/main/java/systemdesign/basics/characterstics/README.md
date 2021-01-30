#### 1. Scalability
1. Capacity to manage increase demands
2. Increased data volume or increase QPS
3. Generally performance of system declines with system size because machines tend to be far apart from one another.


##### Horizontal Vs Vertical Scaling
Horizontal: Add more servers
Eg: Cassandra and mongo db

Vertical: Add more power: CPU/RAM/Storage etc
Eg: MySql

#### 2. Reliability
1. Probability that a system will fail in a particular period
2. Continue delivering service in case of hardware failure
3. For example: Any user transaction should not be cancelled by failure of machine running that transaction.
Solved by replica of data and software components.


#### 3. Availability
1. System or machine remains operational
2. Reliable means available but available does not mean reliable. Even when system is available, it can not be reliable.

#### 4. Efficiency
1. Latency
2. Throughput (no of messages and size of messages)

#### 5. Serviceability
1. How easy it is to operate and maintain?
If time to fix a system increases, Serviceability decreases.