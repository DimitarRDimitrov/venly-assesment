RUN THE APP

- have maven in path https://formulae.brew.sh/formula/maven
- <code> mvn clean install </code> to resolve dependencies
- <code> mvn spring-boot:run </code> to run springboot web app
- h2 db data stored in project dir ./db

EXAMPLES
1) create word relation example

<code> curl --location 'http://localhost:8080/api/v1/word-relations' \
--header 'Content-Type: application/json' \
--data '{
"firstWord":"asdf",
"secondWord": "fsdf",
"relation": "spam"
}'

2) get all word relations

<code> curl --location --request GET 'http://localhost:8080/api/v1/word-relations'

3) get all words with relation filter

<code> curl --location --request GET 'http://localhost:8080/api/v1/word-relations?relation=spam' \

4) get all words with inversions

<code> http://localhost:8080/api/v1/word-relations?includeInversion=true