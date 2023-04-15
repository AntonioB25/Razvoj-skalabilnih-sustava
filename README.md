# razvoj-skalabilnih-sustava

Labosi i projekt iz vještine Razvoj skalabilnih informacijskih i komunikacijskih sustava proizvodne razine

##### Funkcionalnosti servera se mogu isprobati preko Swaggera: http://localhost:8080/swagger-ui/index.html

#### U slučaju da Swagger ne radi ovo su putanje:

<br>

#### Dohvaćanje svih poruka:  GET  http://localhost:8080/messages

#### Odgovor

```json
[
  {
    "senderId": 1,
    "receiverId": 2,
    "message": "Some kind of message"
  },
  {
    "senderId": 3,
    "receiverId": 2,
    "message": "Some kind of message"
  }
]
```

<br>

#### Dohvaćanje svih poruka sa `senderId = 1`:  GET  http://localhost:8080/messages?senderId=1

#### Odgovor

```json
[
  {
    "senderId": 1,
    "receiverId": 2,
    "message": "Some kind of message"
  },
  {
    "senderId": 1,
    "receiverId": 3,
    "message": "Some kind of message"
  }
]
```

<br>

#### Stvaranje nove poruke:  POST  http://localhost:8080/messages

#### Model

```json

{
  "senderId": 1,
  "receiverId": 2,
  "message": "Some kind of message"
}

```