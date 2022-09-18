# Admin User API

## How to guide

### Run tests
- To run test run below command
```shell
gradle clean test
```

### Build jar
```shell
gradle clean build
```

### Access API
- Admin api require basic authentication. Use below curl command to access api
```
curl --request GET \
  --url http://localhost:8080/admin/userDetails/3 \
  --header 'Authorization: Basic YWRtaW46cGFzc3dvcmQ=' \
  --cookie JSESSIONID=D760BFD9D2EF1E8A3F06B66992434384
```