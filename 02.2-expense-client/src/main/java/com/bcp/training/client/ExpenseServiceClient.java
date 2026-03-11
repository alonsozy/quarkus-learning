package com.bcp.training.client;

import com.bcp.training.model.Expense;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Set;

@Path("expenses") // aqui se pone el mismo url del servicio que se llamara
@RegisterRestClient(configKey = "expense-service-alo")
public interface ExpenseServiceClient {

    @GET
    Set<Expense> getAll();

    @POST
    Expense create(Expense expense);
}
