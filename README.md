# FlowMessenger
FlowMessenger is a web-based messaging application designed for portability, security, and ease of deployment. The application is built using Spring Boot, Vaadin Flow, and HSQLDB in embedded mode, with the aim of creating a single executable `.jar` file. Users can run this executable on any hardware/software architecture with a Java Runtime Environment using the command `java -jar flowmessenger.jar`. The application will create a directory named `flowmessenger` in the user's home directory (`$HOME` or `user.home`) and save all data within that directory.

## Project Status
![enter image description here](https://e7.pngegg.com/pngimages/997/906/png-clipart-under-construction-under-construction.png)

## Features
- **Portability**: Single executable `.jar` file for easy deployment.
- **Security**: 
  - No personal identifiable information required (only first name and username for sign-up).
  - Secure storage of passwords and recovery keys using advanced salting and hashing techniques.
  - Encryption of messages and files before storage.
- **Privacy**: 
  - No tracking of users.
  - No collection of logs or telemetry data.

## Technology Stack
- **Backend**: Spring Boot
- **User Interface**: Vaadin Flow
- **Database**: HSQLDB (HyperSQL) with Spring Data JDBC

## Setting up for local development
1. Ensure you have JDK 21+  installed.
2. Clone the `flowmessenger` repo from github.
	`git clone github.com/itzarnabmondal/flowmessenger.git`

## Contribution
If you would like to contribute or have any suggestions, please feel free to contact me at arnabmondal@onmail.com :)

## 📌
Thank you for checking out FlowMessenger! Stay tuned for more updates as i continue to develop and improve this application.
