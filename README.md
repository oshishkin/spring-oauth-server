# spring-oauth-server

## Ready to use OAuth2 authorizadion and resources server implemented with Spring.

Users are stored in H2 database. 

User should be added to the database manually in h2-console.
Following api endpoint can be used to encrypt user password

```
 /api/encodepassword/{samplepassword}
```

User role should be set to ROLE_USER in order to receive access to the secured api.

To start, run command

```
 gradle build && java -jar build/libs/wemboo-oauth-1.0.0.jar
```
