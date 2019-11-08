INSERT INTO role_auth (id, version, createdOn, modifiedOn, roleName, description) 
  VALUES (1, 1, '2019-04-25T00:00:00.000', '2019-04-25T00:00:00.000', 'STANDARD', 'Standard User - Has no admin rights');
INSERT INTO role_auth (id, version, createdOn, modifiedOn, roleName, description) 
  VALUES (2, 1, '2019-04-25T00:00:00.000', '2019-04-25T00:00:00.000', 'ADMIN', 'Admin User - Has permission to perform admin tasks');

INSERT INTO user_auth (id, version, createdOn, modifiedOn, firstName, lastName, password, username) 
  VALUES (1, 1, '2019-04-25T00:00:00.000', '2019-04-25T00:00:00.000', 'Jane', 'Diaz', '{bcrypt}$2a$10$xL94.epsBfiwsuoniC/4JOvjUwfZ00eAwdWj06H93fXW.zcPLnyQm', 'jane.diaz');
INSERT INTO user_auth (id, version, createdOn, modifiedOn, firstName, lastName, password, username) 
  VALUES (2, 1, '2019-04-25T00:00:00.000', '2019-04-25T00:00:00.000', 'Super', 'Admin', '{bcrypt}$2a$10$BccodJJbgcRRqe6BYCFh/eTFsV8WrZfRhHbQJ65in6fpA0EVpx31C', 'super.admin');


INSERT INTO user_role_auth(userId, roleId) VALUES(1, 1);
INSERT INTO user_role_auth(userId, roleId) VALUES(2, 1);
INSERT INTO user_role_auth(userId, roleId) VALUES(2, 2);
