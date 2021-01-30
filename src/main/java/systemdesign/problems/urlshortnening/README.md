### URL Shortnening

#### 1. Objective
To create shorter alias for long URLs

#### 2. Requirements and goals

##### Functional Requirements
1. Given a URL, generate a short version of URL
2. When users access short link, service should redirect to main URL
3. Users should be able to pick custom short links
4. Links will expire after a normal timestamp

##### Non functional Requirements
1. System should be highly available. If service down, all redirections will fail.
2. Redirections should happen in real time with minimum latency.
3. Link should not be guessable

##### Monitoring requirements
1. How many times redirections happen?
2. Latency for redirection?

#### 3. Design Considerations

#### 4. Capacity estimation and constraints
* Object size: 500 bytes with read/write: 100/1
* URL shortnening per month: 500 million
* Total years: 5

 = 500M*100 => 50B
 QPS: 50B/(5*365*24*60*60)

#### 5. Functional interface

#### 6. Database design

#### 7. HLD/LLD

#### 8. Data partitioning and replication

#### 9. Load balancer

#### 10. Purging or DB cleanup

#### 11. Monitoring

#### 12. Security and permissions 