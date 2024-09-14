-- Table: public.authorities

-- DROP TABLE IF EXISTS public.authorities;

CREATE TABLE IF NOT EXISTS public.authorities
(
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    authority character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT authorities_username_authority_key UNIQUE (username, authority),
    CONSTRAINT fk_customer FOREIGN KEY (username)
    REFERENCES public.users (username) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.authorities
    OWNER to postgres;