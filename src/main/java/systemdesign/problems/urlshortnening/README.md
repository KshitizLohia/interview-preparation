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
* URL shortening per month: 500 million
* Total years: 5

Traffic Estimates:
 = 500M*100 => 50B
 QPS: 50B/(5*365*24*60*60)
500 Million / (30 days * 24 hours *3600 sec) ~  200 QPS

Read to write ratio:  100:1  
Read QPS: 20K 


#### 5. Functional interface
createURL(apiKey, url, alias, username, expireDate)
deleteURL(apiKey, urlKey)

#### 6. Database design
1. We need to store billion of records
2. Each object is small
3. No relationship b/w records
4. Read heavy service.

What kind of database? Since we anticipate storing billions of objects, a NoSql DB is a better choice.

#### 7. HLD/LLD
##### Approach 1: Encoding actual URL
* Create a unique hash (base64 or base62 encoded) of the actual URL
base 64: pow(64,6) billion string -> 6 letters

String -----MD5-----> 128 bit -----base 64------> 21 chars
base 32: pow(32,6) billion string -> 6 letters

Problems: 
1. If multiple people enter same URL, We get same shortened URL. -> Append sequence to URL to make it unique
Appending sequence number will affect performance
2. What if part of the URL are encoded?

##### Approach 2: Generating Keys Offline
1. Generates 6 letters string and store in database
2. Whenever we generate URL, we take 6 letters string and use it
[Don't have to worry about duplicates or collisions]

Can concurrency be an issue? Each time a key is used, it should be marked in DB as used
Move not used keys to used keys as soon as we move it to server.
a) Multiple servers asking for same key
b) Same key given to multiple servers

Size Key DB: 6 * 68.7 bytes = 412 Gb
1/ KGS single point of failure? To solve this, replica of DB is needed in case of failure
2/ Can each app server cache some keys?
3/ How key lookup is performed?
4/ Should we impose size limits on custom alias?

Client ------> Application Server [DB] ----> Key Generation Server [KEY DB]


#### 8. Data partitioning and replication
Partition our database in such a way that
a) Range based partitioning
starting with A: partition 1
starting with B: partition 2

b) Hash based partitioning
Calculate hash and choose partition

#### 9. Cache
Cache eviction: LRU based policy
Cache storage: 20%
Update cache in case of cache miss

#### 10. Load balancer
Round Robin
Adv: 
Dis: 

#### 11. Purging or DB cleanup
1. What should happen to the link in case expiration is reached?

* User --------> Expired Link --------> Delete Link
* Separate Cleanup Service to remove links
* Default Expiration time for each link
* Shoudl we remove links that have not been visited in some period of time?


Client ----LB----> Application Server ----LB---------------> Cache servers
                          |
                          |----Key Generation Service------> Cleanup Service

#### 12. Monitoring
1. Locations from where URL hit?
2. How many times URL was hit?


#### 13. Security and permissions 
Can users create private URLs or allow only set of users to create URL?

Create a separate table to store UserId that have permissions to view a URL?

Key -> Value
(Hash) -> List of users