-- Table: public.nr_income

-- DROP TABLE IF EXISTS public.nr_income;

CREATE TABLE IF NOT EXISTS public.nr_income
(
    income_id integer NOT NULL DEFAULT nextval('nr_income_imcome_id_seq'::regclass),
    amount double precision,
    remarks character varying(255) COLLATE pg_catalog."default",
    month_id integer NOT NULL,
    mon integer,
    CONSTRAINT nr_income_pkey PRIMARY KEY (income_id),
    CONSTRAINT nr_income_month_id_fkey FOREIGN KEY (month_id)
    REFERENCES public.nr_income_month (month_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.nr_income
    OWNER to postgres;