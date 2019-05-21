# CSE248 Final Project
Joshua Morris

For my project I chose to use Cloud Firestore, a product of Google's Firebase service.

Firebase is a BaaS (Backend-as-a-service) platform owned by Google. The purpose of Firebase is to allow developers to build 
web and mobile applications without having to manage servers or infrastructure, as it runs entirely on Google's cloud. Firebase can be
used to develop apps for various platforms including Android, iOS, and Web.

One of Firebase's most popular products is Cloud Firestore. Cloud Firestore is a NoSQL database. Unlike a traditon SQL database in which
data is stored in tables, Cloud Firestore stores its data as documents in the form of JSON. This allows Cloud Firestore to be more flexible
and scalable. Google provides native SDK's which allow Cloud Firestore to be easily accessed from any platform.

I chose Cloud Firestore for my project because it seemed like a good fit to store structured data such as user accounts and garage layouts.
In the real world, an app like this would have to be connected to the internet, so I felt it would it would be a good idea to get
experience connecting an app to an online database. I decided to integrate Firestore early in the project because I figured it would be more difficult to do so if I waited until the
end.

I built the project using the Model-View-Presenter (MVP) design pattern. MVP is similar to MVC, but there are some key differnces. The
view in MVP also acts a controller and a source of input, unlike the MVC view which is "dumb" and just shows information. The controller
is replaced by the presenter, which is responsible for commmunicating information between the view and the data model. In my project, the
views were the Android activities and the model consisted of the object classes and the database. Each activity has its own presenter class which is responsible for retrieving data from the database, adding new data to the database, and updating the view in response to input events such as button clicks. Each presenter class defines its own interface called View. Each activity implements its respective 
presenter class's View interface (ex. MainActivity.View). When an activity's onCreate() method is called, it creates an instance of its
presenter class in which it passes itself as a constructor parameter and becomes and instance variable of the presenter class. Using the MVP design pattern allowed me to organize my code more neatly and efficently.

I used the following GitHub repository as an inspiration for my MVP:
https://github.com/jazzbpn/MVP-HandDirty
