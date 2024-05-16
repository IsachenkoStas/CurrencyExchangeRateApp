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