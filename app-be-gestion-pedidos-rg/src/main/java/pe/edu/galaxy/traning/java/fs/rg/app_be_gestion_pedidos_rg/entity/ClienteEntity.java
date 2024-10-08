package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="ClienteEntity")
@Table(name="tbl_cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_id")
	private Long id;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="estado")
	private String estado;

}
