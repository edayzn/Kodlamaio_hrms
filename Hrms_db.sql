-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying NOT NULL,
    web_site character varying NOT NULL,
    phone character(10) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employers_verification
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    employer_id integer NOT NULL,
    personel_id integer NOT NULL,
    email_verification boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_advertisement
(
    job_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_description character varying NOT NULL,
    city character varying(50),
    salary integer NOT NULL,
    number_of_positions smallint NOT NULL,
    release_date date NOT NULL,
    application_deadline date NOT NULL,
    working_condition boolean NOT NULL,
    employer_id integer NOT NULL,
    position_id integer NOT NULL,
    PRIMARY KEY (job_id)
);

CREATE TABLE public.job_applications
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_seeker_id integer NOT NULL,
    job_positions_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    position_name character varying NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_seekers
(
    user_id integer NOT NULL,
    first_name character varying(100) NOT NULL,
    identification_number character(11) NOT NULL,
    year_of_birth integer NOT NULL,
    last_name character varying(100) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.job_seekers_verification
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_seeker_id integer NOT NULL,
    e_mail_verification boolean NOT NULL,
    password_verification boolean NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.system_personel
(
    user_id integer NOT NULL,
    first_name character varying(150) NOT NULL,
    last_name character varying(150) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.users
(
    user_id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    e_mail character varying NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (user_id)
);

ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.employers_verification
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.employers_verification
    ADD FOREIGN KEY (personel_id)
    REFERENCES public.system_personel (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (job_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (job_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_advertisement
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.job_applications
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.job_applications
    ADD FOREIGN KEY (job_positions_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_seekers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.job_seekers_verification
    ADD FOREIGN KEY (job_seeker_id)
    REFERENCES public.job_seekers (user_id)
    NOT VALID;


ALTER TABLE public.system_personel
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (user_id)
    NOT VALID;

END;