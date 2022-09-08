package senai.sp.cotia.wms.rest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import senai.sp.cotia.wms.model.Aluno;
import senai.sp.cotia.wms.repository.AlunoRepository;

@RestController
@RequestMapping("api/relatorio")
public class testeController {
	
	@Autowired
	private AlunoRepository repo;
	
	@RequestMapping(value = "pdf", method = RequestMethod.GET)
	public String generatePdf() throws FileNotFoundException, JRException {
		
		List<Aluno> list;
		list = repo.findAll();
		
		JRBeanCollectionDataSource bean = new JRBeanCollectionDataSource(list);
		JasperReport report = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/teste.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		
		JasperPrint prit = JasperFillManager.fillReport(report, map,bean);
		
		JasperExportManager.exportReportToPdfFile (prit, "turma.pdf");
		
		
		return "generated";
	}
}
