CREATE TABLE PROPERTIES
(
    ID INT NOT NULL,
    PROPERTY_KEY VARCHAR(256) NOT NULL,
    PROPERTY_VALUE VARCHAR(1024) NOT NULL,
    CATEGORY VARCHAR(80),
    CREATION_DATE DATE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    DESCRIPTION VARCHAR(512),
    PRIMARY KEY (ID)
);