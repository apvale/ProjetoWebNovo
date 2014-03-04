<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="pagamentos">
		<h3>Relatório de Pagamentos</h3>
		
		<form action="ListarPagamentos">
			<label for="anopagamento">Escolha o ano:</label>
				<select name="anopagamento">
					<option value="1">2014
					<option value="2">2013
					<option value="3">2012
					<option value="4">2011
				</select>	
				<input type="submit" value="Exibir Relatório">
		</form>
	
		
		<table style="display: none;" class="striped tight sortable">
			<thead>
				<tr>
					<th>Ano</th>
				</tr>
				<tr>
					
					<th>Data</th>
					<th>Pagamento</th>
				</tr>
			</thead>
			<tbody>
				<tr><th>Teste</th>
				<%-- <c:forEach var="pagamento" items="pagamentos">
					<td>${pagamento.data}</td>
					<td>${pagamento.valor}</td>
				</c:forEach> --%>
				</tr>
			</tbody>
			
			</table>	
			<a class="button" href='<c:url value="/gerarelatorio"/>'>Gerar Relatório em PDF</a>
			
	</div>
