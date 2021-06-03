POST http://localhost:8080/quizzes
Content-Type: application/json

{
"name": "Quiz 1",
"date": "01/01/2000"
}


###
PUT http://localhost:8080/quizzes/1
Content-Type: application/json

{
"name": "Quiz 2",
"date": "01/01/2000"
}

###
GET http://localhost:8080/quizzes?name=Quiz&date=01/01/2000
Accept: application/json

###
POST http://localhost:8080/questions
Content-Type: application/json

{
"content": "Content 1",
"quiz": {
"id": 1
}
}

###
PUT http://localhost:8080/questions/1
Content-Type: application/json

{
"content": "Content 2",
"quiz": {
"id": 2
}
}

###
DELETE http://localhost:8080/questions/1
Content-Type: application/json

###
GET http://localhost:8080/questions?content=Content
Accept: application/json

###
POST http://localhost:8080/answers
Content-Type: application/json

{
"content": "Answer 1",
"isCorrectAnswer": false,
"question": {
"id": 1
}
}

###
PUT http://localhost:8080/answers/1
Content-Type: application/json

{
"content": "Answer 1",
"isCorrectAnswer": true,
"question": {
"id": 1
}
}

###
DELETE http://localhost:8080/answers/1
Content-Type: application/json