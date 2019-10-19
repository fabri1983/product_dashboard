# Product Dashboard - Spring Boot REST API, OAuth2 JWT, JUnit5

[![Build Status](https://travis-ci.org/fabri1983/product_dashboard.svg?branch=master)](https://travis-ci.org/fabri1983/product_dashboard?branch=master)
&nbsp;&nbsp;&nbsp;&nbsp;
[![Coverage Status](https://coveralls.io/repos/github/fabri1983/product_dashboard/badge.svg)](https://coveralls.io/github/fabri1983/product_dashboard?branch=master)
&nbsp;&nbsp;&nbsp;&nbsp;
[![Code Climate](https://codeclimate.com/github/fabri1983/product_dashboard/badges/gpa.svg)](https://codeclimate.com/github/fabri1983/product_dashboard)


This project uses JPA, Spring Profiles, and Spring Security with OAuth2 for JWT authorization strategy when accessing web endpoints.  
See related sections at the end of this document.  
The project depends on Maven 3.6.x. You can use `mvnw` if you don't have Maven installed in your host.

 
## E-Shopping: Product Dashboard

In this challenge, you are part of team building product dashboard for internal usage.  
One requirement is to create REST API service using Spring Boot framework that provides functionality to add, update and fetch products.  

The definitions and a detailed requirements list follow.  
You will be graded on whether your application performs data retrieval and manipulation based on given use cases exactly as described in the requirements.  

Each product is a JSON entry with the following keys:

- id: Unique identifier of the product.
- version: Used to keep track of the product object we are trying to create/update to avoid conflicts with updated versions by other users.
- name: Name of the product.
- category: Category of the product.
- retail_price: The recommended selling price of the product. The price is given up to two places of decimal.
- discounted_price: The current selling price of the product. The price is given up to two places of decimal.
- availability: A boolean value that indicates whether the product is in stock (true) or out of stock (false).
 
Sample Product JSON:
 ```json
{
  "id": 1,
  "version": 1,
  "name": "Waterproof",
  "category": "Coats and Jackets",
  "retail_price": 274.0,
  "discounted_price": 230.16,
  "availability": true
}
 ```

The REST API service should implement the following functionalities:
 
- 1. Add a product: 
	- The service should be able to add a product by the POST request at /eshopping/products. 
	- The product JSON is sent in the request body. 
	- If a product with the same ID already exists then the HTTP response code should be 400; otherwise, the response code should be 201.

- 2. Update a product by id: 
The service should be able to update a product by the PUT request at /eshopping/products/{product_id}.  
The product JSON sent in the request body is described by the following keys:
	- retail_price: The updated retail price. The value may remain unchanged.
	- discounted_price: The updated discounted price. The value may remain unchanged.
	- availability: The updated availability. The value may remain unchanged.
If the product with the requested ID does not exist then the HTTP response code should be 400; otherwise, the response code should be 200.

- 3. Return a product by id: 
The service should be able to return the product by the given ID by the GET request at /eshopping/products/{product_id}.  
If the product with the requested ID does not exist then the HTTP response code should be 404; otherwise, the response code should be 200.

- 4. Return products by category: 
The service should be able to return the JSON array of all the products by the given category by the GET request at /eshopping/products?category={category}.  
The HTTP response code should be 200. The JSON array should be sorted by the availability, in stock products must be listed before out of stock products.  
The products with same availability status must be sorted by the discounted price in the ascending order.  
Finally, the products with same discounted price must be sorted by the ID in the ascending order.

- 5. Return products by category and availability: 
The service should be able to return the JSON array of all the products by the given category and availability by the GET request 
at /eshopping/products?category={category}&availability={availability}. 
The availability is described by 0 (false) and 1 (true).  
The HTTP response code should be 200.  
The JSON array should be sorted by the discount percentage in the descending order.  
The products with same discount percentage status must be sorted by the discounted price in the ascending order.  
Finally, the products with same discounted price must be sorted by the ID in the ascending order.  
The discount percentage is calculated as:
	- Discount Percentage = ((Retail Price — Discounted Price) ⁄ Retail Price) * 100

- 6. Return all products: 
The service should be able to return the JSON array of all products by the GET request at /eshopping/products.  
The HTTP response code should be 200. The JSON array should be sorted by the ID in the ascending order.


Complete the given project so that it passes all the test cases when running the provided JUnit tests.  
The project by default supports the use of H2 database, but you can make use of any database to store the data by specifying the dependency in the pom.xml file.  

Make sure that:
- You configure the models correctly, so serialization and deserialization work as expected.
- The field names in the response JSON and expected response JSON must exactly match. 
For example, sending retailprice, retail-price, or retailPrice in the response when retail_price is expected is a wrong response. 


## Generate an JWT access token
Use the following generic command to generate an access token:
```bash
curl <client-id>:<secret>@localhost:8080/eshopping/auth/jwt -d grant_type=password -d username=<username> -d password=<plain-text-pass>
```
For instance:
for a user with a standard role
```bash
curl product-dashboard-client-id:XY7kmzoNzl100@localhost:8080/eshopping/auth/jwt -d grant_type=password -d username=jane.diaz -d password=abc123456
or
curl -H "Authorization: Basic cHJvZHVjdC1kYXNoYm9hcmQtY2xpZW50LWlkOlhZN2ttem9OemwxMDA=" http://localhost:8080/eshopping/auth/jwt -d grant_type=password -d username=jane.diaz -d password=abc123456
```
for a user with an admin role
```bash
curl product-dashboard-client-id:XY7kmzoNzl100@localhost:8080/eshopping/auth/jwt -d grant_type=password -d username=super.admin -d password=passw0rd$1
or
curl -H "Authorization: Basic cHJvZHVjdC1kYXNoYm9hcmQtY2xpZW50LWlkOlhZN2ttem9OemwxMDA=" http://localhost:8080/eshopping/auth/jwt -d grant_type=password -d username=super.admin -d password=passw0rd$1
```
You will get an input similar to:
```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicHJvZHVjdC1kYXNoYm9hcmQtcmVzb3VyY2UtaWQiXSwidXNlcl9uYW1lIjoiamFuZS5kaWF6Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU2NTE0OTQ0OCwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkQiXSwianRpIjoiNGExZjdlZjEtZmNhZC00YjQzLTgwM2EtMTkwNDJiMjY5ZDkwIiwiY2xpZW50X2lkIjoicHJvZHVjdC1kYXNoYm9hcmQtY2xpZW50LWlkIn0.RdEp_yqQ1115sVYzxDg1QkhzL7Gx30XekMVj2bfmj70",
  "token_type": "bearer",
  "expires_in": 43199,
  "scope": "read write",
  "jti": "4a1f7ef1-fcad-4b43-803a-19042b269d90"
}
```


## Use a JWT access token
When calling any /eshopping/* path use the Authorization Bearer scheme:
```bash
curl http://localhost:8080/eshopping/products -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicHJvZHVjdC1kYXNoYm9hcmQtcmVzb3VyY2UtaWQiXSwidXNlcl9uYW1lIjoiamFuZS5kaWF6Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTU2NTE0OTQ0OCwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkQiXSwianRpIjoiNGExZjdlZjEtZmNhZC00YjQzLTgwM2EtMTkwNDJiMjY5ZDkwIiwiY2xpZW50X2lkIjoicHJvZHVjdC1kYXNoYm9hcmQtY2xpZW50LWlkIn0.RdEp_yqQ1115sVYzxDg1QkhzL7Gx30XekMVj2bfmj70"
```


## IDE Considerations
This project uses **MapStruct Bean Mapper**. So you need to install a plugin in your IDE to properly generate code for the mappers you declare.  
Install Eclipse plugin: *m2e-apt*.  
Edit your pom.xml by adding inside `<properties>` tag: `<m2e.apt.activation>jdt_apt</m2e.apt.activation>`  
See http://mapstruct.org/documentation/ide-support/.  


## OWASP Dependency Checker
Run next command to check if any dependency has a security risk according the Maven plugin *dependency-checker* from **OWASP**:  
```sh
mvn verify -P securitycheck
```

