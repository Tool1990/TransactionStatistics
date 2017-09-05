package backend.challenge.api.resources;

import backend.challenge.ApplicationContext;
import backend.challenge.dto.Statistic;
import backend.challenge.entities.Transaction;
import backend.challenge.services.TransactionService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatisticResource {
	@Inject
	ApplicationContext applicationContext;

	@Inject
	TransactionService transactionService;

	@GET
	public Response getLatestMinuteStatistic() {
		List<Transaction> transactions = applicationContext.getTransactions();
		transactions = transactionService.getLatestMinuteTransactions(transactions);

		if (transactions.isEmpty()) {
			return Response.noContent().build();
		}

		Statistic statistic = transactionService.getStatistic(transactions);
		return Response.status(201).entity(statistic).build();
	}
}
