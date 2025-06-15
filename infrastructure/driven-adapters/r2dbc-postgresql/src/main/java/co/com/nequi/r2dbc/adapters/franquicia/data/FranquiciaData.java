package co.com.nequi.r2dbc.adapters.franquicia.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("franquicias_schema.franquicia")
public class FranquiciaData {
    @Id
    private UUID id;
    private String nombre;
}