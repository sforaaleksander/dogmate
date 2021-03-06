<h1 align="center">Welcome to Dogmate 👋</h1>
<p>
  <a href="https://opensource.org/licenses/MIT" target="_blank">
    <img alt="License: mit" src="https://img.shields.io/badge/License-mit-yellow.svg" />
  </a>
</p>

> Dogmate is a project which helps you get to know new people and stay in touch with the ones you know during walks with your dogs. Plan your walks, join other people, and their dogs.

This is a backend app of our Dogmate project. You can test it with Postman app or use it
with [the frontend](https://github.com/sforaaleksander/dogmate-frontend).

## Prerequisites

Java 11

## Usage

Run the following command at the root of your project:

```sh
./mvnw spring-boot:run
```

To check available endpoints go to http://localhost:8080/swagger-ui/.

We provided two users, which can be used for testing:

- email: `user@user.com`    password: `user`
- email: `admin@admin.com`  password: `admin`

You can use it to login with the [frontend](https://github.com/sforaaleksander/dogmate-frontend) app for our project
or with Postman app.

### Postman

**To login**

- Set method to `POST`.
- Set url to `http://localhost:8080/api/v1/login`.
- Set body to raw JSON.
- Paste this into bode and hit Send.

```
{
  "username": "user@user.com",
  "password": "user"
}
```

You can now send request as logged user!

- Copy Authorization header from the response.
- Set Authorization type to `Bearer token`.
- Paste your token.
- Now you can send some request, e.g. GET http://localhost:8080/api/v1/users.

## 👤 Authors

- **Rafał Wypasek**
- **Aleksander Jednaszewski**
- **Mateusz Gołda**

* Github:
    - [@luiver](https://github.com/luiver)
    - [@sforaaleksander](https://github.com/sforaaleksander)
    - [@MateuszGolda](https://github.com/MateuszGolda)
* LinkedIn:
    - [@rafal-wypasek](https://linkedin.com/in/rafal-wypasek)
    - [@aleksander-jednaszewski](https://www.linkedin.com/in/aleksander-jednaszewski/)
    - [@mateusz-gołda](https://www.linkedin.com/in/mateusz-golda/)
