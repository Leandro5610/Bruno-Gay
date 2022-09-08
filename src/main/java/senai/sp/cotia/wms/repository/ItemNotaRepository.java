package senai.sp.cotia.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import senai.sp.cotia.wms.model.ItemNota;


public interface ItemNotaRepository extends PagingAndSortingRepository<ItemNota, Long> {
	
	public ItemNota findByPedidoAndNotaFiscal(String pedido, String notaFiscal);
	
	
	//metodo para procurar itens no banco de dados por qualquer atributo
	@Query("SELECT itens FROM ItemNota itens WHERE itens.pedido LIKE %:p% OR itens.notaFiscal LIKE %:p% " + "OR itens.qtd LIKE %:p% ")
	public List<ItemNota> procurarTudo(@Param("p") String param);
	

}
