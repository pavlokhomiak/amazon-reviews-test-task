Task
Stack: springboot, spring jpa, java 11, h2

This should be RESTful app. We are not interesting in the UI

The goal of this task is to analyze and transform the > 500.000 
reviews from Amazon. Please go to this link and download the 300 
MB csv file. Parse this file and store the received data in the H2 DB.

We are interested in:

1) Finding 1000 most active users (profile names)

2) Finding 1000 most commented food items (item ids).

3) Finding 1000 most used words in the reviews

Any errors will be reported by the HTTP codes.

Implement Spring Security and JWT authentication. Expected to have 
two roles: ADMIN and USER. User is able to create and edit his own 
comments (not the other user’s comments). Admin is able to delete 
any comment, but is not able to edit any comment.

We are interested in clean testable code (add tests if you have time).
How do you make sure there are no duplicates in the file?
Please provide working code: 1,2,3 to standard output sorted alphabetically.

MUST HAVE: use Swagger in your project
ADVANCED: wrap the app in to the Docker image
ADVANCED: deploy the app on Google Cloud / AWS
ADVANCED: add Angular Framework module
NOTE: there is no technical ability to upload file greater than 150 MB 
to the GitHub. Download file from the web on the program startup and 
save to the resource folder