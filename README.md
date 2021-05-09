# SOCIAL NETWORK PROJECT

This project is a good example for the new learners of the object-oriented programming paradigm.

## CLASS "User"

User class contains all the features a user needs to have on the social network.

* Constructor
    > User(String name, String email, String dateOfBirth, String placeOfResidence)

      Create a new user with given a name , an email, a dateOfBirth and a placeOfResidence.

* Method Details
  * followUser
    > public void followUser(user userName)
    * You can follow new user.
    * Send notification to the tracked user's notification box to “userName” parameter.

  * showFollowedUserList
    > public void showfollowedUserList()
    * You can show followed user list.

  * showNotificationBox
    > public void showNotificationBox()
    * You can show notification box.

  * sendMessage
    > public void sendMessage(User receiverUser , String contentMessage)
    * You can send message.
    * With the receiverUser parameter, you can get the message recipient name.
    * With the contentMessage parameter, you can get the message content.
    * The sent message is dropped in the “outgoingMessageBox” of the sending user.
    * The sent message is dropped in the “incomingMessageBox” of the receiver user.

  * showOutgoingMessageBox
    > public void showOutgoingMessageBox()
    * You can see outgoing message box.

  * showIncomingMessageBox
    > public void showIncomingMessageBox()
    * You can see incoming message box.

  * getName
    > public String getName()
    * You can return name of the user.

  * getInformationOfUser
    > public String getInformationOfUser()
    * You can return user’s name, email, date of birth and place of residence.

  * getDateOfBirthday
    > public string getDateOfBirthday()
    * You can returns the date of birthday of the user.

  * searchUserList
    > public User searchUserList(int index)
    * User must select a friend to send message from friend list. This method makes this choice.

  * sharePost
    > public void sharePost(String message)
    * You can share a new post.
    * This new post is added to the user's postlist.

  * likePost
    > public void likePost(int index)
    * You can like post.
    * Allows to control the likes. Warning message if it is already liked.

  * showPosts
    > public void showPosts()
    * You can show posts.

  * showTimeLine
    > public void showTimeLine()
    * You can show timeline.

  * timeLineToPostList
    > private void timeLineToPostList()
    * Adds followed by friends' posts to the user's post list.
    * Clears postList before adding post

  * showFavouritePosts
    > public void showFavouritePosts()
    * You can show favourite posts.

  * controlBirthday
    > public void controlBirthday()
    * If it's your birthday, you get a happy birthday notification.

## CLASS "Message"

Message class contains all of the information required for sending messages.

* Constructor

    > Message(String senderUser, User receiverUser, String contentMessage )

      Create a new message with given a senderUser , a receiverUser, a contentMessage.

* Method Details

  * getDetails

    > public string getDetails()
    * You can return sender user, receiver user(receiver user is a parameter derived from user class is the name of the receiver user we need for him is called by the” getName” method) and content of message.

## CLASS "Post"

Regulate who shares the posts, when they share and the likes.

* Constructor

    > Post(String userName, String post )

      Create a new post with given a userName , a post.

* Method Details

  * getDetails

    > public string getDetails()
    * You can return sender user, receiver user(receiver user is a parameter derived from user class is the name of the receiver user we need for him is called by the” getName” method) and content of message.

  * setLikes
    >public void setLikes()
    * You can like posts shared by users.

  * getLike
    > public int getLike()
    * You can return likes.

## CLASS "Administrator"

This class can be used to pull date from the system.

* Constructor

    > Administrator()

      Create a new timeStamp.

* Method Details

  * getDate
    > public String getDate()
    * You can return the now of date.

  * getHoursAndDate
    > public String getHoursAndDate ()
    * You can return the now of date and hours.

