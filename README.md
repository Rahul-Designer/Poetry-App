
# Poetry App

This app is completely based on REST API.
With the help of REST API, we show the poetry with the recycler view in the app layout. Users can update and delete the poetry by the click the button.

 



## API Reference

#### Get all poetry

```http
  GET /poetryapis/getpoetry.php
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Add poetry

```http
  POST //poetryapis/addpoetry.php
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `poetry`      | `text` | **Required**. Id of item to fetch |
| `poet_name`   | `text` | **Required**. Id of item to fetch |

#### Update poetry

```http
  POST /poetryapis/updatepoetry.php
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `poetry_data` | `text` | **Required**. Id of item to fetch |
| `id`   | `text` | **Required**. Id of item to fetch |

#### Delete poetry

```http
  POST /poetryapis/deletepoetry.php
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `poetry_id`   | `text` | **Required**. Id of item to fetch |




## Appendix
For Run this app you need to install the XAMPP server and paste all the PHP files into the location (C:\xampp\htdocs\poetryapis). Firstly create the folder name is poetryapis. And paste all the PHP files into the folder. And Change the IP address in ApiClient.java class.


## Authors

- [@rahulsingh](https://github.com/Rahul-Designer)


## 🛠 Skills
Java , Kotlin , PHP , Android Studio


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rahul-singh-987975204)


