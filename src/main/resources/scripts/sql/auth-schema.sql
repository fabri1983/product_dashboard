CREATE TABLE role_auth (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  roleName varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_auth (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  firstName varchar(255) NOT NULL,
  lastName varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_role_auth (
  userId bigint(20) NOT NULL,
  roleId bigint(20) NOT NULL,
  CONSTRAINT user_role_auth_cnstrnt_user_auth FOREIGN KEY (userId) REFERENCES user_auth (id),
  CONSTRAINT user_role_auth_cnstrnt_role_auth FOREIGN KEY (roleId) REFERENCES role_auth (id)
);
