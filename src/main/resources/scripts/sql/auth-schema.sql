CREATE TABLE IF NOT EXISTS role_auth (
  id           BIGINT(20)   NOT NULL AUTO_INCREMENT,
  version      BIGINT(20)   NOT NULL,
  createdOn    DATETIME     NOT NULL,
  modifiedAt   DATETIME     NOT NULL,
  description  VARCHAR(255) DEFAULT NULL,
  roleName     VARCHAR(128) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS user_auth (
  id          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  version     BIGINT(20)   NOT NULL,
  createdOn   DATETIME     NOT NULL,
  modifiedAt  DATETIME     NOT NULL,
  firstName   VARCHAR(128) NOT NULL,
  lastName    VARCHAR(128) NOT NULL,
  password    VARCHAR(128) NOT NULL,
  username    VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS user_role_auth (
  userId    BIGINT(20) NOT NULL,
  roleId    BIGINT(20) NOT NULL,
  CONSTRAINT user_role_auth_cnstrnt_user_auth FOREIGN KEY (userId) REFERENCES user_auth (id),
  CONSTRAINT user_role_auth_cnstrnt_role_auth FOREIGN KEY (roleId) REFERENCES role_auth (id)
);
