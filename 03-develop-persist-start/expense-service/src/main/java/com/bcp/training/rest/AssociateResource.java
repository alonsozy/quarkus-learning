package com.bcp.training.rest;

import com.bcp.training.model.Associate;
import com.bcp.training.model.Expense;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Path("associate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AssociateResource {

    @GET
    public List<Associate> getAssociates() {
        return Associate.listAll();
    }

    @GET
    @Path("{id}")
    public Associate getAssociate(@PathParam("id") Long id) {
        return Associate.findById(id);
    }

    @GET
    @Path("{id}/expenses")
    public Response getExpenses(@PathParam("id") Long id) {
        Associate associate = Associate.findById(id);
        if (associate == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Expense.list("associateId",id)).build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Associate createAssociate(final Associate associate) {
        Associate newAssociate = new Associate();
        newAssociate.name = associate.name;
        System.out.println("ID antes de persist: " + associate.id);
        newAssociate.persist();
        return newAssociate;
    }*/

}
