# urlshortner
A url shortener is a tool that creates a short, unique URL that will redirect to specific website.

# Getting Started

## Mandatory Requirements
- Design and implement an api for short url creation.
- Implement forwarding of short url to original url.
- Cron Job to change the status of url record to expired after the expiry date of short url.

## Dependencies
- spring-boot-starter-web (Spring boot framework)
- spring-boot-starter-data-jpa (for data persistence)
- mysql-connector-java
- lombok

## Project Build And Run
### To build :
- git clone https://github.com/Mangesh8788/urlshortner.git
- As we used the mysql database need to changes username and password in application.properties file.
    - spring.datasource.username={username}
    - spring.datasource.password={password}
- cd urlshortner
- mvn clean install
- In urlshortner/target folder executable jar file will get generated.
### To run the project :
- Go to target folder.
- Run the above jar file by command using command : java -jar urlshortner-0.0.1-SNAPSHOT.jar

## API Endpoints
You can access following API endpoints at http://localhost:8080
### Create short url for full url : POST /url
#### Payload
{\
    "url": "facebook.com",\
    "expiry_date":"2021-12-12"  //expiry date is optional. If you want set short url expiry date then send it in given format.\
}

#### Response
{\
    "status_code": 200,\
    "result": {\
        "id": 20,\
        "url": "http://facebook.com",\
        "short_code": "Ob5ttC",\
        "short_url": "localhost:8080/Ob5ttC",\
        "expiry_date": null\
    },\
    "validate": true,\
    "error": null,\
    "message": null\
}

### API to get redirect to original url :
- Need to hit the short_url from above payload to get redirected to original url.

### API to get all the active url : GET /url
#### Response
{\
    "status_code": 200,\
    "result": [\
        {\
            "id": 20,\
            "created_by": "SYSTEM",\
            "created_date": "2021-06-12T11:42:07.000+00:00",\
            "updated_by": "SYSTEM",\
            "updated_date": "2021-06-12T11:42:07.000+00:00",\
            "actual_url": "http://facebook.com",\
            "short_code_for_url": "Ob5ttC",\
            "url_expiry_date": null,\
            "url_status": "ACTIVE",\
            "short_url": "localhost:8080/Ob5ttC"\
        }\
    ],\
    "validate": true,\
    "error": null,\
    "message": null\
}

## Future Enhancements / Known Issues
- Haven't implemented Front-end application.
- Add user specific functionality like :
  - Create user account.
  - Login functionality.
  - User specfic short url creation.
- Create short url for multiple urls by using excel file.
- Check for duplicate url.
