RUN THE APP


1) create word relation example

curl --location 'http://localhost:8080/api/v1/word-relations' \
--header 'Content-Type: application/json' \
--data '{
"firstWord":"asdf",
"secondWord": "fsdf",
"relation": "spam"
}'

2) get all word relations

curl --location --request GET 'http://localhost:8080/api/v1/word-relations'

