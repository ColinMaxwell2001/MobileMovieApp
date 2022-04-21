# MobileMovieApp

- - -

## Introduction:

Have you ever wondered how popular your favorite movie was? Do you know how well it did at the box office? Where did it rank amongst other movies? Our app can give you the answers.

- Display a movie’s gross earnings at the box office over the year.
- Display a movie’s gross earnings at the box office on opening weekend.
- See what studio produced the movie the user inputted
- Find what movies were released in the user inputted year
- Compare user inputted movie to other movies released that same year.

-Using this link for JSON data:
https://api.jsonbin.io/b/6227c3b9a703bb674925773a

-Firebase Database
https://console.firebase.google.com/project/my-movie-info-8ed2d/overview 

## Storyboard
![Screen Shot 2022-01-29 at 2 25 06 PM](https://user-images.githubusercontent.com/95194573/151718807-16a5cb4a-8e03-4a84-be1d-02e58011371b.png)
![Screen Shot 2022-01-29 at 2 24 52 PM](https://user-images.githubusercontent.com/95194573/151718830-cef1c680-635f-4803-959d-2f329eccfe4a.png)

## Functional requirements
*Scenario*
As someone who is interested in films, I would like to know how well films did in the year they were released so I can compare them to other films released that same year. 

*Dependencies*
Film search data is available and accessible
Film data is only for years 2018, 2019, and 2020

*Assumptions*
Movies will correspond to the years they were released
Movies listed will be limited to the top 20 movies of that particular year based on Box Office Gross

### Examples
**1.1**
**Given** a feed of movie data is available
**When** a user inputs "2019" in the year text box
**Then** a user should only be shown movies that were released in 2019 such as:
*Avengers: Endgame*
*The Lion King*
*Toy Story 4*
*Joker*
*Star Wars: The Rise of Skywalker*
*etc*

**1.2**
**Given** a feed of movie data is available
**When** a user inputs "2019" in the year textbox and inputs "Avengers: Endgame" in the Movie Name textbox
**Then** the results should appear at the bottom of the screen showing these attributes:
Title: *Avengers: Endgame*
Country of Origin: *USA/UK*
Box Office Gross: *$88.7 (Million)*
Opening Weekend Gross: *$43.4 (Million)*
Distributor: *Walt Disney*

## Kanban 
![Kanban Scrum Sprint 1](https://user-images.githubusercontent.com/95194573/151726811-aa13e5e4-cf79-4be3-a37b-155f0b5001f3.png)

## Class Diagram 

<img width="766" alt="Screen Shot 2022-01-30 at 8 36 24 PM" src="https://user-images.githubusercontent.com/83935603/151727871-8e870c51-0b53-403e-b9b7-86455f202fc4.png">

## Class Diagram Description 

**MainScreen**: The first screen that user is on. This will have the options to type in a movie based on year.

**MovieResults**: Noun class that lists the movie.



## SCRUM Roles
### UI Developer - Yifei Yang
### Product Owner/Developer - Payton Turnbow
### Product Owner/Backend Developer - Anish Selar
### Integration Specialist - Benjamin Seamon
### Dev Ops/ Scrum Master - Colin Maxwell
### Frontend Developer - Kevin Migadde

## Weekly Standup
Monday 2:30 Teams Meeting
https://teams.microsoft.com/_?lm=deeplink&lmsrc=NeutralHomePageWeb&cmpid=WebSignIn&culture=en-us&country=us#/conversations/19:a2f50954fb994689936231a8f86ea1ce@thread.v2?ctx=chat 










