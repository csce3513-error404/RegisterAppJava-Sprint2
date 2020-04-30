package edu.uark.registerapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.registerapp.commands.activeUsers.ActiveUserDeleteCommand;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.ApiResponse;
import edu.uark.registerapp.models.api.Transaction;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionRestController extends BaseRestController
{
    @RequestMapping(value="/", method = RequestMethod.POST)
    public @ResponseBody 
    ApiResponse createTransaction(
        @RequestBody final Transaction Transaction,
                     final HttpServletRequest request,
                     final HttpServletResponse response
	) {
        final ApiResponse elevatedUserResponse =
        this.redirectUserNotElevated(
            request,
            response,
            ViewNames.TRANSACTION.getRoute());
	}
}
