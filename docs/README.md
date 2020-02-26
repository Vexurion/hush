## *hush.*

###### The purpose of the app!

Silencing your phone has never been easier! Explore the effortless quality-of-life features that *hush.* has to provide! Life gets busy, and having the interruption of a phone call in the middle of important events can be embarrassing. Nevermind the embarrassing calls amidst a meeting, a movie at your local theater, or school! With *hush.*, it will do all the work for you!
 
## Features!
 
###### SAVE LOCATIONS
 - Find and save any location on the map for future reference!
 - Bookmark and note the destination by type and add things like titles and descriptions!
 
###### GPS LOCATION
 - See your current GPS on the map with user-friendly navigation!
 - Locate yourself in real-time!
 
###### CURRENT LOCATION
 - It allows the user to see the current address and street. Never get lost again!
 - Address and location searching. Allows the user to search easily for desired locations by name.
 
###### NOTIFICATIONS
 - Receive a silent notification to indicate your *Silent* or *Vibrate-Mode* initiating.

## Intended users

 * Students in college or high school
 * Office meeting attendees.
 * Theater enthusiasts.
 * Library fanatics.
 
## User stories  
[User stories](user-stories.md)

## Design documentation
[Entity-relationship diagram](erd.md)

[Wireframe](wire-frame.md)

## External services/data

* <b>Google Sign In for OAuth 2.0</b>

    * <u>Site URL</u>: https://developers.google.com/identity/protocols/OAuth2
    * <u>Service use</u>: OAuth will be used to authenticate users and store info such as saved HushZones and preferences to said authenticated account.
    * <u>Required</u>: Yes, for authenticating users into Hush and for saved user information.
    
* <b>TomTom Map Display API</b> 

    * <u>Site URL</u>: https://developer.tomtom.com/map-display-api
    * <u>Service use</u>: TomTom Map Display will be used to integrate it's many API features such as <i>Search</i>, <i>Location History</i>, and <i>Geofencing</i> into my application.
    * <u>Required</u>: Yes, because it's required to display the map, geofencing, and search features provided by the API.
   
## Data Information    
    
### Data Access Objects

* [Hush DAO](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/model/dao/HushDao.java)
* [User DAO](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/model/dao/UserDao.java)

### Database classes

* [Hush Database](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/services/HushDatabase.java)

### Repository

* [User Repository](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/model/repository/UserRepository.java)

### Entity classes

* [Hush.java](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/model/entity/Hush.java)
* [User.java](https://github.com/Vexurion/hush/blob/master/app/src/main/java/edu/cnm/deepdive/hush/model/entity/User.java)

### Implementation

[Data definition language (DDL)](ddl.md)