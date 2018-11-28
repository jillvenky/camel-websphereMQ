package br.com.conecta.poc.processor;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;

public class ProducerWMQProcessor implements Processor{
	
	@EndpointInject
	private ProducerTemplate producerTemplate;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<Eventos>\r\n" + 
				"   <Evento>\r\n" + 
				"      <SistemaOrigem>1</SistemaOrigem>\r\n" + 
				"      <CodigoEvento>1.1</CodigoEvento>\r\n" + 
				"      <DataCompetencia>\r\n" + 
				"         <Dia>01</Dia>\r\n" + 
				"         <Mes>01</Mes>\r\n" + 
				"         <Ano>2017</Ano>\r\n" + 
				"      </DataCompetencia>\r\n" + 
				"      <Datas>\r\n" + 
				"         <Data>\r\n" + 
				"            <Tipo>1</Tipo>\r\n" + 
				"            <Dia>01</Dia>\r\n" + 
				"            <Mes>01</Mes>\r\n" + 
				"            <Ano>2017</Ano>\r\n" + 
				"         </Data>\r\n" + 
				"      </Datas>\r\n" + 
				"      <Documentos>\r\n" + 
				"         <Apolice>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </Apolice>\r\n" + 
				"         <Deposito>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </Deposito>\r\n" + 
				"         <Endosso>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </Endosso>\r\n" + 
				"         <OrdemPagamento>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </OrdemPagamento>\r\n" + 
				"         <Projeto>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </Projeto>\r\n" + 
				"         <Sinistro>\r\n" + 
				"            <Numero>123456789</Numero>\r\n" + 
				"         </Sinistro>\r\n" + 
				"      </Documentos>\r\n" + 
				"      <Entidades>\r\n" + 
				"         <Cliente>\r\n" + 
				"            <Nome>CLIENTE TESTE</Nome>\r\n" + 
				"         </Cliente>\r\n" + 
				"         <Corretor>\r\n" + 
				"            <SUSEP>0005J</SUSEP>\r\n" + 
				"         </Corretor>\r\n" + 
				"         <SeguradoraExterna>\r\n" + 
				"            <Codigo>05886</Codigo>\r\n" + 
				"         </SeguradoraExterna>\r\n" + 
				"         <Empresa>\r\n" + 
				"            <Codigo>1</Codigo>\r\n" + 
				"            <Departamento>\r\n" + 
				"               <Codigo>1508</Codigo>\r\n" + 
				"            </Departamento>\r\n" + 
				"            <Local>\r\n" + 
				"               <Codigo>001</Codigo>\r\n" + 
				"            </Local>\r\n" + 
				"            <ModalidadeRamo>\r\n" + 
				"               <Codigo>0</Codigo>\r\n" + 
				"            </ModalidadeRamo>\r\n" + 
				"            <Ramo>\r\n" + 
				"               <Codigo>531</Codigo>\r\n" + 
				"            </Ramo>\r\n" + 
				"            <Sucursal>\r\n" + 
				"               <CaracteristicaEntidade>1</CaracteristicaEntidade>\r\n" + 
				"               <Codigo>1</Codigo>\r\n" + 
				"            </Sucursal>\r\n" + 
				"         </Empresa>\r\n" + 
				"         <EntidadeBancaria>\r\n" + 
				"            <Codigo>001</Codigo>\r\n" + 
				"         </EntidadeBancaria>\r\n" + 
				"         <Fornecedor>\r\n" + 
				"            <Nome>FORNECEDOR TESTE</Nome>\r\n" + 
				"         </Fornecedor>\r\n" + 
				"      </Entidades>\r\n" + 
				"      <Valores>\r\n" + 
				"         <Valor>\r\n" + 
				"            <CaracteristicaValor>1</CaracteristicaValor>\r\n" + 
				"            <Valor>9999.99</Valor>\r\n" + 
				"         </Valor>\r\n" + 
				"      </Valores>\r\n" + 
				"      <ChavePrimariaOrigem>TESTE CHAVE PRIMARIA STRING</ChavePrimariaOrigem>\r\n" + 
				"   </Evento>\r\n" + 
				"</Eventos>";
		
		try {
		
			this.producerTemplate.sendBody("websphere:queue:CONTABILIDADE.ENVIO.CRITICA.RQ", ExchangePattern.InOnly, xml);
		
		} catch (Exception e) {
			
			throw e;
		
		}
		
		exchange.getOut().setBody(xml);
		
	}

}
