ALTER TABLE USUARIO ADD CONSTRAINT PK_USUARIO PRIMARY KEY(nroidentificacion_usu);
ALTER TABLE DONANTE ADD CONSTRAINT PK_DONANTE PRIMARY KEY(nroidentificacion_don);
ALTER TABLE HOSPITAL ADD CONSTRAINT PK_HOSPITAL PRIMARY KEY(nit_hos);
ALTER TABLE JORNADA ADD CONSTRAINT PK_JORNADA PRIMARY KEY(codigo_jor);
ALTER TABLE BOLSA ADD CONSTRAINT PK_BOLSA PRIMARY KEY(codigo_bol);
ALTER TABLE DEPARTAMENTO ADD CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY(id_dep);
ALTER TABLE MUNICIPIO ADD CONSTRAINT PK_MUNICIPIO PRIMARY KEY(id_mun);


ALTER TABLE USUARIO ADD CONSTRAINT NN_NOMBRES_USU CHECK(nombres_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_APELLIDO1_USU CHECK(apellido1_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_USUARIO_USU CHECK(usuario_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_CORREO_USU CHECK(correo_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_CONTRASENIA_USU CHECK(contrasenia_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_PERFIL_USU CHECK(perfil_usu is not null);
ALTER TABLE USUARIO ADD CONSTRAINT NN_ESTADO_USU CHECK(estado_usu is not null);


ALTER TABLE DONANTE ADD CONSTRAINT NN_TIPODOCUMENTO_DON CHECK(tipodocumento_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_NOMBRES_DON CHECK(nombres_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_APELLIDO1_DON CHECK(apellido1_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_TELEFONO_DON CHECK(telefono_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_DIRECCION_DON CHECK(direccion_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_CORREO_DON CHECK(correo_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_FEC_NAC_DON CHECK(fec_nac_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_FEC_DOC_DON CHECK(fec_doc_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_ENFERMEDADES_DON CHECK(enfermedades_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_HABITOS_DON CHECK(habitos_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_GENERO_DON CHECK(genero_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_DEPARTAMENTO_DON CHECK(departamento_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_MUNICIPIO_DON CHECK(municipio_don is not null);
ALTER TABLE DONANTE ADD CONSTRAINT NN_ESTADO_DON CHECK(estado_don is not null);


ALTER TABLE HOSPITAL ADD CONSTRAINT NN_TIPO_HOS CHECK(tipo_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_RAZON_SOCIAL_HOS CHECK(razon_social_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_NIVEL_HOS CHECK(nivel_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_DEPARTAMENTO_HOS CHECK(departamento_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_MUNICIPIO_HOS CHECK(municipio_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_DIRECCION_HOS CHECK(direccion_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_TELEFONO_HOS CHECK(telefono_hos  is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_NOMBRE_REP_HOS CHECK(nombre_rep_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_TEL_REP_HOS CHECK(tel_rep_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_CORREO_REP_HOS CHECK(correo_rep_hos is not null);
ALTER TABLE HOSPITAL ADD CONSTRAINT NN_ESTADO_HOS CHECK(estado_hos is not null);


ALTER TABLE JORNADA ADD CONSTRAINT NN_DESCRIPCION_JOR CHECK(descripcion_jor is not null);
ALTER TABLE JORNADA ADD CONSTRAINT NN_FECHA_JOR CHECK(fecha_jor is not null);
ALTER TABLE JORNADA ADD CONSTRAINT NN_DEPARTAMENTO_JOR CHECK(departamento_jor is not null);
ALTER TABLE JORNADA ADD CONSTRAINT NN_ESTADO_JOR CHECK(estado_jor is not null);
ALTER TABLE JORNADA ADD CONSTRAINT NN_OBSERVACIONES_JOR CHECK(observaciones_jor is not null);


ALTER TABLE BOLSA ADD CONSTRAINT NN_GRUPO_SANGUINEO_BOL CHECK(grupo_sanguineo_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_RH_BOL CHECK(rh_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_FECHA_DONACION_BOL CHECK(fecha_donacion_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_FECHA_VENCI_BOL CHECK(fecha_venci_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_CANTIDAD_SANGRE_BOL CHECK(cantidad_sangre_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_OBSERVACIONES_BOL CHECK(observaciones_bol is not null);
ALTER TABLE BOLSA ADD CONSTRAINT NN_JORNADA_DON_BOL CHECK(jornada_don_bol is not null);


ALTER TABLE DEPARTAMENTO ADD CONSTRAINT NN_NOMBRE_DEP CHECK(nombre_dep is not null);

 
ALTER TABLE MUNICIPIO ADD CONSTRAINT NN_MUNICIPIO_MUN CHECK(departamento_mun is not null);
ALTER TABLE MUNICIPIO ADD CONSTRAINT NN_NOMBRE_MUN CHECK(nombre_mun is not null); 

ALTER TABLE BOLSA ADD CONSTRAINT FK_CODIGO_JOR_BOL FOREIGN KEY(jornada_don_bol) REFERENCES JORNADA(codigo_jor);

ALTER TABLE DONANTE ADD CONSTRAINT FK_DEPARTAMENTO_DON FOREIGN KEY(departamento_don) REFERENCES DEPARTAMENTO(id_dep); 
ALTER TABLE DONANTE ADD CONSTRAINT FK_MUNICIPIO_DON FOREIGN KEY(municipio_don) REFERENCES MUNICIPIO(id_mun);

ALTER TABLE HOSPITAL ADD CONSTRAINT FK_DEPARTAMENTO_HOS FOREIGN KEY(departamento_hos) REFERENCES DEPARTAMENTO(id_dep);
ALTER TABLE HOSPITAL ADD CONSTRAINT FK_MUNICIPIO_HOS FOREIGN KEY(municipio_hos) REFERENCES MUNICIPIO(id_mun);

ALTER TABLE JORNADA ADD CONSTRAINT FK_DEPARTAMENTO_JOR FOREIGN KEY(departamento_jor) REFERENCES DEPARTAMENTO(id_dep);
ALTER TABLE JORNADA ADD CONSTRAINT FK_MUNICIPIO_JOR FOREIGN KEY(municipio_jor) REFERENCES MUNICIPIO(id_mun);








