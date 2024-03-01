
# Football League Application

The Football League Application is a mobile app that is optimized for Android devices and provides information about football competitions. Two main screens are present: a list of competitions and details about each competition. The app utilizes data from the public service provided by football-data.org, specifically using the Compete API . 



## Features
- Display a list of competitions with the following details :

    * Competition name    
    * Area name
    * Competition emblem
- Display competition details including all available data , but here i used it in the same Feature because shared the same data 


## Requirements
- **Architecture Pattern** : I used in this app MVVM (Model-View-ViewModel) by feature for organizing codebase . 
- **Data Retrieval and Storage** : 
    * Fetch data from the provided APIs
    * Implement caching mechanism to securely store retrieved data locally by using Room DB
- **Offline Support** : 
    * Display cached data when there is no internet connection.

- **Security Measures** : 
    * Prevent screenshots or screen recording while the app is in use.
    * Protect against Man-in-the-Middle (MITM) cyberattacks
    * Implement techniques to prevent common reverse engineering and app hooking using also **ProGuard**

## API Reference
#### Base Url
```http
  http://api.football-data.org/v4/
```
#### End point to fetch all competitions
| End point | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `competitions/` | `GET` | to fetch all competitions |



## Implementation Details : 
**Architecture**  --> The app is built using the MVVM architecture pattern to separate concerns and enhance maintainability .

**Data Retrieval and Storage**  --> 
- Utilize Retrofit library to make HTTP requests and fetch data from the Football Data API 
- Implement Room Persistence Library for local data caching

**Offline Support**  --> Use stateFolw to manage data streams and provide offline support by displaying cached data when the device is offline .

**UI/UX Design**  --> 
- Design layouts using ConstraintLayout with sdp to ensure responsiveness across various screen sizes .
- Utilize RecyclerView to display lists of competitions and competition details


## Libraries/Frameworks Used

For network requests used `Retrofit` , For local data caching used `Room Persistence Library`, For managing data streams `RxJava` , For support multi screen used  `intuit` with `ConstraintLayout` For designing responsive layouts, `Hilt` used to manage the dependencies between different components of an application apps used , `Retrofit` used in Android app development to fetch data from web servers and interact with RESTful APIs ,`Coroutines ` to allow you to write asynchronous code in a sequential style , `Glide` used to simplifie the process of loading images from various sources such as URLs, local storage ,`Navigation component` used it to define the navigation structure of their apps in a visual and declarative way . 

## Conclusion
The Football League Application is designed to provide users with a seamless experience in accessing information about football competitions while ensuring data security and offline functionality. By adhering to best practices in architecture, security, and UI/UX design, the app aims to deliver a reliable and user-friendly experience to football enthusiasts.
