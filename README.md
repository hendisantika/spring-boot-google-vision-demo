# spring-boot-google-vision-demo

In this section, we will take a look at how to integrate Google Cloud Vision with Spring Boot.

We will do following experiments with Google Cloud Vision & Spring Boot.

1. Detect Faces from an Image**
2. Extract Text from an Image
3. Recognize Landmark from an Image
4. Extract Text from a PDF
5. Retrieve Labels from an Image

### Create a GCP Project

First, Sign into the Google console at https://console.cloud.google.com.

You can create a new project by first selecting the project dropdown in the top left and selecting "New Project".

![New Project](img/gcp1.png "New Project")

Next, specify your GCP Project name and Project ID.

![Create New Project](img/gcp2.png "Create New Project")

Then Click on the "CREATE" button.

Copy "Project ID" and keep it for future purposes.

### Enable Cloud Vision API

From cloud console, search for "Cloud Vision API" like below and click on "Cloud Vision API" button.

![Enable Cloud Vision API](img/gcp3.png "Enable Cloud Vision API")

Next, click on "ENABLE" button,

![Enable Cloud Vision API](img/gcp4.png "Enable Cloud Vision API")

### Create a service account key

First choose "IAM & Admin" and then click on "Service accounts".

![Create a service account key](img/gcp5.png "Create a service account key")

After that, click on "CREATE SERVICE ACCOUNT".

![Create a service account key](img/gcp6.png "Create a service account key")

Then, enter service account details like "Service account name", and "Service account ID" and click on "CREATE AND
CONTINUE".

![Create a service account key](img/gcp7.png "Create a service account key")

Then, grant basic role Editor.

![Create a service account key](img/gcp8.png "Create a service account key")

Finally click on "DONE" button.

Then, from "Actions" click on "Manage keys".

![Create a service account key](img/gcp9.png "Create a service account key")

Then, click on "Create new key".

![Create a service account key](img/gcp10.png "Create a service account key")

Then, choose "Key type" as JSON and click on "CREATE" button.

![Create a service account key](img/gcp11.png "Create a service account key")

Service account keys in JSON format will be downloaded. Keep the file safe for future purposes.

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-google-vision-demo.git`
2. Navigate to the folder: `cd spring-boot-google-vision-demo`
3. Run the application: `mvn clean spring-boot:run`
4. Open POSTMAN app
5. Import POSTMAN Collection file

### Images Screen shot

Extract Text From Image
![Extract Text From Image](img/sample1.png "Extract Text From Image")

Detect Face From Image
![Detect Face From Image](img/sample2.png "Detect Face From Image")

Get Landmark From Image
![Get Landmark From Image](img/sample3.png "Get Landmark From Image")

Detect Label From Image
![Detect Label From Image](img/sample4.png "Detect Label From Image")

Extract Text From Pdf
![Extract Text From Pdf](img/sample5.png "Extract Text From Pdf")



