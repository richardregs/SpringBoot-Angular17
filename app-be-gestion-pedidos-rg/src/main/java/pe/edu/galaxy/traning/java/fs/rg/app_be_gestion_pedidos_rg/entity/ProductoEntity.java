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
@Entity(name="ProductoEntity")
@Table(name="tbl_producto")
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="producto_id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="stock")
	private Integer stock;
	
	@Column(name="estado")
	private String estado;
	

}