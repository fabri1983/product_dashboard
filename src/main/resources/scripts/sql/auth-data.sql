INSERT INTO role_auth (id, roleName, description) VALUES (1, 'STANDARD', 'Standard User - Has no admin rights');
INSERT INTO role_auth (id, roleName, description) VALUES (2, 'ADMIN', 'Admin User - Has permission to perform admin tasks');

INSERT INTO user_auth (id, firstName, lastName, password, username) VALUES (1, 'Jane', 'Diaz', '{bcrypt}$2a$10$xL94.epsBfiwsuoniC/4JOvjUwfZ00eAwdWj06H93fXW.zcPLnyQm', 'jane.diaz');
INSERT INTO user_auth (id, firstName, lastName, password, username) VALUES (2, 'Super', 'Admin', '{bcrypt}$2a$10$BccodJJbgcRRqe6BYCFh/eTFsV8WrZfRhHbQJ65in6fpA0EVpx31C', 'super.admin');


INSERT INTO user_role_auth(userId, roleId) VALUES(1, 1);
INSERT INTO user_role_auth(userId, roleId) VALUES(2, 1);
INSERT INTO user_role_auth(userId, roleId) VALUES(2, 2);
