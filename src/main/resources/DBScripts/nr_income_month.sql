-- Table: public.nr_income_month

-- DROP TABLE IF EXISTS public.nr_income_month;

CREATE TABLE IF NOT EXISTS public.nr_income_month
(
    month_id integer NOT NULL DEFAULT nextval('nr_income_month_month_id_seq'::regclass),
    month_nam character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT nr_income_month_pkey PRIMARY KEY (month_id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.nr_income_month
    OWNER to postgres;