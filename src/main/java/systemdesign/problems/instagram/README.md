### Instagram
#### 1. Objective
1. Share photos and videos with other users
2. Privacy:
* Public: Can be seen by other users
* Private: Cannot be seen by other users
3. News feed will consist of all photos/videos users follow

#### 2. Requirements and goals of system

##### Functional Requirements
1. Users should be able to download/upload and view photos
2. Users can follow other users
3. Users should be able to generate and display user news feed from other people user follow.

##### Non functional requirements
1. Highly available
2. Latency: 200ms for news feed generation
3. Highly reliable: Photos uploaded are not lost.

#### 3. Design Considerations 
The application should be read heavy. So building a system that can retrieve photos quickly 
1. Since users can store as many photos/videos as they like, efficient management of storage is key factor.
2. Low latency while viewing photos
3. Highly reliable data

#### 4. Capacity Estimation and Constraints
