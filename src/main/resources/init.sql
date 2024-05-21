CREATE TABLE exchange_rate
(
    id              bigserial primary key,
    base_currency   varchar not null,
    target_currency varchar not null,
    currency_rate   decimal not null,
    last_updated    timestamp default CURRENT_DATE
);

CREATE TABLE currency
(
    id            bigserial primary key,
    currency_code varchar not null
);

CREATE TABLE user_credentials
(
    id        bigserial primary key,
    username  varchar(20)                                not null,
    password  varchar                                    not null,
    user_role varchar default 'USER':: character varying not null

)