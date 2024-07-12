package com.cap.cursos.dto.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
@Document(collection = "auditoria")
public class Auditoria {
    @Id
    private String id;
    private String usuario;
    private String dni;
    private LocalDateTime fecha;
    private String estado;
}