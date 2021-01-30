#### Pastebin

##### 1. Objective
Enable users to store plain text messages over network and generate unique URLs to upload the data

##### 2. Requirements
###### Functional requirements
1. Users should be able to upload text and get unique URL to access it
2. Data and link will exire after some time
3. Users should be able to pick custom alias

###### Non functional requirements
1. Highly reliable
2. Highly available
3. Able to access in real time with minimum latency
4. Paste links should not be guessable 

###### Monitoring requirements
1. Analytics
2. Available via REST api

##### 3. Design Considerations
1. Limit on amount of text user can paste
2. Size limits on custom URLs

##### 4. Capacity Estimation
###### Bandwidth Estimates
* Read/Write Ratio: 5 to 1
* Paste Write per second: 1M/(24*60*60) = 12 paste/second
* Paste Write per second: 5M/(24*60*60) = 60 paste/second

###### Storage Estimates
* Size of data: 10KB on average = 10KB * 1M per day = 10GB per day
* over 10 years = 10GB*10*365 = 3.6 Billion
* 6letter string base 64 encoded: pow(64,6) * 3.6 bytes == 22GB

###### Memory Estimates
* 12*10kb write / second
* 60*10kb read / second
* Cache 80/20 rule: Cache 20% of paste used 80% of the time

5M req per day: 5M * 0.2 * 10KB = 10GB

##### 6. System APIs
* addPaste(text, customUrl=null, user, pasteName, expireDate)
* getPaste(id, devKey)
* deletePaste(id, devKey)

##### 7. Database Design
* Paste
id 
name
userid
expiration date

* User
id
name

##### 8. HLD/LLD Design

##### HLD
Client -> Server -> Database (Cache/non cache)
* Paste content can be stored in Amazaon S3

##### LLD
a) Application Layer

Approach 1:
1. Generate key if user has not provided custom key
2. Store content and generated key in database
3. Return id to the user after storing in database
4. In case of insertion failure due to duplicate key, retry insertion

Approach 2:
1. Key Generation Service to create random keys
2. Take one of the keys and use it. No need to worry about duplicates and collisions. Can use 2 tables. One used and another not used

Questions:
1. KGS as single point of failure : End up losing all the keys if down. Need replica of KGS
2. Read: If key found in used, return paste content else return error

b) Database Layer
1. Metadata database: Relational SQL or No Sql database
2. Object storage: Amazon S3

Client -> LB -> Application Server -> Database (Cache/Relational)
           |
           |-----> Key Generation Service -> Database
           
           
##### 8. Purging/ DB Cleanup

##### 9. Data Partitioning and Replication

##### 10. Cache and LB

##### 11. Security and permission