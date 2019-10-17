CREATE TABLE IF NOT EXISTS product (
  id               BIGINT(20)   NOT NULL,
  createdOn        DATETIME     NOT NULL,
  modifiedAt       DATETIME     NOT NULL,
  name             VARCHAR(255) NOT NULL,
  category         VARCHAR(255) NOT NULL,
  retailPrice      DOUBLE       NOT NULL,
  discountedPrice  DOUBLE       NOT NULL,
  availability     TINYINT(1)   NOT NULL,
  PRIMARY KEY (id)
);
