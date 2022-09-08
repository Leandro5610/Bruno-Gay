package senai.sp.cotia.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import senai.sp.cotia.wms.model.ItemFornecedor;

public interface ItemFornecedorRepository extends PagingAndSortingRepository<ItemFornecedor, Long> {	
	
	
	//metodo para procurar itens no banco de dados por qualquer atributo
	@Query("SELECT i FROM ItemFornecedor i WHERE i.fornecedor LIKE %:p% OR i.produto LIKE %:p% ")
	public List<ItemFornecedor> procurarTudo(@Param("p") String param);
	

}




