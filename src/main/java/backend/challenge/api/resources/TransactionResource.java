package backend.challenge.api.resources;

import backend.challenge.ApplicationContext;
import backend.challenge.entities.Transaction;
import backend.challenge.services.TransactionService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {
	@Inject
	private ApplicationContext applicationContext;

	@Inject
	private TransactionService transactionService;

	@POST
	public Response persistTransaction(Transaction transaction) {
		List<Transaction> transactions = applicationContext.getTransactions();

		//adding every transaction for extensibility
		//possibility to run out of memory
		transactions.add(transaction);

		if (!transactionService.isLatestMinute(transaction)) {
			return Response.status(204).build();
		}

		//TODO remove entity
		return Response.status(201).entity(transactions).build();
	}
}
