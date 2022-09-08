package senai.sp.cotia.wms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import senai.sp.cotia.wms.model.ItemNota;
import senai.sp.cotia.wms.model.Movimentacao;

public interface MovimentacaoRepository extends PagingAndSortingRepository<Movimentacao, Long> {
	
	public Movimentacao findByProdutoAndData(String produto, String data);
	
	//metodo para procurar itens no banco de dados por qualquer atributo
	@Query("SELECT mov FROM Movimentacao mov WHERE mov.data LIKE %:p% OR mov.tipo LIKE %:p% " + "OR mov.produto LIKE %:p% ")
	public List<Movimentacao> procurarTudo(@Param("p") String param);

}
