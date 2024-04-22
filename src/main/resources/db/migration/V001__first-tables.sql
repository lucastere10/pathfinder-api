CREATE TABLE TASK(
    TASK_CD_ID SERIAL PRIMARY KEY,
    TASK_TX_CODE VARCHAR(255) NOT NULL UNIQUE,
    TASK_TX_NOME VARCHAR(255) NOT NULL UNIQUE,
    TASK_TX_DESC VARCHAR(255) NOT NULL,
    TASK_TX_TAG VARCHAR(255),
    TASK_TX_STATUS VARCHAR(255) NOT NULL,
    TASK_TX_PRIORITY VARCHAR(255) NOT NULL,
    TASK_DT_CREATE TIMESTAMP NOT NULL,
    TASK_DT_UPDATE TIMESTAMP NOT NULL
);

CREATE TABLE FLOW(
    FLOW_CD_ID SERIAL PRIMARY KEY,
    PRIOR_TAST_PK BIGINT NOT NULL,
    AFTER_TAST_PK BIGINT NOT NULL,
    CONSTRAINT FK_PRIOR_TASK_FLOW FOREIGN KEY (PRIOR_TAST_PK) REFERENCES TASK (TASK_CD_ID),
    CONSTRAINT FK_AFTER_TASK_FLOW FOREIGN KEY (AFTER_TAST_PK) REFERENCES TASK (TASK_CD_ID)
)