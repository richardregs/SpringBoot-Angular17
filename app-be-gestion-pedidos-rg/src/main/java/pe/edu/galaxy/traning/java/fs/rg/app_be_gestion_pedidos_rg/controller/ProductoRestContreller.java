package pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.entity.ProductoEntity;
import pe.edu.galaxy.traning.java.fs.rg.app_be_gestion_pedidos_rg.service.ProductoService;

import static java.util.Objects.isNull;

 @RestController
 @RequestMapping("/v1/productos")
public class ProductoRestContreller {
	
	private ProductoService productoService;
	
	public ProductoRestContreller(ProductoService productoService){
		this.productoService = productoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProductoEntity>> findAll(){
		try {
			ProductoEntity prmProductoEntity = new ProductoEntity();
			prmProductoEntity.setNombre("");
			List<ProductoEntity> lstProductoEntity = productoService.findLikeObject(prmProductoEntity);
			if (lstProductoEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstProductoEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoEntity> findById(@PathVariable("id") Long id){
		try {
			ProductoEntity prmProductoEntity = new ProductoEntity();
			prmProductoEntity.setId(id);
			Optional<ProductoEntity> optProductoEntity = productoService.findById(prmProductoEntity);
			if (optProductoEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(optProductoEntity.get());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/by-nombre")
	public ResponseEntity<List<ProductoEntity>> findByLikeNombre(
			@RequestParam(value="nombre", defaultValue="") String nombre){
		try {
			ProductoEntity prmProductoEntity = new ProductoEntity();
			prmProductoEntity.setNombre(nombre);
			List<ProductoEntity> ListProductoEntity = productoService.findLikeObject(prmProductoEntity);
			if (ListProductoEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(ListProductoEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@PostMapping
	public ResponseEntity<ProductoEntity> save(@RequestBody ProductoEntity productoEntity){
		try {
			ProductoEntity rProductoEntity = productoService.save(productoEntity);
			if (isNull(rProductoEntity)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(rProductoEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoEntity> update(@PathVariable("id") Long id, @RequestBody ProductoEntity productoEntity){
		try {
			productoEntity.setId(id);
			ProductoEntity rProductoEntity = productoService.update(productoEntity);
			if (isNull(rProductoEntity)) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(rProductoEntity);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		try {
			ProductoEntity prmProductoEntity = new ProductoEntity();
			prmProductoEntity.setId(id);
			productoService.delete(prmProductoEntity); 
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}

}
