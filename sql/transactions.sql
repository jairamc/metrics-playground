USE wrtystore;

CREATE TABLE IF NOT EXISTS transactions (
    id varchar(256) primary key,
    firstname varchar(256) DEFAULT NULL,
    lastname varchar(256) DEFAULT NULL,
    item varchar(256) DEFAULT NULL,
    amount double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;